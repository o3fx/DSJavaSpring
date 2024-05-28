package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    // 16 by 9 ratio, ratio of 50.
    private static final int B_WIDTH = 960;
    private static final int B_HEIGHT = 540;
    private static final int FLOOR = B_HEIGHT - 25;
    private final int PERIOD_INTERVAL = 20;
    private Cannon cannon;
    private Cannonball cannonball;
    private Timer timer;
    private final int INITIAL_DELAY = 0;
    private final int TIMER_INTERVAL = 20;
    

    
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this);
        cannon = new Cannon();
        cannonball = new Cannonball(0,1,480);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),
                INITIAL_DELAY, TIMER_INTERVAL);
    }

    @Override
    // This overrides paint component
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawLine(0, FLOOR, B_WIDTH, FLOOR);
        g.setColor(Color.GREEN);
        g.fillRect(0, FLOOR + 1, B_WIDTH, B_HEIGHT - FLOOR);


        
        Graphics2D g2d = (Graphics2D) g;
        cannon.draw(g2d);
        cannonball.draw(g2d);

        
    }
    private class ScheduledUpdate extends TimerTask {
        public void run(){
            cannonball.updateBall();

            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    

    

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                System.out.println("SPACE button is pressed");
                cannon.fire(cannonball);
            
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT button is pressed");
                cannon.rotateCCW();
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT button is pressed");
                cannon.rotateCW();
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN button is pressed");
                cannonball.changeTimeScale(-1);
                repaint();
                break;
            case KeyEvent.VK_UP:
                System.out.println("UP button is pressed");
                cannonball.changeTimeScale(1);
                repaint();
                break;
            default:
                System.out.println("Another key is pressed");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    
}