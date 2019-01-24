import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int points;
    private Font myFont = new Font("Comic Sans MS", true, false, 24);
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Score() 
    {
        points = 0;
        GreenfootImage img = new GreenfootImage(500, 30);
        img.setFont(myFont);
        img.drawString("Score: " + points, 5, 25);
        setImage(img);
    }   
    
    
    
    /**
     * addToScore sets the score needed to win, creates the score counter at the top left 
     * of the screen and actually adds to score only when called. 
     * (gets called when player kills an enemy)
     * 
     * @param there are no parameters
     * @return addToScore returns nothing
     */
    public void addToScore()
    {
        points++;
        GreenfootImage img = getImage();
        img.clear();
        if(points < 30)
        {
            img.drawString("Score: " + points, 5, 25);
        }
        else
        {
            img.clear();
            img.setFont(myFont);
            img.drawString("You Win *multiple exclamation marks*" ,5 , 25);
            setImage(img);
            Greenfoot.stop();
        }
    }
}
