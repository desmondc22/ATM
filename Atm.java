import java.util.*;
import java.io.*;

public class Atm {
  
  public static void main(String args[] ){ 

    Scanner s = new Scanner(System.in);  
    Bank bank = new Bank(1);
    System.out.println("Test case Customer and Account Info");
    System.out.print("Customer Name:");
    String name = s.nextLine();
    System.out.print("Pin Number:");
    int pin = s.nextInt();
    System.out.print("First Account Balance:");
    int amount1 = s.nextInt();
    System.out.print("Second Account Balance:");
    int amount2 = s.nextInt();
    Customer customer = bank.addCustomer(name, pin);
    Account account1 = bank.addAccount(customer,amount1);
    Account account2 = bank.addAccount(customer,amount2);
    System.out.println("");
    System.out.println("CustomerId: "+ customer.getCustomerId());
    System.out.println("");
    run(bank,s);

  }

  private static void run(Bank bank, Scanner s){
    // Scanner s = new Scanner(System.in);  
    boolean loggedIn = false;
    int customerId = -1;
    int accountNum = -1;
    int withdraw = 0,deposit = 0;

    while(true){
      System.out.println("Simple ATM");
      System.out.print("Please insert ATM card / Enter Customer ID:");
      int n = s.nextInt();
      if(bank.isValidCustomer(n)){
        customerId = n;
        break;
      } else {
        System.out.println("Invalid Customer ID\n Please try again");
      }
      System.out.println("");
    }
    while(true){
      System.out.print("Please enter pin number:");
      int n = s.nextInt();
      if(bank.authenticateCustomer(customerId, n)){
        loggedIn = true;
        break;
      } else {
        System.out.println("Invalid pin number\n Please try again");
      }
      System.out.println("");
    }
    while(loggedIn){
      System.out.println("Please select account:");
      Set<Integer> accounts = bank.getAccounts(customerId);
      HashMap<Integer, Integer> map = new HashMap<>();
      int counter = 0;
      for(Integer accountId : accounts){
        map.put(counter, accountId);
        System.out.println("Choose "+counter+ " for "+accountId);
        counter++;
      }
      System.out.print(":");
      int n = s.nextInt();
      if(n < 0 || n >= counter){
        System.out.println("Invalid input, try again");
        System.out.println("");
      } else {
        accountNum = map.get(n).intValue();
        System.out.println("");
        break;
      }
    }
    while(loggedIn){
      System.out.println("Welcome to Simple ATM");
      System.out.println("Choose 1 for Withdraw");
      System.out.println("Choose 2 for Deposit");
      System.out.println("Choose 3 for Check Balance");
      System.out.println("Choose 4 for EXIT");
      System.out.print("Choose the operation you want to perform:");
      int n = s.nextInt();
      switch(n){
        case 1:
          System.out.print("Enter money to be withdrawn:");
          withdraw = s.nextInt();
          if(bank.withdraw(accountNum, withdraw)){
            System.out.println("\n>> Please collect your money");
          }
          else{
            System.out.println("\n>> Insufficient Balance");
          }
          System.out.println("");
          break;

        case 2:
          System.out.print("Enter money to be deposited:");
          deposit = s.nextInt();
          if (bank.deposit(accountNum, deposit)){
            System.out.println("\n>> Your Money has been successfully depsited");
          }
          System.out.println("");
          break;

        case 3:
          System.out.println("\n>> Balance : "+bank.getBalance(accountNum));
          System.out.println("");
          break;

        case 4:
          System.exit(0);
        default:
        System.out.println("");
      } 
    }
  }
}
