package �߳�ͨ��Demo.Exchangeer;

import java.util.concurrent.Exchanger;
/**
 * С��:Exchanger
 * Exchanger��
 * java.util.concurrent���е�Exchanger������������߳�֮�佻����Ϣ��
 * �ɼ򵥵ؽ�Exchanger�������Ϊһ�������������ӵ�������ͨ��exchanger�������������������������Ϣ��
 * �����������еľ������ʱ���ö�����Զ����������ӵ���Ϣ������
 * Ȼ�󷵻ظ��̣߳��Ӷ�ʵ�������̵߳���Ϣ������
 * Exchanger��ĺ��ı���exchange()������ʹ�ã�exchange()�������̻߳���н������ݡ�
 * @author Lenovo
 *
 */
public class DataTest {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		Data shuju = new Data(exchanger);
		
		new Thread(new DataTaskA(shuju)).start(); //�ھ��A
		
		new Thread(new DataTaskB(shuju)).start(); //�ھ��B
	}
}
