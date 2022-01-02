/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Admin;
import Views.ViewBeranda;
import Views.ViewLoginAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bagas
 */
public class CtrlLogin {
    private Admin modelAdmin;
    private ViewLoginAdmin viewAdmin;

    public CtrlLogin() {
        modelAdmin = new Admin(1, "", "", "Lukman Judge");//membuat object
        viewAdmin = new ViewLoginAdmin();//membuat object
        
        viewAdmin.addActionLogin(new LoginListener());
        
        viewAdmin.setVisible(true);
        viewAdmin.setLocationRelativeTo(null);
        viewAdmin.setTitle("Login Admin");
    }
    
    class LoginListener implements ActionListener {//interface AL
        //buat klo dipencet memanggil ini
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String username = viewAdmin.getUsername();
                String password = viewAdmin.getPassword();
                
                if (modelAdmin.loginAdmin(username, password)) {
                    CtrlBeranda beranda = new CtrlBeranda();
                    viewAdmin.dispose();
                } else {
                    viewAdmin.DipslayError("Username atau Password salah!");
                }
            } catch (Exception e) {
                viewAdmin.DipslayError(e.getMessage());//untuk kodingan
            }
        }

       
        
    }
}
