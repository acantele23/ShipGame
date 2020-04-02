import processing.core.PApplet;

public class Emitter {
    private int x;
    private int y;

    private Particle[] allParticles;


    public Emitter(int locX, int locY, int size) {
        x = locX;
        y = locY;

        allParticles = new Particle[size];

        for (int i = 0; i < allParticles.length; i++) {
            allParticles[i] = new Particle(x, y, Math.random() * 360, (int) (Math.random() * 10 + 5));
        }

    }


    public void display(PApplet screen)
    {
        screen.fill(255,0,100);
        screen.noStroke();
        for (Particle p: allParticles)
        {
            p.display(screen);
            p.update();
        }
    }
}
