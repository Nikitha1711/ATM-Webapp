/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import static atm.Login.l;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
class user extends JFrame{
       private boolean validate_login(String username,String password) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti");     
       PreparedStatement pst = conn.prepareStatement("Select * from customer where accno=? and pin=?");
       pst.setString(1, username); 
       pst.setString(2, password);
       ResultSet rs = pst.executeQuery();                        
       if(rs.next())            
           return true;    
       else{
          
           return false;  
       }
   }
   catch(Exception e){
       e.printStackTrace();
       return false;
   }       
} 
        private String getname(String username,String password) {
            String s=null;
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti");     
       PreparedStatement pst = conn.prepareStatement("Select name from customer where accno=? and pin=?");
       pst.setString(1, username); 
       pst.setString(2, password);
       ResultSet rs = pst.executeQuery();                        
       if(rs.next())   {   
           s=rs.getString("name");
           return s ;  
       } 
       else{
          
           return "false";  
       }
   }
   catch(Exception e){
       e.printStackTrace();
       return "f";
   }
        }

     user()
 { setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome user");
 setSize(800, 800);
  JLabel label1,label2;
  JButton SUBMIT;
 final JTextField  text1,text2;
 label1 = new JLabel();
  label1.setText("Card Number:");
  text1 = new JTextField(15);

  label2 = new JLabel();
  label2.setText("PIN:");
  text2 = new JPasswordField(4);
 
  SUBMIT=new JButton("SUBMIT");
  getContentPane().setBackground(new Color(153, 255, 153)); 
      
     Container c=getContentPane();   
     c.setLayout(null);
      label1.setBounds(150,150, 250,30); 
       text1.setBounds(150,200, 150,30); 
       label2.setBounds(150,250, 250,30); 
        text2.setBounds(150,300, 150,30);
        SUBMIT.setBounds(150,350, 100,100);
    c.add(label1);
    c.add(text1);
    
    c.add(label2);
     c.add(text2);
    c.add(SUBMIT);
 
  class AddInterestListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    
                    if(text1.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else if(text2.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else{
       String user = text1.getText();   // Collecting the input
          String pass = text2.getText(); // Collecting the input
        // converting from array to string
       if(validate_login(user,pass)){
          JOptionPane.showMessageDialog(null, "Correct Login Credentials");   
          String name=getname(user,pass);
           System.out.print(name);
          options u=new options(name);
                  dispose();
                    u.setVisible(true);
       }
       else{
          JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
           
       }
   }        
                    
                }
            }
   SUBMIT.addActionListener(new AddInterestListener()); 
  }
      
}
