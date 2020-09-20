package 线程通信Demo.Semaphore信号量;

import java.util.concurrent.Semaphore;
/**
 * 小结 ：Semaphore
	主要用于控制当前活动线程数目，就如同停车场系统一般，而Semaphore则相当于看守的人，用于控制总共允许停车的停
	车位的个数，而对于每辆车来说就如同一个线程，线程需要通过acquire()方法获取许可，而release()释放许可。如果许可
	数达到最大活动数，那么调用acquire()之后，便进入等待队列，等待已获得许可的线程释放许可，从而使得多线程能够合理的运行
 * @author Lenovo
 *
 */
public class Wc {
	private Semaphore semaphore = new Semaphore(3);// 信号量

	public void paidui() {// 排队任务方法
		try {
			semaphore.acquire(); //从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。 
	          
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :正在使用厕所");
		try {
			Thread.sleep(5000); //睡5秒
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :使用厕所完毕");
		semaphore.release(); //释放一个许可，将其返回给信号量。
	}
}
