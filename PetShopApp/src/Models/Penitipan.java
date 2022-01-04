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
public class Penitipan extends Layanan{
    private int lamaPenitipan;

    public Penitipan(HewanPeliharaan hewan, int lamaPenitipan) {
        super(hewan);
        this.lamaPenitipan = lamaPenitipan;
    }

    public int getLamaPenitipan() {
        return lamaPenitipan;
    }

    public void setLamaPenitipan(int lamaPenitipan) {
        this.lamaPenitipan = lamaPenitipan;
    }

    @Override
    public String getJenisLayanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float menghitungBiaya() {
        float biaya = 20000;
        if (lamaPenitipan <= 3) {
            biaya = 30000;
        } else if (lamaPenitipan <= 8) {
            biaya = 25000;
        }
        return lamaPenitipan * biaya;
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
