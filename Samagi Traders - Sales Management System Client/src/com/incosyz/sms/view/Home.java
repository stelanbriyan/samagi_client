/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.view;

import com.incosyz.sms.clientcontroller.ChequeControllerClient;
import com.incosyz.sms.config.Setting;
import com.incosyz.sms.config.ValueProperty;
import com.incosyz.sms.dialog.ServerConnecting;
import com.incosyz.sms.model.CheckModel;
import com.incosyz.sms.model.UserModel;
import com.incosyz.sms.other.AutoBackup;
import com.incosyz.sms.other.Internet;
import com.incosyz.sms.pdfcontroller.ChequePDF;
import com.incosyz.sms.server.ServerChecking;
import com.incosyz.sms.server.ServerConnector;
import com.itextpdf.text.DocumentException;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

/**
 * Date : Nov 18, 2015 Time : 2:07:40 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Home extends javax.swing.JFrame {

    public static UserModel USER_MODEL;

    public static TrayIcon icon;

    public ViewSaleBigWindow bigWindow;
    public ManageUser manageUser;
    public ManageCheque cheque;
    public ViewStock stock;
    public CreateNewSale cns;
    public ManageDeliveryOrder deliveryOrder;
    public ManagePriceAnnouncement announcement;
    public Backup b;
    public Account account;

    boolean isLocal = false;

    public static Image img ;
    
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
        
        System.out.println(USER_MODEL);
        
        img = new ImageIcon("./src/com/incosyz/sms/image/Form-24.png").getImage();
        setIconImage(img);

        final ServerConnecting connecting = new ServerConnecting(this, true);
        connecting.setHome(this);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    boolean serverAvailable = ServerChecking.isServerAvailable();
                    if (serverAvailable) {

                    } else {
                        connecting.setVisible(true);
                        dispose();
                        try {
                            ServerConnector.getServerConnector().setServerConnector();
                            boolean connectionReady = ServerConnector.getServerConnector().isConnectionReady();
                            if (connectionReady) {
                                connecting.setVisible(false);
                            }
                        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
            }

        }.start();

        bigWindow = new ViewSaleBigWindow();
        manageUser = new ManageUser();
        cheque = new ManageCheque();
        stock = new ViewStock();
        cns = new CreateNewSale();
        deliveryOrder = new ManageDeliveryOrder();
        announcement = new ManagePriceAnnouncement();
        b = new Backup();

        USER_MODEL = new UserModel().setUserId("U001");
        AutoBackup ab = new AutoBackup();
        ab.createAutoDirectoryBackup();

        ValueProperty property = null;
        try {
            property = new ValueProperty();
        } catch (IOException ex) {
            Logger.getLogger(AutoBackup.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dateBackup = property.getProperty("AUTO_BACKUP_CLOUD");
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(d);

        if (!format.equals(dateBackup)) {
            ab.backupToCloud();
        }

        try {
            Image img = Toolkit.getDefaultToolkit().getImage("./src/com/incosyz/sms/image/orderTrayIcon.png");
            icon = new TrayIcon(img, "Incosyz @ 2015", createPopupMenu());
            SystemTray.getSystemTray().add(icon);
            icon.setImageAutoSize(true);
        } catch (AWTException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        final String todayCheque = dateFormat.format(d);

        try {
            String saveCheque = new Setting().getProperty("CHEQUE_MAIL");

            if (!todayCheque.equals(saveCheque)) {
                new Thread() {

                    @Override
                    public void run() {
                        while (true) {
                            if (Internet.isInternetAvailable()) {
                                ChequePDF chequePDF = new ChequePDF();
                                try {
                                    ArrayList<CheckModel> todayCheque1 = ChequeControllerClient.getTodayCheque();

                                    chequePDF.sendPdf(todayCheque1, "TODAY DATE CHEQUES");

                                    new Setting().setProperty("CHEQUE_MAIL", todayCheque);
                                } catch (DocumentException | MessagingException | NotBoundException | ClassNotFoundException | SQLException ex) {
                                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (MalformedURLException ex) {
                                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (RemoteException ex) {
                                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            }
                        }
                    }

                }.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setUser(UserModel model) {
        this.USER_MODEL = model;

        if (USER_MODEL.getUserType().equals("Local Account")) {
            isLocal = true;
            jLabel7.setIcon(new ImageIcon("./src/com/incosyz/sms/image/deliveryOrderDisable.png"));
            jLabel6.setIcon(new ImageIcon("./src/com/incosyz/sms/image/managePriceannouncementDis.png"));
            jLabel5.setIcon(new ImageIcon("./src/com/incosyz/sms/image/manageUsersDis.png"));
        }
    }

    private static PopupMenu createPopupMenu() throws HeadlessException {
        PopupMenu menu = new PopupMenu();

        MenuItem viewSales = new MenuItem("View Sales Detail");
        viewSales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewSaleBigWindow bigWindow = new ViewSaleBigWindow();
                bigWindow.setVisible(true);
            }
        });
        menu.add(viewSales);

        MenuItem viewCheque = new MenuItem("View Cheque Detail");
        viewCheque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManageCheque cheque = new ManageCheque();
                cheque.setVisible(true);
            }
        });
        menu.add(viewCheque);

        MenuItem viewStock = new MenuItem("View Stock Detail");
        viewStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewStock stock = new ViewStock();
                stock.setVisible(true);
            }
        });
        menu.add(viewStock);

        menu.addSeparator();

        MenuItem exit = new MenuItem("Exit Sales Management");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exit);

        return menu;
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
        jLabel2 = new javax.swing.JLabel();
        manageSaleDetail = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Samagi Traders | Sales Management System | Home");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/viewStock.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(280, 360, 120, 150);

        manageSaleDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/manageSale.png"))); // NOI18N
        manageSaleDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageSaleDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageSaleDetailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageSaleDetailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageSaleDetailMouseExited(evt);
            }
        });
        jPanel1.add(manageSaleDetail);
        manageSaleDetail.setBounds(20, 360, 120, 150);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/manageChequeHome.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 360, 120, 150);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/accountSummer.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(800, 360, 120, 150);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/managePirceannouncementIcon.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(670, 360, 120, 150);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/deliveryOrder.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(540, 360, 120, 150);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/createNewSale.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(410, 360, 120, 150);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/LMINI.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(880, 10, 40, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/BMINI.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(780, 10, 40, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/UMINI.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10);
        jLabel10.setBounds(830, 10, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/HOME.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 950, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        if (isLocal) {

        } else {
            jLabel5.setIcon(new ImageIcon("./src/com/incosyz/sms/image/accountSummerMove.png"));
        }
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        if (isLocal) {

        } else {
            jLabel5.setIcon(new ImageIcon("./src/com/incosyz/sms/image/accountSummer.png"));
        }
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new ImageIcon("./src/com/incosyz/sms/image/manageChequeMove.png"));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new ImageIcon("./src/com/incosyz/sms/image/manageChequeHome.png"));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jLabel8.setIcon(new ImageIcon("./src/com/incosyz/sms/image/createNewSaleMove.png"));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jLabel8.setIcon(new ImageIcon("./src/com/incosyz/sms/image/createNewSale.png"));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new ImageIcon("./src/com/incosyz/sms/image/viewStockMove.png"));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new ImageIcon("./src/com/incosyz/sms/image/viewStock.png"));
    }//GEN-LAST:event_jLabel2MouseExited

    private void manageSaleDetailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageSaleDetailMouseEntered
        manageSaleDetail.setIcon(new ImageIcon("./src/com/incosyz/sms/image/manageSaleMove.png"));
    }//GEN-LAST:event_manageSaleDetailMouseEntered

    private void manageSaleDetailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageSaleDetailMouseExited
        manageSaleDetail.setIcon(new ImageIcon("./src/com/incosyz/sms/image/manageSale.png"));
    }//GEN-LAST:event_manageSaleDetailMouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        if (isLocal) {

        } else {
            jLabel6.setIcon(new ImageIcon("./src/com/incosyz/sms/image/mpMove.png"));
        }
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        if (isLocal) {

        } else {
            jLabel6.setIcon(new ImageIcon("./src/com/incosyz/sms/image/managePirceannouncementIcon.png"));
        }
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        if (isLocal) {

        } else {
            jLabel7.setIcon(new ImageIcon("./src/com/incosyz/sms/image/mdMove.png"));
        }
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        if (isLocal) {

        } else {
            jLabel7.setIcon(new ImageIcon("./src/com/incosyz/sms/image/deliveryOrder.png"));
        }
    }//GEN-LAST:event_jLabel7MouseExited

    private void manageSaleDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageSaleDetailMouseClicked
        bigWindow = new ViewSaleBigWindow();
        bigWindow.setVisible(true);
    }//GEN-LAST:event_manageSaleDetailMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        cheque = new ManageCheque();
        cheque.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        stock = new ViewStock();
        stock.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        cns = new CreateNewSale();
        cns.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if (isLocal) {

        } else {
            deliveryOrder = new ManageDeliveryOrder();
            deliveryOrder.setVisible(true);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if (isLocal) {

        } else {
            announcement = new ManagePriceAnnouncement();
            announcement.setVisible(true);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if (isLocal) {

        } else {
            account = new Account();
            account.setVisible(true);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

        b.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

        manageUser.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        bigWindow.setVisible(false);

        bigWindow.setVisible(false);
        manageUser.setVisible(false);
        cheque.setVisible(false);
        stock.setVisible(false);
        cns.setVisible(false);
        deliveryOrder.setVisible(false);
        announcement.setVisible(false);
        b.setVisible(false);

        Login login = new Login();
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel manageSaleDetail;
    // End of variables declaration//GEN-END:variables

}
