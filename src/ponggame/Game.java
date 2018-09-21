/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponggame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bence
 */
public class Game extends Applet implements Runnable, KeyListener{
    private int selected, score1,score2;
    private final int WIDTH=700;
    private final int HEIGHT=500;
    private Thread thread;
    private Paddle p1, p2, bluePaddle, greenPaddle, redPaddle, orangePaddle, bluePaddle2, greenPaddle2, redPaddle2, orangePaddle2;
    private Ball ball;
    private boolean gamestarted;
    private Graphics gfx;
    private Image img;
    @Override
    public void init(){
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        ball = new Ball();
        p1 = new PlayerPaddle(1);
        p2 = new ComputerPaddle(0,ball);
        bluePaddle = new BluePaddleDecorator(p1);
        greenPaddle = new GreenPaddleDecorator(p1);
        redPaddle = new RedPaddleDecorator(p1);
        orangePaddle = new OrangePaddleDecorator(p1);
        bluePaddle2 = new BluePaddleDecorator(p2);
        greenPaddle2 = new GreenPaddleDecorator(p2);
        redPaddle2 = new RedPaddleDecorator(p2);
        orangePaddle2 = new OrangePaddleDecorator(p2);
        gamestarted=false;
        img = createImage(WIDTH,HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void paint(Graphics g){
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);

        if(!gamestarted){

            gfx.setColor(Color.GREEN);
            gfx.drawString("This is a Pong Game", 200, 100);
            gfx.drawString("After the game starts, you can do some settings...", 200, 125);
            gfx.drawString("To change Player1 color, press: 1->Blue 2->Green 3->Red 4->Orange", 200, 150);
            gfx.drawString("To change Player2 color, press: 5->Blue 6->Green 7->Red 8->Orange", 200, 175);
            gfx.drawString("Press ENTER to start...", 200, 200);
        }
        
        if(ball.getX()<10){
            score1+=1;
            displayItems(gfx);       
        }
        
        if(ball.getX()>690){
            score2+=1;
            displayItems(gfx); 
            
        }else{
             displayItems(gfx); 
        }
        
       
        
       g.drawImage(img,0, 0,this);
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }

    @Override
    public void run() {
        while(true){
   
            if(gamestarted==true){
                 p1.move();
                 p2.move();
                 ball.move();
                 ball.checkPaddleCollision(p1, p2);
                 repaint();
            }
           
           
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                p1.setToUp(true);
                break;
            case KeyEvent.VK_DOWN:
                p1.setToDown(true);
                break;
            case KeyEvent.VK_ENTER:
                gamestarted = true;
                break;
             case KeyEvent.VK_1:
                selected=1;
                break;
            case KeyEvent.VK_2:
                selected=2;
                break;
            case KeyEvent.VK_3:
                selected=3;
                break;
            case KeyEvent.VK_4:
                selected=4;
                break;
            case KeyEvent.VK_5:
                selected=5;
                break;
            case KeyEvent.VK_6:
                selected=6;
                break;
            case KeyEvent.VK_7:
                selected=7;
                break;
            case KeyEvent.VK_8:
                selected=8;
                break;
            default: selected=0;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
          switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                p1.setToUp(false);
                break;
            case KeyEvent.VK_DOWN:
                p1.setToDown(false);
                break;
          }
    }
    
    private void displayItems(Graphics gfx){
        switch (selected) {
                case 1:
                    bluePaddle.draw(gfx);
                    break;
                case 2:
                    greenPaddle.draw(gfx);
                    break;
                case 3:
                    redPaddle.draw(gfx);
                    break;
                case 4:
                    orangePaddle.draw(gfx);
                    break;
                case 5:
                    bluePaddle2.draw(gfx);
                    break;
                case 6:
                    greenPaddle2.draw(gfx);
                    break;
                case 7:
                    redPaddle2.draw(gfx);
                    break;
                case 8:
                    orangePaddle2.draw(gfx);
                    break;
                default:
                    break;
            }
             
            p1.draw(gfx);
            p2.draw(gfx);
            ball.draw(gfx);
            gfx.setColor(Color.GREEN);
            gfx.drawString(String.valueOf(score1), 20, 20);
            gfx.drawString(String.valueOf(score2), 680, 20);
            gfx.drawString("Scores", 320, 20);
    }
}

   
