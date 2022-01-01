/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Models.Pelanggan;
import Views.ViewTambahHewanPeliharaan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author bagas
 */
public class CtrlTambahHewanPeliharaan {
    private ViewTambahHewanPeliharaan viewTambahHewan;
    private ArrayList<Pelanggan> listPelanggan = new ArrayList<>();

    public CtrlTambahHewanPeliharaan() {
        viewTambahHewan = new ViewTambahHewanPeliharaan();
        
        viewTambahHewan.addActionKembali(new KembaliListener());
        viewTambahHewan.setPelangganDropDown(loadPelangganDropDown());
        
        viewTambahHewan.setVisible(true);
        viewTambahHewan.setLocationRelativeTo(null);
        viewTambahHewan.setTitle("Tambah Hewan Peliharaan");
    }
    
    private DefaultComboBoxModel<String> loadPelangganDropDown() {
        DefaultComboBoxModel<String> cmb = new DefaultComboBoxModel<>();
        try {
            Database db = new Database();
            String sql = "SELECT * FROM pelanggan";
            ResultSet rs = db.getData(sql);
            while(rs.next()) {
                listPelanggan.add(new Pelanggan(rs.getInt("id"),rs.getString("nama") ,rs.getString("nomorTelepon"), rs.getString("alamat")));
            }
            
            
            for(Pelanggan e : listPelanggan) {
                cmb.addElement(e.getNama()+"-"+e.getId());
            }
        } catch (Exception e) {
            viewTambahHewan.DisplayMessage(e.getMessage());
        }
        return cmb;
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlDaftarHewan daftarHewan = new CtrlDaftarHewan();
            viewTambahHewan.dispose();
        }
    }
    
    
}
