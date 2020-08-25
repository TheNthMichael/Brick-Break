/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author miryn
 */
public class ParticleGenerator {
    //Data
    private int numParticles;
    private int totalNum;
    private ArrayList<Particle> arr, removalArr;
    private int internalCounter;
    private Canvas canvas;
    
    public ParticleGenerator(int num, int limit, Canvas c) {
        numParticles = num;
        totalNum = limit;
        arr = new ArrayList<>();
        removalArr = new ArrayList<>();
        canvas = c;
    }
    //Getters/Setters
    public ArrayList<Particle> getArr() {
        return arr;
    }
    //Public Methods
    public boolean check() {
        removalArr.clear();
        for(Particle e : arr) {
            if(e.check())
                removalArr.add(e);
        }
        for(Particle e : removalArr) {
            arr.remove(e);
        }
        return arr.isEmpty();
    }
    public void update() {
        //Point[] p = canvas.determineAngle();
        int ballx = canvas.getBall().xPos;
        int bally = canvas.getBall().yPos;
        int rad = canvas.getBall().radius;
        arr.add( new Particle( new Point(ballx, bally), 10, 30, false));
        arr.add( new Particle( new Point(ballx, bally), 10, 30, false));
        if(internalCounter < 20) {
            internalCounter++;
        } else {
            internalCounter = 0;
            arr.add( new Particle( new Point(ballx, bally), 5, 20, true));
            arr.add( new Particle( new Point(ballx, bally), 5, 20, true));
            arr.add( new Particle( new Point(ballx, bally), 5, 20, true));
            arr.add( new Particle( new Point(ballx, bally), 5, 20, true));
        }
        for(Particle e : arr) {
            e.update();
        }
    }
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.black);
        for(Particle e : arr) {
            g2d.setColor(e.getColor());
            //g2d.fillRect((int)(e.getPos().x), (int)(e.getPos().y), (int)(e.getLength()), (int)(e.getLength()));
            g2d.fillOval((int)(e.getPos().x), (int)(e.getPos().y), (int)(e.getLength()), (int)(e.getLength()));
        }
    }
    //Private Methods
}
