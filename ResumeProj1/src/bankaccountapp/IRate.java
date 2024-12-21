package bankaccountapp;

public interface IRate {
    //method that returns the base interest rate
    default double getBaseRate(){
        return 2.5;
    }
}
