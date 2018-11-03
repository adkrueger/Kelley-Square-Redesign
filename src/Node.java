import java.util.ArrayList;
import java.lang.Math;

public class Node {
    private float _xPos;
    private float _yPos;
    private ArrayList<Node> exits;

    /**
     * the constructor for a Node
     * @param x the x-coordinate of the node
     * @param y the y-coordinate of the node
     * @param exits the possible exits from this node to the next
     */
    public Node(float x, float y, ArrayList<Node> exits) {
        _xPos = x;
        _yPos = y;
        this.exits = exits;
    }

    /**
     * returns an ArrayList of all possible exit nodes
     * @return the possible exit(s) for the current node
     */
    public ArrayList nextNodes() {
        return this.exits;
    }

    /**
     * finds the difference between the x-coordinate of the next node and the current node
     * @return the value that represents said distance, or 0 if there is no next node
     */
    private double distanceBetweenX() {
        if(!(this.exits.get(0) == null))
            return (this.exits.get(0)._xPos - this._xPos);
        else
            return 0;
    }

    /**
     * finds the difference between the y-coordinate of the next node and the current node
     * @return the value that represents said distance, or 0 if there is no next node
     */
    private double distanceBetweenY() {
        if(!(this.exits.get(0) == null))
            return (this.exits.get(0)._yPos - this._yPos);
        else
            return 0;
    }

    /**
     * finds the hypotenuse of the distances between two points
     * @return magnitude the distance between two points
     */
    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.distanceBetweenX(),2) + Math.pow(this.distanceBetweenY(),2));
    }

    /**
     * checks whether it would be faster for the car to go right or left at the current junction
     * @return true if the vehicle should go right and false if not
     */
    public boolean shouldGoRight() {
        int sumL = 0;
        int sumR = 0;
        Node leftOption = this.exits.get(0);
        Node rightOption = this.exits.get(1);

        if(!(leftOption == null)) {
            if (exits.get(0).shouldGoRight())
                sumL += 1;
        }

        if(!(rightOption == null)) {
            if (exits.get(1).shouldGoRight())
                sumR += 1;
        }

        return (sumL < sumR || (leftOption == null && rightOption == null));
    }

    public float getPos() {
        return 0;
    }
}