public class BankAccount{
    private float balance; 

    public BankAccount(float balance)
    {
        this.balance = balance;
    }

    public float getBalance()
    {
        return this.balance;
    }

    public void withdraw(float amount){
       if (amount > this.balance) {
            throw new IllegalArgumentException("Not enough money");
       }
       balance = balance - amount;
    }
    
    public void deposit(float amount){
        this.balance += amount;
    }
}