public class Vehicle extends Traffic {
    int _priority;
    Position pos = new Position();

    public Vehicle(int xPos, int yPos, int priority) {
        pos.setXPos(xPos);
        pos.setYPos(yPos);
        _priority = priority;
    }

    public Position getPos()
    {
        return pos;
    }

    public void setPos(int x, int y) {
        pos.setXPos(x);
        pos.setYPos(y);
    }

    public int getPriority() { return _priority; }
    public void setPriority(int newPriority) { _priority = newPriority; }


}
