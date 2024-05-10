package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Cannon {
    private double x;
    private double y;
    private Clip wheelClip;
    private Clip cannonCLip;
    private String filePath;
    private File audioFile;
    private AudioInputStream audioIn;
    private boolean loop;
    private BufferedImage img;
    private double angle = -45; //Degrees not raidians
    private SoundClip soundCannon;
    private SoundClip soundRotate;


    public Cannon(){
        try {
            File imgFile = new File("media/sm_cannon.png");
            img = ImageIO.read(imgFile);
        } catch (IllegalArgumentException e) {
            System.err.println("input is null!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException");
            System.err.println(e.getMessage()); 
        }
        soundCannon = new SoundClip("media/cannon.wav");
        soundCannon.open();
        soundRotate = new SoundClip("media/wheel.wav");
        soundRotate.open();
        
    }
    
    public void draw(Graphics2D g2d){
        if (img != null) {
            double scale = 0.5;
            int x_t = 60-15;
            int y_t = 480-img.getHeight()/2;
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.translate(x_t, y_t);
            affineTransform.rotate(Math.toRadians(angle), 15, img.getHeight()/2);
            g2d.drawImage(img, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
        /*
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
        */
    }
    public void rotateCCW(){
        angle = angle - 5;
        if (angle < -90) {
            angle = -90;
        }
        soundRotate.play();
    }
    public void rotateCW(){
        angle = angle + 5;
        if (angle > 0) {
            angle = 0;
        }
        soundRotate.play();
    }
    public void fire(){
        soundCannon.play();
    }

    
    
 
    

}
