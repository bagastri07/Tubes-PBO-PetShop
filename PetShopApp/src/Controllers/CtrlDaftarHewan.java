/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewDaftarHewan;

/**
 *
 * @author bagas
 */
public class CtrlDaftarHewan {
    private ViewDaftarHewan viewDaftarHewan;

    public CtrlDaftarHewan() {
        viewDaftarHewan = new ViewDaftarHewan();
        
        viewDaftarHewan.setVisible(true);
        viewDaftarHewan.setLocationRelativeTo(null);
        viewDaftarHewan.setTitle("Menu Daftar Hewan");
    }
    
    
}
