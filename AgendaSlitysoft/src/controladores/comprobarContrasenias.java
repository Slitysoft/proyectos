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
public class comprobarContrasenias {

    public boolean verificar(String uno, String dos) {

        boolean exito = false;

        if (uno.equals(dos)) {
            exito = true;
        } else {
            exito = false;
        }

        return exito;

    }

 
}

