package 线程通信Demo.Semaphore信号量;

public class WcTest {
	public static void main(String[] args) {
		Wc wc = new Wc();
		//50个人枪3个厕所
		for (int i = 0; i < 50; i++) {
			new Thread(new WcTask(wc)).start();
		}
	}
}
