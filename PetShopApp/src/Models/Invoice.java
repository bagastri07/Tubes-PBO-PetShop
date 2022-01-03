/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Farrel
 */
public class Invoice {
    private String noInvoice;
    private Layanan layanan;
    private Date tanggalTransaksi;

    public Invoice(Layanan layanan ) {
        this.layanan = layanan;
        this.noInvoice = generateInvoice(layanan);
        this.tanggalTransaksi = new Date();
    }
    
    private static String generateInvoice(Layanan layanan) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HHmmss");  
        Date date = new Date();  
        
        String kodeLayanan = "";
        if (layanan instanceof Grooming) {
            String jenisLayanan = layanan.getJenisLayanan();
            if (jenisLayanan.equals("Memandikan Hewan")) {
                kodeLayanan = "GR01";
            } else if (jenisLayanan.equals("Membersihkan Kutu")) {
                kodeLayanan = "GR02";
            } else {
                kodeLayanan = "GR03";
            }
        } else {
            kodeLayanan = "PH";
        }
        
        return String.format("INV-%s-%s", kodeLayanan, formatter.format(date));
    }

    public String getNoInvoice() {
        return noInvoice;
    }

    public void setNoInvoice(String noInvoice) {
        this.noInvoice = noInvoice;
    }

    public Layanan getLayanan() {
        return layanan;
    }

    public void setLayanan(Layanan layanan) {
        this.layanan = layanan;
    }

    public String getTanggalTransaksi() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(tanggalTransaksi);
    }

    public void setTanggalTransaksi(Date tanggal_pembelian) {
        this.tanggalTransaksi = tanggal_pembelian;
    }
    
    
}
