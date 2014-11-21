/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMain;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author chutc_000
 */
public class MainEngine2 extends JPanel implements ActionListener {
    
    
    private Timer timer;//not using this
    private Lava Lava;
    private ArrayList lava;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
    
    private int[][] pos = { 
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239}, 
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
     };
    
     public MainEngine2() {

        //addKeyListener(new TAdapter());//not sure what this does
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        setSize(400, 300);

        Lava = new Lava();

     }
     
     public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();   
    }
     
     public void initLava() {
        lava = new ArrayList();

        for (int i=0; i<pos.length; i++ ) {
            lava.add(new Lava());
        }
    }
     
       public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {
            /*dont forget to add the ball, there should be a ball method in here!!!*/
            Graphics2D g2d = (Graphics2D)g;

            if (Lava.isVisible())
                g2d.drawImage(Lava.getImage(), Lava.getX(), Lava.getY(),
                              this);
            } 
        else {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2,
                         B_HEIGHT / 2);
        }
         Toolkit.getDefaultToolkit().sync();
        g.dispose();
    
       }
       public void actionPerformed(ActionEvent e) {
           
           /* THIS WOULD BE FOR BALL, BUT WE NEED TO MAKE IT WORK FOR OBJECT INSTEAD OF ARRAY
           
           need to write this ourselves!! we think this was set initially as an arraylist
           hitting an array list, we need object to hit an array list
           
        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
                   
                   */
        }
       

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}   
