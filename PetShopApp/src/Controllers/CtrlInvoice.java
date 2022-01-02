/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.ViewInvoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Farrel
 */
public class CtrlInvoice {
    private ViewInvoice viewInvoice;

    public CtrlInvoice() {
        viewInvoice = new ViewInvoice();
        
        viewInvoice.setVisible(true);
        viewInvoice.setLocationRelativeTo(null);
        viewInvoice.setTitle("Tagihan Grooming");        
    }
    
    class SelesaiListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            CtrlBeranda beranda = new CtrlBeranda();
            viewInvoice.dispose();
        }        
    }
}
