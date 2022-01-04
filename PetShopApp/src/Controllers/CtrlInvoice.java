/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Models.Grooming;
import Models.Invoice;
import Models.Kucing;
import Models.Layanan;
import Views.ViewInvoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 *
 * @author Farrel
 */
public class CtrlInvoice {
    private ViewInvoice viewInvoice;
    private Invoice invoice;

    public CtrlInvoice() {
        viewInvoice = new ViewInvoice();
        
        viewInvoice.addActionSelesai(new SelesaiListener());
        
        viewInvoice.setVisible(true);
        viewInvoice.setLocationRelativeTo(null);
        viewInvoice.setTitle("Tagihan Grooming");        
    }
    
    public  void setLayananModel(Layanan layanan, String metodePembayaran) {
        invoice = new Invoice(layanan);
        
        viewInvoice.setNamaPemilik(invoice.getLayanan().getHewan().getPemilik().getNama());
        viewInvoice.setNamaHewan(invoice.getLayanan().getHewan().getNama());
        viewInvoice.setJenisHewan(invoice.getLayanan().getHewan());
        if (layanan instanceof Grooming) {
            viewInvoice.setLayanan("Grooming-"+invoice.getLayanan().getJenisLayanan());
        } else {
            viewInvoice.setLayanan("Penitipan-"+invoice.getLayanan().getLamaPenitipan()+" Hari");
        }
        viewInvoice.setMetodePembayaran(metodePembayaran);
        viewInvoice.setBiaya(invoice.getLayanan().menghitungBiaya());
        if (metodePembayaran.equals("Gopay")) {
            float diskon = invoice.getLayanan().menghitungBiaya() - invoice.getLayanan().MembayarDenganGopay();
            viewInvoice.setTotalBiaya(invoice.getLayanan().MembayarDenganGopay());
            viewInvoice.setDiskon(diskon);
        } else {
            viewInvoice.setTotalBiaya(invoice.getLayanan().MembayarDenganTunai());
            viewInvoice.setDiskon(0);
        }
        viewInvoice.setNoInvoice(invoice.getNoInvoice());
        viewInvoice.setTanggalTransaksi(invoice.getTanggalTransaksi());
    }
    
    class SelesaiListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String noInvoice = invoice.getNoInvoice();
                int idPelanggan = invoice.getLayanan().getHewan().getPemilik().getId();
                int idHewan = invoice.getLayanan().getHewan().getId();
                String jenisLayanan = null;
                if (invoice.getLayanan() instanceof Grooming) {
                    jenisLayanan = "Grooming-"+invoice.getLayanan().getJenisLayanan();
                } else {
                    jenisLayanan = "Penitipan-"+invoice.getLayanan().getLamaPenitipan()+" Hari";
                }
                String metodePembayaran = viewInvoice.getMetodePembayaran();
                String tanggalTransaksi = viewInvoice.getTanggalTransaksi();
                float biaya = invoice.getLayanan().menghitungBiaya();
                float diskon = 0;
                float biayaTotal = 0;
                if (metodePembayaran.equals("Gopay")) {
                    diskon = invoice.getLayanan().menghitungBiaya() - invoice.getLayanan().MembayarDenganGopay();
                    biayaTotal = invoice.getLayanan().MembayarDenganGopay();
                } else {
                    biayaTotal = invoice.getLayanan().MembayarDenganTunai();
                }
                
                Database db = new Database();
                String sql = String.format(Locale.US, "INSERT INTO `invoice` (`no_invoice`, `id_pelanggan`, `id_hewan`, `jenis_layanan`, "
                        + "`metode_pembayaran`, `tanggal_transaksi`, `biaya_layanan`, `diskon`, `total_biaya`) "
                        + "VALUES ('%s', '%d', '%d', '%s', '%s', '%s', '%.2f', '%.2f', '%.2f') ",
                        noInvoice, idPelanggan, idHewan, jenisLayanan, metodePembayaran, tanggalTransaksi
                , biaya, diskon, biayaTotal);
                db.query(sql);
                
                viewInvoice.DisplayMessage("Pembayaran Selesai");
                CtrlBeranda beranda = new CtrlBeranda();
                viewInvoice.dispose();
            } catch (Exception ex) {
                viewInvoice.DisplayMessage(ex.getMessage());
            }
        }        
    }
}
