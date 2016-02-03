/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

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
