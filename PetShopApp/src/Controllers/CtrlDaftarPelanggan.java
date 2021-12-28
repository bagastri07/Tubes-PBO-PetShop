/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Models.Pelanggan;
import Views.ViewDaftarPelanggan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author bagas
 */
public class CtrlDaftarPelanggan {
    private ViewDaftarPelanggan viewDaftarPelanggan;
    private ArrayList<Pelanggan> listPelanggan = new ArrayList<>();

    public CtrlDaftarPelanggan() {
        viewDaftarPelanggan = new ViewDaftarPelanggan();
        
        //Add Listener
        viewDaftarPelanggan.addActionKembali(new KembaliListener());
        viewDaftarPelanggan.addMouseListPegawai(new DetailPelangganMouseAdapter());
        viewDaftarPelanggan.addPelangganList(getDaftarPelanggan());
        viewDaftarPelanggan.addActionHapusPelanggan(new HapusPelangganListener());
        
        viewDaftarPelanggan.setVisible(true);
        viewDaftarPelanggan.setLocationRelativeTo(null);
        viewDaftarPelanggan.setTitle("Daftar Pelanggan");
    }
    
    private DefaultListModel getDaftarPelanggan() {
        DefaultListModel<String> dlm = new DefaultListModel<>();
        try {
            Database db = new Database();
            String sql = "SELECT * FROM pelanggan";
            ResultSet rs = db.getData(sql);
            while(rs.next()) {
                listPelanggan.add(new Pelanggan(rs.getInt("id"),rs.getString("nama") ,rs.getString("nomorTelepon"), rs.getString("alamat")));
            }
            
            
            for(Pelanggan e : listPelanggan) {
                dlm.addElement(e.getNama());
            }
        } catch (Exception e) {
            viewDaftarPelanggan.DipslayError("Database Error");
        }
        return dlm;
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlMenuPelanggan menuPelanngan = new CtrlMenuPelanggan();
            viewDaftarPelanggan.dispose();
        }   
    }
    
    class HapusPelangganListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            JList listPegawai = viewDaftarPelanggan.getListPelanggan();
            if (listPegawai.isSelectionEmpty()) {
                viewDaftarPelanggan.DipslayMessage("Anda Belum Memilih Pelanggan");
            } else {
                int idPegawai = 0;
                for(Pelanggan e : listPelanggan) {
                    if (e.getNama() == listPegawai.getSelectedValue()) {
                        idPegawai = e.getId();
                    }
                }

                try {
                    Database db = new Database();
                    String sql = "DELETE FROM pelanggan WHERE id = " + idPegawai;
                    db.query(sql);
                } catch (Exception e) {

                }
                viewDaftarPelanggan.DipslayMessage("Pelanggan dengan id " + idPegawai + "berhasil dihapus");
                CtrlMenuPelanggan menuPelanngan = new CtrlMenuPelanggan();
                viewDaftarPelanggan.dispose();
            }
            
        }
    }
    
    class DetailPelangganMouseAdapter extends MouseAdapter{
        @Override
        public void mouseClicked(java.awt.event.MouseEvent me){
            JList listPegawai = viewDaftarPelanggan.getListPelanggan();
            for(Pelanggan e : listPelanggan) {
                if (e.getNama() == listPegawai.getSelectedValue()) {
                    viewDaftarPelanggan.setLabelNama(e.getNama());
                    viewDaftarPelanggan.setLabelNomorTelp(e.getNomorTelepon());
                    viewDaftarPelanggan.setLabelAlamat(e.getAlamat());
                }
            }
        }
    }    
}
