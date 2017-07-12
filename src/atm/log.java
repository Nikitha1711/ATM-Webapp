/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Nikki
 */
 class log extends JFrame{
    log(){
 setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome Admin");
 setSize(800, 800);
  JLabel label1,label2;
  JButton SUBMIT;
 final JTextField  text1,text2;
 label1 = new JLabel();
  label1.setText("Enter the verification code:");
  text1 = new JPasswordField(15);
 
  SUBMIT=new JButton("SUBMIT");
  getContentPane().setBackground(new Color(153, 255, 153)); 
      
     Container c=getContentPane();   
     c.setLayout(null);
      label1.setBounds(150,200, 250,30); 
       text1.setBounds(150,250, 150,30); 
 
        SUBMIT.setBounds(150,300, 100,100);
    c.add(label1);
    c.add(text1);
    c.add(SUBMIT);
 
  class AddInterestListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    
                    if(text1.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else{
       String user = text1.getText();   // Collecting the input
        System.out.println(user);
       if(user.equalsIgnoreCase("ADMIN123")){
          JOptionPane.showMessageDialog(null, "Correct Login Credentials");   
         
          
          admin u;
           try {
               u = new admin();
                dispose();
                  u.setVisible(true);  
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
           }
                 
       }
       else
          JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
   }        
                    
                }
            }
   SUBMIT.addActionListener(new AddInterestListener()); 
  }
      
    
}
