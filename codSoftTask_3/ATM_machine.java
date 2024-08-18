package codSoftTask_3;

import java.util.Scanner;

public class ATM_machine {
	BankAccount ba=new BankAccount(1000);
	public void checkBalance(){
		System.out.println("your account balance is "+ ba.getBalance() );
		
	}
	public void deposit(double amount ) {
		
		if(amount>0) {
			ba.deposit(amount);
			System.out.println(amount +" is deposit to your account");
			System.out.println("now Your account balance is "+ba.getBalance());
			
		}
		else {
			System.out.println(amount +"is invalid");
		}
		
	}
	public void withdraw(double amount) {
		if(ba.getBalance()>amount) {
			double bal=ba.withdraw(amount);
			System.out.println(amount +"amount is withdraw from your account.");
			System.out.println("now Your account balance is"+ba.getBalance());
			
		}
		else if(ba.getBalance()<amount){
			System.out.println("The balance is less than given amount");
		}
		else {
			System.out.println("invalid amount");
		}
		
	}
	
	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	       do {
	    	ATM_machine am=new ATM_machine();
	    	System.out.println("\n----Welcome To ATM machine!----");
	        System.out.println("Enter 1 to Check Balance from your Account.");
	        System.out.println("Enter 2 for Deposit to your Account.");
	        System.out.println("Enter 3 for Withdraw from your Account.");
	        System.out.println("Enter 4 for Exit");
	        
	        int choice=sc.nextInt();
	        switch (choice) {
	            case 1:
	                am.checkBalance();
	                break;
	            case 2:
	                System.out.print("Enter amount to deposit: ");
	                double depositAmount = sc.nextDouble();
	                am.deposit(depositAmount);
	                break;
	            case 3:
	                System.out.print("Enter amount to withdraw: ");
	                double withdrawAmount = sc.nextDouble();
	                am.withdraw(withdrawAmount);
	                break;
	            case 4:
	            	System.out.println("Thank You!");
	            	break;
	            default:
	                System.out.println("Invalid choice,Please try again.");
	                break;
	        }
	       System.out.println("----Enter Y to continue----");
	       System.out.println("----Enter E to Exit----");
	       }while ("Y".equalsIgnoreCase(sc.next()));
	       System.out.println("----Thank You! ----");
	    }
}
