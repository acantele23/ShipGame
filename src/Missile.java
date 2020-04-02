import processing.core.PApplet;

public class Missile
{
    private int x;
    private int y;
    private int speedX;
    private int speedY;

    //An example of a "constant". It's a static, public variable that can not vary.
    //Because of this, constants are often declared public.
    public static final int MISSILE_SPEED = 10;

    /**
     * Constructs a new missile
     * @param x The initial horizontal position of the missile
     * @param y The initial vertical position of the missile
     * @param angle The direction that the missile is pointing.
     */
    public Missile(int x, int y, int angle)
    {
        this.x=x;
        this.y=y;

        //calculate the horizontal and vertical speed of the missile based on the angle it is pointing
        //remember that the "speed" is really the hypotenuse so the horizontal component of the speed (often called delta X) is found using cos
        //similarly, the vertical component of the speed is found using sin.
        speedX = (int) Math.cos(Math.toRadians(angle)) * MISSILE_SPEED;
        speedY = (int) Math.sin(Math.toRadians(angle)) * MISSILE_SPEED;
    }

    /**
     * Updates the location of the missile based on it's speed
     */
    public void update()
    {
        x+=speedX;
        y+=speedY;
    }

    /**
     * Draws itself onto the screen using Processing.
     * @param screen The Processing environment. Usually the class that extends PApplet
     */
    public void display(PApplet screen)
    {
        screen.noStroke();
        screen.fill(255,0,0);
        screen.ellipse(x,y,5,10);
    }

}
