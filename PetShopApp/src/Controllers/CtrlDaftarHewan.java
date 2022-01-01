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
import Views.ViewDaftarHewan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author bagas
 */
public class CtrlDaftarHewan {
    private ViewDaftarHewan viewDaftarHewan;
    private ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
    private ArrayList<HewanPeliharaan> listHewanPeliharaan = new ArrayList<>();

    public CtrlDaftarHewan() {
        viewDaftarHewan = new ViewDaftarHewan();
        
        viewDaftarHewan.addActionKembali(new KembaliListener());
        viewDaftarHewan.addActionTambahHewanPeliharaan(new TambahHewanPeliharaanListener());
        viewDaftarHewan.setHewanList(LoadHewanPeliharaanDropDown());
        viewDaftarHewan.addMouseListHewanPeliharaan(new DetailHewanPeliharaanMouseAdapter());
        viewDaftarHewan.addActionHapusHewanPeliharaan(new HapusHewanPeliharaan());
        
        viewDaftarHewan.setVisible(true);
        viewDaftarHewan.setLocationRelativeTo(null);
        viewDaftarHewan.setTitle("Menu Daftar Hewan");
        
        loadtDaftarPelangganDatabase();
    }
    
    private void loadtDaftarPelangganDatabase() {
        try {
            Database db = new Database();
            String sql = "SELECT * FROM pelanggan";
            ResultSet rs = db.getData(sql);
            while(rs.next()) {
                listPelanggan.add(new Pelanggan(rs.getInt("id"),rs.getString("nama") ,rs.getString("nomorTelepon"), rs.getString("alamat")));
            }
            
        } catch (Exception e) {
            viewDaftarHewan.DipslayMessage(e.getMessage());
        }
    }
    
    private DefaultListModel LoadHewanPeliharaanDropDown() {
        loadtDaftarPelangganDatabase();
        DefaultListModel<String> dlm = new DefaultListModel<>();
        try {
            Database db = new Database();
            String sql = "SELECT * FROM hewan_peliharaan";
            ResultSet rs = db.getData(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String jenisKelamin = rs.getString("jenis_kelamin");
                int usia = rs.getInt("usia");
                String jenisHewan = rs.getString("jenis_hewan");
                int idPelanggan = rs.getInt("id_pelanggan");
                Pelanggan pemilik = null;
                
                //Searching Pelanggan
                for (Pelanggan e : listPelanggan) {
                    if (e.getId() == idPelanggan) {
                        pemilik = e;
                    }
                }
                
                // Menentukan jenis Hewan
                if ("Anjing".equals(jenisHewan)) {
                    listHewanPeliharaan.add(new Anjing(id, usia, nama, jenisKelamin, pemilik));
                } else if ("Kucing".equals(jenisHewan)) {
                    listHewanPeliharaan.add(new Kucing(id, usia, nama, jenisKelamin, pemilik));
                } 
            }
            //add to model view
            for (HewanPeliharaan e : listHewanPeliharaan) {
                dlm.addElement(e.getNama()+"-"+e.getId());
            }
        } catch (Exception e) {
            viewDaftarHewan.DipslayMessage(e.getMessage());
        }
        return dlm;
    }

    public ArrayList<Pelanggan> getListPelanggan() {
        return listPelanggan;
    }
    
    class DetailHewanPeliharaanMouseAdapter extends MouseAdapter{
        @Override
        public void mouseClicked(java.awt.event.MouseEvent me){
            JList listHewan = viewDaftarHewan.getListHewan();
            for(HewanPeliharaan e : listHewanPeliharaan) {
                String namaDanId = e.getNama()+"-"+e.getId();
                if (namaDanId.equals(listHewan.getSelectedValue())) {
                    viewDaftarHewan.setNamaHewan(e.getNama());
                    viewDaftarHewan.setUsiaHewan(String.valueOf(e.getUsia())+" Bulan");
                    viewDaftarHewan.setJenisKelamin(e.getJenisKelamin());
                    viewDaftarHewan.setNamaPemilik(e.getPemilik().getNama());
                    if (e instanceof Kucing) {
                        viewDaftarHewan.setJenisHewan("Kucing");
                    } else if (e instanceof Anjing) {
                        viewDaftarHewan.setJenisHewan("Anjing");
                    }
                }
            }
        }
    }
    
    class HapusHewanPeliharaan implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            JList listHewan = viewDaftarHewan.getListHewan();
            String selectedHewan = (String) listHewan.getSelectedValue();
            String[] arrOfStr = selectedHewan.split("-");
            String idHewan = arrOfStr[1];
            try {
                Database db = new Database();
                
                String sql = "DELETE FROM hewan_peliharaan WHERE id = " + idHewan;
                db.query(sql);
                viewDaftarHewan.DipslayMessage("Hewan Peliharaan dengan id " + idHewan + " berhasil dihapus");
                CtrlDaftarHewan daftarHewan = new CtrlDaftarHewan();
                viewDaftarHewan.dispose();
            } catch (Exception e) {
            }
        }
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda beranda = new CtrlBeranda();
            viewDaftarHewan.dispose();
        }
    }
    
    class TambahHewanPeliharaanListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            CtrlTambahHewanPeliharaan tambahHewan = new CtrlTambahHewanPeliharaan();
            viewDaftarHewan.dispose();
        }
    }
}
