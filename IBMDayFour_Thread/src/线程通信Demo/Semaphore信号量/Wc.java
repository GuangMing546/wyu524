package �߳�ͨ��Demo.Semaphore�ź���;

import java.util.concurrent.Semaphore;
/**
 * С�� ��Semaphore
	��Ҫ���ڿ��Ƶ�ǰ��߳���Ŀ������ͬͣ����ϵͳһ�㣬��Semaphore���൱�ڿ��ص��ˣ����ڿ����ܹ�����ͣ����ͣ
	��λ�ĸ�����������ÿ������˵����ͬһ���̣߳��߳���Ҫͨ��acquire()������ȡ��ɣ���release()�ͷ���ɡ�������
	���ﵽ���������ô����acquire()֮�󣬱����ȴ����У��ȴ��ѻ����ɵ��߳��ͷ���ɣ��Ӷ�ʹ�ö��߳��ܹ����������
 * @author Lenovo
 *
 */
public class Wc {
	private Semaphore semaphore = new Semaphore(3);// �ź���

	public void paidui() {// �Ŷ����񷽷�
		try {
			semaphore.acquire(); //�Ӵ��ź�����ȡһ����ɣ����ṩһ�����ǰһֱ���߳������������̱߳��жϡ� 
	          
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :����ʹ�ò���");
		try {
			Thread.sleep(5000); //˯5��
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :ʹ�ò������");
		semaphore.release(); //�ͷ�һ����ɣ����䷵�ظ��ź�����
	}
}
