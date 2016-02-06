package controladores;

public class Cifrado {

    char[] mensaje;

    private String cifrado;

    public String Cifrar(String mensaje, int movimiento) {

        cifrado = "";
        this.mensaje = mensaje.toCharArray();
        for (int i = 0; i < mensaje.length(); i++) {
            int caracter;
            caracter = (this.mensaje[i]) + movimiento;
            cifrado = cifrado + ((char) caracter);
        }

        return this.cifrado;
    }

    public String Descifrar(String mensaje, int movimiento) {
        cifrado = "";
        this.mensaje = mensaje.toCharArray();
        for (int i = 0; i < mensaje.length(); i++) {
            int caracter;
            caracter = (this.mensaje[i]) - movimiento;
            cifrado = cifrado + ((char) caracter);
        }

        return cifrado;
    }

    public String getCifrado() {
        return cifrado;
    }

    public void setCifrado(String Cifrado) {
        this.cifrado = Cifrado;
    }

}
