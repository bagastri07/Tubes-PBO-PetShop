/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewBeranda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bagas
 */
public class CtrlBeranda {
    private ViewBeranda viewBeranda;

    public CtrlBeranda() {
        viewBeranda = new ViewBeranda();
        
        viewBeranda.addActionKeluar(new KeluarListener());
        
        viewBeranda.setVisible(true);
        viewBeranda.setLocationRelativeTo(null);
        viewBeranda.setTitle("Beranda PetShop");
    }
    
     class KeluarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            CtrlLogin login = new CtrlLogin();
            viewBeranda.dispose();
        }
         
     }
}
