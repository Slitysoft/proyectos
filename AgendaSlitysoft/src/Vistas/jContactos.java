package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class jContactos extends javax.swing.JFrame {

    private int maxContactos = 10;

    JButton btn;
    JTextField[] txtContacto;
    JLabel[] labelContacto;
    JPanel panelInterno;
    JPanel panelDos;
    JPanel panelTres;
    JPanel panelCuatro;

    JPanel[] contacto;

    public jContactos() {

        txtContacto = new JTextField[maxContactos];
        labelContacto = new JLabel[5];
        contacto = new JPanel[maxContactos];

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        p = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        scroll.setViewportView(p);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int altoPanel = 50;//200 es el valor inicial
        int ancho = 500;
        int izquierda = 10;
        int posicionActual = 10;
        int espacioEntrePanel = 10;
        int altoScroll = 0;

        for (int i = 0; i < maxContactos; i++) {
 posicionActual = 10 * (i) + (altoPanel)*(i) + espacioEntrePanel;
            contacto[i] = new JPanel();
            if(i%2 == 0)
            contacto[i].setBackground(Color.CYAN);
            else
                 contacto[i].setBackground(Color.PINK);
            
            contacto[i].setBounds(izquierda, posicionActual, ancho, altoPanel);
            contacto[i].setLayout(null);
            
            txtContacto[i] = new JTextField();
             txtContacto[i].setBounds(new Rectangle(100, 30, 60, 25));
             txtContacto[i].setText(i + "");
             contacto[i].add(txtContacto[i]);
              p.add(contacto[i]);
        }
        altoScroll = posicionActual + altoPanel +espacioEntrePanel;
         p.setPreferredSize(new Dimension(100, altoScroll));//ancho //alto que obtenos del ultimo jpanelCreado

       
//        panelInterno = new JPanel();
//        panelInterno.setBpound(Color.red);
//        //despegado de el lado izquierdo
//        //despegado de arriba
//        panelInterno.setBounds(10, 10, 500, 200);
//        panelInterno.setLayout(null);
//        
//         for (int i = 0; i < 5; i++) {
//            txtContacto[i] = new JTextField();
//             labelContacto[i] = new JLabel();
//             if(i == 0){
//            txtContacto[i].setText("Nombre ");
//            labelContacto[i].setText("Nombre");
//             }
//             if(i == 1){
//            txtContacto[i].setText("Tel ");
//            labelContacto[i].setText("Tel");
//             }
//            if(i == 2){
//            txtContacto[i].setText("Cel");
//            labelContacto[i].setText("Cel");
//             }
//             if(i == 3){
//            txtContacto[i].setText("email ");
//            labelContacto[i].setText("email");
//             }
//              if(i == 4){
//            txtContacto[i].setText("tipo");
//            labelContacto[i].setText("tipo");
//             }
//            txtContacto[i].setBounds(new Rectangle(100, (i + 1) * 30, 60, 25));
//             labelContacto[i].setBounds(new Rectangle(25, (i + 1) * 30, 60, 25));
//            
//             panelInterno.add(labelContacto[i]);
//             panelInterno.add(txtContacto[i]);
//
//        }
//         
//           this.add(panelInterno);
//
//        panelDos = new JPanel();
//        panelDos.setBackground(Color.BLUE);
//        //despegado de el lado izquierdo
//        //despegado de arriba
//        panelDos.setBounds(10,220, 200, 200);
//        panelDos.setLayout(null);
//        txtContacto[0] = new JTextField();
//
//        for (int i = 0; i < 5; i++) {
//            txtContacto[i] = new JTextField();
//            if(i == 0)
//            txtContacto[i].setText("Nombre ");
//             if(i == 1)
//            txtContacto[i].setText("Tel ");
//             if(i == 2)
//            txtContacto[i].setText("Cel ");
//             if(i == 3)
//            txtContacto[i].setText("Email ");
//             if(i == 4)
//            txtContacto[i].setText("Tipo ");
//            txtContacto[i].setBounds(new Rectangle(25, (i + 1) * 30, 60, 25));
//            panelDos.add(txtContacto[i]);
//
//        }
//         
//           this.add(panelDos);
//       
//       
//           panelTres = new JPanel();
//        panelTres.setBackground(Color.GREEN);
//        //despegado de el lado izquierdo
//        //despegado de arriba
//        panelTres.setBounds(10,430, 200, 200);
//        panelTres.setLayout(null);
//        txtContacto[0] = new JTextField();
//
//        for (int i = 0; i < 5; i++) {
//            txtContacto[i] = new JTextField();
//            if(i == 0)
//            txtContacto[i].setText("Nombre ");
//             if(i == 1)
//            txtContacto[i].setText("Tel ");
//             if(i == 2)
//            txtContacto[i].setText("Cel ");
//             if(i == 3)
//            txtContacto[i].setText("Email ");
//             if(i == 4)
//            txtContacto[i].setText("Tipo ");
//            txtContacto[i].setBounds(new Rectangle(25, (i + 1) * 30, 60, 25));
//           panelTres.add(txtContacto[i]);
//
//           
//           
//        }
//         
//           this.add(panelTres);
//
//           panelCuatro = new JPanel();
//       panelCuatro.setBackground(Color.CYAN);
//        //despegado de el lado izquierdo
//        //despegado de arriba
//        panelCuatro.setBounds(10,640, 200, 200);
//        panelCuatro.setLayout(null);
//        txtContacto[0] = new JTextField();
//
//        for (int i = 0; i < 5; i++) {
//            txtContacto[i] = new JTextField();
//            if(i == 0)
//            txtContacto[i].setText("Nombre ");
//             if(i == 1)
//            txtContacto[i].setText("Tel ");
//             if(i == 2)
//            txtContacto[i].setText("Cel ");
//             if(i == 3)
//            txtContacto[i].setText("Email ");
//             if(i == 4)
//            txtContacto[i].setText("Tipo ");
//            txtContacto[i].setBounds(new Rectangle(25, (i + 1) * 30, 60, 25));
//           panelCuatro.add(txtContacto[i]);
//
//        }
//         
//           this.add(panelCuatro);
//           p.setPreferredSize(new Dimension(100, 850));//ancho //largo que obtenos del ultimo jpanelCreado
//          
//           p.add(panelInterno);
//           p.add(panelDos);
//           p.add(panelTres);
//           p.add(panelCuatro);

    }//GEN-LAST:event_jButton1ActionPerformed

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
                new jContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel p;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
