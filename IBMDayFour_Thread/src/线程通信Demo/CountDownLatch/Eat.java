package �߳�ͨ��Demo.CountDownLatch;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch�� һ����������Э������߳�֮���ͬ��������˵���߳�֮���ͨ�����õĹ����ࡣ
 * ���ܹ�ʹһ���߳��ڵȴ�����һЩ�߳���ɸ��Թ���֮���ټ���ִ�С�ʹ��һ������������ʵ�֡���������ʼֵΪ
 * �̵߳���������ÿһ���߳�����Լ�����󣬼�������ֵ�ͻ��һ������������ֵΪ0ʱ����ʾ���е��̶߳��Ѿ���
 * ��������Ȼ��
 * CountDownLatch�ϵȴ����߳̾Ϳ��Իָ�ִ������
 * @author Lenovo
 *
 */

//ģ��Է������߳��������߳�ִ��֮���ڳԷ�
public class Eat {
	private CountDownLatch countDownLatch;

	public Eat(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void doEat() {
		System.out.println(Thread.currentThread().getName() + " :���ڳԷ�");
		try {
			Thread.sleep(5000); //˯5��
		} catch (InterruptedException e) {
		}
		countDownLatch.countDown();	// ������������㣬���ͷ����еȴ����߳�
	}
}
