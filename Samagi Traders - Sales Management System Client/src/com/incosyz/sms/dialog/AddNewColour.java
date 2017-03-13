/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dialog;

import com.incosyz.sms.clientcontroller.DeliveryNoteControllerClient;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Stelan
 */
public class AddNewColour extends javax.swing.JDialog {

    /**
     * Creates new form AddNewOption
     */
    public AddNewColour(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        try {
            ArrayList<String> colours = DeliveryNoteControllerClient.getColours();
            ListModel model = colourList.getModel();
            DefaultListModel listModel = new DefaultListModel();
            for (String colour : colours) {
                listModel.addElement(colour.toUpperCase());
            }
            colourList.setModel(listModel);
        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddNewColour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        colourText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        colourList = new javax.swing.JList();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Samagi Traders - Sales Management System");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Colours");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(30, 20, 320, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Sales Management System -> Manage Price Announcement");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(30, 50, 400, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Colour Name :");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(30, 140, 200, 30);

        colourText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colourTextActionPerformed(evt);
            }
        });
        jPanel4.add(colourText);
        colourText.setBounds(30, 170, 210, 30);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/addToList.jpg"))); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel4.add(addButton);
        addButton.setBounds(130, 210, 110, 50);

        colourList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(colourList);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(270, 100, 310, 160);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/done.jpg"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(470, 270, 110, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            String colourName = colourText.getText().toUpperCase();
            ListModel model = colourList.getModel();
            DefaultListModel listModel = new DefaultListModel();
            boolean isExists = false;
            for (int i = 0; i < model.getSize(); i++) {
                listModel.addElement(model.getElementAt(i));
                if (colourName.toUpperCase().equals(model.getElementAt(i))) {
                    isExists = true;
                }
            }
            if (!isExists) {
                boolean addOption = DeliveryNoteControllerClient.addColour(colourName);
                if (addOption) {
                    listModel.addElement(colourText.getText().toUpperCase());
                    colourList.setModel(listModel);
                    manageDeliveryOrderDetail.addColourToCombo(colourName.toUpperCase());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Option is already exists !");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddNewColour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void colourTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colourTextActionPerformed
        addButton.doClick();
    }//GEN-LAST:event_colourTextActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewColour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewColour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewColour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewColour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddNewColour dialog = new AddNewColour(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JList colourList;
    private javax.swing.JTextField colourText;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private ManageDeliveryOrderDetail manageDeliveryOrderDetail;

    public void setParentFrame(ManageDeliveryOrderDetail manageDeliveryOrderDetail) {
        this.manageDeliveryOrderDetail = manageDeliveryOrderDetail;
    }
}