/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nikki
 */
public class options extends JFrame {
    options(){
        
    }
     options(String name)
 {
      setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome User");
 setSize(800, 800);
 JButton b1,b2,b3,b4,b5;
 b1=new JButton("CASH WITHDRAWAL");
 b2=new JButton("PIN CHANGE");
 b3=new JButton("BALANCE ENQUIRY");
 b4=new JButton("MONEY TRANSFER");
 b5=new JButton("DEPOSIT MONEY");
 getContentPane().setBackground(new Color(153, 255, 153)); 
      
     Container c=getContentPane();   
     c.setLayout(null);
     b1.setBounds(200,150, 300,80); 
       b2.setBounds(200,250, 300,80); 
       b3.setBounds(200,350, 300,80); 
        b4.setBounds(200,450, 300,80);
        b5.setBounds(200,550, 300,80);
     c.add(b1);
     c.add(b2);
     c.add(b3);
     c.add(b4);
      c.add(b5);
 class Cash implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    cash u=new cash(name);
                  dispose();
                    u.setVisible(true);
                }
            }
   b1.addActionListener(new Cash()); 
    class Pin implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    pin u=new pin(name);
                  dispose();
                    u.setVisible(true);
                }
            }
   b2.addActionListener(new Pin()); 
    class Enq implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                   enquiry u=new enquiry(name);
                  dispose();
                  u.setVisible(true);
                }
            }
   b3.addActionListener(new Enq()); 
    class Transfer implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    transfer u=new transfer(name);
                 dispose();
                   u.setVisible(true);
                }
            }
   b4.addActionListener(new Transfer()); 
    class Deposit implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    deposit u=new deposit(name);
                 dispose();
                   u.setVisible(true);
                }
            }
   b5.addActionListener(new Deposit()); 
  
  }
}
