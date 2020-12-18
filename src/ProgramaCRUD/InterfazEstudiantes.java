/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaCRUD;

import ConexionCRUD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stee-
 */
public class InterfazEstudiantes extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterfazEstudiantes
     */
    public InterfazEstudiantes() {
        initComponents();
        CargarCBEstCivil();
        BloquearBotonesInicio();
        BloquerJtfInicio();
        CargarTablaEstudiantes("");
        LeerDatosTabla();
    }

    public void BloquearBotonesInicio() {
        jbNuevo.setEnabled(true);
        jbActualizar.setEnabled(false);
        jbCancelar.setEnabled(false);
        jbEliminar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbSalir.setEnabled(true);

    }

    public void BloquearBotonesActualizar() {
        jbNuevo.setEnabled(false);
        jbActualizar.setEnabled(true);
        jbCancelar.setEnabled(true);
        jbEliminar.setEnabled(true);
        jbGuardar.setEnabled(false);
        jbSalir.setEnabled(false);

    }

    public void BloquerJtfInicio() {
        jtfApellido.setEnabled(false);
        jtfCedula.setEnabled(false);
        jtfDireccion.setEnabled(false);
        jtfNombre.setEnabled(false);
        jcbECivil.setEnabled(false);
        jrbMasculino.setEnabled(false);
        jrbFemenino.setEnabled(false);
    }

    public void BloquearBotonesNuevo() {
        jbNuevo.setEnabled(false);
        jbActualizar.setEnabled(false);
        jbCancelar.setEnabled(true);
        jbEliminar.setEnabled(false);
        jbGuardar.setEnabled(true);
        jbSalir.setEnabled(false);

    }

    public void DesBloquearBotonesInicio() {
        jbActualizar.setEnabled(true);
        jbCancelar.setEnabled(true);
        jbEliminar.setEnabled(true);
        jbGuardar.setEnabled(true);
        jbSalir.setEnabled(false);

    }

    public void DesBloquerJtfInicio() {
        jtfApellido.setEnabled(true);
        jtfCedula.setEnabled(true);
        jtfDireccion.setEnabled(true);
        jtfNombre.setEnabled(true);
        jcbECivil.setEnabled(true);
        jrbMasculino.setEnabled(true);
        jrbFemenino.setEnabled(true);
    }

    public void DesBloquerJtfActualizar() {
        jtfCedula.setEnabled(false);
        jtfApellido.setEnabled(true);
        jtfDireccion.setEnabled(true);
        jtfNombre.setEnabled(true);
        jcbECivil.setEnabled(true);
        jrbMasculino.setEnabled(true);
        jrbFemenino.setEnabled(true);
    }

    public void LimpiarJTF() {
        jtfApellido.setText("");
        jtfCedula.setText("");
        jtfDireccion.setText("");
        jtfNombre.setText("");
    }

    public void LeerDatosTabla() {
        jTableRegistrosEstudiantes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (jTableRegistrosEstudiantes.getSelectedRow() != -1) {

                    jtfCedula.setText(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 0).toString());
                    jtfNombre.setText(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 1).toString());
                    jtfApellido.setText(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 2).toString());
                    jtfDireccion.setText(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 3).toString());
                    jcbECivil.setSelectedItem(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 4).toString());
                    if (jrbMasculino.getText().equals(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 5).toString())) {
                        jrbMasculino.setSelected(true);
                    } else {
                        jrbFemenino.setSelected(true);
                    }
                    BloquearBotonesActualizar();
                    DesBloquerJtfActualizar();
                }
            }
        });
    }

    public void CargarCBEstCivil() {
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sqlIns = "select * from estcivil ";
            java.sql.Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sqlIns);
            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
            jcbECivil.setModel(dcbm);
            while (rs.next()) {
                jcbECivil.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
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

        buttonGroupSexo = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistrosEstudiantes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfCedula = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jtfDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbECivil = new javax.swing.JComboBox<>();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFemenino = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTableRegistrosEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableRegistrosEstudiantes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Direccion");

        jLabel5.setText("Buscar por Cedula:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel6.setText("Estado Civil:");

        jLabel7.setText("Sexo:");

        jcbECivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbECivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbECivilActionPerformed(evt);
            }
        });

        buttonGroupSexo.add(jrbMasculino);
        jrbMasculino.setText("Masculino");

        buttonGroupSexo.add(jrbFemenino);
        jrbFemenino.setText("Femenino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbFemenino))
                            .addComponent(jtfDireccion)
                            .addComponent(jtfApellido)
                            .addComponent(jcbECivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfCedula)
                            .addComponent(jtfNombre))
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jtfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbECivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbMasculino)
                        .addComponent(jLabel7))
                    .addComponent(jrbFemenino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbSalir.setLabel("Cerrar");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbGuardar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        CargarTablaEstudiantes(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
        DesBloquerJtfInicio();
        DesBloquearBotonesInicio();
        BloquearBotonesNuevo();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        InsertarEstudiante();
        LimpiarJTF();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        ModificarEstudiantes();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        EliminarEstudiante();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        BloquearBotonesInicio();
        BloquerJtfInicio();
        LimpiarJTF();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        //System.exit(0);
        this.setVisible(false);
        LimpiarJTF();
        DesBloquearBotonesInicio();
        DesBloquerJtfInicio();
        BloquearBotonesInicio();
        BloquerJtfInicio();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jcbECivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbECivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbECivilActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableRegistrosEstudiantes;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbECivil;
    private javax.swing.JRadioButton jrbFemenino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCedula;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables


    /*
1.  conectar BDD
2.  Crear sentencia SQL
4.  Preparar sentencia SQL (PreparedStatement)(insert,update,delete)   calledStatement(plsql)    Statement(select (solo consulta))
5.  Ejecutar Statement
     */
    private void InsertarEstudiante() {
        if (jtfCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nro. de cedula");
            jtfCedula.requestFocus();
        } else if (jtfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Nombre");
            jtfNombre.requestFocus();
        } else if (jtfApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Apellido");
            jtfApellido.requestFocus();
        } else {
            try {

                String cedula = jtfCedula.getText();
                String nombre = jtfNombre.getText();
                String apellido = jtfApellido.getText();
                String direccion;
                if (jtfDireccion.getText().isEmpty()) {
                    direccion = "Sin direccion".toUpperCase();
                } else {
                    direccion = jtfDireccion.getText();
                }
                String estcivil = jcbECivil.getSelectedItem().toString();
                String sexo;
                if (jrbMasculino.isSelected()) {
                    sexo = jrbMasculino.getText();
                } else {
                    sexo = jrbFemenino.getText();
                }
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sqlIns = "";
                sqlIns = "insert into estudiantes values(?,?,?,?,?,?)";
                PreparedStatement psd = cn.prepareStatement(sqlIns);
                psd.setString(1, cedula);
                psd.setString(2, nombre);
                psd.setString(3, apellido);
                psd.setString(4, direccion);
                psd.setString(5, estcivil);
                psd.setString(6, sexo);

                psd.executeUpdate();
                CargarTablaEstudiantes("");
                JOptionPane.showMessageDialog(this, "Registro agregado exitosamente!");
                cn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    DefaultTableModel dtm;

    public void CargarTablaEstudiantes(String dato) {
        try {
            String[] registros = {"Cedula", "Nombre", "Apellido", "Direccion", "Est. Civil", "Sexo"};
            String[] datos = new String[6];
            dtm = new DefaultTableModel(null, registros);

            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sqlIns = "select * from estudiantes where EST_CEDULA LIKE '%" + dato + "%' order by EST_CEDULA ";
            java.sql.Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sqlIns);
            while (rs.next()) {
                datos[0] = rs.getString("EST_CEDULA");
                datos[1] = rs.getString("EST_NOMBRE");
                datos[2] = rs.getString("EST_APELLIDO");
                datos[3] = rs.getString("EST_DIRECCION");
                datos[4] = rs.getString("EST_CIVIL");
                datos[5] = rs.getString("EST_SEXO");
                dtm.addRow(datos);
            }
            jTableRegistrosEstudiantes.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarEstudiantes() {
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sqlUpd = "";
            String sexo;
            if (jrbMasculino.isSelected()) {
                sexo = jrbMasculino.getText();
            } else {
                sexo = jrbFemenino.getText();
            }
            sqlUpd = "UPDATE ESTUDIANTES SET EST_APELLIDO='" + jtfApellido.getText()
                    + "', EST_NOMBRE='" + jtfNombre.getText()
                    + "', EST_DIRECCION='" + jtfDireccion.getText()
                    + "', EST_CIVIL='" + jcbECivil.getSelectedItem().toString()
                    + "', EST_SEXO='" + sexo
                    + "' WHERE EST_CEDULA='" + jtfCedula.getText() + "';";
            PreparedStatement psd = cn.prepareStatement(sqlUpd);
            int n = psd.executeUpdate();
            CargarTablaEstudiantes("");
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarEstudiante() {

        try {
            if (jTableRegistrosEstudiantes.getSelectedRow() != -1
                    && JOptionPane.showConfirmDialog(this,
                            "Seguro que desea eliminar este registro?",
                            "Confirmar eliminar registro",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == 0) {
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sqlDel = "DELETE FROM ESTUDIANTES WHERE EST_CEDULA='" + jtfCedula.getText() + "'";
                PreparedStatement psd = cn.prepareStatement(sqlDel);
                int n = psd.executeUpdate();
                CargarTablaEstudiantes("");
                if (n > 0) {
                    JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente!");
                }
                BloquearBotonesInicio();
                BloquerJtfInicio();
                LimpiarJTF();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }
    }

}
