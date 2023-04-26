package Vista;

import java.awt.Graphics;
import javax.swing.JPanel;

import Modelo.Model;

public class Vista extends JPanel {
    
    private Model imageFlyweight;

    public Vista(String imagePath) {
        this.imageFlyweight = Model.getFlyweight(imagePath);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // dibujar la imagen utilizando la instancia de Flyweight
        g.drawImage(imageFlyweight.getImage(), 0, 0, null);
    }


}