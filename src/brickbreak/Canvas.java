/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreak;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import sun.applet.Main;

/**
 *
 * @author Michael's pc
 */
public class Canvas extends JPanel implements MouseInputListener {
    private int canvasX;
    private int canvasY;
    private Paddle player;
    private ArrayList<Brick> brickArray;
    private int brickWidth, brickHeight;
    private String path;
    private Image image, background, brickImage;
    private Ball ball;
    private ParticleGenerator particleSys;
    char gameState;
    boolean start;
    //private int yOverflow;
    
    public Canvas(int width, int height) {
        super();
        
        try {
            //image = ImageIO.read(new File("././src/img/paddle.png"));
            //background = ImageIO.read(new File("././src/img/paddle.png"));
            URL url = Main.class.getResource("/img/paddle.png");
            URL url1 = Main.class.getResource("/img/background.png");
            URL url2 = Main.class.getResource("/img/brick2.png");
            image = ImageIO.read(url);
            brickImage = ImageIO.read(url2);
            background = ImageIO.read(url1);
        } catch (IOException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
        canvasX = width;
        canvasY = height-40;
        System.out.println("x: " + canvasX + " y: " + canvasY);
        gameState = 'C';
        brickWidth = 72;
        brickHeight = 20;
        start = false;
        brickArray = new ArrayList<Brick>();
        player = new Paddle(0,canvasY-20, 165, 14);
        ball = new Ball(canvasX/2, canvasY/2, 30, 1, 5, this);
        particleSys = new ParticleGenerator(100, 400, this);
        setLayout(null);
        setBounds(0, 0, canvasX, canvasY);
        setFocusable(true);
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        for (int y = 0; y < 5; y++) {
            for (int x = 3; x < (int)(canvasX/brickWidth); x++) {
                brickArray.add( new Brick(x*brickWidth, y*brickHeight, brickWidth, brickHeight));
            }
        }
    }
    
    //Getters/Setters
    public int getCanvasX() {
        return canvasX;
    }
    public int getCanvasY() {
        return canvasY;
    }
    public Ball getBall() {
        return ball;
    }
    public void setBall(Ball newBall) {
        if(newBall != null)
            ball = newBall;
    }
    public ArrayList<Brick> getArr() {
        return brickArray;
    }
    public Paddle getPaddle() {
        return player;
    }
    public void setParticleSys(ParticleGenerator newSys) {
        if(newSys != null)
            particleSys = newSys;
    }
    public ParticleGenerator getParticleSys() {
        return particleSys;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        if(gameState == 'C' && start == true) {
            //Draw Background
            g2d.drawImage(background, 0, 0, this);
            g2d.setFont( new Font("TimesRoman", Font.PLAIN, 20));
            g2d.drawString("Lives: " + (11 - ball.dCount), 50, (int)(canvasY/2.1));
            //Draw Paddle
            g2d.drawImage(image, player.xPos, player.yPos, this);
            particleSys.draw(g2d);
            //g2d.setColor(new Color(252, 89, 68));
            g2d.setColor(new Color(132, 35, 35));
            g2d.fillOval(ball.xPos, ball.yPos, ball.radius, ball.radius);
            //Iterate through brick arr and draw all valid bricks
            for(Brick e : brickArray) {
                g2d.drawImage(brickImage, e.xPos, e.yPos, this);
            }
        } else {
            g2d.setFont( new Font("TimesRoman", Font.PLAIN, 20));
            if(gameState == 'L') {
                g2d.drawString("You Lost..", 200, (int)(canvasY/2.1));
            } else if(gameState == 'W') {
                g2d.drawString("You Win,\n congrats!", 200, (int)(canvasY/2.1));
            } else {
                g2d.drawString("Click to start", 200, (int)(canvasY/2.1));
            }
        }
        g.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        start = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        player.xPos = e.getX() - (int)(player.xLen/2);
    }
}
