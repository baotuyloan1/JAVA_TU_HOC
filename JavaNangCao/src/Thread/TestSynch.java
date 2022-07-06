package Thread;

public class TestSynch implements Runnable {
	private int tien;
	public TestSynch(int tien) {
		this.tien = 1000;
	}

	@Override
	public  void run() {
		rutTien();
	}
	
	public synchronized void rutTien() {
		if (tien > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tien = tien - 1000;
			System.out.println(tien);
		}else {
			System.out.println("het tien");
		}
	}

}
