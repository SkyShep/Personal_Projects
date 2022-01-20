
/**
 * QuasarRandomizer.java
 * v1.0
 * by SkyShep
 * 
 * If there's a random number to be assigned, this class does it.
 * Also keeps track of the running total of player points.
 */

public class QuasarRandomizer
{
    private int initial;           // Initial value given to the player
    private int random;            // Random numbers generated
    private int total;             // Running total of points
    
    // Gives the user their initial starting number and adds it to the
    // running total
    public int getInitial()
    {
        int min = 1;
        int max = 5;
        this.initial = min + (int)(Math.random() * (max - min + 1));
        this.total = this.initial;
        return this.initial;
    } // end getInitial
    //************************************************************************
    // Adds random number between 1 and 8 to the running total
    public void OnetoEight()
    {
        int min = 1;
        int max = 8;
        this.random = min + (int)(Math.random() * (max - min + 1));
        this.total += this.random;
    } // end OnetoEight
    //************************************************************************
    // Adds random number between 4 and 7 to the running total
    public void FourtoSeven()
    {
        int min = 4;
        int max = 7;
        this.random = min + (int)(Math.random() * (max - min + 1));
        this.total += this.random;
    } // end FourtoSeven
    //************************************************************************
    // Returns running total of player's points
    public int getTotal()
    {
        return this.total;
    }// end getTotal
} // end QuasarRandomizer class
