package CargarImagenes;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {

public Imagen() {
this.setSize(80, 80); //se selecciona el tamaño del panel

}

//Se crea un método cuyo parámetro debe ser un objeto Graphics

public void paint(Graphics grafico) {
Dimension height = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa

ImageIcon Img = new ImageIcon(getClass().getResource("/Img/imagen.png")); 

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel

grafico.drawImage(Img.getImage(), 0, 0, 80,80,null);

setOpaque(false);
super.paintComponent(grafico);
}
}