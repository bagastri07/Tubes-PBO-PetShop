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
public abstract class Layanan implements Biaya, MetodePembayaran{
    private HewanPeliharaan hewan;

    public Layanan(HewanPeliharaan hewan) {
        this.hewan = hewan;
    }

    public HewanPeliharaan getHewan() {
        return hewan;
    }

    public void setHewan(HewanPeliharaan hewan) {
        this.hewan = hewan;
    }
    
    public abstract String getJenisLayanan();
    
    public abstract int getLamaPenitipan();

    @Override
    public abstract float menghitungBiaya();

    @Override
    public abstract float MembayarDenganGopay();

    @Override
    public abstract float MembayarDenganTunai();
    
    
}
