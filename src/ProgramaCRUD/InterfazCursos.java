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
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stee-
 */
public class InterfazCursos extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterfazCursos
     */
    public InterfazCursos() {
        initComponents();
        BloquearBotonesInicio();
        BloquerJtfInicio();
        CargarTablaCursos("");
        LeerDatosTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfIDCurso = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfNivel = new javax.swing.JTextField();
        jtfObservacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jTableRegistros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableRegistros);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("ID de Curso: ");

        jLabel2.setText("Nombre");

        jLabel3.setText("Nivel: ");

        jLabel4.setText("Observacion: ");

        jLabel5.setText("Buscar por ID de curso:");

        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });
        jtfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBuscarKeyReleased(evt);
            }
        });

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
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jtfNivel)
                            .addComponent(jtfIDCurso)
                            .addComponent(jtfNombre))
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jtfIDCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jbSalir.setText("Cerrar");
        jbSalir.setToolTipText("Cerrar esta ventana.");
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
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbActualizar))
                .addGap(26, 26, 26)
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

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jtfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarKeyReleased
        // TODO add your handling code here:
        CargarTablaCursos(jtfBuscar.getText());
    }//GEN-LAST:event_jtfBuscarKeyReleased

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
        DesBloquerJtfInicio();
        DesBloquearBotonesInicio();
        BloquearBotonesNuevo();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        InsertarCurso();
        LimpiarJTF();
        BloquearBotonesInicio();
        BloquerJtfInicio();
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        ModificarCursos();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        EliminarCurso();
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
        DesBloquerJtfInicio();
        DesBloquearBotonesInicio();
        BloquearBotonesInicio();
        BloquerJtfInicio();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableRegistros;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfIDCurso;
    private javax.swing.JTextField jtfNivel;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfObservacion;
    // End of variables declaration//GEN-END:variables

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
        jtfNivel.setEnabled(false);
        jtfIDCurso.setEnabled(false);
        jtfObservacion.setEnabled(false);
        jtfNombre.setEnabled(false);
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
        jtfNivel.setEnabled(true);
        jtfIDCurso.setEnabled(true);
        jtfObservacion.setEnabled(true);
        jtfNombre.setEnabled(true);
    }

    public void DesBloquerJtfActualizar() {
        jtfIDCurso.setEnabled(false);
        jtfNivel.setEnabled(true);
        jtfObservacion.setEnabled(true);
        jtfNombre.setEnabled(true);
    }

    public void LimpiarJTF() {
        jtfNivel.setText("");
        jtfIDCurso.setText("");
        jtfObservacion.setText("");
        jtfNombre.setText("");
    }

    public void LeerDatosTabla() {
        jTableRegistros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (jTableRegistros.getSelectedRow() != -1) {
                    
                    jtfIDCurso.setText(jTableRegistros.getValueAt(jTableRegistros.getSelectedRow(), 0).toString());
                    jtfNombre.setText(jTableRegistros.getValueAt(jTableRegistros.getSelectedRow(), 1).toString());
                    jtfNivel.setText(jTableRegistros.getValueAt(jTableRegistros.getSelectedRow(), 2).toString());
                    jtfObservacion.setText(jTableRegistros.getValueAt(jTableRegistros.getSelectedRow(), 3).toString());
                    BloquearBotonesActualizar();
                    DesBloquerJtfActualizar();
                }
            }
        });
    }
    
     private void InsertarCurso() {
        if (jtfIDCurso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nro. de ID de Curso");
            jtfIDCurso.requestFocus();
        } else if (jtfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre");
            jtfNombre.requestFocus();
        } else if (jtfNivel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nivel");
            jtfNivel.requestFocus();
        } else {
            try {

                String idCurso = jtfIDCurso.getText();
                String nombre = jtfNombre.getText();
                String nivel = jtfNivel.getText();
                String observacion;
                if (jtfObservacion.getText().isEmpty()) {
                    observacion = "Sin observacion".toUpperCase();
                } else {
                    observacion = jtfObservacion.getText();
                }
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sqlIns = "";
                sqlIns = "insert into curso values(?,?,?,?)";
                PreparedStatement psd = cn.prepareStatement(sqlIns);
                psd.setString(1, idCurso);
                psd.setString(2, nombre);
                psd.setString(3, nivel);
                psd.setString(4, observacion);

                psd.executeUpdate();
                CargarTablaCursos("");
                JOptionPane.showMessageDialog(this, "Registro agregado exitosamente!");
                cn.close();
            } catch (Exception ex) {JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    DefaultTableModel dtm;

    public void CargarTablaCursos(String dato) {
        try {
            String[] registros = {"ID Curso", "Nombre", "Nivel", "Observacion"};
            String[] datos = new String[6];
            dtm = new DefaultTableModel(null, registros);

            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sqlIns = "select * from curso where cur_id LIKE '%" + dato + "%' order by cur_nivel ";
            java.sql.Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sqlIns);
            while (rs.next()) {
                datos[0] = rs.getString("cur_id");
                datos[1] = rs.getString("cur_nombre");
                datos[2] = rs.getString("cur_nivel");
                datos[3] = rs.getString("cur_obs");
                dtm.addRow(datos);
            }
            jTableRegistros.setModel(dtm);
        } catch (Exception ex) {JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarCursos() {
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sqlUpd = "";
            sqlUpd = "UPDATE curso SET cur_nivel='" + jtfNivel.getText()
                    + "', cur_nombre='" + jtfNombre.getText()
                    + "', cur_obs='" + jtfObservacion.getText()
                    + "' WHERE cur_id='" + jtfIDCurso.getText() + "';";
            PreparedStatement psd = cn.prepareStatement(sqlUpd);
            int n = psd.executeUpdate();
            CargarTablaCursos("");
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarCurso() {

        try {
            if (jTableRegistros.getSelectedRow() != -1
                    && JOptionPane.showConfirmDialog(this,
                            "Seguro que desea eliminar este registro?",
                            "Confirmar eliminar registro",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == 0) {
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sqlDel = "DELETE FROM curso WHERE cur_id='" + jtfIDCurso.getText() + "'";
                PreparedStatement psd = cn.prepareStatement(sqlDel);
                int n = psd.executeUpdate();
                CargarTablaCursos("");
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
