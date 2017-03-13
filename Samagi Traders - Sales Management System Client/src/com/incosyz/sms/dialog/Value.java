/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.dialog;

import com.incosyz.sms.config.Setting;
import com.incosyz.sms.other.CurrancyFormat;
import com.incosyz.sms.other.Validation;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Date : Nov 23, 2015 Time : 4:37:06 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Value extends javax.swing.JDialog {

    /**
     * Creates new form Value
     */
    public Value(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);

        try {
            Setting s = new Setting();
            a.setText("Rs " + CurrancyFormat.getCurrancyFormat(s.getProperty("RMV_WITH_LEASING")));
            aa.setText(s.getProperty("RMV_WITH_LEASING"));
            b.setText("Rs " + CurrancyFormat.getCurrancyFormat(s.getProperty("RMV_WITHOUT_LEASING")));
            bb.setText(s.getProperty("RMV_WITHOUT_LEASING"));
            c.setText("Rs " + CurrancyFormat.getCurrancyFormat(s.getProperty("INSURANCE")));
            cc.setText(s.getProperty("INSURANCE"));
        } catch (IOException ex) {
            Logger.getLogger(Value.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        aa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        bb = new javax.swing.JTextField();
        cc = new javax.swing.JTextField();
        c = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Model Amount");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 20, 320, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Sales Management System -> Create New Sale -> Manage Sale");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 50, 440, 30);

        aa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaActionPerformed(evt);
            }
        });
        aa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aaKeyReleased(evt);
            }
        });
        jPanel1.add(aa);
        aa.setBounds(100, 150, 250, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("RMV Price ( With Leasing )");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 100, 210, 30);

        a.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        a.setForeground(new java.awt.Color(153, 153, 153));
        a.setText("217,900.00");
        jPanel1.add(a);
        a.setBounds(100, 120, 170, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("RMV Price ( Without Leasing ) :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 200, 230, 30);

        b.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        b.setForeground(new java.awt.Color(153, 153, 153));
        b.setText("217,900.00");
        jPanel1.add(b);
        b.setBounds(100, 220, 170, 30);

        bb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbActionPerformed(evt);
            }
        });
        bb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bbKeyReleased(evt);
            }
        });
        jPanel1.add(bb);
        bb.setBounds(100, 250, 250, 30);

        cc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccActionPerformed(evt);
            }
        });
        cc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ccKeyReleased(evt);
            }
        });
        jPanel1.add(cc);
        cc.setBounds(100, 350, 250, 30);

        c.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        c.setForeground(new java.awt.Color(153, 153, 153));
        c.setText("217,900.00");
        jPanel1.add(c);
        c.setBounds(100, 320, 170, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Insurance :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 300, 170, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/cancel.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(210, 430, 110, 50);

        doneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/done.jpg"))); // NOI18N
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
        jPanel1.add(doneButton);
        doneButton.setBounds(330, 430, 110, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaActionPerformed
        bb.requestFocus();
    }//GEN-LAST:event_aaActionPerformed

    private void aaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aaKeyReleased
        Validation v = new Validation();
        v.inputCurrancy(aa);
    }//GEN-LAST:event_aaKeyReleased

    private void bbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbActionPerformed
        cc.requestFocus();
    }//GEN-LAST:event_bbActionPerformed

    private void bbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bbKeyReleased
        Validation v = new Validation();
        v.inputCurrancy(bb);
    }//GEN-LAST:event_bbKeyReleased

    private void ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccActionPerformed
        doneButton.doClick();
    }//GEN-LAST:event_ccActionPerformed

    private void ccKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ccKeyReleased
        Validation v = new Validation();
        v.inputCurrancy(cc);
    }//GEN-LAST:event_ccKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        try {
            Setting s = new Setting();

            boolean abc = true;

            if (aa.getForeground() != Color.RED) {
                s.setProperty("RMV_WITH_LEASING", aa.getText());
            } else {
                abc = false;
                JOptionPane.showMessageDialog(this, "RMV Price ( With leasing ) Wrong input !");
            }

            if (bb.getForeground() != Color.RED) {
                s.setProperty("RMV_WITHOUT_LEASING", bb.getText());
            } else {
                abc = false;
                JOptionPane.showMessageDialog(this, "RMV Price ( With out leasing ) Wrong input !");
            }

            if (cc.getForeground() != Color.RED) {
                s.setProperty("INSURANCE", cc.getText());
            } else {
                abc = false;
                JOptionPane.showMessageDialog(this, "Insurance amount Wrong input !");
            }
            if (abc) {
                JOptionPane.showMessageDialog(this, "Value changed successfully !");
                dispose();
            }
        } catch (IOException ex) {
            Logger.getLogger(Value.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_doneButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Value.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Value.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Value.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Value.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Value dialog = new Value(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel a;
    private javax.swing.JTextField aa;
    private javax.swing.JLabel b;
    private javax.swing.JTextField bb;
    private javax.swing.JLabel c;
    private javax.swing.JTextField cc;
    private javax.swing.JButton doneButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}