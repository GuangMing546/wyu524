package �߳�ͨ��Demo.Cyclicbarrier;

//ģ�⿪�ᣬ�����˵���֮���һ�𿪻�
public class MeetTask implements Runnable {
	private Meet meet;

	public MeetTask(Meet meet) {
		super();
		this.meet = meet;
	}

	@Override
	public void run() {
		meet.doMeet();// ���ÿ����෽��
	}
}
