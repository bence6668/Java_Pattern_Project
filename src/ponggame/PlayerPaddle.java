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
public class PlayerPaddle implements Paddle{
    
    double y=210, ySpeed=0;
    boolean toUp=false, toDown=false;
    int player, x;
    final double GRAVITY = 0.94;

    public PlayerPaddle(int player) {
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
        if(toUp){
            ySpeed -=2;
        }else if(toDown){
            ySpeed +=2;
        }else if(!toUp && !toDown){
            ySpeed *= GRAVITY;
        }
        
        if(ySpeed>=6){
            ySpeed=6;
        }else if(ySpeed<=-6){
            ySpeed=-6;
        }
            
        y += ySpeed;
        
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

    public void setToUp(boolean toUp) {
        this.toUp = toUp;
    }

    public void setToDown(boolean toDown) {
        this.toDown = toDown;
    }

    @Override
    public int getX() {
        return x;
    }
    
    
    
    
}
