/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewMenuReportPenjualan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bagas
 */
public class CtrlMenuReportPenjualan {
    private ViewMenuReportPenjualan viewReport;

    public CtrlMenuReportPenjualan() {
        viewReport = new ViewMenuReportPenjualan();
        
        viewReport.addActionKembali(new KembaliListener());
        
        viewReport.setVisible(true);
        viewReport.setLocationRelativeTo(null);
        viewReport.setTitle("Menu Report Penjualan");
    }
    
    class KembaliListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda beranda = new CtrlBeranda();
            viewReport.dispose();
        }
    }
}
