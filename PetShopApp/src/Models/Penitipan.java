/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author bagas
 */
public class Penitipan {
    private String nama;
    private Pelanggan pelanggan;
    private HewanPeliharaan hewan;

    public Penitipan(String nama, Pelanggan pelanggan, HewanPeliharaan hewan) {
        this.nama = nama;
        this.pelanggan = pelanggan;
        this.hewan = hewan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void setHewan(HewanPeliharaan hewan) {
        this.hewan = hewan;
    }

    public String getNama() {
        return nama;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public HewanPeliharaan getHewan() {
        return hewan;
    }
}
