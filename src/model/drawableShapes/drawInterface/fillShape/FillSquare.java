package model.drawableShapes.drawInterface.fillShape;

import model.drawableShapes.drawInterface.PaintAll;

import java.awt.*;

public class FillSquare extends PaintAll {

    public FillSquare(int x, int y, int sideLength, Color color) {
        super(x,y,sideLength,color);
    }

    public void drawMe(Graphics g) {
        Graphics2D g2d = super.setGraphicsProperties(g);

        g2d.fillRect(x - (atribute / 2), y - (atribute / 2), atribute, atribute);
    }
}