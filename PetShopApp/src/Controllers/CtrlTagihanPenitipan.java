/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.HewanPeliharaan;
import Models.Penitipan;
import Views.ViewTagihanPenitipan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bagas
 */
public class CtrlTagihanPenitipan {
    private ViewTagihanPenitipan viewTagihan;
    private Penitipan penitipan;

    public CtrlTagihanPenitipan() {
        viewTagihan = new ViewTagihanPenitipan();
        
        viewTagihan.addActionBayar(new BayarListener());
        viewTagihan.addActionKembali(new KembaliListener());
        
        viewTagihan.setVisible(true);
        viewTagihan.setLocationRelativeTo(null);
        viewTagihan.setTitle("Tagihan Penitipan");
    }
    
    public void setPenitipanModel(HewanPeliharaan hewanPeliharaan, int lamaPenitipan) {
        penitipan = new Penitipan(hewanPeliharaan, lamaPenitipan);
        
        String tagihan = "Rp. " + String.valueOf(penitipan.menghitungBiaya());
        viewTagihan.setTagihan(tagihan);
        viewTagihan.setNamaPemilik(penitipan.getHewan().getPemilik().getNama());
        viewTagihan.setNamaHewan(penitipan.getHewan().getNama());
        viewTagihan.setLamaPenitipan(String.valueOf(penitipan.getLamaPenitipan()) + " Hari");
        viewTagihan.setJenisHewan(hewanPeliharaan);
    }
    
    class BayarListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            CtrlInvoice invoice = new CtrlInvoice();
            invoice.setLayananModel(penitipan, viewTagihan.getMetodePembayaran());
            viewTagihan.dispose();
        }
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlMenuPenitipan menuPenitipan = new CtrlMenuPenitipan();
            viewTagihan.dispose();
        }   
    }
}
