/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apcsa;

/**
 *
 * @author nitin
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Font;
public class Tablet extends JPanel implements KeyListener, Runnable
{
private boolean[] keys;
private int x;
private int y;
    public Tablet(JFrame par)
    {
        //the keys array will store the key presses
        //[0]=left arrow
        //[1]=right arrow
        //[2]=up arrow
        //[3]=down arrow
        //[4]=space bar
        keys = new boolean[5];
        setBackground(Color.BLACK);
        //x and y will keep track of where the pen is
        //on the screen
        x = DrawIt.WIDTH/2;
        y = DrawIt.HEIGHT/2;
        this.addKeyListener(this);
        new Thread(this).start();
        setVisible(true);
    }
    public void update(Graphics window)
    {
        paint(window);
    }
    public void paint( Graphics window )
    {
        window.setColor( Color.WHITE );
        window.setFont(new Font("TAHOMA",Font.BOLD,18));
        window.drawString("A+ Draw a Shape", 20,20);
        window.drawString("Use the arrow keys to draw.", 20,40);
        window.drawString("Use the space bar to clear the screen.", 20,60);
        //add in code to move the x and y
        if (keys[2] && y > 0) 
        {
            y--; // Up arrow
        }
        //if the up arrow was pressed
        //take 1 away from y value
         if (keys[3] && y < DrawIt.HEIGHT - 1) 
         {
            y++; // Down arrow
        }
        //if the down arrow was pressed
        //add 1 to the y value
        if (keys[0] && x > 0) 
        {
            x--; // Left arrow
        }
        if (keys[1] && x < DrawIt.WIDTH - 1) 
        {
            x++; // Right arrow
        }
        //if the left array was pressed
        //take 1 away from x valye
        //if the right arrow was pressed
        //add 1 to the y value
        //if the space bar was pressed
        //reset x and y to the center
        if (keys[4]) 
        {
            x = DrawIt.WIDTH / 2;
            y = DrawIt.HEIGHT / 2; // Space bar, reset to center
            window.setColor(Color.BLACK);
            window.fillRect(0, 0, DrawIt.WIDTH, DrawIt.HEIGHT); // Clear the screen
        }
        //draw a black rectangle the size of the screen
        window.setColor( Color.WHITE );
        window.fillRect(x, y, 2, 2);
    }
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = true;
        }
            repaint();
    }
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = false;
        }
        repaint();
    }
    public void keyTyped(KeyEvent e)
    {
    }
    public void run()
    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(5);
                repaint();
            }
        }
        catch(Exception e)
        {
        }
    }
}
