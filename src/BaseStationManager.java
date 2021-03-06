
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.net.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lanil Marasinghe
 */
public class BaseStationManager extends javax.swing.JFrame {

    private Socket serverSocket;
    private PrintWriter out;
    private BufferedReader in;
    boolean connected;
    private String serverHost;
    private int serverPort;
    
    private String[] baseStationsList;

    /**
     * Creates new form BaseStationManager
     */
    public BaseStationManager() {
        connected = false;
        initComponents();
    }

    private void initializeServerConnection(String host, int port) throws IOException {
        this.serverHost = host;
        this.serverPort = port;
        serverSocket = new Socket(host, port);
        out = new PrintWriter(serverSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        connected = true;
        this.setTitle("Sensor Emulator " + serverSocket.getLocalAddress() + ":" + serverSocket.getLocalPort());
    }

    private void destroyServerConnection() throws IOException {
        serverSocket.close();
        connected = false;
    }

    void showAlert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    String getUnit(String measure) {
        String unit = "NA";
        switch (measure) {
            case "Temparature":
                unit = "C";
                break;
            case "Humidity":
                unit = "%";
                break;
            case "Rainfaill":
                unit = "mm";
                break;
            case "Air Pressure":
                unit = "psi";
                break;
        }
        return unit;
    }

    float getMax(String measure) {
        float max = 35.6F;
        switch (measure) {
            case "Temparature":
                max = 24.0F;
                break;
            case "Humidity":
                max = 56.0F;
                break;
            case "Rainfaill":
                max = 2000.0F;
                break;
            case "Air Pressure":
                max = 124.0F;
                break;
        }
        return max;
    }

    float getMin(String measure) {
        float min = 35.6F;
        switch (measure) {
            case "Temparature":
                min = 21.0F;
                break;
            case "Humidity":
                min = 13.0F;
                break;
            case "Rainfaill":
                min = 500.0F;
                break;
            case "Air Pressure":
                min = 64.0F;
                break;
        }
        return min;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBaseStationLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtServerKey = new javax.swing.JTextField();
        btnStartNewBaseStation = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbBaseStations = new javax.swing.JComboBox();
        btnOpenBase = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbSensors = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtLoginKey = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        txtRefreshInt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtServerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtServerPort = new javax.swing.JTextField();
        lblServerStatus = new javax.swing.JLabel();
        btnConnectServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add New Base Station"));

        jLabel1.setText("Location");

        jLabel2.setText("Server Key");

        btnStartNewBaseStation.setText("Start New Base Station");
        btnStartNewBaseStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartNewBaseStationActionPerformed(evt);
            }
        });

        jLabel7.setText("New Password");

        txtNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServerKey)
                    .addComponent(btnStartNewBaseStation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBaseStationLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewPassword)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBaseStationLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtServerKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStartNewBaseStation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Open Existing Base Station"));

        jLabel3.setText("Available Base Stations");

        cmbBaseStations.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBaseStations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBaseStationsActionPerformed(evt);
            }
        });

        btnOpenBase.setText("Open Base Station");
        btnOpenBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenBaseActionPerformed(evt);
            }
        });

        jLabel6.setText("Login Password");

        cmbSensors.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSensors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSensorsActionPerformed(evt);
            }
        });

        jLabel8.setText("Available Sensors");

        txtLoginKey.setText("Kandy123");

        jLabel9.setText("Refresh Interval (Min.)");

        txtRefreshInt.setText("1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSensors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOpenBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbBaseStations, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLoginKey)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRefreshInt)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbBaseStations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbSensors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLoginKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRefreshInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOpenBase)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Server Connection Information"));

        jLabel4.setText("IP Address / Hostname");

        txtServerName.setText("localhost");
        txtServerName.setToolTipText("");

        jLabel5.setText("Port");

        txtServerPort.setText("9001");

        lblServerStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblServerStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblServerStatus.setText("NOT CONNECTED");

        btnConnectServer.setText("Connect");
        btnConnectServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(txtServerName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(lblServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConnectServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServerPort))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtServerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnectServer)
                    .addComponent(lblServerStatus)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenBaseActionPerformed
        if (connected && !txtLoginKey.getText().equals("")) {
            String selectedStation = cmbBaseStations.getSelectedItem().toString();
            String selectedSensor = cmbSensors.getSelectedItem().toString();
            String unit = getUnit(selectedSensor);
            float max = getMax(selectedSensor);
            float min = getMin(selectedSensor);
            String password = txtLoginKey.getText();
            Integer rInt = Integer.parseInt(txtRefreshInt.getText()) * 60 * 10000;
            out.println("OPEN_BASE&" + selectedStation + "&" + password + "&" + selectedSensor + "&" + unit + "&" + min + "&" + max + "&" + rInt);
            try {
                String response = in.readLine();
                if (response.equals("LOGIN_VALIDATED")) {
                    showAlert("Login Succesful ! :)");
                    new Thread(new BaseStationModel(selectedSensor, selectedStation, unit, min, max, 30000, serverHost, serverPort)).start();
                } else {
                    showAlert("Login Failed ! :( " + response);
                }
            } catch (IOException ex) {
                showAlert(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Make sure you are connected to the server and has entered the password !");
        }
    }//GEN-LAST:event_btnOpenBaseActionPerformed

    private void txtNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewPasswordActionPerformed

    private void btnStartNewBaseStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartNewBaseStationActionPerformed
        String location = txtBaseStationLocation.getText();
        String key = txtServerKey.getText();
        String newPass = txtNewPassword.getText();

        out.println("NEW_BASE&" + location + "&" + key + "&" + newPass);
        try {
            String status = in.readLine();
            showAlert(status);
        } catch (IOException ex) {
            showAlert(ex.getMessage());
        }
    }//GEN-LAST:event_btnStartNewBaseStationActionPerformed

    private void btnConnectServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectServerActionPerformed
        try {
            if (!connected) {
                initializeServerConnection(txtServerName.getText(), Integer.parseInt(txtServerPort.getText()));
                txtServerName.setEnabled(false);
                txtServerPort.setEnabled(false);
                btnConnectServer.setText("Disconnect");
                out.println("CONNECT&_");
                lblServerStatus.setText(in.readLine());

                out.println("GET_BASE_STATIONS&_");
                baseStationsList = in.readLine().split(",");
                cmbBaseStations.setModel(new DefaultComboBoxModel(baseStationsList));
            } else {
                out.println("DISCONNECT&_");
                destroyServerConnection();
                txtServerName.setEnabled(true);
                txtServerPort.setEnabled(true);
                btnConnectServer.setText("Connect");
                lblServerStatus.setText("DISCONNECTED");
                cmbBaseStations.removeAllItems();
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            lblServerStatus.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnConnectServerActionPerformed

    private void cmbBaseStationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBaseStationsActionPerformed
        out.println("GET_SENSORS&" + cmbBaseStations.getSelectedItem().toString());
        try {
            String sensorList[] = in.readLine().split(",");
            cmbSensors.setModel(new DefaultComboBoxModel(sensorList));
        } catch (IOException ex) {
            showAlert(ex.getMessage());
        }
    }//GEN-LAST:event_cmbBaseStationsActionPerformed

    private void cmbSensorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSensorsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSensorsActionPerformed

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
            java.util.logging.Logger.getLogger(BaseStationManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaseStationManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaseStationManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaseStationManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            //</editor-fold>
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BaseStationManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseStationManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnectServer;
    private javax.swing.JButton btnOpenBase;
    private javax.swing.JButton btnStartNewBaseStation;
    private javax.swing.JComboBox cmbBaseStations;
    private javax.swing.JComboBox cmbSensors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblServerStatus;
    private javax.swing.JTextField txtBaseStationLocation;
    private javax.swing.JPasswordField txtLoginKey;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JTextField txtRefreshInt;
    private javax.swing.JTextField txtServerKey;
    private javax.swing.JTextField txtServerName;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables
}
