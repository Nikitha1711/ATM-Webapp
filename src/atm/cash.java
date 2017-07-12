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
class cash extends JFrame{
    private String n;
   private boolean t=false;
    private  void pinc(String bal,String wd) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti"); 
       if(Integer.parseInt(wd)<=Integer.parseInt(bal)){
           String updateTableSQL = "UPDATE customer SET amount = ? WHERE name = ?";
PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
int p=Integer.parseInt(bal)-Integer.parseInt(wd);
preparedStatement.setInt(1, p);
preparedStatement.setString(2,n);
// execute insert SQL stetement
preparedStatement .executeUpdate(); }else{
           t=true;
       }              
      System.out.println("hiii");
   }
   catch(Exception e){
       e.printStackTrace();
      
   }       
} 
     private  boolean wd(String bal) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti");     
          PreparedStatement pst = conn.prepareStatement("Select amount from customer where name=?");
 pst.setString(1, n); 
      String n;
       ResultSet rs = pst.executeQuery();                        
       if(rs.next())  { 
           n=rs.getString("amount");
           pinc(n,bal);
           return true; 
           
       }
       else{
          
           return false;  
           }
   }
   catch(Exception e){
       e.printStackTrace();
       return false;
   }
     }
     cash(String name)
 {
      setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
     n=name;
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome User");
 setSize(800, 800);
  JLabel label1;
   label1 = new JLabel();
  label1.setText("Enter amount to be withdrawn :");
  JButton SUBMIT;
 final JTextField  text1;
 text1 = new JTextField(4);
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
     class OtherButtonListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                     if(text1.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else{
       String amount = text1.getText();   // Collecting the input
     
       if(Integer.parseInt(amount)%100==0){
       if(wd(amount)&&!t){
            JOptionPane.showMessageDialog(null, "Withdraw is successfull"); 
            Login u=new Login();
                     dispose();
                  u.setVisible(true);
         
       }else{
            JOptionPane.showMessageDialog(null, "insufficient cash"); 
       }
           
//          
       }else{
           JOptionPane.showMessageDialog(null, "Enter only multiples of 100"); 
       }
       
          
   }                
                }
            }
             SUBMIT.addActionListener(new OtherButtonListener());  
 

  
  }
}

