import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeScreen extends World
{

    /**
     * Constructor for objects of class HomeScreen.
     * 
     */
    public HomeScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showText( "press the space bar to start", getWidth()/4, getHeight() - 20);
        showText( "press A to move left \n press A to move right \n press S to attack", getWidth() - 100, getHeight() - 50);
    }
    
    public void act()
    {
        gameStart();
    }
    
    /**
     * gameStart switches the screen to a screen of which you actually play the game on
     * but only when the space bar is pressed
     */
    private void gameStart()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
