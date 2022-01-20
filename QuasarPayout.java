
/**
 * QuasarPayout.java
 * v1.0
 * by SkyShep
 * 
 * Class that controls the payout and money management for the game.
 */
public class QuasarPayout
{
    private double purse = 600;   // Player's purse, starting at 600 credits
    private double payout;        // Amount that gets payed out to the player
    
    // Takes bet from the player's purse
    public void playerBet(double bet)
    {
        this.purse -= bet;
    } // end playerBet
    //************************************************************************
    // Calculates payout and adds it to player's purse
    public void payPlayer(int total, double bet)
    {
        // Payouts are different based on point total.
        // The closer the player is to 20, the larger the payout.
        switch(total)
        {
            case 20:
                this.payout = 2 * bet;
                break;
            case 19:
                this.payout = 1.5 * bet;
                break;
            case 18:
                this.payout = 1.25 * bet;
                break;
            case 17:
                this.payout = bet;
                break;
            case 16:
                this.payout = bet / 2;
                break;
            case 15:
                this.payout = bet / 4;
                break;
        }
        
        // Add payout to the player's purse
        this.purse += this.payout;
        
    } // end payPlayer
    //************************************************************************
    // Returns value of the player's purse
    public double getPurse()
    {
        return this.purse;
    } // end getPurse
} // end QuasarPayout class
