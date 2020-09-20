package 线程通信Demo.Lock_Condition_条件;

/**
 * Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作。此实现允许更灵活的结构，可以具有差别很大的属性，可以支持多个相关的 Condition 对象。 

	锁是控制多个线程对共享资源进行访问的工具。通常，锁提供了对共享资源的独占访问。一次只能有一个线程获得锁，对共享资源的所有访问都需要首先获得锁。不过，某些锁可能允许对共享资源并发访问，如 ReadWriteLock 的读取锁。 

	synchronized 方法或语句的使用提供了对与每个对象相关的隐式监视器锁的访问，但却强制所有锁获取和释放均要出现在一个块结构中：当获取了多个锁时，它们必须以相反的顺序释放，且必须在与所有锁被获取时相同的词法范围内释放所有锁。 

	虽然 synchronized 方法和语句的范围机制使得使用监视器锁编程方便了很多，而且还帮助避免了很多涉及到锁的常见编程错误，但有时也需要以更为灵活的方式使用锁。例如，某些遍历并发访问的数据结果的算法要求使用 "hand-over-hand" 或 "chain locking"：获取节点 A 的锁，然后再获取节点 B 的锁，然后释放 A 并获取 C，然后释放 B 并获取 D，依此类推。Lock 接口的实现允许锁在不同的作用范围内获取和释放，并允许以任何顺序获取和释放多个锁，从而支持使用这种技术。 

	随着灵活性的增加，也带来了更多的责任。不使用块结构锁就失去了使用 synchronized 方法和语句时会出现的锁自动释放功能。在大多数情况下，应该使用以下语句： 

     Lock l = ...; 
     l.lock();
     try {
         // access the resource protected by this lock
     } finally {
         l.unlock();
     }
 	锁定和取消锁定出现在不同作用范围中时，必须谨慎地确保保持锁定时所执行的所有代码用 try-finally 或 try-catch 加以保护，以确保在必要时释放锁。 
 */
/**
 * Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，
 * 以便通过将这些对象与任意 Lock 实现组合使用，为每个对象提供多个等待 set（wait-set）。
 * 其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。 
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tianmao {

	private volatile int value;// 共享变量值
	private final int MAX_VALUE = 10;
	private final int MIN_VALUE = 0;
	//Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作。此实现允许更灵活的结构，可以具有差别很大的属性，可以支持多个相关的 Condition 对象。 
	private Lock lock = new ReentrantLock();// 可重入锁
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();

	public void shengChan() {// 生产方法
		lock.lock(); //锁住这个方法
		while (value >= MAX_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("生产者"+Thread.currentThread().getName() + " :停止生产，当前库存：" + value);
			try {
				c1.await();// 生产者等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//如果库存还没到最大库存
		value++;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产者"+Thread.currentThread().getName() + " :正在生产，库存：" + value);
		c2.signalAll();// 唤醒消费者（消费者方法哪里相应着用c2.await()来阻塞）
		lock.unlock();// 方法结束一定要解开解锁
	}

	public void xiaoFei() {// 消费方法
		lock.lock();// 消费上锁
		while (value <= MIN_VALUE) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " :停止消费，当前库存：" + value);
			try {
				c2.await();// 消费等待
			} catch (InterruptedException e) {
			}
		}
		value--;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " :正在消费，库存：" + value);
		c1.signalAll();// 唤醒生产者（生产者方法相应的要用c1.await()来阻塞）
		lock.unlock();// 方法结束一定要解开解锁
	}
}
