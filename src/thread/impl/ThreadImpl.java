package thread.impl;

public class ThreadImpl extends Thread {

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		System.out.println("启动线程：" + this.getName());
		for (int i = 0; i < 10;) {
			try {
				System.out.println(this.getName() + " GlobalImpl.num:" + (i = GlobalImpl.getNum()));
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public ThreadImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThreadImpl(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	public ThreadImpl(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public ThreadImpl(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public ThreadImpl(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		// TODO Auto-generated constructor stub
	}

	public ThreadImpl(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	public ThreadImpl(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	public ThreadImpl(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}
	
}
