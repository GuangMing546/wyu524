package �߳�ͨ��Demo.Lock_Condition_����;

/**
 * Lock ʵ���ṩ�˱�ʹ�� synchronized ���������ɻ�õĸ��㷺��������������ʵ����������Ľṹ�����Ծ��в��ܴ�����ԣ�����֧�ֶ����ص� Condition ���� 

	���ǿ��ƶ���̶߳Թ�����Դ���з��ʵĹ��ߡ�ͨ�������ṩ�˶Թ�����Դ�Ķ�ռ���ʡ�һ��ֻ����һ���̻߳�������Թ�����Դ�����з��ʶ���Ҫ���Ȼ������������ĳЩ����������Թ�����Դ�������ʣ��� ReadWriteLock �Ķ�ȡ���� 

	synchronized ����������ʹ���ṩ�˶���ÿ��������ص���ʽ���������ķ��ʣ���ȴǿ����������ȡ���ͷž�Ҫ������һ����ṹ�У�����ȡ�˶����ʱ�����Ǳ������෴��˳���ͷţ��ұ�����������������ȡʱ��ͬ�Ĵʷ���Χ���ͷ��������� 

	��Ȼ synchronized ���������ķ�Χ����ʹ��ʹ�ü���������̷����˺ܶ࣬���һ����������˺ܶ��漰�����ĳ�����̴��󣬵���ʱҲ��Ҫ�Ը�Ϊ���ķ�ʽʹ���������磬ĳЩ�����������ʵ����ݽ�����㷨Ҫ��ʹ�� "hand-over-hand" �� "chain locking"����ȡ�ڵ� A ������Ȼ���ٻ�ȡ�ڵ� B ������Ȼ���ͷ� A ����ȡ C��Ȼ���ͷ� B ����ȡ D���������ơ�Lock �ӿڵ�ʵ���������ڲ�ͬ�����÷�Χ�ڻ�ȡ���ͷţ����������κ�˳���ȡ���ͷŶ�������Ӷ�֧��ʹ�����ּ����� 

	��������Ե����ӣ�Ҳ�����˸�������Ρ���ʹ�ÿ�ṹ����ʧȥ��ʹ�� synchronized ���������ʱ����ֵ����Զ��ͷŹ��ܡ��ڴ��������£�Ӧ��ʹ��������䣺 

     Lock l = ...; 
     l.lock();
     try {
         // access the resource protected by this lock
     } finally {
         l.unlock();
     }
 	������ȡ�����������ڲ�ͬ���÷�Χ��ʱ�����������ȷ����������ʱ��ִ�е����д����� try-finally �� try-catch ���Ա�������ȷ���ڱ�Ҫʱ�ͷ����� 
 */
/**
 * Condition �� Object ������������wait��notify �� notifyAll���ֽ�ɽ�Ȼ��ͬ�Ķ���
 * �Ա�ͨ������Щ���������� Lock ʵ�����ʹ�ã�Ϊÿ�������ṩ����ȴ� set��wait-set����
 * ���У�Lock ����� synchronized ����������ʹ�ã�Condition ����� Object ������������ʹ�á� 
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tianmao {

	private volatile int value;// �������ֵ
	private final int MAX_VALUE = 10;
	private final int MIN_VALUE = 0;
	//Lock ʵ���ṩ�˱�ʹ�� synchronized ���������ɻ�õĸ��㷺��������������ʵ����������Ľṹ�����Ծ��в��ܴ�����ԣ�����֧�ֶ����ص� Condition ���� 
	private Lock lock = new ReentrantLock();// ��������
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();

	public void shengChan() {// ��������
		lock.lock(); //��ס�������
		while (value >= MAX_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("������"+Thread.currentThread().getName() + " :ֹͣ��������ǰ��棺" + value);
			try {
				c1.await();// �����ߵȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//�����滹û�������
		value++;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������"+Thread.currentThread().getName() + " :������������棺" + value);
		c2.signalAll();// ���������ߣ������߷���������Ӧ����c2.await()��������
		lock.unlock();// ��������һ��Ҫ�⿪����
	}

	public void xiaoFei() {// ���ѷ���
		lock.lock();// ��������
		while (value <= MIN_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " :ֹͣ���ѣ���ǰ��棺" + value);
			try {
				c2.await();// ���ѵȴ�
			} catch (InterruptedException e) {
			}
		}
		value--;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :�������ѣ���棺" + value);
		c1.signalAll();// ���������ߣ������߷�����Ӧ��Ҫ��c1.await()��������
		lock.unlock();// ��������һ��Ҫ�⿪����
	}
}
