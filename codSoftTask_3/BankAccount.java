package codSoftTask_3;

public class BankAccount {
	private double balance;
	 public BankAccount(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	
	 
	public double deposit(double amount ) {
		balance=balance+amount;
		return balance;
		
		
	}
	public double withdraw(double amount) {
		balance=balance-amount;
		return balance;
		
		
	}
	



}
