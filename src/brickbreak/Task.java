/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author Michael's pc
 */
public class Task extends TimerTask {
    //Data
    Canvas canvas;
    private Ball temp;
    private ArrayList<Brick> arr;
    private Brick tempBrick;
    private ParticleGenerator particleSys;
    public Task(Canvas e) {
        canvas = e;
    }
    //Getters/Setters
    
    //Public Methods
    @Override
    public void run() {        
        if(canvas.gameState == 'C' && canvas.start == true) {
            arr = canvas.getArr();
            temp = canvas.getBall();
            particleSys = canvas.getParticleSys();
            tempBrick = temp.checkForCollision();
            if(tempBrick != null) {
                arr.remove(tempBrick);
                tempBrick = null;
            }
            if(arr.isEmpty())
                canvas.gameState = 'W';        
            temp.update();
            particleSys.check();
            particleSys.update();
        } else {
            
        }
        canvas.repaint();
    }
}
