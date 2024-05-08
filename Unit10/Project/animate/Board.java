package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    // 16 by 9 ratio, ratio of 50.
    private static final int B_WIDTH = 800;
    private static final int B_HEIGHT = 450;
    private static final int FLOOR = B_HEIGHT - 25;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        this.setFocusable(true);
        this.addKeyListener(this); 
    }

    // This overrides paint component
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Color.BLACK);
        g.drawLine(0, FLOOR, B_WIDTH, FLOOR);
        g.setColor(Color.GREEN);
        g.fillRect(0, FLOOR + 1, B_WIDTH, B_HEIGHT - FLOOR);
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