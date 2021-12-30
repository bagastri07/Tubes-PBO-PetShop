/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewDaftarHewan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bagas
 */
public class CtrlDaftarHewan {
    private ViewDaftarHewan viewDaftarHewan;

    public CtrlDaftarHewan() {
        viewDaftarHewan = new ViewDaftarHewan();
        
        viewDaftarHewan.addActionKembali(new KembaliListener());
        
        viewDaftarHewan.setVisible(true);
        viewDaftarHewan.setLocationRelativeTo(null);
        viewDaftarHewan.setTitle("Menu Daftar Hewan");
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda beranda = new CtrlBeranda();
            viewDaftarHewan.dispose();
        }
    }
}
