package �̳߳�Demo;
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
		System.out.println(num+"��ѡ�ֳ�����");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 100; i++) {
			if (50==i) {
				System.out.println(num+"ѡ���Ѿ�����һ�룡");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(num+"ѡ�ֵ����յ���~~~");
	}
}
