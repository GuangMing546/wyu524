package 线程通信Demo.synchronized_wait_notifyAll;
/**
 * 模拟生产者&消费者 用同步块
 * @author Lenovo
 *
 */
public class TianmaoStore {
	//被volatile修饰的变量保证对所有线程可见 (例如生产者消费者示例)
	private volatile int value; //重点
	private final int MAX_VALUE=10;
	private final int MIN_VALUE=0;
	
	public synchronized void shengChan() {
		while (value >= MAX_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("生产者"+Thread.currentThread().getName() + " :停止生产，当前库存：" + value);
			try {
				this.wait(); // 生产等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value++;// volatile变量
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产者"+Thread.currentThread().getName() + " :正在生产，库存：" + value);
		this.notifyAll();// 生产唤醒
	}
	
	public synchronized void xiaoFei() {
		while (value <= MIN_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println("消费者"+Thread.currentThread().getName() + " :停止消费，当前库存：" + value);
			try {
				this.wait();// 消费等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		value--;// volatile变量
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者"+Thread.currentThread().getName() + " :正在消费，库存：" + value);
		this.notifyAll();// 消费唤醒
	}
}
