public class SavingsAccountTest {
    public SavingsAccountTest() {
        SavingsAccount s1 = new SavingsAccount(1000.00, 1.2);
        SavingsAccount s2 = new SavingsAccount();
        System.out.print("1000.0 - ");
        System.out.println(s1.getBalance());
        System.out.print("0.0 - ");
        System.out.println(s2.getBalance());
        System.out.print("true - ");
        System.out.println(s1.addInterest());
        System.out.print("1012.0 - ");
        System.out.println(s1.getBalance());
        s1.withdraw(100);
        System.out.print("912.0 - ");
        System.out.println(s1.getBalance());

    }
}
