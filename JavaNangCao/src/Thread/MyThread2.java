package Thread;

import java.util.Iterator;

public class MyThread2 extends Thread {
	@Override
	public void run() {
		
		for (int i = 0; i< 10; i++) {
			try {
				super.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(super.getName() + i);
			
		}
		super.run();
	}
}
