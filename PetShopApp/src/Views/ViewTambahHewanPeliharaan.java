/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Exeptions.EmptyExeption;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Farrel
 */
public class ViewTambahHewanPeliharaan extends javax.swing.JFrame {

    /**
     * Creates new form ViewCheckIn
     */
    public ViewTambahHewanPeliharaan() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupJenisKelamin = new javax.swing.ButtonGroup();
        btnGroupJenisHewan = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldUsiaHewan = new javax.swing.JTextField();
        fieldNamaHewan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        radioButtonJantan = new javax.swing.JRadioButton();
        radioButtonBetina = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        dropDownNamaPelanggan = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JToggleButton();
        btnKembali = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        radioButtonAnjing = new javax.swing.JRadioButton();
        radioButtonKucing = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tambah Hewan Peliharaan");

        jLabel2.setText("Nama Hewan");

        jLabel6.setText("Jenis Kelamin");

        jLabel8.setText("Usia");

        jLabel9.setText("Bulan");

        btnGroupJenisKelamin.add(radioButtonJantan);
        radioButtonJantan.setSelected(true);
        radioButtonJantan.setText("Jantan");

        btnGroupJenisKelamin.add(radioButtonBetina);
        radioButtonBetina.setText("Betina");

        jLabel3.setText("Nama Pelanggan");

        dropDownNamaPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSubmit.setText("Submit");

        btnKembali.setText("Kembali");

        jLabel7.setText("Jenis Hewan");

        btnGroupJenisHewan.add(radioButtonAnjing);
        radioButtonAnjing.setText("Anjing");

        btnGroupJenisHewan.add(radioButtonKucing);
        radioButtonKucing.setSelected(true);
        radioButtonKucing.setText("Kucing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(24, 24, 24))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldNamaHewan, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(radioButtonJantan)
                                    .addGap(18, 18, 18)
                                    .addComponent(radioButtonBetina))
                                .addComponent(dropDownNamaPelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSubmit)
                                .addGap(18, 18, 18)
                                .addComponent(btnKembali))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldUsiaHewan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioButtonKucing)
                                .addGap(18, 18, 18)
                                .addComponent(radioButtonAnjing)))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dropDownNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fieldNamaHewan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(radioButtonJantan)
                    .addComponent(radioButtonBetina))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radioButtonAnjing)
                    .addComponent(radioButtonKucing))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldUsiaHewan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnKembali))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewTambahHewanPeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTambahHewanPeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTambahHewanPeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTambahHewanPeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTambahHewanPeliharaan().setVisible(true);
            }
        });
    }
    
    public void addActionKembali(ActionListener listener) {
        btnKembali.addActionListener(listener);
    }
    
    public void addActionSubmit(ActionListener listener) {
        btnSubmit.addActionListener(listener);
    }
    
    public void setPelangganDropDown(ComboBoxModel cbm){
        dropDownNamaPelanggan.setModel(cbm);
    }
    
    public void DisplayMessage(String S) {
        JOptionPane.showMessageDialog(this, S);
    }
    
    public int getIdPelanggan() {
        String temp = (String) dropDownNamaPelanggan.getSelectedItem();
        String[] arrTemp = temp.split("-");
        int idPelanggan = Integer.parseInt(arrTemp[1]);
        return idPelanggan;
    }
    
    public String getNamaHewanPeliharaan() throws EmptyExeption{
        if ("".equals(fieldNamaHewan.getText())) {
            throw new EmptyExeption();
        }
        return fieldNamaHewan.getText();
    }
    
    public int getUsiaHewanPeliharaan() throws EmptyExeption{
        if ("".equals(fieldUsiaHewan.getText())) {
            throw new EmptyExeption();
        }
        return Integer.parseInt(fieldUsiaHewan.getText());
    }
    
    public String getJenisHewanPeliharaan() {
        if (radioButtonAnjing.isSelected()) {
            return "Anjing";
        } else {
            return "Kucing";
        }
    }
    
    public String getJenisKelaminHewanPeliharaan() {
        if (radioButtonJantan.isSelected()) {
            return "Jantan";
        } else {
            return  "Betina";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupJenisHewan;
    private javax.swing.ButtonGroup btnGroupJenisKelamin;
    private javax.swing.JButton btnKembali;
    private javax.swing.JToggleButton btnSubmit;
    private javax.swing.JComboBox<String> dropDownNamaPelanggan;
    private javax.swing.JTextField fieldNamaHewan;
    private javax.swing.JTextField fieldUsiaHewan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton radioButtonAnjing;
    private javax.swing.JRadioButton radioButtonBetina;
    private javax.swing.JRadioButton radioButtonJantan;
    private javax.swing.JRadioButton radioButtonKucing;
    // End of variables declaration//GEN-END:variables
}
