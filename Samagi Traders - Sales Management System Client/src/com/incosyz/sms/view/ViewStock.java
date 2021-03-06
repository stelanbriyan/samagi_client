/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.view;

import com.incosyz.sms.clientcontroller.PriceAnnouncementControllerClient;
import com.incosyz.sms.clientcontroller.StockControllerClient;
import com.incosyz.sms.dialog.ReturnToTVS;
import com.incosyz.sms.mixmodel.GETStock;
import com.incosyz.sms.mixmodel.StockModel;
import com.incosyz.sms.model.BatchModel;
import com.incosyz.sms.model.BikeModel;
import com.incosyz.sms.model.Model;
import com.incosyz.sms.model.PriceAnnouncementModel;
import com.incosyz.sms.other.CurrancyFormat;
import com.incosyz.sms.other.SearchStockTable;
import static com.incosyz.sms.view.Home.img;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Date : Nov 13, 2015 Time : 4:04:29 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class ViewStock extends javax.swing.JFrame {

    /**
     * Creates new form ViewStock
     */
    public ViewStock() {
        initComponents();
        setLocationRelativeTo(null);
        constructor();
    }

    public void constructor() {
        setIconImage(img);
        chequeTableModel = (DefaultTableModel) stockTable.getModel();
        map = new HashMap<>();
        try {
            priceAnnouncement = PriceAnnouncementControllerClient.getPriceAnnouncement();
            for (PriceAnnouncementModel priceAnnouncementModel : priceAnnouncement) {
                addPriceAnnoucement(priceAnnouncementModel);
            }
            setData();
        } catch (NotBoundException | MalformedURLException | RemoteException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewStock.class.getName()).log(Level.SEVERE, null, ex);
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
        addNewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        viewCombo = new javax.swing.JComboBox();
        priceAnnouncementCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        addNewButton1 = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        searchByCombo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        newPriceAnnouncement5 = new javax.swing.JButton();
        newPriceAnnouncement8 = new javax.swing.JButton();
        newPriceAnnouncement7 = new javax.swing.JButton();
        newPriceAnnouncement6 = new javax.swing.JButton();
        newPriceAnnouncement10 = new javax.swing.JButton();
        newPriceAnnouncement11 = new javax.swing.JButton();
        newPriceAnnouncement9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        count = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Samagi Traders | Sales Management System | View Stock Detail");
        setMinimumSize(new java.awt.Dimension(980, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Samagi Traders - View Stock Details");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Sales Management System");

        addNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/priceAnnouncement.jpg"))); // NOI18N
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        stockTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Round No", "Model Name", "Engine No", "Chassis No", "Colour", "Bike Option", "Capacity", "Commision", "Bike Amount", "TVS Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.setGridColor(new java.awt.Color(204, 204, 204));
        stockTable.setRowHeight(25);
        stockTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stockTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(stockTable);
        if (stockTable.getColumnModel().getColumnCount() > 0) {
            stockTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Config", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        viewCombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        viewCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "View Samagi Stock", "View TVS Stock", "Sold Stock", "Returned Stock", "View All Stock" }));
        viewCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        priceAnnouncementCombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        priceAnnouncementCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                priceAnnouncementComboItemStateChanged(evt);
            }
        });
        priceAnnouncementCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceAnnouncementComboActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Price Announcement Date :");

        addNewButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/delivery.jpg"))); // NOI18N
        addNewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButton1ActionPerformed(evt);
            }
        });

        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Search :");

        searchByCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchByCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Round No", "Model Name", "Engine No", "Chassis No", "Colour", "Bike Option", "Capacity", "Commision", "Bike Amount" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Search By :");

        newPriceAnnouncement5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/advanceSearch_1.jpg"))); // NOI18N
        newPriceAnnouncement5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceAnnouncement5ActionPerformed(evt);
            }
        });

        newPriceAnnouncement8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/sendMail.jpg"))); // NOI18N
        newPriceAnnouncement8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceAnnouncement8ActionPerformed(evt);
            }
        });

        newPriceAnnouncement7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/pdf.jpg"))); // NOI18N
        newPriceAnnouncement7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceAnnouncement7ActionPerformed(evt);
            }
        });

        newPriceAnnouncement6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/print.jpg"))); // NOI18N
        newPriceAnnouncement6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceAnnouncement6ActionPerformed(evt);
            }
        });

        newPriceAnnouncement10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/refresh.jpg"))); // NOI18N
        newPriceAnnouncement10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceAnnouncement10ActionPerformed(evt);
            }
        });

        newPriceAnnouncement11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/setting.jpg"))); // NOI18N
        newPriceAnnouncement11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceAnnouncement11ActionPerformed(evt);
            }
        });

        newPriceAnnouncement9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/returnToTVS.jpg"))); // NOI18N
        newPriceAnnouncement9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceAnnouncement9ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        count.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        count.setForeground(new java.awt.Color(153, 153, 153));
        count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count.setText("06");
        count.setToolTipText("");
        jPanel3.add(count);
        count.setBounds(6, 0, 90, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/nmber.jpg"))); // NOI18N
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 4, 90, 44);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNewButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceAnnouncement5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceAnnouncement9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceAnnouncement8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceAnnouncement7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceAnnouncement6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceAnnouncement10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newPriceAnnouncement11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceAnnouncementCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(priceAnnouncementCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchByCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addNewButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPriceAnnouncement5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPriceAnnouncement8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPriceAnnouncement7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPriceAnnouncement6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPriceAnnouncement10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPriceAnnouncement11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(newPriceAnnouncement9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        ManagePriceAnnouncement managePriceAnnouncement = new ManagePriceAnnouncement();
        managePriceAnnouncement.setVisible(true);
    }//GEN-LAST:event_addNewButtonActionPerformed

    private void stockTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockTableMouseClicked

    }//GEN-LAST:event_stockTableMouseClicked

    private void viewComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewComboActionPerformed
        if (viewCombo.getSelectedItem().equals("Returned Stock")) {
            try {
                ArrayList<GETStock> gETStocks = StockControllerClient.getReturnStock((String) priceAnnouncementCombo.getSelectedItem());
                addToTableRows(gETStocks);
            } catch (NotBoundException | MalformedURLException | ClassNotFoundException | SQLException | RemoteException ex) {
                Logger.getLogger(ViewStock.class.getName()).log(Level.SEVERE, null, ex);
            }
            newPriceAnnouncement9.setEnabled(false);
        } else {
            newPriceAnnouncement9.setEnabled(true);
        }
    }//GEN-LAST:event_viewComboActionPerformed

    private void priceAnnouncementComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_priceAnnouncementComboItemStateChanged

    }//GEN-LAST:event_priceAnnouncementComboItemStateChanged

    private void priceAnnouncementComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceAnnouncementComboActionPerformed
        setData();
    }//GEN-LAST:event_priceAnnouncementComboActionPerformed

    private void addNewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButton1ActionPerformed
        ManageDeliveryOrder deliveryOrder = new ManageDeliveryOrder();
        deliveryOrder.setVisible(true);
    }//GEN-LAST:event_addNewButton1ActionPerformed

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextActionPerformed

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased

        SearchStockTable searchStockTable = new SearchStockTable();
        if (searchByCombo.getSelectedItem().equals("Round No")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 0, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Model Name")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 1, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Engine No")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 2, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Chassis No")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 3, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Colour")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 4, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Bike Option")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 5, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Capacity")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 6, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Commision")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 7, searchText.getText());
            addToTableRows(filterTable);
        } else if (searchByCombo.getSelectedItem().equals("Bike Amount")) {
            ArrayList<GETStock> filterTable = searchStockTable.filterTable(stock, 8, searchText.getText());
            addToTableRows(filterTable);
        }


    }//GEN-LAST:event_searchTextKeyReleased

    private void newPriceAnnouncement5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceAnnouncement5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPriceAnnouncement5ActionPerformed

    private void newPriceAnnouncement8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceAnnouncement8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPriceAnnouncement8ActionPerformed

    private void newPriceAnnouncement7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceAnnouncement7ActionPerformed

    }//GEN-LAST:event_newPriceAnnouncement7ActionPerformed

    private void newPriceAnnouncement6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceAnnouncement6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPriceAnnouncement6ActionPerformed

    private void newPriceAnnouncement10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceAnnouncement10ActionPerformed
        setData();
    }//GEN-LAST:event_newPriceAnnouncement10ActionPerformed

    private void newPriceAnnouncement11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceAnnouncement11ActionPerformed

    }//GEN-LAST:event_newPriceAnnouncement11ActionPerformed

    private void newPriceAnnouncement9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPriceAnnouncement9ActionPerformed
        if (stockTable.getSelectedRow() > -1) {
            String roundNo = (String) chequeTableModel.getValueAt(stockTable.getSelectedRow(), 0);
            ReturnToTVS returnToTVS = new ReturnToTVS(this, true);
            returnToTVS.setDetail(roundNo);
            returnToTVS.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select round number to return !");
        }
    }//GEN-LAST:event_newPriceAnnouncement9ActionPerformed

    private void stockTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockTableMouseReleased

    }//GEN-LAST:event_stockTableMouseReleased

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
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton addNewButton1;
    private javax.swing.JLabel count;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newPriceAnnouncement10;
    private javax.swing.JButton newPriceAnnouncement11;
    private javax.swing.JButton newPriceAnnouncement5;
    private javax.swing.JButton newPriceAnnouncement6;
    private javax.swing.JButton newPriceAnnouncement7;
    private javax.swing.JButton newPriceAnnouncement8;
    private javax.swing.JButton newPriceAnnouncement9;
    private javax.swing.JComboBox priceAnnouncementCombo;
    private javax.swing.JComboBox searchByCombo;
    private javax.swing.JTextField searchText;
    private javax.swing.JTable stockTable;
    private javax.swing.JComboBox viewCombo;
    // End of variables declaration//GEN-END:variables
    private ArrayList<PriceAnnouncementModel> priceAnnouncement;
    private Map<String, PriceAnnouncementModel> map;
    private DefaultTableModel chequeTableModel;

    private ArrayList<GETStock> stock;
    private ArrayList<GETStock> searchStock;

    private void addPriceAnnoucement(PriceAnnouncementModel priceAnnouncementModel) {
        priceAnnouncementCombo.addItem(priceAnnouncementModel.getPriceAnnouncementDate());
        map.put(priceAnnouncementModel.getPriceAnnouncementDate(), priceAnnouncementModel);
    }

    public void setData() {
        PriceAnnouncementModel selectedPriceAnnouncement = getSelectedPriceAnnouncement();
        if (selectedPriceAnnouncement != null) {
            try {
                stock = StockControllerClient.getStock(selectedPriceAnnouncement.getPriceAnnouncementId());
                addToTableRows(stock);
            } catch (NotBoundException | MalformedURLException | ClassNotFoundException | SQLException | RemoteException ex) {
                Logger.getLogger(ViewStock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private PriceAnnouncementModel getSelectedPriceAnnouncement() {
        if (priceAnnouncementCombo.getItemCount() > 0) {
            return map.get(priceAnnouncementCombo.getSelectedItem().toString());
        }
        return null;
    }

    private void addToTableRows(ArrayList<GETStock> gETStocks) {
        searchStock = gETStocks;
        chequeTableModel.setRowCount(0);

        for (GETStock gETStock : gETStocks) {
            addToTableRow(gETStock);
        }
        count.setText(String.valueOf(gETStocks.size()));
    }

    private void addToTableRow(GETStock gETStock) {
        StockModel stockModel = gETStock.getStockModel();
        BikeModel bikeModel = gETStock.getBikeModel();
        BatchModel batchModel = gETStock.getBatchModel();
        Model model = gETStock.getModel();

        String roundNo = stockModel.getRoundNo();
        String modelName = model.getModelName();
        String engineNo = stockModel.getEngineNo();
        String chassisNo = stockModel.getChassisNo();
        String colour = stockModel.getColour();
        String bikeOption = "";
        String capacity = "";
        String commision = "";
        String bikeAmount = "";
        String tvsAmount = "";

        if (bikeModel != null) {
            bikeOption = bikeModel.getBikeOption();
            capacity = bikeModel.getCapacity();

            if (bikeModel.getCommision() != null) {
                commision = CurrancyFormat.getCurrancyFormat(bikeModel.getCommision());
            }
            if (bikeModel.getNetAmount() != null) {
                bikeAmount = CurrancyFormat.getCurrancyFormat(bikeModel.getNetAmount());
            }

            if (bikeModel.getCommision() != null & bikeModel.getNetAmount() != null) {
                double tvsAm = Double.parseDouble(bikeModel.getNetAmount()) - Double.parseDouble(bikeModel.getCommision());
                tvsAmount = CurrancyFormat.getCurrancyFormat(tvsAm);
            }
        }

        Object[] row = {roundNo, modelName, engineNo, chassisNo, colour, bikeOption, capacity, commision, bikeAmount, tvsAmount};
        chequeTableModel.addRow(row);
    }

}
