package 线程池Demo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 创建使用ThreadPoolExecutor创建一个线程池，要求corePoolSize=10 maximumPoolSize=20 keepAliveTime=20  时间单位为秒  任务队列长度为200
 * @author Lenovo
 *
 */
public class Test02 {
	//关于游泳比赛的（10泳道）的线程池设计
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10, 20, 
				20L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(200));
		CountDownLatch countDownLatch=new CountDownLatch(10);
		System.out.println("比赛开始");
		for(int i=1;i<=10;i++) {
			//execute(Runnable command) 在将来某个时间执行给定任务。
	        //submit()提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。该 Future 的 get 方法在成功 完成时将会返回 null。 
			threadPoolExecutor.execute(new SwimRunnable(countDownLatch, i)); //在未来某个时间执行任务
			countDownLatch.countDown();
		}
//		System.out.println("准备等待线程池任务执行完毕");
		try {	
			countDownLatch.await(); //使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
			Thread.sleep(1000);
			System.out.println("--------比赛结束--------");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
