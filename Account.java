import java.util.*;
import java.io.*;

public class Account{

  private int accountNumber;
  private int balance;
  private int customerId;

  public Account(int customerId, int balance, int accountNumber){
    this.customerId = customerId;
    this.balance = balance;
    this.accountNumber = accountNumber;
  }

  public int getAccountNumber(){
    return accountNumber;
  }

  public int getCustomerId(){
    return customerId;
  }

  public int getBalance() {
    return balance;
  }

  // true if successful, false if not
  public boolean deposit(int amount){
    balance += amount;
    return true;
  }


  // true if successful, false if not
  public boolean withdraw(int amount){
    if(balance - amount < 0){
      return false;
    } else {
      balance -= amount;
      return true;
    }
  }
}