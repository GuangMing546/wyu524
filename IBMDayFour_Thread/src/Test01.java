import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test01 {
	public static void main(String args[]) {
		//建立一个线程池，并配置它的各自参数
		//初始化核心线程是5个，总线程数是10个
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(1000), new ThreadPoolExecutor.AbortPolicy());
		
		//CountDownLatch：一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
		//用给定的计数 初始化 CountDownLatch。由于调用了 countDown() 方法，
		//所以在当前计数到达零之前，await 方法会一直受阻塞。
		//之后，会释放所有等待的线程，await 的所有后续调用都将立即返回。这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。 
		/**
		 * 方法摘要 
		 * void await() 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。、
		 * boolean await(long timeout,TimeUnit unit) 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断或超出了指定的等待时间。 
		 * void countDown()递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
		 */
		final CountDownLatch countDownLatch = new CountDownLatch(8);
		//循环提交
		for (int i = 0; i < 8; i++) {
			final int currentIndex = i;
			System.out.println("提交第" + i + "个线程");
			threadPoolExecutor.execute(() -> {
				System.out.println(Thread.currentThread().getName() + ", currentIndex is : " + currentIndex);
				countDownLatch.countDown();
			});
		}
		System.out.println("全部提交完毕");
		try {
			System.out.println("准备等待线程池任务执行完毕");
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("全部线程执行完毕");
	}
}
