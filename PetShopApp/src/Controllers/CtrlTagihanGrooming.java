/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Grooming;
import Models.HewanPeliharaan;
import Models.Kucing;
import Models.Pelanggan;
import Views.ViewTagihanGrooming;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bagas
 */
public class CtrlTagihanGrooming {
    private ViewTagihanGrooming viewTagihan;
    private Grooming grooming;

    public CtrlTagihanGrooming() {
        viewTagihan = new ViewTagihanGrooming();
        
        viewTagihan.addActionKembali(new KembaliListener());
        
        viewTagihan.setVisible(true);
        viewTagihan.setLocationRelativeTo(null);
        viewTagihan.setTagihan("Tagihan Grooming");
    }
    
    public void setGroomingModel(HewanPeliharaan hewanPeliharaan, String layanan) {
        grooming = new Grooming(hewanPeliharaan, layanan);
        
        String tagihan = "Rp. " + String.valueOf(grooming.menghitungBiaya());
        viewTagihan.setTagihan(tagihan);
        viewTagihan.setNamaPemilik(grooming.getHewan().getPemilik().getNama());
        viewTagihan.setNamaHewan(grooming.getHewan().getNama());
        viewTagihan.setLayanan(grooming.getLayanan());
        viewTagihan.setJenisHewan(hewanPeliharaan);
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlMenuGrooming menuGrooming = new CtrlMenuGrooming();
            viewTagihan.dispose();
        }   
    }
    
}
