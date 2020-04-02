import com.jogamp.opengl.GLFBODrawable;
import processing.core.PApplet;
import java.util.ArrayList;

public class App extends PApplet
{
    private Ship player;
    private ArrayList<Missile> allMissiles = new ArrayList<Missile>();
    private ArrayList<Rock> allRocks = new ArrayList<Rock>();
    private long rockBirthTimer =0;
    private ArrayList<Emitter> explosions = new ArrayList<Emitter>();

    private Emitter e;


    public static void main (String[] args)
    {

        PApplet.main("App");

    }

    public void settings()
    {
        size(800,600, P2D);

        player = new Ship(width/2, height-100);

        for (int i=0; i<5; i++)
        {
            allRocks.add(spawnRock());
        }
    }



    public void draw()
    {
        background(0);
        player.update();
        player.display(this);

        //An example of the "enhanced" for-loop.
        //It's easier to write, but if looping over a list, you can't modify the list from it within this type of loop.
        for(Missile m:allMissiles)
        {
            m.update();
            m.display(this);
        }
        for(Rock r: allRocks)
        {
            r.update();
            r.display(this);

        }
        if(System.currentTimeMillis()>rockBirthTimer)
        {
            allRocks.add(spawnRock());
            rockBirthTimer =(long)( System.currentTimeMillis()+(Math.random()*2000)+1000);
        }
        for(Emitter e:explosions)
        {
            e.display(this);
        }

    }

    public void keyPressed()
    {
        if (keyCode == RIGHT)
        {
            player.setSpeed(5);
        }
        else if (keyCode==LEFT)
        {
            player.setSpeed(-5);
        }
        else if (key == ' ')
        {
            Missile myMissile = player.fire();
            if (myMissile != null)
            {
                allMissiles.add(myMissile);
            }
        }
    }

    public void keyReleased()
    {
        //if pressing right and the ship is moving right OR pressing left and the ship is moving left, stop moving
        if ((keyCode==RIGHT && player.getDirection()>0) || (keyCode==LEFT && player.getDirection()<0))
        {
            player.setSpeed(0);
        }
    }
    private Rock spawnRock()
    {
        return new Rock((int) (Math.random()*width),(int) (Math.random()*height-height),90,(int)(Math.random()*5+2));
    }
}
