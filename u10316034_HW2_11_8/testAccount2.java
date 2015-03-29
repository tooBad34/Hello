import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class testAccount2{
	public static void main(String[] args){
		
		Account Account1 = new Account("George",1122,1000);
		
		Transaction Transaction1 = new Transaction();
		
		
		Account1.setannualInterestRate(1.5);
		
		System.out.println(Account1.toString());
		
		
		Account1.deposit(30);
		Account1.deposit(40);
		Account1.deposit(50);
		
		Account1.withdraw(5);
		Account1.withdraw(4);
		Account1.withdraw(2);
		
		
		
	
	}

}
class Account{
	
	private int id ;
	private double balance ;
	private double annualInterestRate ;
	private Date dateCreated;
	private String name;
	
	int x = 0;
	
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	
	Account(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	
	
	Account(String name, int id, double balance){
		this.name = name;
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}
	
	
	
	public void setid(int id){
		this.id = id;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public void setannualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	
	
	
	
	public int getid(){
		return id;
	}
	
	public double getBalance(){
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
	
	
	
	
	
	public void withdraw(double money){
		setBalance(getBalance() - money);
		transactions.add(new Transaction('-',money,balance,"You withdraw"));
		balance = balance - money;
		
		System.out.println("\n"+((Transaction)transactions.get(x)).getDescription2());
		
		x++;
	}
	
	
	
	public void deposit(double money){
		setBalance(getBalance() + money);
		transactions.add(new Transaction('+',money,balance,"You deposit"));
		balance = balance + money;
		
		System.out.println("\n"+((Transaction)transactions.get(x)).getDescription2());
		
		x++;
	}
	
	
	public String toString(){
		
		return ("\n"+
				"Holder name : " + name + "\n" +
				"Your ID : " + getid() + "\n" + 
				"Your balance : " + getBalance() + "\n" +
				"Monthly interest rate : " + getMonthlyInterest() + "\n" +
				"Date : " + getDateCreated()
		);
		
					
	
	}

	

	
}
class Transaction{
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	
	Transaction(){
	
	}
	
	public Transaction(char type,double amount,double balance,String description){
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		
	}
	
	
	public void setType(char type){
		this.type = type;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	
	
	public char getType(){
		return type;
	}
	public String getDescription(){
		return description;
	}
	public String getDescription2(){
		return (getDescription() + "\nType : " + getType() + "\nAmount : " + 
				getAmount() + "\nYour balance : " + getBalance());
	}
	public double getBalance(){
		return balance;
	}
	public double getAmount(){
		return amount;
	}
	

	

}