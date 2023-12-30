package bank;

public class Bank {
    BankAccount[] accounts;
    int numAccounts;

    public Bank() {
        accounts = new BankAccount[10];
        numAccounts = 0;
    }

    public BankAccount addAccount(int initialBalance, String customerName) {
        accounts[numAccounts] = new BankAccount(customerName, initialBalance);
        numAccounts++;
        return accounts[numAccounts - 1];
    }

    public void deposit(BankAccount account, int amount){
        account.deposit(amount);
    }

    public void withdraw(BankAccount account, int amount){
        account.withdraw(amount);
    }

    public int getBalance(BankAccount account){
        return account.getBalance();
    }

    public void transfer(BankAccount from, BankAccount to, int amount){
        from.withdraw(amount);
        to.deposit(amount);
    }
}
