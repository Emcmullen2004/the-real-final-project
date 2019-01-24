import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    private Score score;
    public String difficulty;
    private int spawnRate;
    private boolean startOfGame;
    /**
     * creates the world along with placing the character and the score object
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        startOfGame = true;
        
        score = new Score();
        
        addObject( score, 250, 10);
        
        addObject(new Player(), getWidth()/2, 350);
    }
    
    
    public void act()
    {
        spawnRate = Greenfoot.getRandomNumber(100+1);
        
        difficulty();
    }
    
    /**
     * askes for the desired difficulty in the form of a text box which
     * then sets the spawn rate differently based on the chosen difficulty
     * 
     * @param there are no parameters
     * @return difficulty returns nothing
     */
    private void difficulty()
    {
        if(startOfGame == true)
        {
            difficulty = JOptionPane.showInputDialog("please type the difficulty level(easy, medium, hard):", null);
            startOfGame = false;
        }
        
        if(difficulty.equalsIgnoreCase("easy"))
        {
            if(spawnRate <= 5)
            {
                addObject(new Enemy(), Greenfoot.getRandomNumber(560)+20 ,20);
            }
        }
        
        else if(difficulty.equalsIgnoreCase("medium"))
        {
            if(spawnRate <= 10)
            {
                addObject(new Enemy(), Greenfoot.getRandomNumber(560)+20 ,20);
            }
        }
        
        else if(difficulty.equalsIgnoreCase("hard"))
        {
            if(spawnRate <= 25)
            {
                addObject(new Enemy(), Greenfoot.getRandomNumber(560)+20 ,20);
            }
        }
        
        else
        {
            difficulty = JOptionPane.showInputDialog("please type the difficulty level(easy, medium, hard) PROPERLY:", null);
        }
    }
    
    /**
     * update runs for one act cycle only whenever an enemy is taken out and runs the 
     * addToScore method
     * 
     * @param there are no parameters
     * @return update returns nothing
     */
    public void update()
    {
        score.addToScore();
    }
}

