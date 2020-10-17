import java.util.*;
import java.io.*;

public class Customer{

  private HashMap<Integer, Account> accounts;
  private int customerId; // Also the cardNumber
  private int pin;
  private String customerName;
  private HashSet<Integer> banks;

  public Customer(String customerName, int pin, int customerId){
    this.customerId = customerId;
    this.pin = pin;
    this.customerName = customerName;
    this.accounts = new HashMap<Integer, Account>();
  }

  // We could never access the pin, we can only check if the input pin
  // is the correct pin.
  public boolean correctPin(int pin){
    if(this.pin == pin){
      return true;
    } else {
      return false;
    }
  } 

  // We could never access the pin, we can only check if the input pin
  // is the correct pin.
  public void setPin(int pin){
      this.pin = pin;
  } 

  public int getCustomerId(){
    return this.customerId;
  }

  public HashMap<Integer, Account> getAccounts() {
    return accounts;
  }

  // add a new account for this customer
  // add and return true only if the account number doesnt exist for this customer.
  public boolean addAccount(Account acct){
    if(accounts.containsKey(acct.getAccountNumber())){
      return false;
    } else {
      accounts.put(acct.getAccountNumber(), acct);
      return true;
    }
  }

  // delete an account for this customer.
  // delete and return true only if the account exist for this customer.
  public boolean deleteAccount(Account acct){
    if(!accounts.containsKey(acct.getAccountNumber())){
      return false;
    } else {
      accounts.remove(acct.getAccountNumber());
      return true;
    }
  }

}