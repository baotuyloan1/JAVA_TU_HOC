package deadlock;

public class BankAccount implements Runnable {
	private User user;
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		deposit();
	}
	
	public synchronized void deposit() {
		System.out.println(Thread.currentThread().getName() + ": Bank Account");
		
		System.out.println(Thread.currentThread().getName() + ": Waiting for user...");
		
		user.sendNotify();
	}
	
}
