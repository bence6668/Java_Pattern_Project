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
public class OrangePaddleDecorator extends PaddleDecorator{

    public OrangePaddleDecorator(Paddle decoratedPaddle) {
        super(decoratedPaddle);
    }

    @Override
     public void draw(Graphics g){
         addBorder(g);
         decoratedPaddle.draw(g);
        
     }
     
     public void addBorder(Graphics g){
         g.setColor(Color.ORANGE);
         g.fillRect(decoratedPaddle.getX()-2, decoratedPaddle.getY()-2, 25, 85);
     }
    
    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setToUp(boolean toUp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setToDown(boolean toDown) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
