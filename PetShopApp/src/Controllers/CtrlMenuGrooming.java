/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.Database;
import Models.Pelanggan;
import Views.ViewMenuGrooming;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author bagas
 */
public class CtrlMenuGrooming {
    private ViewMenuGrooming viewGrooming;

    public CtrlMenuGrooming() {
        viewGrooming = new ViewMenuGrooming();
//        
//        viewGrooming.addActionKembali(new KembaliListener());
//        viewGrooming.setPelangganDropDown(getDaftarPelanggan());
        
        viewGrooming.setVisible(true);
        viewGrooming.setLocationRelativeTo(null);
        viewGrooming.setTitle("Menu Grooming");
    }
    
    private DefaultComboBoxModel<String> getDaftarPelanggan() {
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel();
        try {
            Database db = new Database();
            String sql = "SELECT * FROM pelanggan";
            ResultSet rs = db.getData(sql);
            while(rs.next()) {
                String pelangganWithId = rs.getString("nama") + "-" + rs.getString("id");
                cbm.addElement(pelangganWithId);
            }
        } catch (Exception e) {
//            viewGrooming.DipslayMessage(e.getMessage());
        }
        return cbm;
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda menuPelanngan = new CtrlBeranda();
            viewGrooming.dispose();
        }   
    }
}
