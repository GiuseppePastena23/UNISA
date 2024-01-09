package bank;

public class BankAccount{

    private double balance = 0;

    public BankAccount(double balance) throws NullBankAccountException{
        if (balance >= 0){
            this.balance = balance;
        }
        else{
            throw new NullBankAccountException("Valore minore di zero");
        }
    }

    public void deposit(double amount) throws NullDepositException{
        if(amount >= 0){
            this.balance += amount;
        }
        else{
            throw new NullDepositException("Valore minore di zero");
        }
    }

    public void withdraw(double amount) throws NullDepositException{
        if(amount >= 0 && amount < this.balance){
            this.balance -= amount;
        }
        else{
            throw new NullDepositException("Valore minore di zero");
        }
    }
}
