/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.view;

import com.incosyz.sms.clientcontroller.DeliveryNoteControllerClient;
import com.incosyz.sms.dialog.DeliveryNoteDetail;
import com.incosyz.sms.dialog.ManageDeliveryOrderDetail;
import com.incosyz.sms.model.BatchModel;
import static com.incosyz.sms.view.Home.img;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stelan
 */
public class ManageDeliveryOrder extends javax.swing.JFrame {

    /**
     * Creates new form ManagePriceAnnouncement
     */
    public ManageDeliveryOrder() {
        initComponents();
        setLocationRelativeTo(null);
        constructor();
    }

    public void constructor() {
        try {
            deliveryNoteTableModel = (DefaultTableModel) deliveryNoteTable.getModel();
            deliveryNoteTableModel.setRowCount(0);
            allBatch = DeliveryNoteControllerClient.getAllBatch();
            setIconImage(img);
            for (BatchModel batchModel : allBatch) {
                addBatchToTable(batchModel);
            }
        } catch (ClassNotFoundException | SQLException | NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ManageDeliveryOrder.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        deliveryNoteTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        consignmentNoLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        deleteDelivery = new javax.swing.JButton();
        viewDeliveryOrder = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        manualCountLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        toolKitCountLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        sideMirrorCountLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        warrantyCountLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jacketCountLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        helmetCountLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        orderRequestNoLabel = new javax.swing.JTextField();
        userIdLabel = new javax.swing.JTextField();
        vehicleNoLabel = new javax.swing.JTextField();
        driverNameLabel = new javax.swing.JTextField();
        helperNameLabel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Samagi Traders | Sales Management System | Manage Delivery Order");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Samagi Traders - Manage Delivery Orders");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 10, 550, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Sales Management System");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 40, 230, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/editDo.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(300, 80, 110, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/newDeliveryOrder_1.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 80, 140, 50);

        deliveryNoteTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        deliveryNoteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Consign. Note No", "Date", "Transport Order No", "Transport Inv.No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        deliveryNoteTable.setRowHeight(25);
        deliveryNoteTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        deliveryNoteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deliveryNoteTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(deliveryNoteTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(250, 150, 680, 330);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("User Id         :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 290, 150, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Consignment Note No :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 150, 150, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Order Req.No:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(30, 230, 150, 20);

        consignmentNoLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        consignmentNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(consignmentNoLabel);
        consignmentNoLabel.setBounds(30, 180, 200, 40);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Vehicle No    :");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(30, 350, 150, 20);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Driver Name  :");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(30, 410, 150, 20);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Helper Name :");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(30, 470, 90, 20);

        deleteDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/deleteDO.jpg"))); // NOI18N
        deleteDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDeliveryActionPerformed(evt);
            }
        });
        jPanel1.add(deleteDelivery);
        deleteDelivery.setBounds(420, 80, 110, 50);

        viewDeliveryOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/viewDo_1.jpg"))); // NOI18N
        viewDeliveryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDeliveryOrderActionPerformed(evt);
            }
        });
        jPanel1.add(viewDeliveryOrder);
        viewDeliveryOrder.setBounds(180, 80, 110, 50);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Free Issues", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel10.setLayout(null);

        jPanel4.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(250, 250, 250));
        jPanel5.setLayout(null);

        manualCountLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        manualCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manualCountLabel.setText("0");
        jPanel5.add(manualCountLabel);
        manualCountLabel.setBounds(0, 0, 80, 30);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(110, 0, 80, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Manual :");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(10, 0, 80, 30);

        jPanel10.add(jPanel4);
        jPanel4.setBounds(20, 20, 190, 30);

        jPanel6.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(250, 250, 250));
        jPanel7.setLayout(null);

        toolKitCountLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        toolKitCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toolKitCountLabel.setText("0");
        jPanel7.add(toolKitCountLabel);
        toolKitCountLabel.setBounds(0, 0, 80, 30);

        jPanel6.add(jPanel7);
        jPanel7.setBounds(110, 0, 80, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tool Kits :");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(10, 0, 70, 30);

        jPanel10.add(jPanel6);
        jPanel6.setBounds(20, 60, 190, 30);

        jPanel12.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(250, 250, 250));
        jPanel13.setLayout(null);

        sideMirrorCountLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sideMirrorCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sideMirrorCountLabel.setText("0");
        jPanel13.add(sideMirrorCountLabel);
        sideMirrorCountLabel.setBounds(0, 0, 80, 30);

        jPanel12.add(jPanel13);
        jPanel13.setBounds(110, 0, 80, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Side Mirrors :");
        jPanel12.add(jLabel11);
        jLabel11.setBounds(10, 0, 80, 30);

        jPanel10.add(jPanel12);
        jPanel12.setBounds(230, 20, 190, 30);

        jPanel8.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(250, 250, 250));
        jPanel9.setLayout(null);

        warrantyCountLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        warrantyCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warrantyCountLabel.setText("0");
        jPanel9.add(warrantyCountLabel);
        warrantyCountLabel.setBounds(0, 0, 80, 30);

        jPanel8.add(jPanel9);
        jPanel9.setBounds(110, 0, 80, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Warranty Manual :");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(10, 0, 110, 30);

        jPanel10.add(jPanel8);
        jPanel8.setBounds(230, 60, 190, 30);

        jPanel14.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(250, 250, 250));
        jPanel15.setLayout(null);

        jacketCountLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jacketCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jacketCountLabel.setText("0");
        jPanel15.add(jacketCountLabel);
        jacketCountLabel.setBounds(0, 0, 80, 30);

        jPanel14.add(jPanel15);
        jPanel15.setBounds(110, 0, 80, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Jackets :");
        jPanel14.add(jLabel12);
        jLabel12.setBounds(10, 0, 80, 30);

        jPanel10.add(jPanel14);
        jPanel14.setBounds(430, 20, 190, 30);

        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setLayout(null);

        helmetCountLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        helmetCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helmetCountLabel.setText("0");
        jPanel3.add(helmetCountLabel);
        helmetCountLabel.setBounds(0, 0, 80, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(110, 0, 80, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Helmets :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 0, 90, 30);

        jPanel10.add(jPanel2);
        jPanel2.setBounds(430, 60, 190, 30);

        jPanel1.add(jPanel10);
        jPanel10.setBounds(250, 500, 680, 100);

        orderRequestNoLabel.setEditable(false);
        jPanel1.add(orderRequestNoLabel);
        orderRequestNoLabel.setBounds(30, 250, 200, 30);

        userIdLabel.setEditable(false);
        jPanel1.add(userIdLabel);
        userIdLabel.setBounds(30, 310, 200, 30);

        vehicleNoLabel.setEditable(false);
        jPanel1.add(vehicleNoLabel);
        vehicleNoLabel.setBounds(30, 370, 200, 30);

        driverNameLabel.setEditable(false);
        jPanel1.add(driverNameLabel);
        driverNameLabel.setBounds(30, 430, 200, 30);

        helperNameLabel.setEditable(false);
        jPanel1.add(helperNameLabel);
        helperNameLabel.setBounds(30, 490, 200, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DeliveryNoteDetail deliveryNoteDetail = new DeliveryNoteDetail(this, true);
        deliveryNoteDetail.setParentFrame(this);
        deliveryNoteDetail.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (deliveryNoteTable.getSelectedRow() > -1) {
            BatchModel selectedBatch = getSelectedBatch();

            if (selectedBatch != null) {
                DeliveryNoteDetail deliveryNoteDetail = new DeliveryNoteDetail(this, true);
                deliveryNoteDetail.setUpdateMode(selectedBatch);
                deliveryNoteDetail.setParentFrame(this);
                deliveryNoteDetail.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Batch info not found !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select item to edit delivery order detail !");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void deliveryNoteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryNoteTableMouseClicked
        String consignNo = (String) deliveryNoteTableModel.getValueAt(deliveryNoteTable.getSelectedRow(), 0);
        BatchModel batchModel = getBatchModel(consignNo);
        consignmentNoLabel.setText(consignNo);
        orderRequestNoLabel.setText(batchModel.getOrderRequestNo());
        userIdLabel.setText(batchModel.getUserId());
        vehicleNoLabel.setText(batchModel.getVehicleNo());
        driverNameLabel.setText(batchModel.getDriverName());
        helperNameLabel.setText(batchModel.getHelperName());

        manualCountLabel.setText(batchModel.getManual());
        toolKitCountLabel.setText(batchModel.getToolKit());
        sideMirrorCountLabel.setText(batchModel.getSideMirror());
        warrantyCountLabel.setText(batchModel.getWarrantyManual());
        jacketCountLabel.setText(batchModel.getJacket());
        helmetCountLabel.setText(batchModel.getHelmet());
    }//GEN-LAST:event_deliveryNoteTableMouseClicked

    private void viewDeliveryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDeliveryOrderActionPerformed
        if (deliveryNoteTable.getSelectedRow() > -1) {

            String consignmentNoteNo = (String) deliveryNoteTable.getValueAt(deliveryNoteTable.getSelectedRow(), 0);
            String batchDate = (String) deliveryNoteTable.getValueAt(deliveryNoteTable.getSelectedRow(), 1);

            BatchModel batchModel = new BatchModel()
                    .setBatchId(getBatchId(consignmentNoteNo))
                    .setConsignmentNoteNo(consignmentNoteNo)
                    .setBatchDate(batchDate);

            ManageDeliveryOrderDetail manageDeliveryOrderDetail = new ManageDeliveryOrderDetail(this, true);
            manageDeliveryOrderDetail.setParentFrame(batchModel, allBatch);
            manageDeliveryOrderDetail.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Select Delivery Note To Edit !");
        }
    }//GEN-LAST:event_viewDeliveryOrderActionPerformed

    private void deleteDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDeliveryActionPerformed
        String consignmentNoteNo = (String) deliveryNoteTable.getValueAt(deliveryNoteTable.getSelectedRow(), 0);
        try {
            int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Are your sure to delete delivery note ? delivery note detail items will deleted !");
            if (showConfirmDialog == JOptionPane.YES_OPTION) {
                boolean deleteDelivery = DeliveryNoteControllerClient.deleteDelivery(consignmentNoteNo);
                if (deleteDelivery) {
                    deliveryNoteTableModel.removeRow(deliveryNoteTable.getSelectedRow());
                    JOptionPane.showMessageDialog(this, "Delivery Note deleted successfully !");
                }
            }
        } catch (NotBoundException | MalformedURLException | ClassNotFoundException | RemoteException | SQLException ex) {
            Logger.getLogger(ManageDeliveryOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteDeliveryActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageDeliveryOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel consignmentNoLabel;
    private javax.swing.JButton deleteDelivery;
    private javax.swing.JTable deliveryNoteTable;
    private javax.swing.JTextField driverNameLabel;
    private javax.swing.JLabel helmetCountLabel;
    private javax.swing.JTextField helperNameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jacketCountLabel;
    private javax.swing.JLabel manualCountLabel;
    private javax.swing.JTextField orderRequestNoLabel;
    private javax.swing.JLabel sideMirrorCountLabel;
    private javax.swing.JLabel toolKitCountLabel;
    private javax.swing.JTextField userIdLabel;
    private javax.swing.JTextField vehicleNoLabel;
    private javax.swing.JButton viewDeliveryOrder;
    private javax.swing.JLabel warrantyCountLabel;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel deliveryNoteTableModel;
    private ArrayList<BatchModel> allBatch;

    public void refresh() {
        try {
            deliveryNoteTableModel.setRowCount(0);
            allBatch = DeliveryNoteControllerClient.getAllBatch();
            for (BatchModel batchModel : allBatch) {
                addBatchToTable(batchModel);
            }
        } catch (ClassNotFoundException | SQLException | NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ManageDeliveryOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addBatchToTable(BatchModel batchModel) {
        Object[] row = {batchModel.getConsignmentNoteNo(), batchModel.getBatchDate(), batchModel.getTransportOrderNo(), batchModel.getTransportInvoiceNo()};
        deliveryNoteTableModel.addRow(row);
    }

    public void addToArrayList(BatchModel batchModel) {
        allBatch.add(batchModel);
        addBatchToTable(batchModel);
    }

    public ArrayList<BatchModel> getAllBatch() {
        return allBatch;
    }

    public String getBatchId(String consignmentNoteNo) {
        for (BatchModel batchModel : allBatch) {
            if (consignmentNoteNo.equals(batchModel.getConsignmentNoteNo())) {
                return batchModel.getBatchId();
            }
        }
        return null;
    }

    public BatchModel getBatchModel(String consignNo) {
        for (BatchModel batchModel : allBatch) {
            if (batchModel.getConsignmentNoteNo().equals(consignNo)) {
                return batchModel;
            }
        }
        return null;
    }

    public BatchModel getSelectedBatch() {
        String consignmentNo = (String) deliveryNoteTableModel.getValueAt(deliveryNoteTable.getSelectedRow(), 0);
        for (BatchModel batchModel : allBatch) {
            if (consignmentNo.equals(batchModel.getConsignmentNoteNo())) {
                return batchModel;
            }
        }
        return null;
    }
}
