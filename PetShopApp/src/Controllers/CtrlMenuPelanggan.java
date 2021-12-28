/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewMenuPelanggan;

/**
 *
 * @author Yoga
 */
public class CtrlMenuPelanggan {
    private ViewMenuPelanggan viewMenu;

    public CtrlMenuPelanggan() {
        viewMenu = new ViewMenuPelanggan();
        
        //.addActionKeluar(new KeluarListener());
        
        viewMenu.setVisible(true);
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setTitle("Menu Pelanggan");
    }
    
    
}
