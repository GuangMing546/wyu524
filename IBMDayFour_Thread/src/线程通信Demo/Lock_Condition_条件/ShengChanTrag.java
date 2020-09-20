package 线程通信Demo.Lock_Condition_条件;

public class ShengChanTrag implements Runnable {
	private Tianmao t;

	public ShengChanTrag(Tianmao t) {
		super();
		this.t = t;
	}

	@Override
	public void run() {
		while (true) {
			t.shengChan();
		}
	}
}
