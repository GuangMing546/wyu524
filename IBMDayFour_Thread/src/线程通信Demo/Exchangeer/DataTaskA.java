package �߳�ͨ��Demo.Exchangeer;

public class DataTaskA implements Runnable {
	private Data shuju;

	public DataTaskA(Data shuju) {
		super();
		this.shuju = shuju;
	}

	@Override
	public void run() {
		shuju.wajueA();
	}
}
