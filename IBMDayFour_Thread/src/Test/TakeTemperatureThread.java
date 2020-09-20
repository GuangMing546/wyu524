package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 定义了一个Student类，该类有一个属性id，为学生的编号。
 * 定义了一个TakeTemperatureThread类，该类有一个方法takeTemperature，为学生测量体温。该类继承了Thread类并重写了run方法，实现了多线程。
 * 在该类的main方法中，创建了一个学生列表，并启动5个线程实现为100个学生测体温的功能。
 * @author Lenovo
 *
 */
public class TakeTemperatureThread extends Thread {

	private Student student;
	private CountDownLatch countDownLatch;
	
	public TakeTemperatureThread(Student student,CountDownLatch countDownLatch) {
		this.student=student;
		this.countDownLatch=countDownLatch;
	}
	
	public void takeTemperature() {
		System.out.println("编号：" + student.getId() + "正在测体温中.....");
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int tempertature = (int) (36 + Math.random() * 5);
		System.out.println("编号：" + student.getId() + "测体温结束，体温为：" + tempertature+"度");
		countDownLatch.countDown();
		
	}
	
	@Override
	public void run() {
		takeTemperature();
	}
	
	public static void main(String[] args) {
		CountDownLatch countDownLatch=new CountDownLatch(100);
		//建立100个学生
		List<Student> list=new ArrayList<Student>();
		for(int i=0;i<100;i++) {
			Student student=new Student(i+1);
			list.add(student);
		}
		//开一个线程池，核心线程5个
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5, 10, 10L, 
				TimeUnit.SECONDS, new LinkedBlockingDeque<>(200));
		//开始测温
		for(int i=0;i<100;i++) {
			TakeTemperatureThread ttt=new TakeTemperatureThread(list.get(i),countDownLatch);
			threadPoolExecutor.execute(ttt);
		}
		try {
			countDownLatch.await();
			System.out.println("测温100个同学完毕！");
			threadPoolExecutor.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
