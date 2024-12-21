package bankaccountapp;

public class Savings extends Account{
    //properties unique to savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    //constructor to initialize settings for a savings account
    public Savings(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        iin = "1";
        accountType = "SAVINGS";
        accountNumber = iin + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;

    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    //methods specific to savings accounts
    public void showAccountInfo(){
        super.showAccountInfo();
        System.out.println("ACCOUNT TYPE: " + accountType +
                           "\nSAFETY BOX ID: " + safetyDepositBoxID +
                           "\nSAFETY BOX KEY: " + safetyDepositBoxKey + "\n");
    }
}
