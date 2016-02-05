package BD;

import java.sql.*;

public class Conexion {

    static private String nombreDB = "bdAgenda";
    static private String nombreUsuario = "root";
    static private String contrasenia = "";
    private String mensaje = "DISCULPE, NO TENGO MENSAJES PARA MOSTRARLE";

    ResultSet datos;
    static Connection con;
    PreparedStatement actualizar;

    public boolean conectar() {

        boolean exito = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + nombreDB, nombreUsuario, contrasenia);

            mensaje = "Conexion exitosa";
            exito = true;

        } catch (SQLException e) {

            mensaje = "Verifica tu servidor tienes el siguiente error: \n" + e.getMessage();
            exito = false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            mensaje = "Verifica tu servidor tienes el siguiente error: \n" + e.getMessage();
            exito = false;
        } catch (Exception e) {
            exito = false;
            mensaje = "Verifica tu servidor tienes el siguiente error: \n" + e.getMessage();

        }

        return exito;
    }

    public void obtenerDatos(String query) throws SQLException { //Esta encargado de mostrar los datos 

        Statement estado = con.createStatement();
        datos = estado.executeQuery(query);

    }

    public void insertar(String nombreTabla, String campos, String signosDeCampos) throws SQLException { ////se encarga de insertar datos a una bd recibiendo los siguientes parametros

        try {
            String queryAgregar = "INSERT INTO " + nombreTabla + "(" + campos + ")VALUES(" + signosDeCampos + ")";
            actualizar = con.prepareStatement(queryAgregar);

//INSERT INTO nombreTabla (campo1,campo2 )VALUES(?,? ) //EJEMPLO
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                mensaje = "clave repetida " + ex.getMessage();
            } else {
                mensaje = "ERROR al intentar agregar datos: \n" + ex.getMessage();
            }

            mensaje = "ERROR al intentar agregar datos: \n" + ex.getMessage();
        } catch (Exception e) {
            mensaje = "ERROR al intentar agregar datos: \n" + e.getMessage();;
        } catch (ExceptionInInitializerError e) {
            mensaje = "ERROR al intentar agregar datos: \n" + e.getMessage();
        }

    }

    public void actualizar(String tabla, String campoValor, String sentenciaWhere) throws SQLException {
        //Es importante no omitir \" cuando se requiera poner un valor por lo regular se utiliza cuando es necesario

        actualizar = con.prepareStatement("UPDATE " + tabla + " " + "SET " + campoValor + " " + "WHERE " + sentenciaWhere);

        int n = actualizar.executeUpdate();

        if (n == 1) {
            mensaje = "Actualizado con exito";
        } else if (n != 1) {
            mensaje = "Error al actualizar";
        }

    }

    public void eliminar(String tabla, String campoValor) throws SQLException {

        //Es importante no omitir \" cuando se requiera poner un valor por lo regular se utiliza cuando es necesario
        actualizar = con.prepareStatement("DELETE FROM " + tabla + " " + "WHERE " + campoValor);

        int n = actualizar.executeUpdate();

        if (n == 1) {
            mensaje = "Eliminado con exito";
        } else if (n != 1) {
            mensaje = "Error al eliminar";
        }
    }

    public void cerrarConexion() throws SQLException {

        if (con != null) {
            con.close();
            mensaje = "Base de datos cerrada con exito";
        } else {
            mensaje = "Imposible cerrar la conexion";
        }

    }

    public ResultSet getDatos() {
        return datos;
    }

    public void setDatos(ResultSet datos) {
        this.datos = datos;
    }

    public PreparedStatement getActualizar() {
        return actualizar;
    }

    public void setActualizar(PreparedStatement actualizar) {
        this.actualizar = actualizar;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
