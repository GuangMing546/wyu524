package �߳�ͨ��Demo.Semaphore�ź���;

public class WcTest {
	public static void main(String[] args) {
		Wc wc = new Wc();
		//50����ǹ3������
		for (int i = 0; i < 50; i++) {
			new Thread(new WcTask(wc)).start();
		}
	}
}
