/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.util.ArrayList;

/**
 *
 * @author Michael's pc
 */
public class Ball {
    //Data
    int xPos;
    int yPos;
    int radius;
    int xVel, yVel;
    int dCount;
    Canvas canvas;
    ArrayList<Brick> arr;
    public Ball(int init_xPos, int init_yPos, int init_radius, int init_xV, int init_yV, Canvas canvas) {
        xPos = init_xPos;
        yPos = init_yPos;
        radius = init_radius;
        xVel = init_xV;
        yVel = init_yV;
        this.canvas = canvas;
        arr = canvas.getArr();
        dCount = 0;
    }
    //Getters/Setters
    
    //Public Methods
    //Check for collision
    public Brick checkForCollision() {
        //Collision with canvas
        if(xPos < 0 || xPos+radius > canvas.getCanvasX()) {
            xVel *= -1;
            return null;
        }
        if(yPos > canvas.getCanvasY()) {
            xPos = canvas.getCanvasX()/2-100;
            yPos = canvas.getCanvasY()/2-150;
            xVel = 0;
            yVel = 5;
            dCount++;
            if(dCount > 10)
                canvas.gameState = 'L';
            return null;
        }
        if(yPos < 0) {
            yVel *= -1;
            return null;
        }
        //Brick Collisions
        for(Brick e : arr) {
            Point[] vert = e.getVertices();
            if(xPos+radius >= e.xPos && xPos+radius <= e.xPos + e.xLen 
                    && yPos+radius >= e.yPos && yPos <= e.yPos + e.yLen) {
                if(xPos+radius == e.xPos || xPos == e.xPos+e.xLen)
                    xVel *= -1;
                else
                    yVel *= -1;
                return e;
            }
        }
        //Paddle Collisions
        Paddle temp = canvas.getPaddle();
//        if(xPos > temp.xPos && xPos < temp.xPos+temp.xLen
//                && yPos+radius > temp.yPos - temp.changer) { 
//            System.out.println("Hit");
//            temp.changer = canvas.getCanvasY() - (yPos+radius);
//            return null;
//        } 
        double deltax = xPos+(int)(radius/2) - (temp.xPos + (temp.xLen/2));
        if(xPos > temp.xPos && xPos < temp.xPos+temp.xLen
                && yPos+radius > temp.yPos) { 
            xVel = (int)(deltax*0.07);
            yVel *= -1;
            return null;
        } 
        return null;
    }
    //Apply Velocity Changes
    
    //Update function
    public void update() {
        xPos += xVel;
        yPos += yVel;
    }
    //Private Methods
    
}
