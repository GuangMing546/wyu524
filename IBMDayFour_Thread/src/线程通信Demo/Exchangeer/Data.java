package �߳�ͨ��Demo.Exchangeer;

import java.util.concurrent.Exchanger;

//ģ����̨�����ھ�������ھ�֮�������̵߳��ھ�����ݽ���
//������package ibm.com.thread.communication
public class Data {
	private Exchanger<String> exchanger; //Exchanger<String>��

	public Data(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	public void wajueA() {
		String str = "aaa";
		System.out.println(Thread.currentThread().getName() + " :��ʼ�ھ�����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :�ھ�������ϣ�����Ϊ��" + str);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//ģ����̨�����ھ�������ھ�֮�������̵߳��ھ�����ݽ���
		//������package ibm.com.thread.communication
		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :������õ����ݣ�����Ϊ��" + ss);
		} catch (InterruptedException e) {
		}
	}

	public void wajueB() {// �ھ򷽷�B
		String str = "bbb";
		System.out.println(Thread.currentThread().getName() + " :��ʼ�ھ�����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :�ھ�������ϣ�����Ϊ��" + str);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :������õ����ݣ�����Ϊ��" + ss);
		} catch (InterruptedException e) {
		}
	}
}
