package Thread;

public class MyThread1 implements Runnable{

	@Override
	public void run() {
		
		for (int i = 0; i <10; i++) {
			System.out.println("A" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
