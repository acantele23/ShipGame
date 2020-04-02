import processing.core.PApplet;

public class Ship
{
    //internal instance variables
    private int locationX;
    private int locationY;
    private int currentSpeed;
    private long coolOff = 0;

    /**
     * The constructor for the ship
     * @param x The horizontal position of the ship when it is first created
     * @param y The vertical position of the ship when it is first created
     */
    public Ship (int x, int y)
    {
        this.locationX =x;
        this.locationY =y;
    }

    /**
     * Updates the ship's location based on it's current speed.
     */
    public void update()
    {
        locationX = locationX + currentSpeed;
    }

    /**
     * Draws itself onto the screen using Processing.
     * @param screen The Processing environment. Usually the class that extends PApplet
     */
    public void display(PApplet screen)
    {
        screen.noStroke();
        //draw the thrust. Use a random height so it flickers
        screen.fill(255, 0, 0);
        screen.ellipse(locationX - 10, locationY, 10, (float) (Math.random() * 20) + 20);
        screen.ellipse(locationX + 10, locationY, 10, (float) (Math.random() * 20) + 20);


        //draw the main body of the ship
        screen.fill(255);
        screen.triangle(locationX-25, locationY, locationX,locationY-50, locationX+25, locationY);

        //draw a small cockpit
        screen.fill(0,0,255);
        screen.triangle(locationX-5, locationY-25, locationX,locationY-35, locationX+5, locationY-25);
    }

    /**
     * Sets the speed of the ship.
     * @param speed The rate the the ship's postition will change every time it is asked to update
     */
    public void setSpeed(int speed)
    {
        this.currentSpeed = speed;
    }

    /**
     * Spawns a new missile at the current location of the ship
     * @return The missile that was created or null if cool off time hasn't passed
     */
    public Missile fire()
    {
        if (System.currentTimeMillis()>coolOff)
        {
            Missile m = new Missile(locationX, locationY - 50, -90);
            coolOff=System.currentTimeMillis()+100;
            return m;
        }
        return null;
    }

    /**
     * Returns the current direction that the ship is traveling.
     * < 0 It's moving left
     * > 0 It's moving right
     * == 0 It's not moving
     * @return
     */
    public int getDirection()
    {
        return currentSpeed;
    }
}

