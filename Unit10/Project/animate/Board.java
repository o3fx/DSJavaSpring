package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    // 16 by 9 ratio, ratio of 50.
    private static final int B_WIDTH = 960;
    private static final int B_HEIGHT = 540;
    private static final int FLOOR = B_HEIGHT - 25;
    Cannon cannon;
    

    
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this);
        cannon = new Cannon();
        
        /* 
        cannon = new Cannon("media/cannon.wav");
        cannon.open();
    
        cannon.play();
        wheel = new Cannon("media/ow.wav");
        wheel.open();
        */
       

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

        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    

    

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                System.out.println("SPACE button is pressed");
                cannon.fire();
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
                break;
            case KeyEvent.VK_UP:
                System.out.println("UP button is pressed");
                break;
            default:
                System.out.println("Another key is pressed");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    
}