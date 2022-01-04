/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Models.Anjing;
import Models.HewanPeliharaan;
import Models.Kucing;
import Models.Pelanggan;
import Views.ViewMenuPenitipan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author bagas
 */
public class CtrlMenuPenitipan {
    private ViewMenuPenitipan viewPenitipan;

    public CtrlMenuPenitipan() {
        viewPenitipan = new ViewMenuPenitipan();
        
        viewPenitipan.addActionKembali(new KembaliListener());
        viewPenitipan.setPelangganDropDown(getDaftarPelanggan());
        viewPenitipan.setHewanPeliharaanDropDown(getDaftarHewanPeliharaanPertama());
        viewPenitipan.addActionSubmit(new SubmitListener());
        
        viewPenitipan.setVisible(true);
        viewPenitipan.setLocationRelativeTo(null);
        viewPenitipan.setTitle("Menu Penitipan");
    }
    
    private DefaultComboBoxModel<String> getDaftarPelanggan() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        try {
            Database db = new Database();
            String sql = "SELECT * FROM pelanggan";
            ResultSet rs = db.getData(sql);
            while(rs.next()) {
                String pelangganWithId = rs.getString("nama") + "-" + rs.getString("id");
                cbm.addElement(pelangganWithId);
            }
        } catch (Exception e) {
            viewPenitipan.DisplayMessage(e.getMessage());
        }
        return cbm;
    }
    
    private DefaultComboBoxModel getDaftarHewanPeliharaanPertama() {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel();
         try {
             int idPelanggan = viewPenitipan.getIdPelanggan();
             Database db = new Database();
             String sql = "SELECT * FROM hewan_peliharaan"
                     + " WHERE id_pelanggan = " + idPelanggan + ";";
             ResultSet rs = db.getData(sql);
             while(rs.next()) {
                 String hewan = rs.getString("nama") + "-" + rs.getInt("id")  + "-" + rs.getString("jenis_hewan");
                 cbm.addElement(hewan);
             }
         } catch (Exception e) {
             viewPenitipan.DisplayMessage(e.getMessage());
         }
         return cbm;
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda beranda = new CtrlBeranda();
            viewPenitipan.dispose();
        }
    }
    
    class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                //Cari Pelanggan
                Database db = new Database();
                String sql = "SELECT * FROM pelanggan WHERE id = " + viewPenitipan.getIdPelanggan();
                ResultSet rs = db.getData(sql);
                Pelanggan pelanggan = null;
                while(rs.next()) {
                    pelanggan = new Pelanggan(rs.getInt("id"),rs.getString("nama") ,rs.getString("nomorTelepon"), rs.getString("alamat"));
                }
                
                //Cari HewanPeliharaan
                sql = "SELECT * FROM hewan_peliharaan WHERE id = " + viewPenitipan.getIdHewan();
                rs = db.getData(sql);
                HewanPeliharaan hewanPeliharaan = null;
                while(rs.next()) {
                    if (rs.getString("jenis_hewan").equals("Kucing")) {
                        hewanPeliharaan = new Kucing(rs.getInt("id"), rs.getInt("usia"), rs.getString("nama"),
                            rs.getString("jenis_kelamin"), pelanggan);
                    } else {
                        hewanPeliharaan = new Anjing(rs.getInt("id"), rs.getInt("usia"), rs.getString("nama"),
                            rs.getString("jenis_kelamin"), pelanggan);
                    }   
                }
                
                CtrlTagihanPenitipan tagihanGrooming = new CtrlTagihanPenitipan();
                tagihanGrooming.setPenitipanModel(hewanPeliharaan, (viewPenitipan.getLamaPenitipan()));
                viewPenitipan.dispose();
            } catch (Exception e) {
                viewPenitipan.DisplayMessage(e.getMessage());
            }
        }
    }
    
}
