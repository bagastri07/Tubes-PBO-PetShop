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
        viewBeranda.addActionMenuPelanggan(new MenuPelangganListener());
        viewBeranda.addActionGrooming(new MenuGroomingListener());
        viewBeranda.addActionMenuHewan(new MenuDaftarHewanListener());
        viewBeranda.addActionMenuReport(new MenuReportListener());
        
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
     class MenuPelangganListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlMenuPelanggan menuPelanggan = new CtrlMenuPelanggan();
            viewBeranda.dispose();
        }   
     }
     
     class MenuGroomingListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            CtrlMenuGrooming menuGrooming = new CtrlMenuGrooming();
            viewBeranda.dispose();
        }
     }
     
     class MenuDaftarHewanListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            CtrlDaftarHewan daftarHewan = new CtrlDaftarHewan();
            viewBeranda.dispose();
        }
     }
     
     class MenuReportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            CtrlMenuReportPenjualan menuPenjualan = new CtrlMenuReportPenjualan();
            viewBeranda.dispose();
        }
     }
}
