/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.awt.Color;

/**
 *
 * @author miryn
 */
public class Particle {
    private Vector2d velocity;
    private Point pos;
    private int internalCounter;
    private double length;
    private int lowBound;
    private Color color;
    private int r, g, b;
    private boolean isSmoke;
    
    public Particle(Point start, int lowBound, int upperBound, boolean isIt) {
        double xRand = Math.random() * 3 + -1;
        double yRand = Math.random() * 3 + -1;
        velocity = new Vector2d(xRand, yRand);
        internalCounter = 0;
        length = (int)(Math.random() * upperBound + lowBound);
        pos = new Point(start.x, start.y);
        isSmoke = isIt;
        if(!isSmoke) {
            r = 132;
            g = 35;
            b = 35;
        } else {
            r = 100;
            g = 100;
            b = 100;
        }
        color = new Color(r, g, b);        
    }
    //Getters/Setters
    public void setLength(double newLen) {
        if(newLen >= 0)
            length = newLen;
    }
    public double getLength() {
        return length;
    }
    public void setPos(Point newPos) {
        if(newPos != null)
            pos = newPos;
    }
    public Point getPos() {
        return pos;
    }
    public void setColor(Color newColor) {
        if(newColor != null)
            color = newColor;
    }
    public Color getColor() {
        return color;
    }
    //Public Methods
    public boolean check() {
        if(internalCounter < 75) {
            internalCounter++;
            return false;
        } else {
            internalCounter = 0;
            return true;
        }
    }
    public void update() {
        pos.x += velocity.xVel;
        pos.y += velocity.yVel;
        //velocity.function();
        if(!isSmoke) {
            if(r < 250)
                r += 10;
            if(g < 250)
                g += 4;
        } else {
            if(r < 250)
                r += 2;
            if(g < 250)
                g += 2;
            if(g < 250)
                b += 2;
        }
        color = new Color(r, g, b);
        length /= 1.05;
    }
    //Private Methods
    
    
}
