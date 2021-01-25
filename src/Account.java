
import java.text.NumberFormat;


public abstract class Account {
    
    //Declare varaibles and initialize
    protected double startingBalance       = 0.0;
    protected double currentBalance        = 0.0;
    protected double totalOfDeposits       = 0.0;
    protected int numberOfDeposits         = 0;
    protected double totalOfWithdrawals    = 0.0;
    protected int numberOfWithdrawals      = 0;
    protected double annualInterestRate    = 0.0;
    protected double serviceCharge         = 0.0;
    protected boolean currentAccountStatus = false;
    
    public Account(){
        // pass starting balance and annual interest rate to parameterized constructor
        this(0.0, 0.02);
    }
   
    public Account (double startingBalance,double annualInterestRate){
        this.startingBalance = startingBalance;
        this.annualInterestRate = annualInterestRate;
       
    }
   
    public void makeDeposit(double deposit){
       /* Receive depost and adjust balance and total amount deposits 
       and number of deposits */
       currentBalance = currentBalance+deposit;
       totalOfDeposits = totalOfDeposits + deposit;
       numberOfDeposits++;
     
    }
    
    public void makeWithdraw(double withdraw){
        currentBalance = currentBalance - withdraw;
        totalOfWithdrawals = totalOfWithdrawals +withdraw;
        numberOfWithdrawals++;

    }

    public double calculateInterest(double currentBalance){
        double monthlyInterestRate = ( annualInterestRate /12);
        double monthlyInterest = currentBalance*monthlyInterestRate;
        return currentBalance = currentBalance + monthlyInterest;
    }
    
    public void doMonthlyReport(){
        
        //Subtract service charge from balance and pass it calculateInterest method
        double tempBalance = currentBalance - serviceCharge;
        double tBalance = calculateInterest(tempBalance);
        
        //Format amounts to currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String startBalance = currency.format(startingBalance);
        String totalDeposits = currency.format(totalOfDeposits);
        String totalWithdrawals = currency.format(totalOfWithdrawals);
        String serviceCharg = currency.format(serviceCharge);
        String balance = currency.format(tBalance);
        
        System.out.println(
                "Your Monthly statement "+"\n"+
                "-----------------------"+"\n"+
                "Starting balance : " + startBalance +"\n"+
                "Total amount of Deposits : " + totalDeposits  + "\n"+ 
                "Total amount of withdrawals : " + totalWithdrawals + "\n"+ 
                "Service charges : " + serviceCharg +"\n" +
                "Current balance : " + balance + "\n" +
                "Account status :"   + currentAccountStatus + "\n");
        
        //Transfer balance to starting balance
        startingBalance         = tBalance;
        numberOfWithdrawals     = 0;
        numberOfDeposits        = 0;
        serviceCharge           = 0.0;
        totalOfDeposits         = 0.0;
        totalOfWithdrawals      = 0.0;
        currentBalance          = 0.0;
        
        
        
    }
    
    
}

