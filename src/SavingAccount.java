
import java.text.NumberFormat;


public class SavingAccount extends Account{
    
     
    @Override
    public void makeDeposit(double deposit){
        
        if(currentAccountStatus == true){
            
            //if account is active call super class and make a deposit
           super.makeDeposit(deposit);
        }
        else if((currentAccountStatus == false)&& (currentBalance +deposit>=25)){
            /*Otherwise if acouint is not active and the deposit brings 
                balance above 25 dollars set account status to true*/
            currentAccountStatus = true;

            super.makeDeposit(deposit); //Call super class and make a deposit

        }
        else{
            //Otherwise print sorry minimum amount of $ 25 has to be deposited
            System.out.println("Sorry, minimum amount of $25.00 dollars must be deposited.");
        }
    }
   
    @Override
    public void makeWithdraw (double withdraw){

        if(currentAccountStatus == true){
            //If account is active make a withdrawal
            super.makeWithdraw(withdraw);
            if(currentBalance-withdraw < 25){
                //If withdrawal amount is more than balance set status of the account to false
                currentAccountStatus = false;
            }
        }
        else{
            //Otherwise print sorry account is inactive
            System.out.println("Sorry, account is inactive.Please, Make a deposit first.");
        }
    }

    @Override
    public void doMonthlyReport(){
       
        if( numberOfWithdrawals> 4){
            //If number of withdrawals is greater than 4 assign service charge value of $1.00 for each withdrawal
            serviceCharge = 1.0*(numberOfWithdrawals-4);
            super.doMonthlyReport(); //Call super class report method

        }
        else{
            //Otherwise call super class report method
            super.doMonthlyReport();
        }

    }

         
}
