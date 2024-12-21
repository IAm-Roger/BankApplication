package bankaccountapp;
import java.util.Random;

public abstract class Account implements IRate {
    //common properties between checking and savings account
    private String name;
    private String ssn;
    protected String accountNumber;
    protected String iin;
    protected String accountType;
    private static int uniqueID = 10000;
    private double balance;
    protected double rate;
    //constructor to initialize a base account
    public Account(String name, String ssn, double initDeposit){
        this.name = name;
        this.ssn = ssn;
        this.balance = initDeposit;
        uniqueID++;
        accountNumber = setAccountNumber();
    }

    public abstract void setRate();

    public void compound(){
        double accruedInterest = balance  * (rate/100);
        balance = balance + accruedInterest;
    }
    private String setAccountNumber(){
        String ssnLastTwo =  this.ssn.substring(ssn.length()-2);
        int uniqueID = Account.uniqueID;
        int randThreeNum = (int) (Math.random() * Math.pow(10,3));
        return ssnLastTwo + uniqueID + randThreeNum;
    }
    //Common methods: Transactions
    public void deposit(double deposit){
        balance = balance + deposit;
        printBalance();
    }

    public void withdraw(double withdraw){
        if((withdraw - balance) < 0)
        {
            System.out.println("Withdraw amount not allowed!");
        }
        else
        {
            balance = balance - withdraw;
            printBalance();
        }
    }

    public void transfer(String toWhere, double amount){
        if((amount - balance) < 0)
        {
            System.out.println("TRANSFER NOT ALLOWED: INSUFFICIENT FUNDS");
        }
        else
        {
            balance = balance - amount;
            System.out.println("TRANSFER MADE IN THE AMOUNT OF: " + amount + ", TO: " + toWhere);
            printBalance();
        }
    }
    public void printBalance(){
        System.out.println("CURRENT BALANCE IS: " + balance);
    }
    public void showAccountInfo(){
        System.out.println("NAME: " + name +
                           "\nACCOUNT NUMBER: " + accountNumber +
                           "\nBALANCE: " + balance);
    }
}
