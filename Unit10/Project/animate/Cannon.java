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
    private SoundClip song;
    private SoundClip fireA;
    private double H = 100;
    private double Vm = 25;
    private Cannonball cannonball;
    private Cannon cannon;


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
        song = new SoundClip("media/song.mp3");
        
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
        g2d.setColor(Color.PINK);
        int[] xPoints = {40,60,80};
        int[] yPoints = {520,480,520};
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.setColor(Color.BLACK);
        int[] x = {60,75,90};
        int[] y = {520,450,520};
        g2d.drawPolygon(xPoints, yPoints, 3);
        g2d.setColor(Color.BLUE);
        g2d.fillOval(57, 480, 7, 7);
        g2d.drawString("Use left/right arrows to adjust angle", 365, 50);
        g2d.drawString("Use up/down arrows to adjust time scale", 355, 75);
        g2d.drawString("Use space key to fire cannon", 380, 100);
        g2d.drawString("The angle of the cannon is = " + Math.abs(angle), 380, 125);
        //g2d.drawString("The time scale is = " + cannonball.getTimeScale(), 380, 150);
    
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
        song.play();
    }
    public void fire(Cannonball ball){
        double xo = H * Math.cos(Math.abs(Math.toRadians(angle)));
        double yo = H * Math.sin(Math.abs(Math.toRadians(angle)));
        double vx = Vm * Math.cos(Math.abs(Math.toRadians(angle)));
        double vy = Vm * Math.sin(Math.abs(Math.toRadians(angle)));
        ball.launch(60+xo, 480-yo, vx, -vy);
        fire();
    }

    public void explode(){
        try {
            File imgFile = new File("media/flame04.png");
            img = ImageIO.read(imgFile);
        } catch (Exception e) {
            System.err.println("unable to open image file!");
            System.err.println(e.getMessage());

        }
    }

    
    
 
    //vy = vy + ay

}
