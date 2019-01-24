
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{    
    private boolean facingRight = false;
    private int attackDelay = 0;
    private int Delay = 0;
    public boolean attackInvincibility = false;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        turnAround();
        attack();
        
        attackDelay++;
        Delay++;
    }    
    
    
    /**
     * move allows the player to move left and right along with aiding in the turning mechanic
     * 
     * @param there are no parameters
     * @return move returns nothing
     */
    private void move()
    {
        if(Greenfoot.isKeyDown("a") == true)
        {
            setLocation(getX()-4, getY());
            facingRight = false;
        }
        
        if(Greenfoot.isKeyDown("d") == true)
        {
            setLocation(getX()+4, getY());
            facingRight = true;
        }
    }
    
    /**
     * turn around allows for the visual effect of turning around the base character
     * 
     * @param there are no parameters
     * @return turnAround returns nothing
     */
    private void turnAround()
    {
        if(facingRight == true)
        {
            setImage("ThatGuyButRight.png");
        }
        else
        {
            setImage("ThatGuy.png");
        }
    }
    
    /**
     * attack creates the ability to attack along with the visual effect and also sets the
     * turning effect during the attack. the attack deletes the enemy it is touching
     * 
     * @param there are no parameters
     * @return attack returns nothing
     */
    private void attack()
    {
        if(Greenfoot.isKeyDown("s") && attackDelay >= 40)
        {
            attackInvincibility = true;
            Delay = 0;
            attackDelay = 0;
        }
        
        if(attackInvincibility == true)
        {
            if(Delay >= 1)
            {
                if(facingRight == false)
                {
                    setImage("ThatGuy attack part 1.png");
                }
                
                else
                {
                    setImage("ThatGuyButRight attack part 1.png");
                }
            }
            
            if(Delay >= 5)
            {
                if(facingRight == false)
                {
                    setImage("ThatGuy attack 2.png");
                }
                
                else
                {
                    setImage("ThatGuyButRight attack 2.png");
                }
            }
            
            if(isTouching(Enemy.class) == true)
            {
                removeTouching(Enemy.class);
                ( (MyWorld)getWorld() ).update();
            }
            
            if(Delay >= 10)
            {
                if(facingRight == false)
                {
                    setImage("ThatGuy.png");
                }
                
                else
                {
                    setImage("ThatGuyButRight.png");
                }
                attackInvincibility = false;
                Delay = 0;
            }
            
            
        }
        
        else
        {
            if(isTouching(Enemy.class) && attackInvincibility == false)
            {
                getWorld().removeObject(this);
                Greenfoot.stop();
            }
        }
    }
}
