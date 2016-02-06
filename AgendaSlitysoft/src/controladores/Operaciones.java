package controladores;

import BD.Conexion;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JCalendar;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Date;

public class Operaciones extends Conexion {

    private String informacion = "";
    private String nombreCompleto;
    private String usuario;

    public void RegistrarUsuario(String nombre,
            String telefono,
            String celular,
            String correo,
            Date cumple,
            String Gustos,
            String usuario,
            String passUno,
            String passDos,
            String folio,
            String foto) throws SQLException, FileNotFoundException {

        FileInputStream archivoFoto;
        archivoFoto = new FileInputStream(foto);
        
        comprobarContrasenias comprobar = new comprobarContrasenias();

        if (comprobar.verificar(passUno, passDos)) {
            if (this.conectar()) {
                this.insertar("usuario",
                        " usuario,"
                        + "nombre_Completo_Usuario, "
                        + "email_usuario,"
                        + "telefono_usuario,"
                        + "celular_usuario,"
                        + "cumpleanios_usuario,"
                        + "gustos_usuario,"
                        + "password_usuario,"
                        + "folio_secreto,"
                       + "imagen_usuario"
                       ,"?,?,?,?,?,?,?,?,?,?");

                this.getActualizar().setString(1, usuario);
                this.getActualizar().setString(2, nombre);
                this.getActualizar().setString(3, correo);
                this.getActualizar().setString(4, telefono);
                this.getActualizar().setString(5, celular);
                this.getActualizar().setDate(6, new java.sql.Date(cumple.getTime()));
                this.getActualizar().setString(7, Gustos);
                this.getActualizar().setString(8, passUno);
                this.getActualizar().setString(9, folio);
                this.getActualizar().setBinaryStream(10, archivoFoto);//Enviamos foto
        

                this.getActualizar().executeUpdate();

                this.informacion = this.getMensaje();
                this.cerrarConexion();
            }
        } else {

            this.informacion = "Contraseñas diferentes, intentalo de nuevo";
        }

    }

    public boolean ValidarUsuario(String user, String pass) throws SQLException {

        boolean exito = false;

        if (this.conectar()) {
            this.obtenerDatos("select * from usuario where usuario = \"" + user + "\" and password_Usuario = \"" + pass + "\"");
            if (this.getDatos().next()) {
                this.informacion = this.getDatos().getString("nombre_completo_usuario");
                this.nombreCompleto = this.informacion;
                this.usuario = this.getDatos().getString("usuario");
                exito = true;
            } else {

                this.informacion = "Usuario o contraseña Incorrectos";
                exito = false;
            }
            this.cerrarConexion();
        } else {

            this.informacion = "Error al intentar conectar a la BD revise la conexion";
        }

        return exito;

    }

    public void RegistrarNuevoContacto(String nombre,
            String telefono,
            String celular,
            String correo,
            Date cumple,
            String gustos,
            String usuario,
            String usuarioEliminado
            ) throws SQLException {

        if (this.conectar()) {

            this.insertar("contacto",
                    "nombre_Completo_Contacto, "
                    + "telefono_Contacto,"
                    + "celular_Contacto,"
                    + "email_Contacto,"
                    + "cumpleanios_Contacto,"
                    + "gustos_Contacto,"
                    + " usuario_usuario,"
                    + "eliminado_contacto"
                      , "?,?,?,?,?,?,?,?");

            this.getActualizar().setString(1, nombre);
            this.getActualizar().setString(2, telefono);
            this.getActualizar().setString(3, celular);
            this.getActualizar().setString(4, correo);
            this.getActualizar().setDate(5, new java.sql.Date(cumple.getTime()));
            this.getActualizar().setString(6, gustos);
            this.getActualizar().setString(7, usuario);
            this.getActualizar().setString(8, usuarioEliminado);

//            
            this.getActualizar().executeUpdate();

            this.informacion = this.getMensaje();
            this.cerrarConexion();
        } else {

            this.informacion = "Error al intentar conectar a la BD revise la conexion";
        }

    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
