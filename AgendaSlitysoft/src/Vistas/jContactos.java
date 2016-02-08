package Vistas;

import BD.Conexion;
import CargarImagenes.Imagen;
import controladores.Cifrado;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class jContactos extends javax.swing.JFrame {

    private String nombreCompletoUsuario;
    private String usuario;

    /////////
    private int maxContactos = 10;

    JLabel labelContacto;

    JButton[] btnModificar;
    JButton[] btnEliminar;

    Imagen imagen;
    //JPanel[] contacto;
    JPanel contacto;

    public jContactos(String nombre, String User) {

        labelContacto = new JLabel();
        //    contacto = new JPanel[maxContactos];
        contacto = new JPanel();

        btnEliminar = new JButton[maxContactos];
        btnModificar = new JButton[maxContactos];
        imagen = new Imagen();
        this.usuario = User;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        p = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        scroll.setViewportView(p);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnActualizar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        int altoPanel = 100;//200 es el valor inicial
        int ancho = 500;
        int izquierda = 10;
        int posicionActual = 10;
        int espacioEntrePanel = 10;
        int altoScroll = 0;

        p.repaint();
        scroll.repaint();
        this.repaint();

        Cifrado decifrar = new Cifrado();
        Conexion conexion = new Conexion();
        conexion.conectar();
        try {
            conexion.obtenerDatos("SELECT *\n" + "FROM contacto where usuario_usuario = \"" + decifrar.Cifrar(usuario, 3) + "\"");
        } catch (SQLException ex) {
            Logger.getLogger(jContactos.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
        try {
            while (conexion.getDatos().next()) {

                posicionActual = 10 * (i) + (altoPanel) * (i) + espacioEntrePanel;
                contacto = new JPanel();
                if (i % 2 == 0) {
                    contacto.setBackground(Color.CYAN);
                } else {
                    contacto.setBackground(Color.PINK);
                }

                contacto.setBounds(izquierda, posicionActual, ancho, altoPanel);
                contacto.setLayout(null);

                for (int j = 0; j < 3; j++) {

                    labelContacto = new JLabel();
                    if (j == 0) {

                        labelContacto.setText(decifrar.Descifrar(conexion.getDatos().getString("nombre_completo_contacto"), 3));
                    }
                    if (j == 1) {

                        labelContacto.setText(decifrar.Descifrar(conexion.getDatos().getString("telefono_contacto"), 3));
                    }
                    if (j == 2) {

                        labelContacto.setText(decifrar.Descifrar(conexion.getDatos().getString("celular_contacto"), 3));
                    }

                    labelContacto.setBounds(new Rectangle(100, (j + 1) * 20, 200, 25));

                    contacto.add(labelContacto);

                }

                btnModificar[i] = new JButton();
                btnModificar[i].setText("Modificar");
                btnModificar[i].setBounds(300, 60, 80, 25);

                btnEliminar[i] = new JButton();
                btnEliminar[i].setText("Eliminar");
                btnEliminar[i].setBounds(400, 60, 80, 25);

                imagen = new Imagen();
                imagen.setBackground(Color.GRAY);
                imagen.setBounds(10, 10, 80, 80);

                contacto.add(imagen);
                contacto.add(btnModificar[i]);
                contacto.add(btnEliminar[i]);

                p.add(contacto);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(jContactos.class.getName()).log(Level.SEVERE, null, ex);
        }
        altoScroll = posicionActual + altoPanel + espacioEntrePanel;

        p.setPreferredSize(new Dimension(100, altoScroll));
        this.scroll.repaint();
        p.repaint();
        this.repaint();


    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(jContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new jContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel p;
    public javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    private void Graphics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
