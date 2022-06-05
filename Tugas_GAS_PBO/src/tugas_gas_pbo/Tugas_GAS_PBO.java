/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas_gas_pbo;

/**
 *
 * @author gilym
 */
public class Tugas_GAS_PBO {

    
    public static void main(String[] args) {
        LoginView Viewlogin = new LoginView();
        LoginModel loginModel = new LoginModel();
       new LoginController(Viewlogin,loginModel);
       

    
    }
    
}
