/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Yoga
 */
public class Pemesanan implements MetodePembayaran{
    private String nama;
    private Pelanggan pelanggan;

    public Pemesanan(String nama, Pelanggan pelanggan) {
        this.nama = nama;
        this.pelanggan = pelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }
    
    @Override
    public void bayarDgnGopay() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void bayarDgnTunai() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
