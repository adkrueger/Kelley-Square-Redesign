import java.awt.*;

public class Vehicle{
    private int _priority;
    private float progress = 0;
    private VehicleCircle vCircle = new VehicleCircle();
    private VehicleCircle oCircle = new VehicleCircle();

    public Vehicle(int xPos, int yPos, int priority) {
        _priority = priority;
        int priorityColorScale = (_priority * 25);
        Color newColor = new Color(priorityColorScale, 255 - priorityColorScale, 0);
        setVCircle(xPos, yPos, newColor);
        oCircle.setXPos(xPos);
        oCircle.setYPos(yPos);
        oCircle.setColor(newColor);
    }

    public VehicleCircle getVCircle()
    {
        return vCircle;
    }

    public void setVCircle(int x, int y, Color color) {
        vCircle.setXPos(x);
        vCircle.setYPos(y);
        vCircle.setColor(color);
    }

    public void moveForward() {
        progress += 0.1f;
        int x = oCircle.getXPos() + (int) (75 * Math.sin(progress));
        int y = oCircle.getYPos() + (int) (75 * Math.cos(progress));
        setVCircle(x, y, vCircle.getColor());
    }

    public float getProgress() {
        return progress;
    }

    public int getPriority() { return _priority; }
    public void setPriority(int newPriority) { _priority = newPriority; }


}
