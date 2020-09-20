package 线程池Demo;
import java.util.concurrent.CountDownLatch;

public class SwimRunnable implements Runnable {

	CountDownLatch countDownLatch;
	int num;
	public SwimRunnable(CountDownLatch countDownLatch,int i) {
		this.countDownLatch=countDownLatch;
		this.num=i;
	}
	@Override
	public void run() {
		System.out.println(num+"号选手出发！");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 100; i++) {
			if (50==i) {
				System.out.println(num+"选手已经游了一半！");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(num+"选手到达终点辽~~~");
	}
}
