import java.util.Random;
import java.util.Scanner;
import java.text.NumberFormat;

public class Bank
{ 
    public static void main(String[] args)
    {
        int sorted = 0;
        int filled = 0;
        String action;
        boolean run = true;
        Random RD = new Random();
        Scanner scan = new Scanner(System.in);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        AccountCollection bank = new AccountCollection();
        String[] names = {"Liam", "Emma", "Noah", "Olivia", "William", "Ava", "James", "Isabella", "Logan", "Sophia", "Benjamin", "Mia", "Mason", "Charlotte", "Elijah", "Amelia", "Oliver", "Evelyn", "Jacob", "Abigail", "Lucas", "Harper", "Michael", "Emily", "Alexander", "Elizabeth", "Ethan", "Avery", "Daniel", "Sofia", "Matthew", "Ella", "Aiden", "Madison", "Henry", "Scarlett", "Joseph", "Victoria", "Jackson", "Aria", "Samuel", "Grace", "Sebastian", "Chloe", "David", "Camila", "Carter", "Penelope", "Wyatt", "Riley", "Jayden", "Layla", "John", "Lillian", "Owen", "Nora", "Dylan", "Zoey", "Luke", "Mila", "Gabriel", "Aubrey", "Anthony", "Hannah", "Isaac", "Lily", "Grayson", "Addison", "Jack", "Eleanor", "Julian", "Natalie", "Levi", "Luna", "Christopher", "Savannah", "Joshua", "Brooklyn", "Andrew", "Leah", "Lincoln", "Zoe", "Mateo", "Stella", "Ryan", "Hazel", "Jaxon", "Ellie", "Nathan", "Paisley", "Aaron", "Audrey", "Isaiah", "Skylar", "Thomas", "Violet", "Charles", "Claire", "Caleb", "Bella"};
        int[] numbers = new int[100];
        
        // Randomization Sort //
        do
        {
            int randomNamesIndex = RD.nextInt(100-sorted)+sorted;
            String tempNames = names[sorted];
            names[sorted] = names[randomNamesIndex];
            names[randomNamesIndex] = tempNames;
            sorted++;
        }  
        while (sorted < 100);
        
        // Making sure there is no repeated account number //
        for (int index = 0; index < 100; index++)
        {
            int randomNumbers = RD.nextInt(900000000)+100000000;
            for (int check = 0; check < filled; check++)
            {
                if (randomNumbers == numbers[check])
                {
                    randomNumbers = RD.nextInt(900000000)+100000000; 
                    check = -1;
                } 
            }       
            numbers[index] = randomNumbers;
            filled++;
        }
        
        for (int auto = 0; auto < 100; auto++)
        {
            int subalances = RD.nextInt(100000);
            float mul = RD.nextFloat();
            double balances = subalances * mul;
            int passwords = RD.nextInt(9000)+1000;
            int lockOrUnlock = RD.nextInt(5);
            boolean locks = false;
            if (lockOrUnlock == 1 || lockOrUnlock == 2 || lockOrUnlock == 3 || lockOrUnlock == 4)
                locks = false;
            else if (lockOrUnlock == 0)
                locks = true;
            bank.addAccount(names[auto], numbers[auto], balances, passwords, locks);
        }
        System.out.println(bank);
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("GIL'S BANK");
        do 
        {
            System.out.println("\nIf you are a customer, please enter 1");
            System.out.println("If you are a teller, enter 2");
            String answer1 = scan.next();
            while (!"1".equals(answer1) && !"2".equals(answer1))
            {    
                System.out.println("Invalid response, please re-enter your answer:");
                answer1 = scan.next();
            }
            
            if (answer1.equals("1"))
            {
                System.out.println("Enter your account number:");
                String subNumber = scan.next();
                while (subNumber.matches("[0-9]+") == false || subNumber.length() != 9)
                {    
                    System.out.println("9 digits only, please re-enter your account number:");
                    subNumber = scan.next();
                }
                int myNumber = Integer.parseInt(subNumber);
                int count = 0;
                boolean tryPassword = true;
                boolean enterPassword = true;
                
                if (bank.checkNumber(myNumber) == false)
                {
                    do
                    {
                        System.out.println("We couldn't find your account number. Enter 1 to re-enter your account number.");
                        System.out.println("Enter 2 to create a new account. Enter 3 to exit.");
                        String answer2 = scan.next();
                        while (!"1".equals(answer2) && !"2".equals(answer2) && !"3".equals(answer2))
                        {    
                            System.out.println("Invalid response, please re-enter your answer:");
                            answer2 = scan.next();
                        }
                        if (answer2.equals("3"))
                        {   
                            run = false;
                            enterPassword = false;
                            break;
                        }
                        else if (answer2.equals("2"))
                        {
                            System.out.println("What's your first name?");
                            String myName = scan.next();
                            System.out.println("Choose 4 digits to be your password");
                            String subPassword = scan.next();
                            while (subPassword.matches("[0-9]+") == false || subPassword.length() != 4)
                            {    
                                System.out.println("4 digits only, please re-enter your password:");
                                subPassword = scan.next();
                            }
                            int myPassword = Integer.parseInt(subPassword);
                            bank.addAccount(myName, myNumber, 0, myPassword, false);
                            System.out.println("Congratulation! "+myName+", you are now one of the members of our bank.");
                            enterPassword = false;
                        }
                        else
                        {
                            System.out.println("Okay, enter your account number here:");
                            subNumber = scan.next();
                            while (subNumber.matches("[0-9]+") == false || subNumber.length() != 9)
                            {    
                                System.out.println("9 digits only, please re-enter your account number:");
                                subNumber = scan.next();
                            }
                            myNumber = Integer.parseInt(subNumber);
                        }
                    }
                    while(bank.checkNumber(myNumber) == false);
                }
                boolean myStatus = bank.getStatus(myNumber);
                
                if (enterPassword == true)
                {
                    System.out.println("Please enter your 4-digits password");
                    String subPassword = scan.next();
                    while (subPassword.matches("[0-9]+") == false || subPassword.length() != 4)
                    {    
                        System.out.println("4 digits only, please re-enter your password:");
                        subPassword = scan.next();
                    }
                    int myPassword = Integer.parseInt(subPassword);
                    if (bank.checkPassword(myPassword) == false)
                    {
                        do
                        {
                            count++;
                            if (count == 3)
                            {
                                System.out.println("Your account is locked because of 3 times of mistyping your password.\n");
                                bank.setStatus(myNumber, true);
                                break;
                            }
                            System.out.println("Your password is not correct. Do you want to try again? (Y/N)");
                            String answer5 = scan.next();
                            String response5 = answer5.toUpperCase();
                            while (!"Y".equals(response5) && !"N".equals(response5))
                            {    
                                System.out.println("Invalid response, please re-enter your answer:");
                                answer5 = scan.next();
                                response5 = answer5.toUpperCase();
                            }
                            if (response5.equals("Y"))
                            {
                                System.out.println("Okay, enter your password here");
                                String subPassword3 = scan.next();
                                while (subPassword3.matches("[0-9]+") == false || subPassword3.length() != 4)
                                {    
                                    System.out.println("4 digits only, please re-enter your password:");
                                    subPassword3 = scan.next();
                                }
                                int myPassword3 = Integer.parseInt(subPassword3);
                            }
                            else
                            {
                                run = false;
                                tryPassword = false;
                                break;
                            }
                        }
                        while(bank.checkPassword(myPassword) == false);
                    } 
                    
                    if (bank.getStatus(myNumber) == true && tryPassword == true)
                    {
                        System.out.println("Your account has been locked, would you like to see our manager? (Y/N)");
                        String answer3 = scan.next();
                        String response3 = answer3.toUpperCase();
                        while (!"Y".equals(response3) && !"N".equals(response3))
                        {    
                            System.out.println("Invalid response, please re-enter your answer:");
                            answer3 = scan.next();
                            response3 = answer3.toUpperCase();
                        }
                        if (response3.equals("Y"))
                        {
                            if (count == 3)
                            {
                                System.out.println("Manager: It looks like you forgot your password.");
                                System.out.println("Manager: Do you have your ID with you? (Y/N)");
                                String answer7 = scan.next();
                                String response7 = answer7.toUpperCase();
                                while (!"Y".equals(response7) && !"N".equals(response7))
                                {    
                                    System.out.println("Invalid response, please re-enter your answer:");
                                    answer7 = scan.next();
                                    response7 = answer7.toUpperCase();
                                }
                                if (response7.equals("Y"))    
                                {
                                    System.out.println("Manager: Okay, now we can unlock your account.");
                                    bank.setStatus(myNumber, false);
                                    System.out.println("Manager: I do need you to re-create a 4-digits password. Please enter your new passsword here:");
                                    String subPassword2 = scan.next();
                                    while (subPassword2.matches("[0-9]+") == false || subPassword2.length() != 4)
                                    {    
                                        System.out.println("4 digits only, please re-enter your password:");
                                        subPassword2 = scan.next();
                                    }
                                    int myPassword2 = Integer.parseInt(subPassword2);
                                    bank.setPassword(myNumber, myPassword2);
                                    System.out.println("Manager: Okay, \""+myPassword2+"\" will be your new password.");
                                    if(myStatus == true)
                                    {
                                        System.out.println("Manager: Wait, it seems your account was locked before you mistyped your password.");
                                        System.out.println("Manager: Did you do this transaction? (Y/N)");
                                        String answer4 = scan.next();
                                        String response4 = answer4.toUpperCase();
                                        while (!"Y".equals(response4) && !"N".equals(response4))
                                        {    
                                            System.out.println("Invalid response, please re-enter your answer:");
                                            answer4 = scan.next();
                                            response4 = answer4.toUpperCase();
                                        }
                                        if (response4.equals("Y"))    
                                        {
                                            System.out.println("Manager: Okay, now you are good, have a nice one.");
                                        }
                                        else
                                        {
                                            System.out.println("Manager: Okay, we will block this transaction,and we will replace your account number with a new one.");
                                            int newNumber = RD.nextInt(900000000)+100000000;
                                            for (int check = 0; check < bank.getLength(); check++)
                                            {
                                                if (newNumber == bank.getNumber(check))
                                                {
                                                    newNumber = RD.nextInt(900000000)+100000000; 
                                                    check = -1;
                                                } 
                                            }
                                            bank.replaceNumber(myNumber, newNumber);
                                            myNumber = newNumber;
                                            System.out.println("Manager: Your new account number is " + myNumber);
                                            }
                                    }
                                    System.out.println("\nHi "+bank.getName(myNumber)+", welcome back!");
                                }
                                else
                                {
                                    System.out.println("Manager: I'm sorry, but we have to see your ID to unlock your account.");
                                    run = false;
                                }
                            }
                            else
                            {
                                System.out.println("Manager: Did you do this transaction? (Y/N)");
                                String answer4 = scan.next();
                                String response4 = answer4.toUpperCase();
                                while (!"Y".equals(response4) && !"N".equals(response4))
                                {    
                                    System.out.println("Invalid response, please re-enter your answer:");
                                    answer4 = scan.next();
                                    response4 = answer4.toUpperCase();
                                }
                                if (response4.equals("Y"))    
                                {
                                    System.out.println("Manager: Okay, we will unlock your account for you.");
                                    bank.setStatus(myNumber, false);
                                    System.out.println("\nHi "+bank.getName(myNumber)+", welcome back!");
                                }
                                else
                                {
                                    System.out.println("Manager: Okay, we will block this transaction,and we will replace your account number with a new one.");
                                    int newNumber = RD.nextInt(900000000)+100000000;
                                    for (int check = 0; check < bank.getLength(); check++)
                                    {
                                        if (newNumber == bank.getNumber(check))
                                        {
                                            newNumber = RD.nextInt(900000000)+100000000; 
                                            check = -1;
                                        } 
                                    }
                                    bank.replaceNumber(myNumber, newNumber);
                                    myNumber = newNumber;
                                    bank.setStatus(myNumber, false);
                                    System.out.println("Manager: Your new account number is " + myNumber);
                                    System.out.println("\nHi "+bank.getName(myNumber)+", welcome back!");
                                }
                            }
                        }
                        else    
                            run = false;
                    }
                    else if (tryPassword == true)
                        System.out.println("Hi "+bank.getName(myNumber)+", welcome back!");
                }
                while(run == true)
                {
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Enter 1 to deposit\nEnter 2 to withdraw\nEnter 3 to check balance\nEnter 4 to delete your account");
                    action = scan.next();
                    switch (action)
                    {
                        case "1":
                            System.out.println("How much do you want to deposit?");
                            String subDeposit = scan.next();
                            while (subDeposit.matches("[0-9.]+") == false)
                            {    
                                System.out.println("Number only, please re-enter your amount");
                                subDeposit = scan.next();
                            }
                            double myDeposit = Double.parseDouble(subDeposit);
                            System.out.println("Depositing...");
                            bank.deposit(myNumber, myDeposit);
                            System.out.println("Completed!");
                            break;
                        case "2":
                            System.out.println("How much do you want to withdraw?");
                            String subWithdraw = scan.next();
                            while (subWithdraw.matches("[0-9.]+") == false)
                            {    
                                System.out.println("Number only, please re-enter your amount");
                                subWithdraw = scan.next();
                            }
                            double myWithdraw = Double.parseDouble(subWithdraw);
                            System.out.println("Withdrawing...");
                            boolean myEnoughCash = bank.withdraw(myNumber, myWithdraw);
                            if (myEnoughCash == true)
                                System.out.println("Completed! Here is your "+ fmt.format(myWithdraw) +" check");
                            else
                                System.out.println("Sorry, there is not enough cash in your account to complete the withdraw.");
                            break;
                        case "3":
                            System.out.println("Your balance is "+fmt.format(bank.getBalance(myNumber)));
                            break;
                        case "4":
                            bank.deleteAccount(myNumber);
                            System.out.println("Your account is deleted. Looking forward to work with you again in the future");
                            action = "-1";
                            break;
                        default:
                            System.out.println("Please enter a existing option");
                            action = "0";
                    }
                    if (action.equals("0"))
                        run = true;
                    else if (action.equals("-1"))
                        run = false;
                    else
                    {
                        System.out.println("\nMore actions? (Y/N)");
                        String input = scan.next();
                        String response2 = input.toUpperCase();
                        while (!"Y".equals(response2) && !"N".equals(response2))
                        {    
                            System.out.println("Invalid response, please re-enter your answer:");
                            input = scan.next();
                            response2 = input.toUpperCase();
                        }
                        if (response2.equals("N"))
                            run = false;
                    }
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\nThank you!");
            }
            else
            {
                System.out.println("Enter your administrator password:"); 
                String myAdminPassword = scan.next();
                while (!myAdminPassword.equals(bank.getAdminPassword()))
                {    
                    System.out.println("Wrong password, please try again");
                    myAdminPassword = scan.next();
                }
                if (myAdminPassword.equals(bank.getAdminPassword()))
                {
                    while(run == true)
                    {
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Enter 1 to get the account list\nEnter 2 to get accounts statistics\nEnter 3 to sort all accounts\nEnter 4 to filter all accounts\nEnter 5 to search one particular account\nEnter 6 to add interest to all accounts");
                            action = scan.next();
                        switch (action)
                        {
                            case "1":
                                System.out.println(bank.toString());
                                break;
                            case "2":
                                System.out.println(bank.reportStats());
                                break;
                            case "3":
                                bank.numberSort();
                                System.out.println("Sorting...");
                                System.out.println("All accounts are sorted based on their account numbers. (from the smallest to the biggest)");
                                break;
                            case "4":
                                System.out.println("Here are the accounts with a balance more than $50,000:\n");
								System.out.println(bank.richPeopleFilter());
                                break;
                            case "5":
                                System.out.println("Input the account number of the account you wish to find:");
								String findInput = scan.next();
				                while (findInput.matches("[0-9]+") == false || findInput.length() != 9)
				                {    
				                    System.out.println("9 digits only, please re-enter the account number:");
				                    findInput = scan.next();
				                }
								int intInput = Integer.parseInt(findInput);
								if (bank.getAccount(intInput).equals("Account not found"))
									System.out.println("\n"+bank.getAccount(intInput));
								else
								{
									System.out.println("Here it is:");
									System.out.println("\n"+bank.getAccount(intInput));
								}
								break;
                            case "6":
                                System.out.println(bank.addInterest());
                                break;
                            default:
                                System.out.println("Please enter a existing option");
                                action = "0";
                        }
                        if (action.equals("0"))
                            run = true;
                        else
                        {
                            System.out.println("\nMore actions? (Y/N)");
                            String input = scan.next();
                            String response2 = input.toUpperCase();
                            while (!"Y".equals(response2) && !"N".equals(response2))
                            {    
                                System.out.println("Invalid response, please re-enter your answer:");
                                input = scan.next();
                                response2 = input.toUpperCase();
                            }
                            if (response2.equals("N"))
                                run = false;
                        }
                    }     
                }   
            }
            System.out.println("\nNext person? (Y/N)");
            String answer5 = scan.next();
            String response5 = answer5.toUpperCase();
            while (!"Y".equals(response5) && !"N".equals(response5))
            {    
                System.out.println("Invalid response, please re-enter your answer:");
                answer5 = scan.next();
                response5 = answer5.toUpperCase();
            }
            if (response5.equals("Y"))
                run = true;
            else
                System.out.println("Done for today!");
        }
        while(run == true);
    }
}