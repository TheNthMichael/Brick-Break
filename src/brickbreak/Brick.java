/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

/**
 *
 * @author Michael's pc
 */
public class Brick {
    //Data
    int xPos;
    int yPos;
    int xLen;
    int yLen;
    boolean isAlive;
    private Point[] vertices;
    
    public Brick(int init_xPos, int init_yPos, int init_xLen, int init_yLen) {
        xPos = init_xPos;
        yPos = init_yPos;
        xLen = init_xLen;
        yLen = init_yLen;
        vertices = new Point[4];
        vertices[0] = new Point(xPos, yPos);
        vertices[1] = new Point(xPos+xLen, yPos);
        vertices[2] = new Point(xPos, yPos+yLen);
        vertices[3] = new Point(xPos+xLen, yPos+yLen);
        isAlive = true;
    }
    
    //Getters and Setters
    public void setVertices(Point[] newSet) {
        if(newSet != null)
            vertices = newSet;
    }
    /*yeeterskeeter*/
    public Point[] getVertices() {
        return vertices;
    }
    //Public Methods
    //Check Collisions
    
    //Private Methods
    
}
