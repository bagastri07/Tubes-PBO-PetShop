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
public class HewanPeliharaan {
    private int id, usia;
    private String nama, jenisKelamin;
    private Pelanggan pemilik;

    public HewanPeliharaan(int id, int usia, String nama, String jenisKelamin, Pelanggan pemilik) {
        this.id = id;
        this.usia = usia;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.pemilik = pemilik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Pelanggan getPemilik() {
        return pemilik;
    }

    public void setPemilik(Pelanggan pemilik) {
        this.pemilik = pemilik;
    }
    
    
}
