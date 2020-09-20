package 线程通信Demo.Cyclicbarrier;

//模拟开会，所有人到达之后才一起开会
public class MeetTask implements Runnable {
	private Meet meet;

	public MeetTask(Meet meet) {
		super();
		this.meet = meet;
	}

	@Override
	public void run() {
		meet.doMeet();// 调用开会类方法
	}
}
