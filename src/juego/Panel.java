package juego;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel  implements ActionListener {
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
        
        caminarP++;
        if (caminarP == 4) {
            caminarP = 0;
        }
        
        if(caminarV==1){
            caminarV=0;
        }
        else{
            caminarV=1;
        }
 
        repaint();
        
    }
    
    private class TAdapter extends KeyAdapter {

       
        
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:

                     t=false;
                    x-=5;
                    
                    
                   
                    break;
                case KeyEvent.VK_RIGHT:
                    t=false;
                    x+=5;
                    
                    break;
                case KeyEvent.VK_UP:
                    
                     
                    while((y+415)!=415){
                        
                         y++;
                         
                         }
                    t=false;
                    
                    
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
                    
                    t=true;
                    
                    x+=10;
                    
                    break;
                case KeyEvent.VK_UP:

                    t=true;
                    
                     y-=150;
                     Puntuacion+=10;
                     timer.start();
                     

                    break;
                case KeyEvent.VK_DOWN:

                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
    
    private int caminarP;
    private int caminarV;
    private int paradoP;
    private int BackGroundX;
    private int y;
    private int x;
    private int xVillano;
    private Timer timer;
    boolean t=false;
    
    private int Puntuacion=0;
    
    
    
    public Panel() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        this.x = 0;
        this.xVillano = 1000;
        this.y = 0;
        this.timer = new Timer(150, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 2201; i+=22) {
            g.drawImage(loadImage("red_background.png"), (BackGroundX + i), 0, this);
        }
        for (int i = 0; i < 2201; i+=112) {
            g.drawImage(loadImage("ground_loop.png"), (BackGroundX + i), 412, this);
        }
        Font font=new Font("Tahoma",1,50);
        g.setFont(font);
        g.drawString("Puntuacion: "+Puntuacion, 15, 40);
        
        if(t==false){
            g.drawImage(loadImage("standing.png"), (x + 50), 281, (x + 190), 415, (142 * paradoP), 0, ((142 * paradoP) + 142), 133, this);
            
            }
           
       
            if(t==true){
            g.drawImage(loadImage("walking.png"), (x + 50), (y+281), (x + 168), (y+415), (124 * caminarP-20), 0, ((124 * caminarP) + 98), 134, this);
            
        }
        g.drawImage(loadImage("enemy_run.png"), xVillano, 314, (xVillano+105),415,(105*caminarV),0,((105*caminarV)+105),101, this);
        
          for(int i=50;i<1000;i=i+300){
              
        g.drawImage(loadImage("coin.png"), i, 100, 55,55, this);
        
          }
          
          for(int i=120;i<1200;i=i+300){
              
        g.drawImage(loadImage("stone.png"), i, 100, 55,59, this);
        
          }
          
          
          
    }
    
}

    

