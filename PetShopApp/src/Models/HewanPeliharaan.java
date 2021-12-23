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
    private String nama, jenisKelamin;
    private int Umur;

    public HewanPeliharaan(String nama, String jenisKelamin, int Umur) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.Umur = Umur;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setUmur(int Umur) {
        this.Umur = Umur;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public int getUmur() {
        return Umur;
    }
    
    
}
