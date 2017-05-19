package juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class Panel extends JPanel implements ActionListener {
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (paradoP == 1) {
            paradoP = 0;
        } else {
            paradoP = 1;
        }
        t = true;
//        x+=20;
        caminarP++;
        if (caminarP == 4) {
            caminarP = 0;
        }
        repaint();
    }
    
    private class TAdapter extends KeyAdapter {
        
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:

                    x-=5;
                    
                    break;
                case KeyEvent.VK_RIGHT:

                    x+=5;
                    
                    break;
                case KeyEvent.VK_UP:
                    
                    while((y+712)!=712)
                         y++;

                    break;
                case KeyEvent.VK_DOWN:

                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    
                    x-=10;
                    
                    break;
                case KeyEvent.VK_RIGHT:
                    
                   x+=10;
                    
                    break;
                case KeyEvent.VK_UP:
                    
                     y-=100;
                     

                    break;
                case KeyEvent.VK_DOWN:

                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
    
    private int caminarP;
    private int paradoP;
    private int BackGroundX;
    private int y;
    private int x;
    private Timer timer;
    boolean t;
    
    public Panel() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.x = 0;
        this.y = 0;
        this.timer = new Timer(90, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 2201; i+=22) {
            g.drawImage(loadImage("red_background.png"), (BackGroundX + i), 0, this);
        }
        for (int i = 0; i < 2201; i+=112) {
            g.drawImage(loadImage("ground_loop.png"), (BackGroundX + i), 712, this);
        }
        
            g.drawImage(loadImage("walking.png"), (x + 50), (y+578), (x + 168), (y+712), (124 * caminarP-20), 0, ((124 * caminarP) + 98), 134, this);
    }
    
    
    
}
