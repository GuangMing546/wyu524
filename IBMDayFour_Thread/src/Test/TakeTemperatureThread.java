package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * ������һ��Student�࣬������һ������id��Ϊѧ���ı�š�
 * ������һ��TakeTemperatureThread�࣬������һ������takeTemperature��Ϊѧ���������¡�����̳���Thread�ಢ��д��run������ʵ���˶��̡߳�
 * �ڸ����main�����У�������һ��ѧ���б�������5���߳�ʵ��Ϊ100��ѧ�������µĹ��ܡ�
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
		System.out.println("��ţ�" + student.getId() + "���ڲ�������.....");
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int tempertature = (int) (36 + Math.random() * 5);
		System.out.println("��ţ�" + student.getId() + "�����½���������Ϊ��" + tempertature+"��");
		countDownLatch.countDown();
		
	}
	
	@Override
	public void run() {
		takeTemperature();
	}
	
	public static void main(String[] args) {
		CountDownLatch countDownLatch=new CountDownLatch(100);
		//����100��ѧ��
		List<Student> list=new ArrayList<Student>();
		for(int i=0;i<100;i++) {
			Student student=new Student(i+1);
			list.add(student);
		}
		//��һ���̳߳أ������߳�5��
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5, 10, 10L, 
				TimeUnit.SECONDS, new LinkedBlockingDeque<>(200));
		//��ʼ����
		for(int i=0;i<100;i++) {
			TakeTemperatureThread ttt=new TakeTemperatureThread(list.get(i),countDownLatch);
			threadPoolExecutor.execute(ttt);
		}
		try {
			countDownLatch.await();
			System.out.println("����100��ͬѧ��ϣ�");
			threadPoolExecutor.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
