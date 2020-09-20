package 线程通信Demo.Exchangeer;

import java.util.concurrent.Exchanger;
/**
 * 小结:Exchanger
 * Exchanger：
 * java.util.concurrent包中的Exchanger类可用于两个线程之间交换信息。
 * 可简单地将Exchanger对象理解为一个包含两个格子的容器，通过exchanger方法可以向两个格子中填充信息。
 * 当两个格子中的均被填充时，该对象会自动将两个格子的信息交换，
 * 然后返回给线程，从而实现两个线程的信息交换。
 * Exchanger类的核心便是exchange()方法的使用，exchange()方法的线程会进行交换数据。
 * @author Lenovo
 *
 */
public class DataTest {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		Data shuju = new Data(exchanger);
		
		new Thread(new DataTaskA(shuju)).start(); //挖掘机A
		
		new Thread(new DataTaskB(shuju)).start(); //挖掘机B
	}
}
