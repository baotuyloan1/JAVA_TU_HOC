package deadlock;

public class User implements Runnable {
	private BankAccount bankAccount;
	
	

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
	}
	
	public synchronized void sendNotify() {
		System.out.println(Thread.currentThread().getName() + " User");
		
		System.out.println(Thread.currentThread().getName() + " Waiting for bankAccount...");
		
		bankAccount.deposit();
	}

}
