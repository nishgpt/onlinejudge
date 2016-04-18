/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on Jan 8, 2016, 10:57:09 AM
 */
package gui;

import management.LoginManagement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import management.CacheManagement;
import management.CoderManagement;
import management.Security;
/**
 *
 * @author nishant
 */
public class Login extends javax.swing.JFrame {
    /** Creates new form Login */
    public Login() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        userLoginLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        handleLabel = new javax.swing.JLabel();
        handleField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        forgotPasswordButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(450, 250, 400, 300));

        userLoginLabel.setFont(new java.awt.Font("Ubuntu", 1, 18));
        userLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLoginLabel.setText("ONJ LOGIN");
        userLoginLabel.setBounds(100, 15, 200, 25);
        jLayeredPane1.add(userLoginLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        passwordLabel.setFont(new java.awt.Font("Ubuntu", 1, 17));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Password");
        passwordLabel.setBounds(25, 115, 100, 25);
        jLayeredPane1.add(passwordLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        handleLabel.setFont(new java.awt.Font("Ubuntu", 1, 17));
        handleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        handleLabel.setText("Handle");
        handleLabel.setBounds(25, 70, 100, 25);
        jLayeredPane1.add(handleLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        handleField.setBounds(140, 70, 210, 27);
        jLayeredPane1.add(handleField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        passwordField.setBounds(140, 115, 210, 27);
        jLayeredPane1.add(passwordField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        forgotPasswordButton.setFont(new java.awt.Font("Ubuntu", 1, 15));
        forgotPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/help-browser.png"))); // NOI18N
        forgotPasswordButton.setText("Forgot Password");
        forgotPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordButtonActionPerformed(evt);
            }
        });
        forgotPasswordButton.setBounds(190, 160, 170, 30);
        jLayeredPane1.add(forgotPasswordButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        loginButton.setFont(new java.awt.Font("Ubuntu", 1, 16));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/rsz_2login.png"))); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.setBounds(40, 160, 140, 30);
        jLayeredPane1.add(loginButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        registerButton.setFont(new java.awt.Font("Ubuntu", 1, 17));
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/list-add.png"))); // NOI18N
        registerButton.setText("New ?  Register Here");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        registerButton.setBounds(40, 210, 320, 40);
        jLayeredPane1.add(registerButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
    if(formComplete()) {
        CacheManagement.addCache(handleField.getText(), passwordField.getText());    
        LoginManagement loginManagement = new LoginManagement();
        try {
            if(loginManagement.checkAuthenticity(handleField.getText(), 
                    Security.getEncryptedPassword(passwordField.getText()))) {
                //Direct to User Dashboard
                Dashboard dashboard = new Dashboard();
                CoderManagement coderManagement = new CoderManagement();
                dashboard.initDashboard(coderManagement.getCoderDetails(handleField.getText()), 
                        coderManagement.getProblemsList(), coderManagement.getTagsList(), 
                        coderManagement.getSolvedProblemsList(handleField.getText()), 
                        coderManagement.getAttemptedUnsolvedProblemsList(handleField.getText()));
                this.dispose();
                dashboard.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Invalid credentials");
            }
        } catch(Exception exception) {}
    }
}//GEN-LAST:event_loginButtonActionPerformed

private void forgotPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordButtonActionPerformed
// TODO add your handling code here:
    if(handleField.getText().equals("")) {
        JOptionPane.showMessageDialog(rootPane, "Please provide your handle");
    }
    else {
        LoginManagement loginManagement = new LoginManagement();
            
        try {
            if(loginManagement.searchHandle(handleField.getText()) == false) {
                JOptionPane.showMessageDialog(rootPane, "No such user exists");
                return ;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Client side : " +ex.getMessage()+" "+ex.getClass());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        this.hide();
        ForgotPassword forgotPassword = new ForgotPassword();
        forgotPassword.setVisible(true);
        forgotPassword.takeLoginObject(this, handleField.getText());
    }
}//GEN-LAST:event_forgotPasswordButtonActionPerformed

private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
// TODO add your handling code here:
    this.hide();
    Register register = new Register();
    register.setVisible(true);
    register.takeLoginObject(this);
}//GEN-LAST:event_registerButtonActionPerformed

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
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotPasswordButton;
    private javax.swing.JTextField handleField;
    private javax.swing.JLabel handleLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel userLoginLabel;
    // End of variables declaration//GEN-END:variables

    private boolean formComplete() {
        if(handleField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Handle Field cannot be left blank");
            return false;
        }
        if(passwordField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password Field cannot be left blank");
            return false;
        }
        return true;
    }
}
