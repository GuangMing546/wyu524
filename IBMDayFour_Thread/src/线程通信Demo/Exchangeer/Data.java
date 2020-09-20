package 线程通信Demo.Exchangeer;

import java.util.concurrent.Exchanger;

//模拟两台数据挖掘机器，挖掘之后将两个线程的挖掘的数据交换
//数据类package ibm.com.thread.communication
public class Data {
	private Exchanger<String> exchanger; //Exchanger<String>类

	public Data(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	public void wajueA() {
		String str = "aaa";
		System.out.println(Thread.currentThread().getName() + " :开始挖掘数据");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :挖掘数据完毕，数据为：" + str);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//模拟两台数据挖掘机器，挖掘之后将两个线程的挖掘的数据交换
		//数据类package ibm.com.thread.communication
		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :交换后得到数据，数据为：" + ss);
		} catch (InterruptedException e) {
		}
	}

	public void wajueB() {// 挖掘方法B
		String str = "bbb";
		System.out.println(Thread.currentThread().getName() + " :开始挖掘数据");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :挖掘数据完毕，数据为：" + str);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			String ss = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + " :交换后得到数据，数据为：" + ss);
		} catch (InterruptedException e) {
		}
	}
}
