import java.awt.*;

public class VehicleCircle {
    private int _xPos;
    private int _yPos;
    private final int _radius = 10;
    private Color _color;

    public void setXPos(int newX) {
        _xPos = newX;
    }

    public int getXPos() {
        return _xPos;
    }

    public void setYPos(int newY) {
        _yPos = newY;
    }

    public int getYPos() {
        return _yPos;
    }

    public int getRadius() {
        return _radius;
    }

    public void setColor(Color newColor) {
        _color = newColor;
    }

    public Color getColor() {
        return _color;
    }

}
