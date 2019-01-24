import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private GreenfootImage animation[] = new GreenfootImage[3];
    private int animationDelay = 0;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        else
        {
            setLocation( getX(), getY()+4);
        }

        objectAnimation();
    }
    
    /**
     * objectAnimation makes the Enemies (the meteor looking things) havea moving fire trail
     * 
     * @param there are no parameters
     * @return does not return anything
     */
    public void objectAnimation()
    {
        animation[0] = new GreenfootImage("Meteor_0.png");
        animation[1] = new GreenfootImage("Meteor_1.png");
        animation[2] = new GreenfootImage("Meteor_2.png");

        if(animationDelay == 0)
        {
            setImage(animation[0]);
        }

        else if(animationDelay == 2)
        {
            setImage(animation[1]);
        }

        else if(animationDelay == 4)
        {
            setImage(animation[2]);
        }

        else
        {
            setImage(animation[0]);
        }

        if(animationDelay >= 6)
        {
            animationDelay = 0;
        }
        animationDelay++;
    }
}
