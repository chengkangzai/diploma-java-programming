/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import MyLogger.PurchaseLog;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class adminPanel extends javax.swing.JFrame {
    DefaultTableModel model;
    public static final String FILENAME = "stock.csv";
    final static Path dbPath = Paths.get(FILENAME);

    /**
     * Creates new form adminPanel
     */

    private void initializedTable() {
        model = (DefaultTableModel) StockTable.getModel();
        String[] data = DB.returnAll();
        for (int i = 1; i < data.length; i++) {
            String id = String.valueOf(i);
            model.insertRow(model.getRowCount(), new Object[] { id, DB.getStockNameByID(id), DB.getStockPriceByID(id),
                    DB.getStockByID(id), DB.getStockAvailabilityByID(id), DB.getStockImageByID(id) });
        }
    }

    public adminPanel() {
        initComponents();
        initializedTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        StockTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnUpdatePassword = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setTitle("Admin Panel for Vending mAchineeee");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1180, 670));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Stock", "AVAILABILITY(T/F)", "Img Path"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(StockTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1000, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Current Stock Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        btnUpdatePassword.setText("Update  Password");
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdatePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 150, 50));

        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, 100, 50));

        btnGoBack.setText("Go Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 130, 100, 50));

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 60, 100, 50));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 47));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment/asset/pic/temp/bg.jpg"))); // NOI18N
        bg.setText("jLabel1");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        GUI_Class.showMessageBox("How to update the stock\n\n 1. select the row where the slot need update \n 2. Double click the field that need update. \n 3. Single Click outside of the row. \n 4. Click \"Update\"Button. ");
        GUI_Class.showMessageBox("How to change the password\n\n 1. Click the \"Update Password Button\" \n 2. Type in the new password and hit enter. \n\n ***** We strongly encourage you change the default password. *****");
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {
        char[] password = GUI_Class.showPasswordBox();
        if (GUI_Class.passwordMatching(new String(password)) == 1) {
            GUI_Class.showMessageBox("You cannot Change to the same Password ! ");
        } else {
            if (DB.updatePassword(new String(password)) == 0) {
                GUI_Class.showMessageBox("Password changed !");
                GUI_Class.showGUI();
                dispose();
            }
        }

    }

    private void loggingStock() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String data = model.getValueAt(i, 0).toString();
            PurchaseLog pl = new PurchaseLog(data);
            pl.log();
        }
    }

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {
        GUI_Class.showGUI();
        dispose();
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        List<String> numData = new ArrayList<String>();
        String[] value = DB.returnAll();
        String data = value[0] + "\n";
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount() - 1; j++) {
                numData.add(model.getValueAt(0, j).toString());
                data += model.getValueAt(i, j).toString() + ",";
                if (j == 4) {
                    data += model.getValueAt(i, 5).toString() + "\n";
                }
            }
        }
        int status = DB.deleteAndWriteAgain(data);
        if (status == 0) {
            loggingStock();
            GUI_Class.showMessageBox("Successfully Update the database !!");
        } else {
            GUI_Class.showMessageBox("Something Wrong is happening ");
        }
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        GUI_Class.exitSoftware();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StockTable;
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
