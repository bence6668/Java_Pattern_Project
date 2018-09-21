/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponggame;

import java.awt.Graphics;

/**
 *
 * @author Bence
 */
public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
    public int getX();
    public void setToUp(boolean toUp);
    public void setToDown(boolean toDown);
}
