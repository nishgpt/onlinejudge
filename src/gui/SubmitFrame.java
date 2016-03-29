/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SubmitFrame.java
 *
 * Created on Mar 19, 2016, 10:55:05 AM
 */
package gui;

import config.Configuration;
import entities.ProblemDetails;
import entities.Submission;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import management.CoderManagement;

/**
 *
 * @author nishant
 */
public class SubmitFrame extends javax.swing.JFrame {

    /** Creates new form SubmitFrame */
    public SubmitFrame() {
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
        headingLabel = new javax.swing.JLabel();
        languageLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox();
        sourceFileLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        sourceFileNameLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        statusImageLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(450, 160, 506, 415));

        headingLabel.setBackground(new java.awt.Color(203, 203, 163));
        headingLabel.setFont(new java.awt.Font("Ubuntu", 1, 21));
        headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headingLabel.setText("Submit - ");
        headingLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        headingLabel.setOpaque(true);
        headingLabel.setBounds(93, 10, 320, 40);
        jLayeredPane1.add(headingLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        languageLabel.setFont(new java.awt.Font("Ubuntu", 1, 17));
        languageLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        languageLabel.setText("Language :");
        languageLabel.setBounds(90, 70, 100, 30);
        jLayeredPane1.add(languageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        languageComboBox.setFont(new java.awt.Font("Ubuntu", 1, 17));
        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "C", "C++", "Java" }));
        languageComboBox.setBounds(200, 70, 100, 30);
        jLayeredPane1.add(languageComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sourceFileLabel.setFont(new java.awt.Font("Ubuntu", 1, 17));
        sourceFileLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        sourceFileLabel.setText("Source File :");
        sourceFileLabel.setBounds(90, 110, 100, 30);
        jLayeredPane1.add(sourceFileLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        browseButton.setFont(new java.awt.Font("Ubuntu", 0, 16));
        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        browseButton.setBounds(200, 110, 100, 30);
        jLayeredPane1.add(browseButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sourceFileNameLabel.setFont(new java.awt.Font("Ubuntu", 0, 17));
        sourceFileNameLabel.setBounds(310, 110, 170, 30);
        jLayeredPane1.add(sourceFileNameLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        submitButton.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/submit.png"))); // NOI18N
        submitButton.setText("SUBMIT");
        submitButton.setFocusPainted(false);
        submitButton.setFocusable(false);
        submitButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        submitButton.setBounds(178, 180, 150, 35);
        jLayeredPane1.add(submitButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        statusImageLabel.setBounds(213, 235, 80, 80);
        jLayeredPane1.add(statusImageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        statusLabel.setFont(new java.awt.Font("Ubuntu", 1, 20));
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setBounds(63, 340, 380, 45);
        jLayeredPane1.add(statusLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        okButton.setFont(new java.awt.Font("Ubuntu", 1, 15));
        okButton.setText("OK");
        okButton.setBounds(445, 360, 55, 40);
        jLayeredPane1.add(okButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
    sourceFilePath = chooseFile();
    if(sourceFilePath.equals("") == false) {
        sourceFileNameLabel.setText(sourceFileName);
    }
}//GEN-LAST:event_browseButtonActionPerformed

private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
    if(formComplete()) {
        try {
            if(conditionsMet() && Configuration.CAN_SUBMIT) { 
                submitButton.setEnabled(false);
                statusLabel.setText("Running...");
                Configuration.CAN_SUBMIT = false;
                statusImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/loading80.gif")));
                createSubmitThread();
            }
            else if(Configuration.CAN_SUBMIT == false) { //already one submission is running
                JOptionPane.showMessageDialog(rootPane, "You already have one submission running!!");
            }
        } catch(Exception exception) {
            JOptionPane.showMessageDialog(rootPane, "Client : Error in submitting - " + exception.getMessage());
        }
    }
    
}//GEN-LAST:event_submitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SubmitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubmitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubmitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubmitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SubmitFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JComboBox languageComboBox;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel sourceFileLabel;
    private javax.swing.JLabel sourceFileNameLabel;
    private javax.swing.JLabel statusImageLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

    public SubmitFrame thisFrame;
    public ProblemDetails problemDetails;
    public String sourceFilePath = "";
    public String sourceCode = "";
    public String handle;
    public File sourceFile; 
    public String sourceFileName;
    public Submission submissionStatus;
    
    void initFrame(ProblemDetails problemDetails, String handle, SubmitFrame submitFrame) {
        this.thisFrame = submitFrame;
        this.problemDetails = problemDetails;
        this.handle = handle;
        
        headingLabel.setText("Submit - " + problemDetails.code);
        okButton.setVisible(false);
        languageComboBox.setSelectedIndex(0);
        sourceFileNameLabel.setText("");
        thisFrame.setVisible(true);
    }

    private String chooseFile() {
        FileNameExtensionFilter filter= new FileNameExtensionFilter("cpp", "c", "java");
        JFileChooser chooser= new JFileChooser();
        chooser.addChoosableFileFilter(filter);
        int returnVal= chooser.showOpenDialog(null);
        if(returnVal==JFileChooser.APPROVE_OPTION) {
            sourceFile = chooser.getSelectedFile();
            sourceFileName = sourceFile.getName();
            return sourceFile + "";
        }
        return "";
    }

    private boolean formComplete() {
        if(sourceFilePath.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please select a source file");
            return false;
        }
        return true;
    }

    private boolean conditionsMet() throws FileNotFoundException, IOException {
        if(sourceFile.length() > problemDetails.sourceLimit) {
            JOptionPane.showMessageDialog(rootPane, "Source code length greater than allowed");
            return false;
        }
        return true;
    }

    private String readFile(String filePath) throws FileNotFoundException, IOException {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        
        while((sCurrentLine = br.readLine()) != null) {
            sourceCode = sourceCode + sCurrentLine + '\n';
        }
        
        return sourceCode;
    }

    private void displaySubmissionResult() {
        if(submissionStatus.status.equals("Runtime Error")) {
            statusLabel.setText(submissionStatus.status + " - " + submissionStatus.errorCode);
            statusImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/rte.png")));
        }
        else if(submissionStatus.status.equals("Time Limit Exceeded")) {
            statusLabel.setText(submissionStatus.status);
            statusImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/tle.png")));
        }
        else if(submissionStatus.status.equals("Wrong Answer")) {
            statusLabel.setText(submissionStatus.status);
            statusImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/wa.png")));
        }
        else if(submissionStatus.status.equals("Accepted")) {
            statusLabel.setText(submissionStatus.status + " - " + getRoundedTime(submissionStatus.time));
            statusImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/ac.png")));
        }
        else if(submissionStatus.status.equals("Compilation Error")) {
            statusLabel.setText(submissionStatus.status);
            statusImageLabel.setIcon(new ImageIcon(getClass().getResource("/resources/cte.png")));
        }
    }

    private void createSubmitThread() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    sourceCode = readFile(sourceFilePath);
                    Submission submission = new Submission(handle, problemDetails.code, 
                            languageComboBox.getSelectedItem().toString(), sourceCode);
                    submissionStatus = new CoderManagement().sendSubmission(submission, problemDetails);
                    displaySubmissionResult();
                    sourceCode = "";
                    submitButton.setEnabled(true);
                    Configuration.CAN_SUBMIT = true;
                } catch(Exception ex) {
                    
                }
                
            }
        }.start();    
    }

    private String getRoundedTime(double time) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(time);
    }
}