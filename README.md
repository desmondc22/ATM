# A Simple ATM Controller in Java

Write code for a simple ATM. It doesn't need any UI (either graphical or console), but a controller should be implemented and tested. However, this implemenation does include a console UI

#### Requirements

At least the following flow should be implemented:

Insert Card => PIN number => Select Account => See Balance/Deposit/Withdraw

For simplification, there are only 1 dollar bills in this world, no cents. Thus account balance can be represented in integer.

Your code doesn't need to integrate with a real bank system, but keep in mind that we may want to integrate it with a real bank system in the future.

It doesn't have to integrate with a real cash bin in the ATM, but keep in mind that we'd want to integrate with that in the future. And even if we integrate it with them, we'd like to test our code.

Implementing bank integration and ATM hardware like cash bin and card reader is not a scope of this task, but testing the controller part (not including bank system, cash bin etc) is within the scope.

A bank API wouldn't give the ATM the PIN number, but it can tell you if the PIN number is correct or not.

Based on your work, another engineer should be able to implement the user interface. You don't need to implement any REST API, RPC, network communication etc, but just functions/classes/methods, etc.

You can simplify some complex real world problems if you think it's not worth illustrating in the project.

#### Directory 

* Atm.java - A static function runs and the controller starts when a Bank is passed in. The ATM will call the bank to process most of the service for the customer.
* Account.java - An Account class. It has the balance of this account
* Bank.java - A Bank holds a list of all the Customers and Accounts that belong to this Bank. The bank process the service for the customer.
* Customer.java - a Customer class. It has the Customer's name, pin number, and all the Accounts under this Customer.

## Build and Execute Instructions

1. Clone this repo.
2. Make sure to have Java installed on locally.
3. Run the script: `./run.sh`. to compile and run
4. Follow the on-screen prompts to enter Customer info a for the controller.
  * Customer Name 
  * Pin Number 
5. Then you will be asked to enter the generated customer id (which will be display for you) and the pin number.
6. Follow the on-screen prompts to enter Account balance info for 2 accounts.
7. Follow the on-screen prompts to test the ATM Controller
  * _1_  - withdraw
  * _2_  - deposit
  * _3_  - balance
  * _4_  - exit
