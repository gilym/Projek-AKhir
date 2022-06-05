/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class LoginView extends JFrame {
           JFrame window = new JFrame("Login");
   
       JLabel loutuser = new JLabel("Username");
        JTextField tfoutuser  = new JTextField();
    JLabel loutpass = new JLabel("Password");
        JTextField tfoutpass = new JTextField();
    JButton btnLogin = new JButton("Login");
   

    public LoginView (){
         window.setLayout(null);
        window.setSize(550,350);
       window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
            this.dispose();
        window.add(loutuser);
        window.add(tfoutuser);
        window.add(loutpass);
        window.add(tfoutpass);
        window.add(btnLogin);
        
      
        loutuser.setBounds(230,35,120,20);
        loutpass.setBounds(230,80,120,20);

//TEXTFIELD
        tfoutuser.setBounds(200, 60, 120, 20);
        tfoutpass.setBounds(200, 100, 120, 20);
       

       btnLogin.setBounds(215, 135, 90, 20);

      
      
        
}

    
    
      public String getlUser(){
         return tfoutuser.getText();
     }
      public String getlPass(){
         return tfoutpass.getText();
     }
     public void inputDB(){
         
    }

   
}
