package bank;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Bank bank = new Bank();
        BankAccount b1 = bank.addAccount(0, "Pippo");
        BankAccount b2 = bank.addAccount(100, "Pluto");
        System.out.println(b1.getBalance());
        System.out.println("Test 0");
        System.out.println(b2.getBalance());
        System.out.println("Test 100");
        bank.transfer(b2, b1, 50);
        System.out.println(b1.getBalance());
        System.out.println("Test 50");
        System.out.println(b2.getBalance());
        System.out.println("Test 50");
    }
}
