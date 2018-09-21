/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponggame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Bence
 */
public class ComputerPaddle implements Paddle{  
    double y=210, ySpeed=0;
    boolean toUp=false, toDown=false;
    int player, x;
    final double GRAVITY = 0.94;
    private final Ball ball;
    
    public ComputerPaddle(int player, Ball ball) {
        this.ball = ball;
        if(player==1){
            x=20;
        }else{
            x=660;
        }
    }
    
    
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, (int)y, 20, 80);
    }

    @Override
    public void move() {
        y = ball.getY()-40;
        if(y<0){
            y=0;
        }
        
        if(y>420){
            y=420;
        }
    }

    @Override
    public int getY() {
        return (int) y;
    }
    
    @Override
     public int getX() {
        return x;
    }

    @Override
    public void setToUp(boolean toUp) {
       
    }

    @Override
    public void setToDown(boolean toDown) {
      
    }
    
}
