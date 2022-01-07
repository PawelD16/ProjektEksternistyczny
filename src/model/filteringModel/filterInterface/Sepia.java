package model.filteringModel.filterInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sepia extends Filter {
    public Sepia(BufferedImage image) {
        super(image);
    }

    public Sepia(BufferedImage image, int xInfo, int yInfo, int filterSize) {
        super(image, xInfo, yInfo, filterSize);
    }

    @Override
    public BufferedImage filterMe() {

        // convert to sepia
        for (int y = startingPointHeight; y < endingPointHeight; y++) {
            for (int x = startingPointWidth; x < endingPointWidth; x++) {
                c = new Color(image.getRGB(x, y));

                // calculate newRed, newGreen, newBlue
                int newRed = (int) (0.393 * c.getRed() + 0.769 * c.getGreen() + 0.189 * c.getBlue());
                int newGreen = (int) (0.349 * c.getRed() + 0.686 * c.getGreen() + 0.168 * c.getBlue());
                int newBlue = (int) (0.272 * c.getRed() + 0.534 * c.getGreen() + 0.131 * c.getBlue());

                // check condition
                if (newRed > 255) rValue = 255;
                else rValue = newRed;

                if (newGreen > 255) gValue = 255;
                else gValue = newGreen;

                if (newBlue > 255) bValue = 255;
                else bValue = newBlue;

                // set new RGB value
                c = new Color(rValue, gValue, gValue, c.getAlpha());

                image.setRGB(x, y, c.getRGB());
            }
        }
        return image;
    }
}