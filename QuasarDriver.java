
/**
 * QuasarDriver.java
 * v1.0
 * by SkyShep
 * 
 * Driver for the QuasarRandomizer and QuasarPayout classes.
 * Runs the game for the player.
 */

import java.util.Scanner;
import java.util.Formatter;

public class QuasarDriver
{
    public static void main(String[] args)
    {
        Scanner stdIn = new Scanner(System.in);
        QuasarRandomizer num = new QuasarRandomizer();
        QuasarPayout money = new QuasarPayout();
    
        double bet = 200;   // Minimum player bet
        String input;       // Player decision to play game
        String add;         // Player decision to add points to total
        int number;         // Player's number
        String pay;         // Player decision to pay out
        
        System.out.println("Welcome to Quasar! \nWould you like to play? Y/N");
        input = stdIn.next();
        // Input validation in case player hits wrong key
        while(!(input.equalsIgnoreCase("Y")) && !(input.equalsIgnoreCase("N")))
        {
            System.out.println("Oops, wrong key! Would you like to play? Y/N");
            input = stdIn.next();
        } // end input validation
        
        // Main while loop. Will continue so long as user inputs Y.
        while(input.equalsIgnoreCase("Y"))
        {
            number = 0;
            System.out.println("You currently have " + money.getPurse() + " credits in your purse.");
            if(money.getPurse() < 200)
            {
                System.out.println("Sorry, you do not have enough money for a minimum bet.");
                input = "N";
            }
            System.out.println("Please place a bet. Minimum bet is 200 credits.");
            bet = stdIn.nextDouble();
            if(bet < 200)
            {
                System.out.println("Oops! Minimum bet is 200 credits. \nPlease place your bet.");
                bet = stdIn.nextDouble();
            }
            money.playerBet(bet);
            System.out.println("Get as close to 20 as possible! \nStarting number: " + num.getInitial());
            number = num.getTotal();
              // Prompts to select more numbers when the total is between
              // 1 and 14.
              while(number >= 1 && number <= 14)
              {
                  System.out.println("To add a number between 1 and 8, press X \nTo add a number between 4 and 7, press Y ");
                  add = stdIn.next();
                    if(add.equalsIgnoreCase("X"))
                    { 
                        num.OnetoEight();
                    }
                    else if(add.equalsIgnoreCase("Y"))
                    {
                        num.FourtoSeven();
                    }
                    else if (!(add.equalsIgnoreCase("Y")) && !(add.equalsIgnoreCase("N")))
                    {
                        System.out.println("Oops! Please press X or Y");
                        add = stdIn.next();
                    }
                  System.out.println("Number: " + num.getTotal());
                  number = num.getTotal();
              }
              
              // At the number 15, give player the option to pay out
              while(number >= 15 && number <= 20)
              {
                  System.out.println("Payout? Press Y to pay out. \nPress any other key to add another number.");
                  pay = stdIn.next();
                    if(pay.equalsIgnoreCase("Y"))
                    {
                        money.payPlayer(number, bet);
                        System.out.println("Play again? Y/N");
                        input = stdIn.next();
                    }
                  System.out.println("To add a number between 1 and 8, press X \nTo add a number between 4 and 7, press Y ");
                  add = stdIn.next();
                    if(add.equalsIgnoreCase("X"))
                    { 
                        num.OnetoEight();
                    }
                    else if(add.equalsIgnoreCase("Y"))
                    {
                        num.FourtoSeven();
                    }
                    else if (!(add.equalsIgnoreCase("Y")) && !(add.equalsIgnoreCase("N")))
                    {
                        System.out.println("Oops! Please press X or Y");
                        add = stdIn.next();
                    }
                  System.out.println("Number: " + num.getTotal());
                  number = num.getTotal();
                  
              } // end 15 to 20 loop
              
              // Over 20, the player busts
              while(number > 20)
              {
                  System.out.println("Bust! \nPlay again? Y/N");
                  input = stdIn.next();
              } // end bust loop
        } // end main while loop
        
        // Quitting message
        System.out.println("You have " + money.getPurse() + " credits in your purse. \nGoodbye!");
        
    } // end main
} // end class QuasarDriver
