import java.util.*;
import java.io.*;
import java.util.HashMap;

public class Bank{

  // A Map of all the customers and accounts belong to this bank.
  private HashMap<Integer, Customer> customers;
  private HashMap<Integer, Account> accounts;
  private int bankId;

  public Bank(int bankId){
    this.bankId = bankId;
    this.customers = new HashMap<>();
    this.accounts = new HashMap<>();
  }

  // check to see if a customer ID belongs to this bank
  public boolean isValidCustomer(int customerId){
    return customers.containsKey(customerId);
  }

  // run only after checking "isValidCustomer"
  // check to see i fthe customer's pin is correct
  public boolean authenticateCustomer(int customerId, int inputPin){
    Customer customer = customers.get(customerId);
    return customer.correctPin(inputPin);
    } 

  // create and add a new customer to the bank
  public Customer addCustomer(String customerName, int pin ){
    Customer customer = new Customer(customerName, pin, generateCustomerId());
    customers.put(customer.getCustomerId(), customer);
    return customer;
  }

  // create and add a new account to the customer and to the bank
  public Account addAccount(Customer customer, int balance){
    Account account = new Account(customer.getCustomerId(), balance, generateAccountNumber());
    customer.addAccount(account);
    accounts.put(account.getAccountNumber(), account);
    return account;
  }

  //generate an account number randomly. 
  private int generateAccountNumber(){
    int num = (int) ((Math.random()*10000)%10000);
    while(accounts.containsKey(num)){
      num = (int) ((Math.random()*10000)%10000);
    }
    return num;
  }

  //generate an customer id randomly. 
  private int generateCustomerId(){
    int id = (int) ((Math.random()*10000)%10000);
    while(customers.containsKey(id)){
      id = (int) ((Math.random()*10000)%10000);
    }
    return id;
  }

  public int getBalance(int accountNum) {
    Account account = accounts.get(accountNum);
    return account.getBalance();
  }

  // true if successful, false if not
  public boolean deposit(int accountNum, int amount){
    Account account = accounts.get(accountNum);
    return account.deposit(amount);
  }

  // true if successful, false if not
  public boolean withdraw(int accountNum, int amount){
    Account account = accounts.get(accountNum);
    return account.withdraw(amount);
  }

  // get all the accounts from a particular customer.
  // true if successful, false if not
  public Set<Integer> getAccounts(int customerId){
    Customer customer = customers.get(customerId);
    return customer.getAccounts().keySet();
  }

}