public class Vehicle extends Traffic {
    int _xPos, _yPos, _priority;

    public Vehicle(int xPos, int yPos, int priority) {
        _xPos = xPos;
        _yPos = yPos;
        _priority = priority;
    }

    public int getXPos() { return _xPos; }
    public void setXPos(int newXPos) { _xPos = newXPos; }

    public int getYPos() { return _yPos; }
    public void setYPos(int newYPos) { _yPos = newYPos; }

    public int getPriority() { return _priority; }
    public void setPriority(int newPriority) { _priority = newPriority; }


}
