/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaslitysoft;

import Vistas.jLogin;
import Vistas.jMenu;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AgendaSlitysoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        jLogin agenda =  new jLogin();
        agenda.setVisible(true);
        jMenu m = new jMenu();
        m.setVisible(true);
      
        
    }
    
}
