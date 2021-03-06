/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incosyz.sms.view;

import com.incosyz.sms.clientcontroller.UserControllerClient;
import com.incosyz.sms.dialog.LoadingData;
import com.incosyz.sms.model.UserModel;
import com.incosyz.sms.server.ServerConnector;
import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Date : Nov 18, 2015 Time : 2:07:40 PM
 *
 * @copyright INCOSYZ
 * @author Stelan
 */
public class Login extends javax.swing.JFrame {

    private ArrayList<UserModel> users;

    /**
     * Creates new form Home
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);

        try {
            users = UserControllerClient.getUsers();
        } catch (NotBoundException | MalformedURLException | ClassNotFoundException | SQLException | RemoteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        setIconImage(new ImageIcon("./src/com/incosyz/sms/image/Form-24.png").getImage());
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
        usernameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Samagi Traders | Sales Management System | Home");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        usernameText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        usernameText.setForeground(new java.awt.Color(153, 153, 153));
        usernameText.setBorder(null);
        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });
        usernameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameTextKeyReleased(evt);
            }
        });
        jPanel1.add(usernameText);
        usernameText.setBounds(160, 265, 270, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Password :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 330, 210, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Username :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 240, 210, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/loginButton.png"))); // NOI18N
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 410, 150, 40);

        passwordText.setForeground(new java.awt.Color(153, 153, 153));
        passwordText.setBorder(null);
        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });
        passwordText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordTextKeyReleased(evt);
            }
        });
        jPanel1.add(passwordText);
        passwordText.setBounds(160, 350, 270, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/incosyz/sms/image/limg.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-160, 0, 800, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new ImageIcon("./src/com/incosyz/sms/image/moveLogin.png"));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new ImageIcon("./src/com/incosyz/sms/image/loginButton.png"));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        jLabel4.setIcon(new ImageIcon("./src/com/incosyz/sms/image/loginClick.png"));
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        jLabel4.setIcon(new ImageIcon("./src/com/incosyz/sms/image/moveLogin.png"));
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        loginButton();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void usernameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextKeyReleased
        usernameText.setForeground(Color.BLACK);
    }//GEN-LAST:event_usernameTextKeyReleased

    private void passwordTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextKeyReleased
        passwordText.setForeground(Color.BLACK);
    }//GEN-LAST:event_passwordTextKeyReleased

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        passwordText.requestFocus();
    }//GEN-LAST:event_usernameTextActionPerformed

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        loginButton();
    }//GEN-LAST:event_passwordTextActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    boolean connectionReady = ServerConnector.getServerConnector().isConnectionReady();
                    if (connectionReady) {
                        new Login().setVisible(true);
                    }
                } catch (Exception e) {

                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables

    public void loginButton() {
        String userName = usernameText.getText();
        String password = String.valueOf(passwordText.getPassword());

        for (final UserModel userModel : users) {
            String user = userModel.getUserName();
            String pass = userModel.getPassword();

            if (user.equals(userName)) {
                usernameText.setForeground(Color.BLACK);
                if (pass.equals(password)) {
                    passwordText.setForeground(Color.BLACK);

                    final LoadingData data = new LoadingData(this, false);
                    new Thread() {
                        @Override
                        public void run() {
                            data.setVisible(true);
                            Home.USER_MODEL = userModel;
                            Home h = new Home();
                            h.setUser(userModel);
                            System.out.println(userModel);
                            h.setVisible(true);
                            data.setVisible(false);

                            dispose();
                        }

                    }.start();

                    break;
                } else {
                    passwordText.setForeground(Color.red);
                }
            } else {
                usernameText.setForeground(Color.red);
            }
        }
    }
}
