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
    private static final int B_WIDTH = 800;
    private static final int B_HEIGHT = 450;
    private static final int FLOOR = B_HEIGHT - 25;
    private BufferedImage img;
    
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this);

        try {
            File imgFile = new File("media/sm_cannon.png");
            img = ImageIO.read(imgFile);
            setPreferredSize(new Dimension(800, 450));
        } catch (IllegalArgumentException e) {
            System.err.println("input is null!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException");
            System.err.println(e.getMessage()); 
        }
       

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
        if (img != null) {
            double scale = 0.5;
            int x_t = 60;
            int y_t = 390;
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.translate(x_t, y_t);
            affineTransform.scale(scale, scale);
            g2d.drawImage(img, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
        g.setColor(Color.PINK);
        int[] xPoints = {60,75,90};
        int[] yPoints = {430,400,430};
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(Color.BLACK);
        int[] x = {60,75,90};
        int[] y = {430,400,430};
        g.drawPolygon(xPoints, yPoints, 3);
        g.setColor(Color.BLUE);
        g.fillOval(72, 400, 7, 7);

        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                System.out.println("SPACE button is pressed");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT button is pressed");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT button is pressed");
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