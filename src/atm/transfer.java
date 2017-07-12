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

class transfer extends JFrame{
    private String n,number;
   private boolean t=false;
       private  String getbal(String num) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti"); 
      PreparedStatement pst = conn.prepareStatement("Select amount from customer where accno=?");
 pst.setString(1, number); 
      String p;
       ResultSet rs = pst.executeQuery();                        
       if(rs.next())  { 
           p=rs.getString("amount");
          
           return p; 
           
       }
       else{
          
           return "f";  
           }
   }
   catch(Exception e){
       e.printStackTrace();
       return "";
   }
   }   
        private  void add(String bal,String wd) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti"); 
       if(Integer.parseInt(wd)<=Integer.parseInt(bal)){
           String updateTableSQL = "UPDATE customer SET amount = ? WHERE accno = ?";
PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
int p=Integer.parseInt(bal)+Integer.parseInt(wd);
preparedStatement.setInt(1, p);
preparedStatement.setString(2,number);
// execute insert SQL stetement
preparedStatement .executeUpdate();
    
       }else{
           t=true;
       }              
      System.out.println("hiii");
   }
   catch(Exception e){
       e.printStackTrace();
      
   }       
}
 
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
preparedStatement .executeUpdate();
     String b=  getbal(wd);
     add(b,wd);
       }else{
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
     transfer(String name)
 { setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
     n=name;
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome user");
 setSize(800, 800);
  JButton SUBMIT;
   JLabel label1,l2;
   label1 = new JLabel();
  label1.setText("Enter amount to be transferred :");
  l2 = new JLabel();
  l2.setText("Enter card number:");
 final JTextField  text1,text2;
 text1 = new JTextField(4);
 text2 = new JTextField(4);
 SUBMIT=new JButton("SUBMIT");
    getContentPane().setBackground(new Color(153, 255, 153)); 
      
     Container c=getContentPane();   
     c.setLayout(null);
     c.add(label1);
    c.add(text1);
     c.add(l2);
    c.add(text2);
     c.add(SUBMIT);
     label1.setBounds(150,200, 250,30); 
       text1.setBounds(150,250, 150,30); 
       l2.setBounds(150,300, 250,30); 
        text2.setBounds(150,350, 150,30);
        SUBMIT.setBounds(150,400, 100,100);
     class OtherButtonListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                     if(text1.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
                    else if(text2.getText().length()==0)  // Checking for empty field
      JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
   else{
       String amount = text1.getText(); 
        String num = text2.getText(); // Collecting the input
     number=num;
        
       if(wd(amount)&&!t){
            JOptionPane.showMessageDialog(null, "Transfer successful"); 
            Login u=new Login();
                     dispose();
                  u.setVisible(true);
         
       }else{
            JOptionPane.showMessageDialog(null, "insufficient cash"); 
       }
           
//          
       
       
          
   }                
                }
            }
             SUBMIT.addActionListener(new OtherButtonListener());  
 

  
  }
}

