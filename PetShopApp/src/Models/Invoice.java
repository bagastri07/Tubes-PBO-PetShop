/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Farrel
 */
public class Invoice {
    private String nama;
    private Pemesanan pemesanan;
    private Pelanggan pelanggan;

    public Invoice(String nama, Pemesanan pemesanan, Pelanggan pelanggan) {
        this.nama = nama;
        this.pemesanan = pemesanan;
        this.pelanggan = pelanggan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPemesanan(Pemesanan pemesanan) {
        this.pemesanan = pemesanan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public String getNama() {
        return nama;
    }

    public Pemesanan getPemesanan() {
        return pemesanan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }
    
    
}
