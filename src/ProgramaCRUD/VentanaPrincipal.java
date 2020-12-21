/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaCRUD;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author stee-
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     *
     * @param tipouser
     */
    public VentanaPrincipal(String tipouser) {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("wb.png")));
        jdpVentanaPrincipal.setBorder(new ImagenFondo());
        this.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH); 
        CambioPorTipoUser(tipouser);
        AgregarVentanas();
        setExtendedState(MAXIMIZED_BOTH);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpVentanaPrincipal = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jToggleButton1 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVentanas = new javax.swing.JMenu();
        jMenuItemEstudiantes = new javax.swing.JMenuItem();
        jMenuItemCursos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        repote_porTodosEstudiantes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        reporte_porGenero = new javax.swing.JMenuItem();
        reporte_porEstadoCivil = new javax.swing.JMenuItem();
        reporte_porCurso = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenu();
        jMenuItemCerrarSesion = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCerrarPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana principal - Registro estudiantes");

        jInternalFrame1.setVisible(false);

        jToggleButton1.setText("jToggleButton1");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(317, 317, 317))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdpVentanaPrincipal.setLayer(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpVentanaPrincipalLayout = new javax.swing.GroupLayout(jdpVentanaPrincipal);
        jdpVentanaPrincipal.setLayout(jdpVentanaPrincipalLayout);
        jdpVentanaPrincipalLayout.setHorizontalGroup(
            jdpVentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpVentanaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(894, Short.MAX_VALUE))
        );
        jdpVentanaPrincipalLayout.setVerticalGroup(
            jdpVentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpVentanaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(642, Short.MAX_VALUE))
        );

        jMenuVentanas.setText("Ventanas");
        jMenuVentanas.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        jMenuItemEstudiantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemEstudiantes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jMenuItemEstudiantes.setText("Estudiantes");
        jMenuItemEstudiantes.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItemEstudiantesMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuItemEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstudiantesActionPerformed(evt);
            }
        });
        jMenuVentanas.add(jMenuItemEstudiantes);

        jMenuItemCursos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCursos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jMenuItemCursos.setText("Cursos");
        jMenuItemCursos.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItemCursosMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuItemCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCursosActionPerformed(evt);
            }
        });
        jMenuVentanas.add(jMenuItemCursos);
        jMenuVentanas.add(jSeparator2);

        jMenuItemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemUsuarios.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jMenuItemUsuarios.setText("Usuarios");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuItemUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItemUsuariosKeyPressed(evt);
            }
        });
        jMenuVentanas.add(jMenuItemUsuarios);

        jMenuBar1.add(jMenuVentanas);

        jMenuReportes.setText("Reportes");
        jMenuReportes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        repote_porTodosEstudiantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        repote_porTodosEstudiantes.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        repote_porTodosEstudiantes.setText("Todos los estudiantes");
        repote_porTodosEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repote_porTodosEstudiantesActionPerformed(evt);
            }
        });
        jMenuReportes.add(repote_porTodosEstudiantes);
        jMenuReportes.add(jSeparator1);

        reporte_porGenero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        reporte_porGenero.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        reporte_porGenero.setText("Estudiantes por genero");
        reporte_porGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporte_porGeneroActionPerformed(evt);
            }
        });
        jMenuReportes.add(reporte_porGenero);

        reporte_porEstadoCivil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        reporte_porEstadoCivil.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        reporte_porEstadoCivil.setText("Estudiantes por estado civil");
        reporte_porEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporte_porEstadoCivilActionPerformed(evt);
            }
        });
        jMenuReportes.add(reporte_porEstadoCivil);

        reporte_porCurso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        reporte_porCurso.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        reporte_porCurso.setText("Estudiantes por curso");
        reporte_porCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporte_porCursoActionPerformed(evt);
            }
        });
        jMenuReportes.add(reporte_porCurso);

        jMenuBar1.add(jMenuReportes);

        jMenuSalir.setText("Salir");
        jMenuSalir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });

        jMenuItemCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCerrarSesion.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jMenuItemCerrarSesion.setText("Cerrar Sesión");
        jMenuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarSesionActionPerformed(evt);
            }
        });
        jMenuSalir.add(jMenuItemCerrarSesion);
        jMenuSalir.add(jSeparator3);

        jMenuItemCerrarPrograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCerrarPrograma.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jMenuItemCerrarPrograma.setText("Cerrar Programa");
        jMenuItemCerrarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarProgramaActionPerformed(evt);
            }
        });
        jMenuSalir.add(jMenuItemCerrarPrograma);

        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpVentanaPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpVentanaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstudiantesActionPerformed
        // TODO add your handling code here:
        AbrirVentanaEstudiantes();
    }//GEN-LAST:event_jMenuItemEstudiantesActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesionActionPerformed
        // TODO add your handling code here:
        CerrarSesion();
    }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

    private void jMenuItemCerrarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarProgramaActionPerformed
        // TODO add your handling code here:
        SalirPrograma();
    }//GEN-LAST:event_jMenuItemCerrarProgramaActionPerformed

    private void jMenuItemCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCursosActionPerformed
        // TODO add your handling code here:
        AbrirVentanaCursos();
    }//GEN-LAST:event_jMenuItemCursosActionPerformed

    private void jMenuItemCursosMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItemCursosMenuKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItemCursosMenuKeyPressed

    private void jMenuItemEstudiantesMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItemEstudiantesMenuKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItemEstudiantesMenuKeyPressed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        // TODO add your handling code here:
        AbrirVentanaUsuarios();
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItemUsuariosKeyPressed

    private void repote_porTodosEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repote_porTodosEstudiantesActionPerformed
        // TODO add your handling code here:
        iniciarReporteTodosLosEstudiantes();
    }//GEN-LAST:event_repote_porTodosEstudiantesActionPerformed

    private void reporte_porGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporte_porGeneroActionPerformed
        // TODO add your handling code here:
        iniciarReportePorGenero();
    }//GEN-LAST:event_reporte_porGeneroActionPerformed

    private void reporte_porEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporte_porEstadoCivilActionPerformed
        // TODO add your handling code here:
        iniciarReportePorEstadoCivil();
    }//GEN-LAST:event_reporte_porEstadoCivilActionPerformed

    private void reporte_porCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporte_porCursoActionPerformed
        // TODO add your handling code here:
        iniciarReportePorCurso();
    }//GEN-LAST:event_reporte_porCursoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCerrarPrograma;
    private javax.swing.JMenuItem jMenuItemCerrarSesion;
    private javax.swing.JMenuItem jMenuItemCursos;
    private javax.swing.JMenuItem jMenuItemEstudiantes;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JMenu jMenuVentanas;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JDesktopPane jdpVentanaPrincipal;
    private javax.swing.JMenuItem reporte_porCurso;
    private javax.swing.JMenuItem reporte_porEstadoCivil;
    private javax.swing.JMenuItem reporte_porGenero;
    private javax.swing.JMenuItem repote_porTodosEstudiantes;
    // End of variables declaration//GEN-END:variables

    InterfazEstudiantes ie = new InterfazEstudiantes();
    InterfazCursos ic = new InterfazCursos();
    InterfazUsuarios iu = new InterfazUsuarios();
    ReportePorCurso rpc = new ReportePorCurso();
    ReportePorGenero rpg = new ReportePorGenero();
    ReportePorEstadoCivil rpec = new ReportePorEstadoCivil();
    ReporteTodosLosEstudiantes rpte = new ReporteTodosLosEstudiantes();

    private void AgregarVentanas() {
        jdpVentanaPrincipal.add(ie);
        jdpVentanaPrincipal.add(iu);
        jdpVentanaPrincipal.add(ic);
        jdpVentanaPrincipal.add(rpc);
        jdpVentanaPrincipal.add(rpg);
        jdpVentanaPrincipal.add(rpec);
        jdpVentanaPrincipal.add(rpte);
    }

    public void CambioPorTipoUser(String tipouser) {
        if (!tipouser.equals("admin")) {
            jMenuReportes.setEnabled(false);
            jMenuItemUsuarios.setEnabled(false);
        }
    }

    private void iniciarReporteTodosLosEstudiantes() {
        if (!rpte.isVisible()) {
            rpte.setSize(jdpVentanaPrincipal.getWidth()-200,jdpVentanaPrincipal.getHeight()-100);
            rpte.setLocation((jdpVentanaPrincipal.getWidth() - rpte.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpte.getHeight()) / 2);
            rpte.setVisible(true);
        } else {
            rpte.setLocation((jdpVentanaPrincipal.getWidth() - rpte.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpte.getHeight()) / 2);
            rpte.moveToFront();
        }
    }

    private void iniciarReportePorEstadoCivil() {
        if (!rpec.isVisible()) {
            rpec.setSize(jdpVentanaPrincipal.getWidth()-200,jdpVentanaPrincipal.getHeight()-100);
            rpec.setLocation((jdpVentanaPrincipal.getWidth() - rpec.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpec.getHeight()) / 2);
            rpec.setVisible(true);
        } else {
            rpec.setLocation((jdpVentanaPrincipal.getWidth() - rpec.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpec.getHeight()) / 2);
            rpec.moveToFront();
        }
    }

    private void iniciarReportePorGenero() {
        if (!rpg.isVisible()) {
            rpg.setSize(jdpVentanaPrincipal.getWidth()-200,jdpVentanaPrincipal.getHeight()-100);
            rpg.setLocation((jdpVentanaPrincipal.getWidth() - rpg.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpg.getHeight()) / 2);
            rpg.setVisible(true);
        } else {
            rpg.setLocation((jdpVentanaPrincipal.getWidth() - rpg.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpg.getHeight()) / 2);
            rpg.moveToFront();
        }

    }

    private void iniciarReportePorCurso() {
        if (!rpc.isVisible()) {
            rpc.setSize(jdpVentanaPrincipal.getWidth()-200,jdpVentanaPrincipal.getHeight()-100);
            rpc.setLocation((jdpVentanaPrincipal.getWidth() - rpc.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpc.getHeight()) / 2);
            rpc.setVisible(true);
        } else {
            rpc.setLocation((jdpVentanaPrincipal.getWidth() - rpc.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - rpc.getHeight()) / 2);
            rpc.moveToFront();
        }

    }

    private void AbrirVentanaUsuarios() {
        
        if (!iu.isVisible()) {
            iu.setLocation((jdpVentanaPrincipal.getWidth() - iu.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - iu.getHeight()) / 2);
            iu.setVisible(true);
            iu.setTitle("Interfaz Usuarios");
        } else {
            iu.setLocation((jdpVentanaPrincipal.getWidth() - iu.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - iu.getHeight()) / 2);
            iu.moveToFront();
        }
    }

    private void AbrirVentanaCursos() {
        if (!ic.isVisible()) {
            ic.setLocation((jdpVentanaPrincipal.getWidth() - ic.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - ic.getHeight()) / 2);
            ic.setVisible(true);
            ic.setTitle("Interfaz Cursos");
        } else {
            ic.setLocation((jdpVentanaPrincipal.getWidth() - ic.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - ic.getHeight()) / 2);
            ic.moveToFront();
        }
    }

    private void AbrirVentanaEstudiantes() {

        if (!ie.isVisible()) {

            ie.setLocation((jdpVentanaPrincipal.getWidth() - ie.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - ie.getHeight()) / 2);
            ie.setVisible(true);
            ie.setTitle("Interfaz Estudiantes");
        } else {
            ie.setLocation((jdpVentanaPrincipal.getWidth() - ie.getWidth()) / 2,
                    (jdpVentanaPrincipal.getHeight() - ie.getHeight()) / 2);
            ie.moveToFront();
        }
    }

    private void CerrarSesion() {
        if (JOptionPane.showConfirmDialog(this,
                "¿Realmente Desea Cerrar La Sesión?",
                "Cerrar Sesión",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {
            LoginCRUD login = new LoginCRUD();
            login.setVisible(true);
            this.dispose();
        }
    }

    private void SalirPrograma() {
        if (JOptionPane.showConfirmDialog(this,
                "¿Realmente Desea Salir Del Programa? "
                + "\n\nNota: Esto Cerrará Todas Las Ventanas Y Procesos",
                "Cerrar Programa",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0) {
            System.exit(0);
        }
    }

}
