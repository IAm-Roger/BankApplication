package bankaccountapp;

public class Checking extends Account{
    //properties unique to checking account
    private int debitCardNumber;
    private int debitCardPin;


    //constructor to initialize settings for a checking account
    public Checking(String name, String ssn, double initDeposit){
        super(name,ssn,initDeposit);
        iin = "2";
        accountType = "CHECKING";
        accountNumber = iin + accountNumber;
        setDebitCard();

    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard(){
        debitCardNumber = (int) (Math.random() * Math.pow(10,12));
        debitCardPin = (int) (Math.random() * Math.pow(10,4));
    }
    //methods specific to checking accounts
    public void showAccountInfo(){
        super.showAccountInfo();
        System.out.println("ACCOUNT TYPE: " + accountType +
                           "\nDEBIT CARD NUMBER: " + debitCardNumber +
                           "\nDEBIT CARD PIN: " + debitCardPin + "\n");
    }
}
