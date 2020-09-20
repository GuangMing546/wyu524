package 线程通信Demo.CountDownLatch;

import java.util.concurrent.CountDownLatch;
/**
 * ◼ 小结：CountDownLatch
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程执行完后再执行。
 * CountDownLatch原理：CountDownLatch是通过一个计数器来实现的，计数器的初始化值为线程的数量。每当一个线
 * 程完成了自己的任务后，计数器的值就相应得减1。当计数器到达0时，表示所有的线程都已完成任务，然后在闭锁上等待
 * 的线程就可以恢复执行任务。
 * @author Lenovo
 *
 */
public class EatTest {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(10); //10个线程
		Eat eat = new Eat(countDownLatch); //传进这个行为类
		for (int i = 0; i < 10; i++) {
			new Thread(new EatTask(eat)).start();
		}
		try {
			countDownLatch.await(); // 当前程序阻塞等待
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("都吃完了，主线程开始吃饭");
	}
}
