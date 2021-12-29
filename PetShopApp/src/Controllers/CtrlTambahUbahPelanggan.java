/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Views.ViewTambahUbahPelanggan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 *
 * @author bagas
 */
public class CtrlTambahUbahPelanggan {
    private ViewTambahUbahPelanggan viewTambahUbah;

    public CtrlTambahUbahPelanggan() {
        viewTambahUbah = new ViewTambahUbahPelanggan();
        
        viewTambahUbah.addActionSubmit(new SubmitPelangganBaruListener());
        
        viewTambahUbah.setVisible(true);
        viewTambahUbah.setLocationRelativeTo(null);
    }
    
    public void setJudulPanel(String judul) {
        viewTambahUbah.setLabelJudul(judul);
        viewTambahUbah.setTitle(judul);
    }
    
    public void SetDataUbahPelanggan(String id, String nama, String noTelepon, String alamat) {
        viewTambahUbah.setLabelIdPelanggan("ID: " + id);
        viewTambahUbah.setFieldNamaPelanggan(nama);
        viewTambahUbah.setFielNomorTeleponPelanggan(noTelepon);
        viewTambahUbah.setFieldAlamatPelanggan(alamat);
    }
    
    class SubmitPelangganBaruListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            //getData Pelanggan
            String nama = viewTambahUbah.getFieldNamaPelanggan();  
            String nomorTelepon = viewTambahUbah.getFieldNoTeleponPelanggan();
            String alamat = viewTambahUbah.getFieldAlamatPelanggan();
            try {
                Database db = new Database();
                String SQL;
                if (viewTambahUbah.getLabelJudul() == "Tambah Pelanggan") {
                    SQL = String.format("INSERT INTO `pelanggan` (`id`, `nama`, `nomorTelepon`, `alamat`)"
                        + "VALUES (NULL, '%s', '%s', '%s') ", nama, nomorTelepon, alamat);
                    db.query(SQL);
                    viewTambahUbah.DipslayMessage(nama + " Berhasil ditambahkan");
                    CtrlMenuPelanggan menuPelanngan = new CtrlMenuPelanggan();
                    viewTambahUbah.dispose();
                } else {
                    
                }
            } catch (Exception e) {
                viewTambahUbah.DipslayMessage(e.getMessage());
            }
            
        }
    }
    
    class SubmitUbahDataPelanggan implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
