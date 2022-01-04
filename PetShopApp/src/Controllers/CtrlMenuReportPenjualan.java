/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Views.ViewMenuReportPenjualan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bagas
 */
public class CtrlMenuReportPenjualan {
    private ViewMenuReportPenjualan viewReport;

    public CtrlMenuReportPenjualan() {
        viewReport = new ViewMenuReportPenjualan();
        
        viewReport.addActionKembali(new KembaliListener());
        viewReport.setTabelGrooming(getTabelGrooming());
        viewReport.setTabelPenitipan(getTabelPenitipan());
        viewReport.setPendapatanGrooming(getPendapatanGrooming());
        viewReport.setPendapatanPenitipan(getPendapatanPenitipan());
        viewReport.setPendapatanMemandikanHewan(getPendapatanMemandikanHewan());
        viewReport.setPendaptanMemotongKuku(getPendapatanMemotongKuku());
        viewReport.setPendapatanMembersihkanKutu(getPendapatanMembersihkanKutu());
        
        viewReport.setVisible(true);
        viewReport.setLocationRelativeTo(null);
        viewReport.setTitle("Menu Report Penjualan");
    }
    
    private String getPendapatanGrooming() {
        String jumlahPendapatanGrooming = null;
        try {
            Database db = new Database();
            String sql = "SELECT SUM(total_biaya) AS total FROM `invoice` WHERE no_invoice REGEXP \"GR\"";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                jumlahPendapatanGrooming = rs.getString("total");
            }
        } catch (Exception e) {
            viewReport.DisplayMessage(e.getMessage());
        }
        return jumlahPendapatanGrooming;
    }
    
    private String getPendapatanPenitipan() {
        String jumlahPendapatanPenitipan = null;
        try {
            Database db = new Database();
            String sql = "SELECT SUM(total_biaya) AS total FROM `invoice` WHERE no_invoice REGEXP \"PH\"";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                jumlahPendapatanPenitipan = rs.getString("total");
            }
        } catch (Exception e) {
            viewReport.DisplayMessage(e.getMessage());
        }
        return jumlahPendapatanPenitipan;
    }
    
    private String getPendapatanMemandikanHewan() {
        String jumlahPendapatanMemandikanHewan = null;
        try {
            Database db = new Database();
            String sql = "SELECT SUM(total_biaya) AS total FROM `invoice` WHERE no_invoice REGEXP \"GR01\"";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                jumlahPendapatanMemandikanHewan = rs.getString("total");
            }
        } catch (Exception e) {
            viewReport.DisplayMessage(e.getMessage());
        }
        return jumlahPendapatanMemandikanHewan;
    }
    
    private String getPendapatanMembersihkanKutu() {
        String jumlahPendapatanMembersihkanKuku = null;
        try {
            Database db = new Database();
            String sql = "SELECT SUM(total_biaya) AS total FROM `invoice` WHERE no_invoice REGEXP \"GR02\"";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                jumlahPendapatanMembersihkanKuku = rs.getString("total");
            }
        } catch (Exception e) {
            viewReport.DisplayMessage(e.getMessage());
        }
        return jumlahPendapatanMembersihkanKuku;
    }
    
    private String getPendapatanMemotongKuku() {
        String jumlahPendapatanMemotongKuku = null;
        try {
            Database db = new Database();
            String sql = "SELECT SUM(total_biaya) AS total FROM `invoice` WHERE no_invoice REGEXP \"GR03\"";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                jumlahPendapatanMemotongKuku = rs.getString("total");
            }
        } catch (Exception e) {
            viewReport.DisplayMessage(e.getMessage());
        }
        return jumlahPendapatanMemotongKuku;
    }
    
    private DefaultTableModel getTabelGrooming() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("No Invoice");
        tm.addColumn("Pelanggan");
        tm.addColumn("Hewan");
        tm.addColumn("Jenis Hewan");
        tm.addColumn("Layanan");
        tm.addColumn("Pembayaran");
        tm.addColumn("Total");
        try {
            Database db = new Database();
            String sql = "SELECT invoice.no_invoice, pelanggan.nama AS n_pelanggan, "
                    + "hewan_peliharaan.nama AS n_hewan, hewan_peliharaan.jenis_hewan, invoice.jenis_layanan, "
                    + "invoice.metode_pembayaran, invoice.total_biaya\n FROM invoice\n"
                    + "INNER JOIN hewan_peliharaan ON hewan_peliharaan.id=invoice.id_hewan\n"
                    + "INNER JOIN pelanggan ON pelanggan.id=invoice.id_pelanggan\n"
                    + "WHERE invoice.no_invoice REGEXP \"GR\";";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                String[] arr = rs.getString("jenis_layanan").split("-");
                String layanan = arr[1];
                
                tm.addRow(new Object[]{rs.getString("no_invoice"), rs.getString("n_pelanggan"), 
                rs.getString("n_hewan"), rs.getString("jenis_hewan"), layanan, rs.getString("metode_pembayaran"), 
                rs.getString("total_biaya")});
            }
        } catch (Exception e) {
            viewReport.DisplayMessage(e.getMessage());
        }
        return tm;
    }
    
    private DefaultTableModel getTabelPenitipan() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("No Invoice");
        tm.addColumn("Pelanggan");
        tm.addColumn("Hewan");
        tm.addColumn("Jenis Hewan");
        tm.addColumn("Lama Penitipan");
        tm.addColumn("Pembayaran");
        tm.addColumn("Total");
        try {
            Database db = new Database();
            String sql = "SELECT invoice.no_invoice, pelanggan.nama AS n_pelanggan, "
                    + "hewan_peliharaan.nama AS n_hewan, hewan_peliharaan.jenis_hewan, invoice.jenis_layanan, "
                    + "invoice.metode_pembayaran, invoice.total_biaya\n FROM invoice\n"
                    + "INNER JOIN hewan_peliharaan ON hewan_peliharaan.id=invoice.id_hewan\n"
                    + "INNER JOIN pelanggan ON pelanggan.id=invoice.id_pelanggan\n"
                    + "WHERE invoice.no_invoice REGEXP \"PH\";";
            ResultSet rs = db.getData(sql);
            while (rs.next()) {
                String[] arr = rs.getString("jenis_layanan").split("-");
                String layanan = arr[1];
                
                tm.addRow(new Object[]{rs.getString("no_invoice"), rs.getString("n_pelanggan"), 
                rs.getString("n_hewan"), rs.getString("jenis_hewan"), layanan, rs.getString("metode_pembayaran"), 
                rs.getString("total_biaya")});
            }
        } catch (Exception e) {
            viewReport.DisplayMessage(e.getMessage());
        }
        return tm;
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda beranda = new CtrlBeranda();
            viewReport.dispose();
        }
    }
    
    
}
