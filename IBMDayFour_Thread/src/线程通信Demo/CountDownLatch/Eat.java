package 线程通信Demo.CountDownLatch;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch： 一个可以用来协调多个线程之间的同步，或者说起到线程之间的通信作用的工具类。
 * 它能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。使用一个计数器进行实现。计数器初始值为
 * 线程的数量。当每一个线程完成自己任务后，计数器的值就会减一。当计数器的值为0时，表示所有的线程都已经完
 * 成了任务，然后
 * CountDownLatch上等待的线程就可以恢复执行任务。
 * @author Lenovo
 *
 */

//模拟吃饭，主线程在其他线程执行之后在吃饭
public class Eat {
	private CountDownLatch countDownLatch;

	public Eat(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void doEat() {
		System.out.println(Thread.currentThread().getName() + " :正在吃饭");
		try {
			Thread.sleep(5000); //睡5秒
		} catch (InterruptedException e) {
		}
		countDownLatch.countDown();	// 如果计数到达零，则释放所有等待的线程
	}
}
