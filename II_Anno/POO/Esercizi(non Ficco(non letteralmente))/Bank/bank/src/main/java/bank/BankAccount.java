package bank;

public class BankAccount {
    private String customerName;
    private int balance;

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BankAccount() {
        this.customerName = "";
        this.balance = 0;
    }

    public BankAccount(String customerName) {
        this.customerName = customerName;
    }

    public BankAccount(String customerName, int initialBalance){
        this(customerName);
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public int getBalance(BankAccount account) {
        return account.getBalance();
    }
}
