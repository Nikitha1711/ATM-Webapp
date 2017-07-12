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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
class admin extends JFrame{
    
        private boolean demo(String name,String acc,String pin,String amount) throws ClassNotFoundException{ 
    try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false", "root", "chitti");
    Statement st = con.createStatement();
    st.executeUpdate("INSERT INTO customer (name, accno, pin, amount) "
          +"VALUES ('"+name+"','"+acc+"','"+pin+"','"+amount+"')");
    return true;
  }
catch(SQLException e) {
     e.printStackTrace();
     return false;
}          
        }

    
     admin() throws ClassNotFoundException
 {
       setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome admin");
 setSize(800, 800);
JLabel label1,label2,label3,label4;
final JTextField  text1,text2,text3,text4;
 text1 = new JTextField();
  text2 = new JTextField();
   text3 = new JTextField();
    text4 = new JTextField();
   
   label1 = new JLabel();
  label1.setText("Enter the Name of the customer :");
   label2 = new JLabel();
  label2.setText("Enter card number :");
   label3 = new JLabel();
  label3.setText("Enter the PIN :");
   label4 = new JLabel();
  label4.setText("Enter the balance :");
  JButton SUBMIT;
 SUBMIT=new JButton("SUBMIT");
   getContentPane().setBackground(new Color(153, 255, 153));  
      label1.setBounds(150,150, 250,30);  
      text1.setBounds(150,200, 150,30);   
      label2.setBounds(150,250, 250,30);  
      text2.setBounds(150,300, 150,30); 
      label3.setBounds(150,350, 250,30);  
      text3.setBounds(150,400, 150,30); 
      label4.setBounds(150,450, 250,30);  
      text4.setBounds(150,500, 150,30); 
      SUBMIT.setBounds(150,550, 100,100); 
     Container c=getContentPane();   
     
     c.add(label1);
     c.add(text1);
     c.add(label2);
     c.add(text2);
     c.add(label3);
     c.add(text3);
     c.add(label4);
     c.add(text4);
     c.add(SUBMIT);
      c.setLayout(null);
  c.setVisible(true);
class OtherButtonListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                     if(text1.getText().length()==0 ||text2.getText().length()==0||text3.getText().length()==0 || text4.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else{
       String name = text1.getText();   
       String accn = text2.getText(); 
       String pin = text3.getText(); String amount = text4.getText(); 
       
     
                         try {
                             // converting from array to string
                             if(demo(name,accn,pin,amount)){
                                 JOptionPane.showMessageDialog(null, "Added successfully");
                                 Login u=new Login();
                                 dispose();
                                 u.setVisible(true);
                                 
                             }else{
                                 JOptionPane.showMessageDialog(null, "Error occured");
                             }
                             
//          
                         } catch (ClassNotFoundException ex) {
                             Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                         }
       
       
          
   }                
                }

               
            }
             SUBMIT.addActionListener(new OtherButtonListener());  
   
  }


}
