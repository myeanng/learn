package thread.main;

import thread.impl.ThreadImpl;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadImpl t1 = null;
		t1=new ThreadImpl(t1, "t1111111Thread");
		ThreadImpl t2 = null;
		t2=new ThreadImpl(t2, "t2222222Thread");
		t1.setPriority(9);
		t2.setPriority(1);
		t1.start();
		t2.start();
	}

}
