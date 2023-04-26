package Modelo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Model {
    private static final HashMap<String, Model> flyweights = new HashMap<>();
    private Image image;

    private Model(Image image) {
        this.image = image;
    }

    public static Model getFlyweight(String imagePath) {
        Model flyweight = flyweights.get(imagePath);

        if (flyweight == null) {
            Image image = loadImage(imagePath);
            flyweight = new Model(image);
            flyweights.put(imagePath, flyweight);
        }

        return flyweight;
    }

    private static Image loadImage(String imagePath) {
        // cargar la imagen desde el archivo
    	try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            // Do something with the loaded image here
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        return null;
    }

    public Image getImage() {
        return image;
    }
}
