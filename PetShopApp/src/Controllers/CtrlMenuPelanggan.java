/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewMenuPelanggan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yoga
 */
public class CtrlMenuPelanggan {
    private ViewMenuPelanggan viewMenu;

    public CtrlMenuPelanggan() {
        viewMenu = new ViewMenuPelanggan();
        
        viewMenu.addActionKembali(new KembaliListener());
        viewMenu.addActionDaftarPelanngan(new DaftarPelangganListener());
        
        viewMenu.setVisible(true);
        viewMenu.setLocationRelativeTo(null);
        viewMenu.setTitle("Menu Pelanggan");
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda beranda = new CtrlBeranda();
            viewMenu.dispose();
        }   
    }
    
    class DaftarPelangganListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            CtrlDaftarPelanggan daftarPelanggan = new CtrlDaftarPelanggan();
            viewMenu.dispose();
        }
    }
}
