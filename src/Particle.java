import processing.core.PApplet;

public class Particle
{
  private int x;
  private int y;
  private int speedX;
  private int speedY;

  public Particle(int locationX, int locationY, double direction,int speed)
  {
      x=locationX;
      y=locationY;

      double directionR = Math.toRadians(direction);
      speedX = (int)(Math.cos(directionR)*speed);
      speedY = (int)(Math.sin(directionR)*speed);
  }
  public void display(PApplet screen)
  {
      screen.ellipse(x,y,5,5);
  }
  public void update()
  {
      x+=speedX;
      y+=speedY;
  }
}
