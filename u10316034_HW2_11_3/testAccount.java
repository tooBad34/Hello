import java.util.Date;
import java.util.Scanner;

public class testAccount{
	public static void main(String[] args){
		Account Account1 = new Account(1122,20000);
		SavingsAccount SavingsAccount1 = new SavingsAccount(9999,20000);
		CheckingAccount CheckingAccount1 = new CheckingAccount(1234,20000);
		Scanner input = new Scanner(System.in);
		
		Account1.setannualInterestRate(4.5);
		CheckingAccount1.setannualInterestRate(4.5);
		SavingsAccount1.setannualInterestRate(4.5);
		
		for(int temp = 0;temp == 0;){
		
			System.out.println("Choose account : Account1(1), Checking Account(2), Savings Account(3)  (0 to end)");
			int input1 = input.nextInt();
		
			System.out.println("----------------------------------------------------------------------");
			if(input1 == 1){
				System.out.println(Account1.toString());
			}
			if(input1 == 2){
				System.out.println(CheckingAccount1.toString());
			}
			if(input1 == 3){
				System.out.println(SavingsAccount1.toString());
			}
			
			System.out.println("----------------------------------------------------------------------");
			if(input1 == 0){
				break;
			}
		
			System.out.println("Action: Withdraw money(1), Deposit money(2)   (0 to end)");
			int input2 = input.nextInt();
		
			System.out.println("----------------------------------------------------------------------");
			if(input1 == 1){
				if(input2 == 1){
					Account1.withdraw();
				}
				if(input2 == 2){
					Account1.deposit();
				}
				if(input2 == 0){
					break;
				}
				System.out.println(Account1.toString());
			
			}
		
		
			if(input1 == 2){
				if(input2 == 1){
					CheckingAccount1.withdraw();
				}
				if(input2 == 2){
					CheckingAccount1.deposit();
				}
				if(input2 == 0){
					break;
				}
				System.out.println(CheckingAccount1.toString());
			}
		
		
			if(input1 == 3){
				if(input2 == 1){
					CheckingAccount1.withdraw();
				}
				if(input2 == 2){
					CheckingAccount1.deposit();
				}
				if(input2 == 0){
					break;
				}
				System.out.println(CheckingAccount1.toString());
			}
			System.out.println("----------------------------------------------------------------------");
		
		}
		
	
	}

}

class Account{
	
	private int id ;
	private double balance ;
	private double annualInterestRate ;
	private Date dateCreated;

	
	
	Account(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	public Account(int id, double balance){
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	
	
	
	
	
	public void setid(int id){
		this.id = id;
	}
	
	public void setbalance(double balance){
		this.balance = balance;
	}
	
	public void setannualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	
	
	
	
	public int getid(){
		return id;
	}
	
	public double getbalance(){
		return balance;
	}
	
	public double getannualInterestRate(){
		return annualInterestRate;
	}
	
	public double getMonthlyInterestRate(){
		return balance * (getMonthlyInterest() / 100);
	} 
	
	public double getMonthlyInterest(){
		return annualInterestRate / 12;
	}
	
	public Date getDateCreated(){
		return dateCreated;
	}
	
	
	
	
	
	public void withdraw(){
		setbalance(getbalance() - 2500);
	}
	public void deposit(){
		setbalance(getbalance() + 3000);
	}
	
	
	public String toString(){
		
		return ("Your ID : " + getid() + "\n" + 
				"Your balance : " + getbalance() + "\n" +
				"Monthly interest rate : " + getMonthlyInterest() + "\n" +
				"Date : " + getDateCreated()
		);
					
	
	}

	
}




class CheckingAccount extends Account{

	CheckingAccount(){
		super();
	}
	CheckingAccount(int id, double balance){
		super(id,balance);
	}
	
	
	
	public void withdraw(){
		if(super.getbalance()-2500 < -5000){
			System.out.println("Checking account has overdraft limit 5000$");
			
		}
		else{
			super.withdraw();
		}
	}
	
	public void deposit(){
		super.deposit();
	}
	
	public String toString(){
		return super.toString();
	}
}




class SavingsAccount extends Account{
	
	SavingsAccount(){
		super();
	}
	SavingsAccount(int id, double balance){
		super(id,balance);
	}
	

	public void withdraw(){
		if(super.getbalance() - 2500 < 0){
			System.out.println("Savings account cannot be overdrawn");
		}
		else{
			super.withdraw();
		}
	}
	
	public void deposit(){
		super.deposit();
	}
	
	public String toString(){
		return  super.toString();
	}
	
}