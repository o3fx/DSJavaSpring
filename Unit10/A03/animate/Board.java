package animate;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Board extends JPanel {
    private final int BOARD_WIDTH = 720;
    private final int BOARD_HEIGHT = 720;
    private int x = 0;
    private int y = 0;
    private final int DIAMETER = 20;
    private BufferedImage img;
    private double angle = 0;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private int xSpeed = 2;
    private int ySpeed = 2;
    private SoundClip sitar;
    private SoundClip ow;

    // constructor
    public Board() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        x = 0;
        y = 0;
        //Making a randomize speed
        xSpeed = (int)(Math.random() * 5) + 1;
        ySpeed = (int)(Math.random() * 5) + 1;
        try {
            File imgFile = new File("media/Andy.png");
            img = ImageIO.read(imgFile);
        } catch (Exception e) {
            System.err.println("unable to open image file!");
            System.err.println(e.getMessage());

        }

        timer = new Timer();
        timer.scheduleAtFixedRate(new UpdateAnimation(),
                INITIAL_DELAY, PERIOD_INTERVAL);

        sitar = new SoundClip("media/sitar.wav");
        sitar.open();
        sitar.SetLoop(true);
        sitar.play();
        ow = new SoundClip("media/ow.wav");
        ow.open();

    }

    // override paint component
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x - DIAMETER / 2, y - DIAMETER / 2);
        affineTransform.rotate(Math.toRadians(angle), img.getWidth() / 2, img.getHeight() / 2);
        g2d.drawImage(img, affineTransform, null);
    }

    private class UpdateAnimation extends TimerTask {
        public void run() {
            x += xSpeed;
            if (x > BOARD_WIDTH || x < 0) {
                xSpeed = - xSpeed;
                ow.play();
            }
            y += ySpeed;
            if (y > BOARD_WIDTH || y < 0) {
                ySpeed = - ySpeed;
                ow.play();
            }
            //should be 5 to 10 ish was playing around
            angle += 1000;
            angle = angle % 360;
            repaint();
        }
    }

}