package animate;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener, MouseListener {
    // 16 by 9 ratio, ratio of 50.
    private static final int B_WIDTH = 500;
    private static final int B_HEIGHT = 500;
    private SoundClip soundBlip;
    private SoundClip soundBlop;
    private int x;
    private int y;
    PlayAudio playAudio;
    

    

    
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        soundBlip = new SoundClip("media/blip.wav");
        soundBlip.open();
        soundBlop = new SoundClip("media/blop.wav");
        soundBlop.open();
        
    }

    @Override
    // This overrides paint component
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.MAGENTA);

        g2d.fillOval(225,225,50,50);

    
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    

    

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            playAudio.pBlop();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        playAudio.pBlip();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    
}