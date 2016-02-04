/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class comprobarContrasenias extends  JFrame implements ActionListener{

    public boolean verificar(String uno, String dos) {

        boolean exito = false;

        if (uno.equals(dos)) {
            exito = true;
        } else {
            exito = false;
        }

        return exito;

    }

    public void crear(){
      
//        JPanel panel = new JPanel();
//        JTextField[] n = new JTextField[4];
//         this.add(panel);
//           panel.setLayout(null);
//            setSize(500,500);
//         
//           
//        //    for (int j = 0; j < 1; j++) {
//                   n[0].setBounds(10,20,80,20);
//      
//       
//     
//      
//     
//        panel.add(n[0]);
         //   }
 JPanel panel = new JPanel();
        JTextField[] n = new JTextField[3];
        this.add(panel);
           panel.setLayout(null);
            setSize(500,500);
  //      for (int i = 0; i < 10; i++) {

         
     
         
        
         JPanel panel2 = new JPanel();
         panel2.setLayout(null);
            this.add(panel2);
           
      
                   n[1].setBounds(10,20,80,20);

        panel.add(n[1]);
             n[2].setBounds(20,30,60,30);

        panel2.add(n[2]);
       
     
      
     
       
        
      //  }
         this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
