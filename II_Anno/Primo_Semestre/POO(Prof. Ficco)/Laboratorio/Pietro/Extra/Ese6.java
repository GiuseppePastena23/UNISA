//Crea una classe Bank con una collezione di account
//E metodi per aggiungerli e rimuoverli e per depositare e ritirare soldi
//Crea una classe Account per gestire i dettagli di un cliente

import java.util.ArrayList;

class Account {
	private String name;
	private String accNum;
	private double balance;
	//Costruttore
	public Account (String name, String accNum, double balance) {
		this.name = name;
		this.accNum = accNum;
		this.balance = balance;
	}
	//Get e Set
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum (String accNum) {
		this.accNum = accNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance (double balance) {
		this.balance = balance;
	}
	//Deposito e prelievo
	public void deposit (double amount) {
		balance = balance + amount;
	}
	public void withdraw (double amount) {
		balance = balance - amount;
	}
	//Informazioni dell'account
	public String getInfo() {
		return ("Name: " + name + ", Account Number: " + accNum + ", Balance: " + balance);
	}
}

class Bank {
	private ArrayList < Account > accounts;
	//Costruttore
	public Bank() {
		accounts = new ArrayList < Account > ();
	}
	//Operazioni possibili
	public void addAccount (Account a) {
		accounts.add (a);
	}
	public void removeAccount (Account a) {
		accounts.remove (a);
	}
	public void depositMoney (Account a, double amount) {
		a.deposit (amount);
	}
	public void withdrawMoney (Account a, double amount) {
		a.withdraw (amount);
	}
	public ArrayList < Account > getAccounts() {
		return accounts;
	}
}

public class Ese6 {
	public static void main (String[] args) {
		Bank bank = new Bank();
		Account a1 = new Account ("Peter", "C015", 6000);
		Account a2 = new Account ("Katia", "C016", 19000);
		Account a3 = new Account ("Jenna", "C017", 2000);
		
		bank.addAccount (a1);
		bank.addAccount (a2);
		bank.addAccount (a3);
		
		ArrayList < Account > accounts = bank.getAccounts();
		
		//for (data_type variable: array_name)
		for (Account account: accounts) {
			System.out.println (account.getInfo());
		}
		
		System.out.println ("\nAfter depositing 1000 into account1:");
		bank.depositMoney (a1, 1000);
		System.out.println (a1.getInfo());
		System.out.println ("No transaction in account2");
		System.out.println (a2.getInfo());
		System.out.println ("After withdrawing 300 from account3:");
		bank.withdrawMoney (a3, 300);
		System.out.println (a3.getInfo());
	}	
}