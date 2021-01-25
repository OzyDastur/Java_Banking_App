
import java.util.Scanner;

//Create a menu class that extends Account
public class Menu extends Account {
    
    Scanner userInput = new Scanner(System.in);//Create a scanner object
    SavingAccount sA = new SavingAccount();//Create a SavingAccount object
    CheckingAccount cA = new CheckingAccount();//Create a CheckingAccount object
    
    private String bankMenu;//Declare a string to store bank menu
    private String savingMenu;//Declare a string to store saving menu
    private String checkingMenu;//Declare a string store checking menu
    private double deposit;//Declare a double to store deposit
    private double withdraw;//Declare a double to store withdraw
    
    public void performTransaction() {
       
       bankMenu();//Call bank menu
       //As long the choice is not C show the bank menu
       while(true){ 
           //If selection is A call saving menu
            if(bankMenu.equalsIgnoreCase("A")){
                //As long as the choice is NOT D keeping showing the saving menu
                while(true){ 
                    
                    savingMenu();
                    //If selection is A call makeDeposit method of the saving account
                    if(savingMenu.equalsIgnoreCase("A")){
                        makeDepositSaving();
                    }
                    //If selection is B call makeWithrawal method of the saving account
                    else if(savingMenu.equalsIgnoreCase("B")){
                        makeWithdrawSaving();
                    }
                    //If selection is C call doReport method of the saving account
                    else if(savingMenu.equalsIgnoreCase("C")){
                        doReportSaving();
                    }
                    //Otherwise go back to the bank menu 
                    else{
                        bankMenu();
                        break;//Break out the loop
                    }
                }     
            }
            //If selection is B call checking menu
            else if(bankMenu.equalsIgnoreCase("B")){
                //As long as the choice is NOT D keeping showing the checking menu
                while(true){
                    checkingMenu();
                    
                    /*If selection is A call makeDeposit method of will be called 
                    which will go directly to the supper class makeDeposit*/
                    if(checkingMenu.equalsIgnoreCase("A")){
                        makeDepositChecking();
                            
                    }
                    //If selection is B call makeWithrawal method of the checking account
                    else if(checkingMenu.equalsIgnoreCase("B")){
                        makeWithdrawChecking();

                    }
                    //If selection is c call doReport method of the checking account
                    else if(checkingMenu.equalsIgnoreCase("C")){
                        doReportChecking();
                    }
                    else{
                        //Otherwise go back to the bank menu 
                        bankMenu(); 
                        break;//Break out of the loop
                    }
                }
            }
            //Otherwise exit the program
            else{
                System.exit(0);

            }
       }
      
    }
   
    public void bankMenu() {
        //Display a welcome message and prompt user to select an account
        System.out.println("+----------------------------------+");
        System.out.println("|          WELCOME TO YOUR         |");
        System.out.println("|         FAVORITE BANK APP        |");
        System.out.println("+----------------------------------+");
        System.out.println("        .   .   .   .   .          \n");
        System.out.println("Please select an account type:\n");
        System.out.println("Bank Menu");
        System.out.println("A: Savings\nB: Checking\nC: Exit");
        
        //Validate the entry is a string
        if(userInput.hasNext()){
             //read the entry and assign it to bankMenu
            bankMenu = userInput.next();
            System.out.println();
        }
        else{
            //Otherwise assign a random value to the bankMenu
            bankMenu ="z";
        }
        //Discard the entry
        userInput.nextLine();
        
        //Validate and ensure user only enters A or B or C
        while(!(bankMenu.equalsIgnoreCase("A") || bankMenu.equalsIgnoreCase("B")
                || bankMenu.equalsIgnoreCase("C"))){
            
             //prompt user to enter a valid entry
            System.out.println("Please select a valid account type");
            if(userInput.hasNext()){
            
            //read the entry and assign it to bankMenu
            bankMenu = userInput.next();
            System.out.println();
            }
            else{
                //Otherwise Assign a random value to the bankMenu
                bankMenu = "z";
            }
            //Discard the invalid entry
            userInput.nextLine();
        }
        
    }

    public void savingMenu() {
        //Prompt user to choose a transaction type
        System.out.println("Please choose transaction type:\n");
        System.out.println("Savings Menu");
        System.out.println("A: Deposit\nB: Withdrawal\nC: Report\nD: Return To Bank Menu");
        
        //Validate the entry is a string
        if(userInput.hasNext()){
            
            //read the entry and assign it savingMenu
            savingMenu = userInput.next();
            System.out.println();
        }
        else{
            //Otherwise Assign a random value to the savingMenu
            savingMenu ="z";
        }
        //Discard the invalid entry
        userInput.nextLine();
        
        //Validate and ensure user only enters A or B or C or D
        while(!(savingMenu.equalsIgnoreCase("A") || savingMenu.equalsIgnoreCase("B")
                || savingMenu.equalsIgnoreCase("C")||savingMenu.equalsIgnoreCase("D") )){
            
            //Prompt user to enter a valid transaction 
            System.out.println("Please select a valid transaction");
            
            //Validate the entry is a string
            if(userInput.hasNext()){
              //read the entry and assign it savingMenu
              savingMenu = userInput.next();
              System.out.println();
            }
            else{
                //Otherwise Assign a random value to the savingMenu
                savingMenu = "z";
            }
            //Discard the invalid entry
            userInput.nextLine();
        }
        
    }

    public void checkingMenu() {
        //Prompt user to choose a transaction type
        System.out.println("Please choose transaction type:\n");
        System.out.println("Checking Menu");
        System.out.println("A: Deposit\nB: Withdrawal\nC: Report\nD: Return To Bank Menu");
        
        //Validate the entry is a string
        if(userInput.hasNext()){
            //read the entry and assign it savingMenu
            checkingMenu = userInput.next();
        }
        else{
            //Otherwise assign a random value to the checkingMenu
            checkingMenu ="z";
        }
        //Discard the invalid entry
        userInput.nextLine();
        
        //Validate and ensure user only enters A or B or C or D
        while(!(checkingMenu.equalsIgnoreCase("A") || checkingMenu.equalsIgnoreCase("B")
                || checkingMenu.equalsIgnoreCase("C")||checkingMenu.equalsIgnoreCase("D") )){
            
            //Prompt user to choose a valid transaction 
            System.out.println("Please select a valid transaction");
            
            //Validate entry is a string
            if(userInput.hasNext()){
              
             //read the entry and assign it to checkingMenu
              checkingMenu = userInput.next();
            }
            else{
                //Otherwise assign a random value to the checkingMenu
                checkingMenu = "z";
            }
            //Discard the invalid entry
            userInput.nextLine();
        }
        
    }

    
    public void makeDepositSaving(){
           
            //Prompt user for deposit amount
            System.out.println("How much would you like to deposit ?");
            
            //Validate the entry is a double
            if(userInput.hasNextDouble()){
               
                //Assing entry to deposit
                deposit = userInput.nextDouble();
            }
            else{
                //Otherwise assing a random number
                deposit = -1;
            }
            //Discard the invalid entry
            userInput.nextLine();
           
            while(deposit<=0){
                //As long as amount is zero or negative promp user to enter valid amount
                System.out.println("Please enter valid amount");
              
                //Validate entry is double
                if(userInput.hasNextDouble()){
                    //Assing value to deposit
                    deposit = userInput.nextDouble();
                }
                else{
                    //Otherwise assign a random value to deposit
                    deposit = -1;
                }
                //Discard invalid entry
                userInput.nextLine();
               
            }
            //Call makeDeposit method in saving account class and pass deposit
            sA.makeDeposit(deposit);
            System.out.println();
    }
    
    public void makeDepositChecking(){
           //Prompt user for deposit amount
            System.out.println("How much would you like to deposit ?");
            
            //Validate entry is double
            if(userInput.hasNextDouble()){
               
                //Assign value to deposit
                deposit = userInput.nextDouble();
            }
            else{
                //Otherwise assign a random value 
                deposit = -1;
            }
            //Discard invalid entery
            userInput.nextLine();
           
            while(deposit<=0){
                 //As long as amount is zero or negative promp user to enter valid amount
                System.out.println("Please enter valid amount");
                
                //Validate entry is double
                if(userInput.hasNextDouble()){
                    
                    //Assign entry to deposit
                    deposit = userInput.nextDouble();
                }
                else{
                    //Otherwise assign a random number to deposit
                    deposit = -1;
                }
                //Discard invalid entry
                userInput.nextLine();
               
            }
           //Call super (Abstract Account) class makeDeposit method and pass deposit
           cA.makeDeposit(deposit);
           
           //Make status of the checking account true
           cA.currentAccountStatus = true;
           System.out.println();
    }
    
    
    public void makeWithdrawSaving(){
        
        //Prompt user for withdrawal amount
        System.out.println("How much would you like to withdraw ?");
        
            //Validate entry is double
            if(userInput.hasNextDouble()){
               
                //Assing to withraw
                withdraw = userInput.nextDouble();
            }
            else{
                //Otherwise assign a random value
                withdraw = -1;
            }
            //Discard invalid entry
            userInput.nextLine();
           
            while(withdraw<=0){
                
                //As long as the entry is negative or zeor prompt to user to enter a valid amount
                System.out.println("Please enter valid amount");
                
                //Validate amount is double
                if(userInput.hasNextDouble()){
                    
                    //Assign entry to withdraw
                    withdraw = userInput.nextDouble();
                }
                else{
                    //Otherwise assign a random value to withdraw
                    withdraw = -1;
                }
                //Discard invalid entry
                userInput.nextLine();
                
            }
            //Call makeWithdraw method in savingAccount and pass withdrawal amount
            sA.makeWithdraw(withdraw);
            System.out.println();
    }
    public void makeWithdrawChecking(){
        
        //Prompt user for withdrawal amount
        System.out.println("How much would you like to withdraw ?");
        
            //Validate user enters a double
            if(userInput.hasNextDouble()){
               
                //Assign value to withdraw
                withdraw = userInput.nextDouble();
            }
            else{
                //Assign a random number to withdraw
                withdraw = -1;
            }
            //Discard invalid entery
            userInput.nextLine();
           
            while(withdraw<=0){
                //As long as the entry is negative or zero prompt user to enter a valid amount
                System.out.println("Please enter valid amount");
                
                //Validate entry is double
                if(userInput.hasNextDouble()){
                    
                    //Assign value to withdraw
                    withdraw = userInput.nextDouble();
                }
                else{
                    //Otherwise assign a random value to withdraw
                    withdraw = -1;
                }
                //Discard invalid entry
                userInput.nextLine();
                break; //Break out of the loop
            }
            //Call makeWithdraw method in saving account and pass withdrawal amount
            cA.makeWithdraw(withdraw);
            System.out.println();
    }
    
    public void doReportSaving(){
        //Call report method in the saving account
        sA.doMonthlyReport();
    }
    public void doReportChecking(){
        //Call report method in checking account
        cA.doMonthlyReport();
    }     
}
