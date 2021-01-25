
public class CheckingAccount extends Account{
    
  
    @Override
    public void makeWithdraw(double withdraw){
        
        if(currentBalance - withdraw <= 0){
            
            //if withdrawal amount is more than balance in the account, subtract $15.00 from the balance
            currentBalance = currentBalance - 15;
            //Print insufficient funds message to the user
            System.out.println("Withdrawal declined due to insufficient funds");
            
            
        }
        else{
            //Otherwise make withdrawal
            super.makeWithdraw(withdraw);
        }
    }
    
    public void doMonthlyReport(){
       
        /*If there's withdrawal add $0.1 per withdrawal per withdrawal */
        if(numberOfWithdrawals>0){
            serviceCharge = numberOfWithdrawals*0.1 + 5;
            super.doMonthlyReport();//Call report method in the super class
        }
        else {
            //Otherwise the monthly fee remains 5
            serviceCharge = 5;
            super.doMonthlyReport();//Call report method of the superclass
        }
        
        
    }
    
}
