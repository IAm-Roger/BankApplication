package bankaccountapp;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) throws FileNotFoundException {
        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\Users\\comic\\Downloads/NewBankAccounts.csv";
        List<String[]> newAccountHolder = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolder) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equalsIgnoreCase("Savings")) {
                accounts.add(new Savings(name, ssn, initDeposit));
            } else if (accountType.equalsIgnoreCase("Checking")) {
                accounts.add(new Checking(name, ssn, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE/INVALID ACCOUNT TYPE");
            }
        }

        System.out.println("SUCCESSFULLY CREATED " + accounts.size() + " NEW ACCOUNTS");
        //print out accounts and their respective info based on account type
        for (Account acc : accounts)
        {
            System.out.println("************************************");
            acc.showAccountInfo();
        }

        /*
        Checking chk123 = new Checking("John","300289090",2000);
        Savings sav123 = new Savings("John", "700590101", 20000);
        chk123.showAccountInfo();
        System.out.println("*************");
        sav123.showAccountInfo();
        */
    }
}
