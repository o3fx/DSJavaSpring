package animate;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Taskbar.State;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Cannonball {
    public enum STATE {
        IDLE,
        FLYING,
        EXPLODING
    }
    private double x = 0;
    private double y = 0;
    private double vx = 0;
    private double vy = 0;
    private double ax = 0;
    private double ay = 0;
    private STATE state = STATE.IDLE;
    private double ground = 0;
    private double timescale = 1;
    private SoundClip boom;
    private BufferedImage flame;
    private int c;

    public Cannonball(double ax, double ay, double ground) {
        this.ax = ax;
        this.ay = ay;
        this.ground = ground;
        boom = new SoundClip("media/boom.wav");
        boom.open();
        try {
            File imageFile = new File("media/flame04.png");
            flame = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println("Unable to load" + "media/flame04.png");
            System.err.println(e.getMessage());
            flame = null;
        }

    }

    /*private BufferedImage loadImage(String path) {
        // loads a buffered image (for the flame animation).
    }
    */

    /*
     * The draw method is called by the Board object
     * and is used to paint the current location and state of the ball.
     * If the ball is flying through the air, the ball is drawn as a red
     * filled in circle. If the ball is in the exploded state, a flame image is
     * drawn. If the ball is idle, then the ball is not drawn at all
     * (since we assume the ball is hidden inside the cannon).
     */
    public void draw(Graphics2D g2d) {
        if (state == STATE.FLYING){
            g2d.setColor(Color.RED);
            g2d.fillOval((int) (x - 5), (int)(y - 5), 10, 10);
        } else if (state == STATE.EXPLODING){
            AffineTransform af = new AffineTransform();
            af.translate(x - flame.getWidth() / 2, y - flame.getHeight() / 2);
            g2d.drawImage(flame, af, null);
        }
    }

    /*
     * The updateBall() method uses the constant acceleration equations
     * to update the velocity and position of the ball each timer interval.
     * note that when calculating the new velocity, the acceleration term is divided
     * by the
     * time scale in case the user wants to slow down the animation.
     * Similarly, when calculating the new position, the velocity term is divided by
     * the time scale
     * in case the user wants to slow down the animation.
     */
    public void updateBall() {
        //use acel and velocity to calculate x and y position
        if (state == STATE.FLYING) {
            vx = vx + ax/timescale;
            x = x + vx/timescale;
            vy = vy + ay/timescale;
            y = y + vy/timescale;

            if (y-18 >= ground){
                state = STATE.EXPLODING;
                boom.play();
            }

            System.out.printf("x = %.1f, y = %.1f%n", x, y);
        }
    }

    /*
     * If the ball is not flying through the air, the launch() method
     * will change the state to FLYING and start the ball moving from position (x,y)
     * with the inital velocity of (vx, vy).
     */
    public void launch(double x, double y, double vx, double vy) {
        if(state != STATE.FLYING) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            state = STATE.FLYING;
        }
    }

    /*
     * Get/set methods for the private member variables.
     */
    public STATE getState() {
        return state;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVX() {
        return vx;
    }

    public double getVY() {
        return vy;
    }

    public double getAX() {
        return ax;
    }

    public double getAY() {
        return ay;
    }


    public double getGround() {
        return ground;
    }

    public void setState(STATE newState) {
        this.state = newState;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVX(double vx) {
        this.vx = vx;
    }

    public void setVY(double vy) {
        this.vy = vy;
    }

    public void setAX(double ax) {
        this.ax = ax;
    }

    public void setAY(double ay) {
        this.ay = ay;
    }

    public void setTimeScale(double timeScale) {
        this.timescale = timescale;
    }

    public void changeTimeScale(double delta) {
        this.timescale += delta;
        if (timescale > 10) {
            timescale = 10;
            System.out.println("Max timescale reached");
        } else if (timescale < 1) {
            timescale = 1;
            System.out.println("Min timescale reached");
        }
        System.out.println("Timescale changed to: " + timescale);
        
    }
    
    public double getTimeScale() {
        return timescale;
    }

    public void setGround(double ground) {
        this.ground = ground;
    }

}