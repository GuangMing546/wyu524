import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test01 {
	public static void main(String args[]) {
		//����һ���̳߳أ����������ĸ��Բ���
		//��ʼ�������߳���5�������߳�����10��
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(1000), new ThreadPoolExecutor.AbortPolicy());
		
		//CountDownLatch��һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ���
		//�ø����ļ��� ��ʼ�� CountDownLatch�����ڵ����� countDown() ������
		//�����ڵ�ǰ����������֮ǰ��await ������һֱ��������
		//֮�󣬻��ͷ����еȴ����̣߳�await �����к������ö����������ء���������ֻ����һ�Ρ��������޷������á������Ҫ���ü������뿼��ʹ�� CyclicBarrier�� 
		/**
		 * ����ժҪ 
		 * void await() ʹ��ǰ�߳�������������������֮ǰһֱ�ȴ��������̱߳��жϡ���
		 * boolean await(long timeout,TimeUnit unit) ʹ��ǰ�߳�������������������֮ǰһֱ�ȴ��������̱߳��жϻ򳬳���ָ���ĵȴ�ʱ�䡣 
		 * void countDown()�ݼ��������ļ�����������������㣬���ͷ����еȴ����̡߳�
		 */
		final CountDownLatch countDownLatch = new CountDownLatch(8);
		//ѭ���ύ
		for (int i = 0; i < 8; i++) {
			final int currentIndex = i;
			System.out.println("�ύ��" + i + "���߳�");
			threadPoolExecutor.execute(() -> {
				System.out.println(Thread.currentThread().getName() + ", currentIndex is : " + currentIndex);
				countDownLatch.countDown();
			});
		}
		System.out.println("ȫ���ύ���");
		try {
			System.out.println("׼���ȴ��̳߳�����ִ�����");
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ȫ���߳�ִ�����");
	}
}
