package thread.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GlobalImpl {
	private static int num = 0;

	private static Lock lock = new ReentrantLock();

	public static synchronized int getNum() {
		lock.lock();
		System.out.println("GlobalImpl:" + num);
		lock.unlock();
		return num++;

	}

	public static synchronized void setNum(int num) {
		GlobalImpl.num = num;
	}

}
