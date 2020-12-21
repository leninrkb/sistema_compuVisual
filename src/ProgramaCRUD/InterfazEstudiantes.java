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
import java.sql.Statement;
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
public final class InterfazEstudiantes extends javax.swing.JInternalFrame {

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
        Cargar_Dir_Est();
        cargarCursos();
        
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
        jComboBox_Direccion.setEnabled(false);
        jtfNombre.setEnabled(false);
        jcbECivil.setEnabled(false);
        jrbMasculino.setEnabled(false);
        jrbFemenino.setEnabled(false);
        jComboBox1_curso.setEnabled(false);
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
        jComboBox_Direccion.setEnabled(true);
        jtfNombre.setEnabled(true);
        jcbECivil.setEnabled(true);
        jrbMasculino.setEnabled(true);
        jrbFemenino.setEnabled(true);
        jComboBox1_curso.setEnabled(true);
    }

    public void DesBloquerJtfActualizar(){
        jtfCedula.setEnabled(false);
        jtfApellido.setEnabled(true);
        jComboBox_Direccion.setEnabled(true);
        jtfNombre.setEnabled(true);
        jcbECivil.setEnabled(true);
        jrbMasculino.setEnabled(true);
        jrbFemenino.setEnabled(true);
        jComboBox1_curso.setEnabled(true);
    }

    public void LimpiarJTF() {
        jtfApellido.setText("");
        jtfCedula.setText("");
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
                    jComboBox_Direccion.setSelectedItem(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 3).toString());
                    jcbECivil.setSelectedItem(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 4).toString());
                    jComboBox1_curso.setSelectedItem(jTableRegistrosEstudiantes.getValueAt(jTableRegistrosEstudiantes.getSelectedRow(), 6).toString());
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

    public void cargarCursos() {
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sqlIns = "select * from curso ";
            java.sql.Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sqlIns);
            DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
            jComboBox1_curso.setModel(dcbm);
            while (rs.next()) {
                jComboBox1_curso.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }
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

    public void Cargar_Dir_Est() {
        try {
            jComboBox_Direccion.removeAllItems();
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sql = " ";
            sql = "select * from direccion";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);

            while (rs.next()) {
                jComboBox_Direccion.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
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
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
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
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbECivil = new javax.swing.JComboBox<>();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFemenino = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox_Direccion = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1_curso = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Ingrese La Cédula:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese El Nombre:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Ingrese El Apellido:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Seleccione La Dirección:");

        jtfCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCedulaActionPerformed(evt);
            }
        });
        jtfCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCedulaKeyTyped(evt);
            }
        });

        jtfNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNombreMouseClicked(evt);
            }
        });
        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreKeyTyped(evt);
            }
        });

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Buscar Por Cédula:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Seleccione El Estado Civil:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Seleccione El Sexo:");

        jcbECivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbECivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbECivilActionPerformed(evt);
            }
        });

        buttonGroupSexo.add(jrbMasculino);
        jrbMasculino.setText("MASCULINO");
        jrbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMasculinoActionPerformed(evt);
            }
        });

        buttonGroupSexo.add(jrbFemenino);
        jrbFemenino.setText("FEMENINO");

        jComboBox_Direccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Seleccione el curso:");

        jComboBox1_curso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbFemenino)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox1_curso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbECivil, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfCedula, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_Direccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(105, 105, 105))))))
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
                    .addComponent(jComboBox_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbECivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jrbMasculino)
                    .addComponent(jrbFemenino))
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbNuevo.setText("NUEVO");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbActualizar.setText("ACTUALIZAR");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbCancelar.setText("CANCELAR");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbSalir.setText("CERRAR");
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
                    .addComponent(jbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalir))
                .addGap(25, 25, 25))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jtfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCedulaActionPerformed

    private void jtfCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCedulaKeyTyped
        // TODO add your handling code here:
        int ced = 10;
        if (jtfCedula.getText().length() == ced) {
            evt.consume();
        }
        char caracter = evt.getKeyChar();

        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCedulaKeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        int ced = 10;
        if (jTextField1.getText().length() == ced) {
            evt.consume();
        }
        char caracter = evt.getKeyChar();

        if (caracter < '0' || caracter > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNombreKeyTyped

    private void jtfApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();

        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfApellidoKeyTyped

    private void jtfNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNombreMouseClicked
        // TODO add your handling code here:
        int ced = 10;
        if (jtfCedula.getText().length() < ced) {
            JOptionPane.showMessageDialog(this, "La Cédula Debe Tener 10 Dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jtfCedula.requestFocus();
        }
    }//GEN-LAST:event_jtfNombreMouseClicked

    private void jrbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbMasculinoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JComboBox<String> jComboBox1_curso;
    private javax.swing.JComboBox jComboBox_Direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
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
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables


    /*
     1.  conectar BDD
     2.  Crear sentencia SQL
     4.  Preparar sentencia SQL (PreparedStatement)(insert,update,delete)   calledStatement(plsql)    Statement(select (solo consulta))
     5.  Ejecutar Statement
     */
    private void InsertarEstudiante() {
        int ced = 10;
        if (jtfCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese El Nro. De Cédula", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jtfCedula.requestFocus();
        } else if (jtfCedula.getText().length() < ced) {
            JOptionPane.showMessageDialog(this, "La Cédula Debe Tener 10 Dígitos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jtfCedula.requestFocus();

        } else if (jtfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese El Nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jtfNombre.requestFocus();
        } else if (jtfApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese El Apellido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            jtfApellido.requestFocus();
        } else {
            try {

                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sqlselect = "select cur_id from curso where cur_nombre ='"+jComboBox1_curso.getSelectedItem().toString().toUpperCase()+"'";
                java.sql.Statement psd1 = cn.createStatement();
                ResultSet rs = psd1.executeQuery(sqlselect);
                String curso ="";
                while (rs.next()) {
                    curso = rs.getString(1);
                }
                String cedula = jtfCedula.getText();
                String nombre = jtfNombre.getText().toUpperCase();
                String apellido = jtfApellido.getText().toUpperCase();
                String direccion = jComboBox_Direccion.getSelectedItem().toString();
                String estcivil = jcbECivil.getSelectedItem().toString().toUpperCase();
                
                String sexo;
                if (jrbMasculino.isSelected()) {
                    sexo = jrbMasculino.getText();
                } else {
                    sexo = jrbFemenino.getText();
                }
              
                String sqlIns = "";
                sqlIns = "insert into estudiantes values(?,?,?,?,?,?,?)";
                PreparedStatement psd = cn.prepareStatement(sqlIns);
                psd.setString(1, cedula);
                psd.setString(2, nombre);
                psd.setString(3, apellido);
                psd.setString(4, direccion);
                psd.setString(5, estcivil);
                psd.setString(6, sexo);
                psd.setString(7, curso);

                psd.executeUpdate();
                CargarTablaEstudiantes("");
                LimpiarJTF();
                JOptionPane.showMessageDialog(this, "¡ Registro Agregado Exitosamente !");
                cn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    DefaultTableModel dtm;

    public void CargarTablaEstudiantes(String dato) {
        try {
            String[] registros = {"CÉDULA", "NOMBRE", "APELLIDO", "DIRECCIÓN", "EST. CIVIL", "SEXO", "CURSO"};
            String[] datos = new String[7];
            dtm = new DefaultTableModel(null, registros);

            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            String sqlIns = "select * from estudiantes e, curso c where e.EST_CEDULA LIKE '%" + dato + "%' and c.cur_id = e.cur_id group by est_cedula";
            java.sql.Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sqlIns);
            while (rs.next()) {
                datos[0] = rs.getString("e.EST_CEDULA");
                datos[1] = rs.getString("e.EST_NOMBRE");
                datos[2] = rs.getString("e.EST_APELLIDO");
                datos[3] = rs.getString("e.EST_DIRECCION");
                datos[4] = rs.getString("e.EST_CIVIL");
                datos[5] = rs.getString("e.EST_SEXO");
                datos[6] = rs.getString("c.cur_nombre");
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
                String sqlselect = "select cur_id from curso where cur_nombre ='"+jComboBox1_curso.getSelectedItem().toString().toUpperCase()+"'";
                java.sql.Statement psd1 = cn.createStatement();
                ResultSet rs = psd1.executeQuery(sqlselect);
                String curso ="";
                while (rs.next()) {
                    curso = rs.getString(1);
                }
            String sqlUpd = "";
            String sexo;
            if (jrbMasculino.isSelected()) {
                sexo = jrbMasculino.getText();
            } else {
                sexo = jrbFemenino.getText();
            }
            System.out.println(curso);
            sqlUpd = "UPDATE ESTUDIANTES SET EST_APELLIDO='" + jtfApellido.getText().toUpperCase()
                    + "', EST_NOMBRE='" + jtfNombre.getText().toUpperCase()
                    + "', EST_DIRECCION='" + jComboBox_Direccion.getSelectedItem()
                    + "', EST_CIVIL='" + jcbECivil.getSelectedItem().toString().toUpperCase()
                    + "', EST_SEXO='" + sexo
                    + "', cur_id='" + curso
                    + "' WHERE EST_CEDULA='" + jtfCedula.getText() + "';";
            PreparedStatement psd = cn.prepareStatement(sqlUpd);
            int n = psd.executeUpdate();
            CargarTablaEstudiantes("");
            BloquearBotonesInicio();
            BloquerJtfInicio();
            LimpiarJTF();
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "¡ Datos Actualizados Correctamente !");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, title, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarEstudiante() {

        try {
            if (jTableRegistrosEstudiantes.getSelectedRow() != -1
                    && JOptionPane.showConfirmDialog(this,
                            "¿Realmente Desea Eliminar Este Estudiante?",
                            "Confirmar Eliminar Estudiante",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == 0) {
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String sqlDel = "DELETE FROM ESTUDIANTES WHERE EST_CEDULA='" + jtfCedula.getText() + "'";
                PreparedStatement psd = cn.prepareStatement(sqlDel);
                int n = psd.executeUpdate();
                CargarTablaEstudiantes("");
                if (n > 0) {
                    JOptionPane.showMessageDialog(this, "¡ Estudiante Eliminado Exitosamente !");
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
