package 线程通信Demo.CountDownLatch;

public class EatTask implements Runnable {
	private Eat eat;// 吃饭类对象

	public EatTask(Eat eat) {
		super();
		this.eat = eat;
	}

	@Override
	public void run() {
		eat.doEat();// 调用吃饭类方法
	}
}
