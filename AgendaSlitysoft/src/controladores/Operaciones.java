/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import BD.Conexion;
import java.sql.SQLException;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Operaciones extends Conexion {

    private String informacion = "";

    public void RegistrarUsuario(String nombre,
            String telefono,
            String celular,
            String correo,
            String cumple,
            String Gustos,
            String usuario,
            String passUno,
            String passDos,
            String folio,
            String foto) throws SQLException {

        comprobarContrasenias comprobar = new comprobarContrasenias();

        if (comprobar.verificar(passUno, passDos)) {
            this.conectar();
            this.insertar("usuario",
                    " usuario,"
                    + "nombre_Completo_Usuario, "
                    + "email_usuario,"
                    + "telefono_usuario,"
                    + "celular_usuario,"
                    + "cumpleanios_usuario,"
                    + "gustos_usuario,"
                    + "password_usuario,"
                    + "folio_secreto "
                    + "foto_usuario", "?,?,?,?,?,?,?,?,?,?");

            this.getActualizar().setString(1, usuario);
            this.getActualizar().setString(2, nombre);
            this.getActualizar().setString(3, correo);
            this.getActualizar().setString(4, telefono);
            this.getActualizar().setString(5, celular);
            this.getActualizar().setDate(6, new java.sql.Date(1992 - 1608));
            this.getActualizar().setString(7, Gustos);
            this.getActualizar().setString(8, passUno);
            this.getActualizar().setString(9, folio);
            this.getActualizar().setString(10, foto);

            this.getActualizar().executeUpdate();
            this.cerrarConexion();
            this.informacion = this.getMensaje();
        } else {

            this.informacion = "Contraseñas diferentes, intentalo de nuevo";
        }

    }

    public boolean ValidarUsuario(String user, String pass) throws SQLException {

        boolean exito = false;

        if (this.conectar()) {
            this.obtenerDatos("select * from usuario where usuario = \"" + user + "\" and password_Usuario = \"" + pass + "\"");
            if (this.getDatos().next()) {
                this.informacion = "Bienvenido " + this.getDatos().getString("nombre_completo_usuario");
            } else {

                this.informacion = "Usuario o contraseña Incorrectos";
            }
            this.cerrarConexion();
        }

        return exito;

    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

}
