package �߳�ͨ��Demo.Cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

//ģ�⿪�ᣬ�����˵���֮���һ�𿪻�
public class MeetTest {
	public static void main(String[] args) {
		//CyclicBarrier(int parties) 
        //����һ���µ� CyclicBarrier�������ڸ��������Ĳ����ߣ��̣߳����ڵȴ�״̬ʱ�������������������� barrier ʱִ��Ԥ����Ĳ����� 
		//CyclicBarrier(int parties, Runnable barrierAction) 
        //����һ���µ� CyclicBarrier�������ڸ��������Ĳ����ߣ��̣߳����ڵȴ�״̬ʱ�������������� barrier ʱִ�и��������ϲ������ò��������һ������ barrier ���߳�ִ�С� 

		CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
			@Override
			public void run() {
				System.out.println("�������ˣ���ʼ����");
			}
		});
		Meet meet = new Meet(barrier);
		for (int i = 0; i < 10; i++) {
			new Thread(new MeetTask(meet)).start();
		}
	}
}
