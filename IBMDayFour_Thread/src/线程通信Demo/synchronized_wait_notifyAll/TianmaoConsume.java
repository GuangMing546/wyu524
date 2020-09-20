package 线程通信Demo.synchronized_wait_notifyAll;

public class TianmaoConsume implements Runnable {

	private TianmaoStore tianmaoStore;
	public TianmaoConsume(TianmaoStore tianmaoStore) {
		this.tianmaoStore=tianmaoStore;
	}
	
	@Override
	public void run() {
		while (true) {
			tianmaoStore.xiaoFei();
		}
	}
}
