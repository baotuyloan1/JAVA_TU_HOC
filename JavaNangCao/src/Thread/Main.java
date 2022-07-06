package Thread;

public class Main {

	public static void main(String[] args) {
//		MyThread1 my1 = new MyThread1();
//		Thread t = new Thread(my1);
//		
//		t.start();
//		
//		
//		MyThread2 my2 = new MyThread2();
//		my2.start();
//		Thread my3 = new MyThread2();
//		my3 = (MyThread2)my3;
//		my3.start();
		
//		TestSynch t = new TestSynch(1000);
//		Thread t1 = new Thread(t);
//		Thread t2 = new Thread(t);
//		t1.start();
//		t2.start();
		
		MyThread2 my1 = new MyThread2();
		my1.setName("Thread A");
		MyThread2 my2 = new MyThread2();
		my2.setName("THread B");
		my1.start();
		try {
			my1.join(5000); //chờ thread chạy trong 5000 giây, thread 1 chưa xong thì thread khác vẫn chạy
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		my2.start();
		
//		
		

	}

}
