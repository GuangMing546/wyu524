package 线程通信Demo.synchronized_wait_notifyAll;

public class TianmaoProduct implements Runnable {
	private TianmaoStore tianmaoStore;
	
	public TianmaoProduct(TianmaoStore tianmaoStore) {
		this.tianmaoStore=tianmaoStore;
	}
	@Override
	public void run() {
		while(true) {
			tianmaoStore.shengChan();
		}
	}
}
