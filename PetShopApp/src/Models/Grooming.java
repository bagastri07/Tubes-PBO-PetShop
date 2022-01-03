/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.Biaya;
import Interfaces.MetodePembayaran;

/**
 *
 * @author bagas
 */
public class Grooming extends Layanan{
    private String layanan;

    public Grooming(HewanPeliharaan hewanPeliharaan, String layanan) {
        super(hewanPeliharaan);
        this.layanan = layanan;
    }

    public String getJenisLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    @Override
    public float menghitungBiaya() {
        // Biaya Tambahan untuk Hewan Jenis Anjing
        float biayaTambahan = 0;
        if (super.getHewan() instanceof Anjing) {
            biayaTambahan = 15000;
        }
        
        if (layanan.equals("Memandikan Hewan")) {
            return 50000 + biayaTambahan;
        } else if (layanan.equals("Membersihkan Kutu")) {
            return 70000 + biayaTambahan;
        } else {
            return 30000 + biayaTambahan;
        }
    }

    @Override
    public float MembayarDenganGopay() {
        // diskon Gopay 10%
        float biaya = menghitungBiaya();
        float diskon = biaya * 10 / 100;
        return biaya - diskon;
    }

    @Override
    public float MembayarDenganTunai() {
        //Tunai ga ada diskon
        float biaya = menghitungBiaya();
        return biaya;
    }



}
