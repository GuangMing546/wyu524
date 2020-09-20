package �߳�ͨ��Demo.Cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//ģ�⿪�ᣬ�����˵���֮���һ�𿪻�
public class Meet { 
	private CyclicBarrier barrier; // �ص�Ҫ��
	private Random random = new Random(); //һ�������

	public Meet(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}

	public void doMeet() { // ���᷽��
		System.out.println(Thread.currentThread().getName() + " :���ڸ�����·��");
		try {
			Thread.sleep(random.nextInt(10000)); //˯���������
		} catch (InterruptedException e1) {
		}
		System.out.println(Thread.currentThread().getName() + " :�Ѿ�����������");
		try {
			//await() 
	        //�����в����߶��Ѿ��ڴ� barrier �ϵ��� await ����֮ǰ����һֱ�ȴ���
			barrier.await();// �̵߳ȴ�
		} catch (InterruptedException e) {
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
