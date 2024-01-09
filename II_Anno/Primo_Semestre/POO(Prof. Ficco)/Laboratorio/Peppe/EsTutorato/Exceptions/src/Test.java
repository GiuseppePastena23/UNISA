import bank.*;

public class Test {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount(1000);
            account.deposit(500);
            account.withdraw(200);
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
