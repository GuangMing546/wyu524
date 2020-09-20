package 线程通信Demo.Cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

//模拟开会，所有人到达之后才一起开会
public class MeetTest {
	public static void main(String[] args) {
		//CyclicBarrier(int parties) 
        //创建一个新的 CyclicBarrier，它将在给定数量的参与者（线程）处于等待状态时启动，但它不会在启动 barrier 时执行预定义的操作。 
		//CyclicBarrier(int parties, Runnable barrierAction) 
        //创建一个新的 CyclicBarrier，它将在给定数量的参与者（线程）处于等待状态时启动，并在启动 barrier 时执行给定的屏障操作，该操作由最后一个进入 barrier 的线程执行。 

		CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
			@Override
			public void run() {
				System.out.println("人来齐了，开始开会");
			}
		});
		Meet meet = new Meet(barrier);
		for (int i = 0; i < 10; i++) {
			new Thread(new MeetTask(meet)).start();
		}
	}
}
