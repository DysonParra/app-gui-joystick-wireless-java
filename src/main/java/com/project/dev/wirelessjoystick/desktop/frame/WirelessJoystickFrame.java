/*
 * @fileoverview {FileName} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {FileName} fue realizada el 31/07/2022.
 * @Dev - La primera version de {FileName} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.wirelessjoystick.desktop.frame;

import com.project.dev.joystick.name.generic.type.GenericJoystickClient;
import com.project.dev.joystick.name.nintendo.NintendoJoystick;
import com.project.dev.joystick.name.poly.PolyJoystick;
import com.project.dev.tray.setter.TrayIconSetter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import static com.project.dev.joystick.name.generic.GenericJoystick.JOYSTICK_TYPE_CLIENT;
import static com.project.dev.joystick.name.generic.GenericJoystick.JOYSTICK_TYPE_LOCAL;
import static com.project.dev.joystick.name.generic.GenericJoystick.JOYSTICK_TYPE_SERVER;
import static com.project.dev.wirelessjoystick.desktop.frame.JoystickFrame.JOYSTICK_FORM_NATIVE;
import static com.project.dev.wirelessjoystick.desktop.frame.JoystickFrame.JOYSTICK_FORM_NORMAL;

/**
 * TODO: Definición de {@code WirelessJoystickFrame}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class WirelessJoystickFrame extends JFrame {

    /*
     * Variables locales.
     */
    private GenericJoystickClient genericJoystick;                      // Usada para probar la conexión con el servidor con el joystick.
    private JFrame frame = this;                                        // Referencia a la ventana.
    private String ipAddress = "";                                      // Indica la ip del servidor.
    private int serverPort = 0;                                         // Indica el puerto de conexión al servidor.

    /*
     * Variables usadas para asignar datos a los spinner.
     */
    private static final String[] JOYSTICK_TYPES = {
        JOYSTICK_TYPE_SERVER,
        JOYSTICK_TYPE_LOCAL,
        JOYSTICK_TYPE_CLIENT
    };
    private final String[] JOYSTICK_TYPES_SPN_TEXT = {
        "Joystick servidor",
        "Joystick local",
        "Joystick cliente"
    };
    private final String[][] JOYSTICK_TYPE_SERVER_FORMS = {
        {JOYSTICK_FORM_NORMAL, "Normal"},
        {JOYSTICK_FORM_NATIVE, "Nativo"}
    };
    private final String[][] JOYSTICK_TYPE_LOCAL_FORMS = {
        {JOYSTICK_FORM_NORMAL, "Normal"}
    };
    private final String[][] JOYSTICK_TYPE_CLIENT_FORMS = {
        {JOYSTICK_FORM_NORMAL, "Normal"}
    };
    private static final String[] JOYSTICK_NAMES = {
        PolyJoystick.JOYSTICK_NAME,
        NintendoJoystick.JOYSTICK_NAME
    };

    /**
     * TODO: Definición de {@code WirelessJoystickFrame}.
     *
     */
    public WirelessJoystickFrame() {
        initComponents();

        // Inicializa el joystick cliente.
        try {
            genericJoystick = new GenericJoystickClient();
        } catch (Exception ignored) {

        }

        // Agrega titulo, icono y trayIcon al frame.
        frame.setTitle("Wireless Joystick");
        TrayIconSetter.setTrayIconToFrame(frame);

        // Asigna valores a los spinner con el tipo y el nombre del joystick.
        for (String name : JOYSTICK_TYPES_SPN_TEXT)
            spnJoystickType.addItem(name);

        for (String name : JOYSTICK_NAMES)
            spnJoystickName.addItem(name);

        // Alinea al centro los jlabel y los editText.
        message1Label.setHorizontalAlignment(JTextField.CENTER);
        message2Label.setHorizontalAlignment(JTextField.CENTER);
        editTextIpAddress.setHorizontalAlignment(JTextField.CENTER);
        editTextPort.setHorizontalAlignment(JTextField.CENTER);

        // Asigna valores por defecto a la dirección ip y el puerto de conexión.
        //editTextIpAddress.setText("192.168.1.60");
        //editTextPort.setText("1025");
        editTextIpAddress.setText("192.168.1.2");
        editTextPort.setText("2");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        message1Label = new javax.swing.JLabel();
        message2Label = new javax.swing.JLabel();
        editTextIpAddress = new javax.swing.JTextField();
        editTextPort = new javax.swing.JTextField();
        spnJoystickName = new javax.swing.JComboBox<>();
        spnJoystickType = new javax.swing.JComboBox<>();
        btnCreateConnect = new javax.swing.JButton();
        spnJoystickForm = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        message1Label.setText("Llene la información requerida para");

        message2Label.setText("crear el joystick.");

        spnJoystickName.setFocusable(false);
        spnJoystickName.addActionListener(this::spnJoystickNameActionPerformed);

        spnJoystickType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        spnJoystickType.addActionListener(this::spnJoystickTypeActionPerformed);

        btnCreateConnect.setText("Conectar");
        btnCreateConnect.setPreferredSize(new java.awt.Dimension(85, 32));
        btnCreateConnect.addActionListener(this::btnCreateConnectActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(message1Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(message2Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(180, 180, 180)
                                                .addComponent(btnCreateConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(185, 185, 185)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(editTextPort, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(spnJoystickName, 0, 80, Short.MAX_VALUE)
                                                        .addComponent(spnJoystickForm, 0, 80, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(160, 160, 160)
                                                .addComponent(spnJoystickType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(175, 175, 175)
                                                .addComponent(editTextIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(159, 160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(message1Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(message2Label)
                                .addGap(34, 34, 34)
                                .addComponent(editTextIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editTextPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(spnJoystickType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(spnJoystickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(spnJoystickForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(btnCreateConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * TODO: Definición de {@code btnCreateConnectActionPerformed}.
     *
     * @param evt
     */
    private void btnCreateConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateConnectActionPerformed
        // Evalúa el tipo de joystick a crear.
        switch (JOYSTICK_TYPES[spnJoystickType.getSelectedIndex()]) {
            // Cliente.
            case JOYSTICK_TYPE_CLIENT:
                ipAddress = String.valueOf(editTextIpAddress.getText());
                if ("".equals(ipAddress))
                    JOptionPane.showMessageDialog(this, "Escriba una direción ip primero.");
                else if ("".equals(editTextPort.getText()))
                    JOptionPane.showMessageDialog(this, "Escriba un puerto de conexión primero.");
                else {
                    try {
                        serverPort = Integer.parseInt(String.valueOf(editTextPort.getText()));

                        genericJoystick.setServerIpAddress(ipAddress);
                        genericJoystick.setServerPort(serverPort);

                        // Prueba la conexión con el servidor.
                        if (genericJoystick.testServerConnection()) {
                            startJoystickFrame(
                                    JOYSTICK_TYPE_CLIENT,
                                    null,
                                    JOYSTICK_TYPE_CLIENT_FORMS[spnJoystickForm.getSelectedIndex()][0],
                                    ipAddress,
                                    serverPort);
                        } else
                            JOptionPane.showMessageDialog(this, "No es posible conectarse al servidor especificado.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Escriba un puerto de conexión válido primero.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error desconocido intente de nuevo.");
                    }
                }
                break;

            // Servidor.
            case JOYSTICK_TYPE_SERVER:
                startJoystickFrame(
                        JOYSTICK_TYPE_SERVER,
                        JOYSTICK_NAMES[spnJoystickName.getSelectedIndex()],
                        JOYSTICK_TYPE_SERVER_FORMS[spnJoystickForm.getSelectedIndex()][0],
                        null,
                        0);
                break;

            // Local.
            case JOYSTICK_TYPE_LOCAL:
                startJoystickFrame(
                        JOYSTICK_TYPE_LOCAL,
                        JOYSTICK_NAMES[spnJoystickName.getSelectedIndex()],
                        JOYSTICK_TYPE_LOCAL_FORMS[spnJoystickForm.getSelectedIndex()][0],
                        null,
                        0);
                break;
        }
    }//GEN-LAST:event_btnCreateConnectActionPerformed

    /**
     * TODO: Definición de {@code spnJoystickNameActionPerformed}.
     *
     * @param evt
     */
    private void spnJoystickNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spnJoystickNameActionPerformed

    }//GEN-LAST:event_spnJoystickNameActionPerformed

    /**
     * TODO: Definición de {@code spnJoystickTypeActionPerformed}.
     *
     * @param evt
     */
    private void spnJoystickTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spnJoystickTypeActionPerformed
        spnJoystickForm.removeAllItems();                                   // Limpia el spinner con las formas del joystick.
        switch (JOYSTICK_TYPES[spnJoystickType.getSelectedIndex()]) {       // Evalúa el tipo de joystick seleccionado.
            case JOYSTICK_TYPE_CLIENT:                                      // Cliente.
                editTextIpAddress.setEnabled(true);                         // Habilita la escritura de la dirección ip.
                //editTextIpAddress.setVisible(true);                       // Muestra la escritura de la dirección ip.
                editTextPort.setEnabled(true);                              // Habilita la escritura del puerto de conexión.
                //editTextPort.setVisible(true);                            // Muestra la escritura del puerto de conexión.
                spnJoystickName.setEnabled(false);                          // Deshabilita el spinner para seleccionar nombre del joystick.
                //spnJoystickName.setVisible(false);                        // Oculta el spinner para seleccionar nombre del joystick.
                btnCreateConnect.setText("Conectar");                       // Pone el texto conectar en el botón.
                for (String[] form : JOYSTICK_TYPE_CLIENT_FORMS)             // Llena el spinner con las formas del joystick.
                    spnJoystickForm.addItem(form[1]);                       // Agrega el item al spinner con las formas.
                break;                                                      // Sale del case.

            case JOYSTICK_TYPE_SERVER:                                      // Servidor.
            case JOYSTICK_TYPE_LOCAL:                                       // Local.
                editTextIpAddress.setEnabled(false);                        // Deshabilita la escritura de la dirección ip.
                //editTextIpAddress.setVisible(false);                      // Oculta la escritura de la dirección ip.
                editTextPort.setEnabled(false);                             // Deshabilita la escritura del puerto de conexión.
                //editTextPort.setVisible(false);                           // Oculta la escritura del puerto de conexión.
                spnJoystickName.setEnabled(true);                           // Habilita el spinner para seleccionar nombre del joystick.
                //spnJoystickName.setVisible(true);                         // Muestra el spinner para seleccionar nombre del joystick.
                btnCreateConnect.setText("Crear");                          // Pone el texto crear en el botón.

                // Si es un joystick sevidor.
                if (JOYSTICK_TYPES[spnJoystickType.getSelectedIndex()].equals(JOYSTICK_TYPE_SERVER))
                    for (String[] form : JOYSTICK_TYPE_SERVER_FORMS)         // Llena el spinner con las formas del joystick.
                        spnJoystickForm.addItem(form[1]);                   // Agrega el item al spinner con las formas.
                // Si es un joystick local.
                else
                    for (String[] form : JOYSTICK_TYPE_LOCAL_FORMS)          // Llena el spinner con las formas del joystick.
                        spnJoystickForm.addItem(form[1]);                   // Agrega el item al spinner con las formas.
                break;                                                      // Sale del case.
        }
    }//GEN-LAST:event_spnJoystickTypeActionPerformed

    /**
     * FIXME: Definición de {@code startJoystickFrame}. Inicia el frame con el joystick.
     *
     * @param joystickType es el tipo de joystick que se creará (Local, cliente o servidor).
     * @param joystickName es el nombre del joystick que se creará.
     * @param joystickForm es la forma del joystcik a crear (Normal o nativo.)
     * @param ipAddress    Es la dirección ip donde se conectará el joystick cliente en caso de ser
     *                     de este tipo.
     * @param serverPort   Es puerto de conexión donde se conectará el joystick cliente en caso de
     *                     ser de este tipo.
     */
    public void startJoystickFrame(String joystickType, String joystickName, String joystickForm, String ipAddress, int serverPort) {
        // Crea un frame para iniciar el frame con el joystick.
        JoystickFrame joystickFrame = new JoystickFrame();

        // Manda información al frame con el joystick.
        joystickFrame.setJoystickType(joystickType);
        joystickFrame.setJoystickName(joystickName);
        joystickFrame.setJoystickForm(joystickForm);
        joystickFrame.setIpAddress(ipAddress);
        joystickFrame.setServerPort(serverPort);

        // Inicia el frame.
        joystickFrame.setVisible(true);
        joystickFrame.startFrame();
    }

    /**
     * Entrada principal del sistema.
     *
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WirelessJoystickFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new WirelessJoystickFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateConnect;
    private javax.swing.JTextField editTextIpAddress;
    private javax.swing.JTextField editTextPort;
    private javax.swing.JLabel message1Label;
    private javax.swing.JLabel message2Label;
    private javax.swing.JComboBox<String> spnJoystickForm;
    private javax.swing.JComboBox<String> spnJoystickName;
    private javax.swing.JComboBox<String> spnJoystickType;
    // End of variables declaration//GEN-END:variables
}
