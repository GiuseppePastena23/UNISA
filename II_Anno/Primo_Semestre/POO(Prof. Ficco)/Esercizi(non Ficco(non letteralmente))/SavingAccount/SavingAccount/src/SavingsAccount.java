
/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class SavingsAccount {
    private double balance;
    private double interestRate;

    public SavingsAccount() {
        this.balance = 0;
    }

    public SavingsAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public SavingsAccount(double initialBalance, double interestRate) {
        this(initialBalance);
        this.interestRate = interestRate;
    }

    /**
     * Gets the current balance of the bank account.
     * 
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposit money from the bank account.
     * 
     * @param amount amount to deposit
     */
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    /**
     * Withdraws money from the bank account.
     * 
     * @param amount amount to withdraw
     */
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    /**
     * Returns the interest rate in double
     * 
     * @return 
     */
    public double getInterestRate(){
        return this.interestRate/100;
    }

    /**
     * Add interest calculated within the current balance
     * 
     * @return bool if balance is positive
     */
    public boolean addInterest() {
        if(this.getBalance() > 0){
            this.balance += this.balance * this.getInterestRate();
            return true;
        }
        return false;
    }

    
}
