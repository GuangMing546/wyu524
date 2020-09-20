package 线程通信Demo.Lock_Condition_条件;

public class ThreadLockTest {
	public static void main(String[] args) {
		Tianmao t = new Tianmao();
		
		new Thread(new ShengChanTrag(t)).start();
		new Thread(new ShengChanTrag(t)).start();
		new Thread(new ShengChanTrag(t)).start();
		
		new Thread(new XiaoFeiTrag(t)).start();
		new Thread(new XiaoFeiTrag(t)).start();
		new Thread(new XiaoFeiTrag(t)).start();
		new Thread(new XiaoFeiTrag(t)).start();
	}
}
