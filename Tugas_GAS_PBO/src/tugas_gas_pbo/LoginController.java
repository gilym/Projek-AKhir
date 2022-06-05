


package tugas_gas_pbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.*;


public class LoginController extends JFrame {
    LoginModel LoginModel;
    LoginView ViewLogin;

    public LoginController(LoginView ViewLogin ,LoginModel LoginModel) {
        this.LoginModel = LoginModel;
        this.ViewLogin = ViewLogin;
          
       ViewLogin.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             try{
                 if(ViewLogin.tfoutuser.getText().equals("") || ViewLogin.tfoutpass.getText().equals("") ){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
               }
                 else{
               
                  String user = ViewLogin.getlUser();
                  String pass = ViewLogin.getlPass();
                  LoginModel.Login(user, pass);
           
                  
                 }
             }
             catch(Exception ex){
                 
                   System.out.println(ex.getMessage());
             }
              
            }
        });
       
       
    }

  
    
}
