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
public class Pelanggan {
    private int id;
    private String nama, nomorTelepon, alamat;

    public Pelanggan(int id, String nama, String nomorTelepon, String alamat) {
        this.id = id;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.alamat = alamat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) throws Exception{
        if (nama == "") {
            throw new Exception() {
                @Override
                public String getMessage() {
                    return "Tidak Boleh Kosong";
                }
            };
        }
        this.nama = nama;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getAlamat() {
        return alamat;
    }
}
