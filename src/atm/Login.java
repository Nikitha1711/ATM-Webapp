/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;


import static com.sun.glass.ui.Cursor.setVisible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
public class Login extends JFrame implements ActionListener{ 
    static Login l;
   JButton jb1,jb2;  
   JLabel j;  

   
  
   public Login(){  
       setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
    setSize(800, 800);
       
       jb1=new JButton("USER");
    
   
     jb2=new JButton("ADMIN");  
           
  
      j=new JLabel("ATM SYSTEM");  
     
   
   
     setLayout(null);
     getContentPane().setBackground(new Color(222, 102, 90)); 
      
     Container c=getContentPane();  
  
       
     c.setLayout(null);
     jb2.setBounds(200, 300, 100, 100);
     jb1.setBounds(500, 300, 100, 100);
     j.setBounds(350, 100, 100, 100);
   //  c.add(j);  
   c.add(jb2);
     c.add(jb1);  
    
  class AddInterestListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    user u=new user();
                    l.setVisible(false);
                    u.setVisible(true);
                }
            }
            class OtherButtonListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                     log u;
                     u = new log();
                     l.setVisible(false);
                     u.setVisible(true);
                     
                }
            }
             jb1.addActionListener(new AddInterestListener());  
        jb2.addActionListener(new OtherButtonListener()); 
   }  
  
  
   public static void main(String[] args) {  
     // TODO code application logic here  
     l=new Login();  
   
  
       l.setVisible(true); 
    
   }  

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }  
    

