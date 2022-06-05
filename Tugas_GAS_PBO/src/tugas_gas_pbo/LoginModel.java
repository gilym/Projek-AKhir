/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_gas_pbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;



public class LoginModel extends JFrame  {
    
    LoginView ViewLogin;
       static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public LoginModel(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
        
    }

    public LoginModel(LoginView ViewLogin) {
        this.ViewLogin = ViewLogin;
        
        
    }
   void Login(String user , String pass)  {
      try{
           
                 String query = "Select * from user WHERE username= '"+user+"' AND `password` = '"+pass+"'";
                 statement = koneksi.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                if(resultSet.next()){
                    
                     JOptionPane.showMessageDialog(null,"       Selamat Datang "+ user+" \n             Berhasil Login"); 
                   
                    MenuView menuView = new MenuView();
                    new MenuController(menuView);
                 
                     
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"              Login Gagal \n Username atau Password salah");  
                }
      }
      catch(Exception ex){
          System.out.println(ex.getMessage());
      }
        
    }

    

   
  
  
  
}

