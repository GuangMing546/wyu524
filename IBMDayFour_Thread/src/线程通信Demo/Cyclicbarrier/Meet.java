package 线程通信Demo.Cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//模拟开会，所有人到达之后才一起开会
public class Meet { 
	private CyclicBarrier barrier; // 重点要讲
	private Random random = new Random(); //一个随机数

	public Meet(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	public void doMeet() { // 开会方法
		System.out.println(Thread.currentThread().getName() + " :正在赶来的路上");
		try {
			Thread.sleep(random.nextInt(10000)); //睡眠随机秒数
		} catch (InterruptedException e1) {
		}
		System.out.println(Thread.currentThread().getName() + " :已经来到会议室");
		try {
			//await() 
	        //在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
			barrier.await();// 线程等待
		} catch (InterruptedException e) {
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
