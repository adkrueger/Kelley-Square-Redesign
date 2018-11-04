import java.awt.*;

public class Circle {
    private int _xPos;
    private int _yPos;
    private String name;
    private Color _color;

    public void setXPos(int newX) {
        _xPos = newX;
    }

    public int getXPos() {
        return _xPos;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setYPos(int newY) {
        _yPos = newY;
    }

    public int getYPos() {
        return _yPos;
    }

    public void setColor(Color newColor) {
        _color = newColor;
    }

    public Color getColor() {
        return _color;
    }

}
