/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

/**
 *
 * @author miryn
 */
public class Vector2d {
    //Data
    double xVel, yVel;
    
    public Vector2d(double x, double y) {
        xVel = x;
        yVel = y;
    }
    //Getters/Setters
    
    //Public Methods
    public void stop() {
        xVel = 0;
        yVel = 0;
    }
    public void function() {
        if(Math.abs(xVel) < 3 && Math.abs(yVel) < 3) {
            if(xVel < 0) 
                xVel *= xVel * -1;
            else
                xVel *= xVel;
            if(yVel < 0) 
                yVel *= yVel * -1;
            else
                yVel *= yVel;
        }
    }
    //Private Methods
}
