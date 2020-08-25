/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.util.Timer;

/**
 *
 * @author Michael's pc
 */
public class BrickBreak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Canvas canvas = new Canvas((int)(1920/2), (int)(1080/1.5));
        Painter pt = new Painter(1920, 1080, canvas);
        
        Task tk = new Task(canvas);
        Timer tm = new Timer();
        tm.schedule(tk, 0, 1000/144);
    }
    
}
