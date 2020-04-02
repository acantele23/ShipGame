import processing.core.PApplet;

public class Rock
{
    private int x;
    private int y;
    private int speedX;
    private int speedY;


    private int[][] verts = new int [8][2];

    public Rock(int startingX, int startingY, double angle, int speed)
    {
        x=startingX;
        y=startingY;

        double angleR = Math.toRadians(angle);
        speedX =(int) (Math.cos(angleR)*speed);
        speedY =(int) (Math.sin(angleR)*speed);

        for (int i=0; i<8; i++)
        {
            double radius = (Math.random() * 50)+25;
            double tempAngle = Math.toRadians(i*(360/8));

            verts[i][0] = (int) (Math.cos(tempAngle)*radius);
            verts[i][1] = (int) (Math.sin(tempAngle)*radius);
        }

    }
    void display(PApplet screen) {

        screen.fill(255);

       screen.stroke(255);
       screen.strokeWeight(2);

        for (int i = 0; i < verts.length; i++) {
            int[] v1 = verts[i];
            int[] v2 = verts[(i + 1)%verts.length];
            screen.line(x + v1[0], y + v1[1], x + v2[0], y + v2[1]);

        }


    }
    public void update()
    {
        x+=speedX;
        y+=speedY;
    }
}
