package 线程通信Demo.Exchangeer;

public class DataTaskB implements Runnable {
	private Data shuju;

	public DataTaskB(Data shuju) {
		super();
		this.shuju = shuju;
	}

	@Override
	public void run() {
		shuju.wajueB();
	}
}
