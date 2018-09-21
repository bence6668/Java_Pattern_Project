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
public class Ball {

    private double x=350,y=250,xSpeed=setRandomSpeed()*setRandomDirection(),ySpeed=setRandomSpeed()*setRandomDirection();

    public Ball() {
    }
    
    private double setRandomSpeed(){
        return 1 + Math.random()*2;
    }
    
    private int setRandomDirection(){
        int rnddir = (int) (Math.random() * 2);
        if(rnddir==1){
            return 1;
        }else{
            return -1;
        }
       
    }
    
    public void draw (Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval((int)x-10, (int)y-10, 20, 20);
    }
    
    public void checkPaddleCollision(Paddle p1, Paddle p2){
        if(x<=50){
            if(y>= p1.getY() && y<=p1.getY()+80){
                xSpeed = -xSpeed;
            }
        }else if(x >= 650){
             if(y>= p2.getY() && y<=p2.getY()+80){
                xSpeed = -xSpeed;
            }
        }
    }
    
    public void move(){
        x+=xSpeed;
        y+=ySpeed;
        
        if(y<10){
            ySpeed = -ySpeed;
        }
        
        if(y>490){
            ySpeed= -ySpeed;
        }
        
        if(x<10){
            xSpeed = -xSpeed;
        }
         if(x>790){
            xSpeed = -xSpeed;
        }
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }
    
    
}
