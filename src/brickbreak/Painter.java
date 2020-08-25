/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Michael's pc
 */
public class Painter extends JFrame {
    //Data
    private int screenX;
    private int screenY;
    private int canvasX;
    private int canvasY;
    private Canvas canvas;
    
    public Painter(int init_sx,  int init_sy, Canvas c) {
        super();        
        screenX = init_sx;
        screenY = init_sy;
        canvasX = screenX/2;
        canvasY = (int)(screenY/1.5);
        this.setTitle("BrickBroke");
        this.setBounds(screenX/4, screenY/4, canvasX, canvasY);
        this.setVisible(true);
        this.setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = c;
        setLayout(null);
        add(canvas);
    }
    //Getters/Setters
    public Canvas getCanvas() {
        return canvas;
    }
    //Public Methods
    @Override
    public void paint(Graphics g) {
        super.paint(g);        
        
        g.dispose();
    }
    
    //Private Methods
}
