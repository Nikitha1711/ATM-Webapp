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

/**
 *
 * @author Nikki
 */

class enquiry extends JFrame{
    private String n;
     private  String wd(String n) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useSSL=false","root","chitti");     
          PreparedStatement pst = conn.prepareStatement("Select amount from customer where name=?");
 pst.setString(1, n); 
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
      
     enquiry(String name)
 { setContentPane(new JLabel(new ImageIcon("image/3.jpg")));
     n=name;
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
 setTitle("Welcome user");
 setSize(800, 800);
String p=wd(name);
JLabel j,j1;
 JButton jb1=new JButton("Back");  
 j=new JLabel("YOUR BALANCE IS:         ");
 j1=new JLabel(p);
  getContentPane().setBackground(new Color(153, 255, 153)); 
      
     Container c=getContentPane();   
     c.setLayout(null);
    c.add(j);
    c.add(j1);
    c.add(jb1);
     j.setBounds(150,200, 250,30); 
     j1.setBounds(350,200, 250,30); 
     jb1.setBounds(200,300, 250,30); 
    class OtherButtonListener implements ActionListener
            {
                public void actionPerformed(ActionEvent event)
                {
                     Login u=new Login();
                    dispose();
                    u.setVisible(true);
                }
            }
             jb1.addActionListener(new OtherButtonListener());  
  
  }
}
