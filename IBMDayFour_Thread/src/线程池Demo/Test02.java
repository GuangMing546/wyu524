package �̳߳�Demo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * ����ʹ��ThreadPoolExecutor����һ���̳߳أ�Ҫ��corePoolSize=10 maximumPoolSize=20 keepAliveTime=20  ʱ�䵥λΪ��  ������г���Ϊ200
 * @author Lenovo
 *
 */
public class Test02 {
	//������Ӿ�����ģ�10Ӿ�������̳߳����
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10, 20, 
				20L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(200));
		CountDownLatch countDownLatch=new CountDownLatch(10);
		System.out.println("������ʼ");
		for(int i=1;i<=10;i++) {
			//execute(Runnable command) �ڽ���ĳ��ʱ��ִ�и�������
	        //submit()�ύһ�� Runnable ��������ִ�У�������һ����ʾ������� Future���� Future �� get �����ڳɹ� ���ʱ���᷵�� null�� 
			threadPoolExecutor.execute(new SwimRunnable(countDownLatch, i)); //��δ��ĳ��ʱ��ִ������
			countDownLatch.countDown();
		}
//		System.out.println("׼���ȴ��̳߳�����ִ�����");
		try {	
			countDownLatch.await(); //ʹ��ǰ�߳�������������������֮ǰһֱ�ȴ��������̱߳��жϡ�
			Thread.sleep(1000);
			System.out.println("--------��������--------");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
