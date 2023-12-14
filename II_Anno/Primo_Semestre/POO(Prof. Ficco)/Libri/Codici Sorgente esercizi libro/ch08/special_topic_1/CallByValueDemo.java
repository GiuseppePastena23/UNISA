public class CallByValueDemo
{
   public static void main(String[] args)
   {
      BankAccount harrysChecking = new BankAccount(2500);
      double savingsBalance = 1000;
      System.out.println("Before: " + savingsBalance);
      harrysChecking.transfer(500, savingsBalance); 
      System.out.println("After: " + savingsBalance);
      
      BankAccount harrysSavings = new BankAccount(1000);
      System.out.println("Before: " + harrysSavings.getBalance());
      harrysChecking.transfer(500, harrysSavings);  
      System.out.println("After: " + harrysSavings.getBalance());
      
      BankAccount savingsAccount = new BankAccount(1000);
      System.out.println("Before: " + savingsAccount.getBalance());
      harrysChecking.transfer2(500, savingsAccount);  
      System.out.println("After: " + savingsAccount.getBalance());
   }
}

