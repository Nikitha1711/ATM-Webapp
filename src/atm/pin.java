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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class pin extends JFrame{
   
    private String n;
    private  void pinc(String pinnew) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti");     
    //   PreparedStatement pst = conn.prepareStatement("update users set pin = "+pinnew+" where name ="+n+"");
      // pst.executeUpdate();
           String updateTableSQL = "UPDATE customer SET pin = ? WHERE name = ?";
PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
preparedStatement.setString(1, pinnew);
preparedStatement.setString(2,n);
// execute insert SQL stetement
preparedStatement .executeUpdate();               
      System.out.println("hiii");
   }
   catch(Exception e){
       e.printStackTrace();
      
   }       
} 
     pin(String name)
             
 { setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
     n=name;
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome user");
 setSize(800, 800);
  JButton SUBMIT;
   JLabel label1,label2,l3;
  
   l3 = new JLabel();
  l3.setText("Enter new PIN");
 final JTextField  text1,text2,text3;
 
   text3 = new JPasswordField(4);
   SUBMIT=new JButton("SUBMIT");
  getContentPane().setBackground(new Color(153, 255, 153)); 
      
     Container c=getContentPane();   
     c.setLayout(null);
  
        c.add(l3);
    c.add(text3);
    c.add(SUBMIT);
    l3.setBounds(150,200, 250,30); 
       text3.setBounds(150,250, 150,30); 
      
        SUBMIT.setBounds(150,300, 100,100);
  class OtherButtonListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                    
    if(text3.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else{
    
          String new2= text3.getText();
        // converting from array to string
       pinc(new2);
          JOptionPane.showMessageDialog(null, "PIN changed successfully");   
//          Login u=new Login();
//                     dispose();
//                    u.setVisible(true);
       
       
   }        
                    
                    
                }
            }
             SUBMIT.addActionListener(new OtherButtonListener());  
  }
}
