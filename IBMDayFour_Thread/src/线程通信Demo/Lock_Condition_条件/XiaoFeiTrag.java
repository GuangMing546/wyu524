package �߳�ͨ��Demo.Lock_Condition_����;

public class XiaoFeiTrag implements Runnable {
	private Tianmao t;

	public XiaoFeiTrag(Tianmao t) {
		super();
		this.t = t;
	}

	@Override
	public void run() {
		while (true) {
			t.xiaoFei();
		}
	}
}
