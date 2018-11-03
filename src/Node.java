import java.util.ArrayList;
import java.lang.Math;
import java.util.EmptyStackException;

public class Node {
    private float _xPos;
    private float _yPos;
    private ArrayList<Node> exits = new ArrayList<Node>();

    /**
     * the constructor for a Node
     *
     * @param x     the x-coordinate of the node
     * @param y     the y-coordinate of the node
     * @param exits the possible exits from this node to the next
     */
    public Node(float x, float y) {
        _xPos = x;
        _yPos = y;
    }

    public void setExits(ArrayList<Node> exits) {
        this.exits = exits;
    }

    public void addNodeToExit(Node node) {
        this.exits.add(node);
    }

    /**
     * finds the difference between the x-coordinate of the next node and the current node
     *
     * @return the value that represents said distance, or 0 if there is no next node
     */

    private double distanceBetweenX() {
        if (!(this.exits.get(0) == null))
            return (this.exits.get(0)._xPos - this._xPos);
        else
            return 0;
    }

    /**
     * finds the difference between the y-coordinate of the next node and the current node
     * @return the value that represents said distance, or 0 if there is no next node
     */

    private double distanceBetweenY() {
        if (!(this.exits.get(0) == null))
            return (this.exits.get(0)._yPos - this._yPos);
        else
            return 0;
    }


    /**
     * finds the hypotenuse of the distances between two points
     * @return magnitude the distance between two points
     */

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.distanceBetweenX(), 2) + Math.pow(this.distanceBetweenY(), 2));
    }

    public ArrayList<Node> getPath(Node ent, Node ext, ArrayList<Node> currentPath) {
        if (currentPath.size() == 0) {
            currentPath.add(ent);
        }
        for (Node node : ent.exits) {
            if (node.exits.size() == 0) {

            } else if (node.equals(ext)) {
                currentPath.add(ext);
                return currentPath;
            } else if (node.exits.contains(ext)) {
                currentPath.add(node);
                currentPath.add(ext);
                return currentPath;
            } else {
                currentPath.add(node);
                return getPath(node, ext, currentPath);
            }
        }
        return currentPath;
    }

    public void initNodes() {
        Node n5 = new Node(0, 5);
        Node n4 = new Node(0, 4);
        Node n3 = new Node(0, 3);
        Node n2 = new Node(0, 2);
        Node n1 = new Node(0, 1);
        Node n0 = new Node(0, 0);

        n4.addNodeToExit(n5);
        n4.addNodeToExit(n0);
        n0.addNodeToExit(n1);
        n1.addNodeToExit(n2);
        n2.addNodeToExit(n4);
        n2.addNodeToExit(n3);

        for (Node node : getPath(n0, n0, new ArrayList<>())) {
            System.out.println(node._yPos);
        }
    }

    public static void main(String[] args) {
        Node blank = new Node(0, 0);
        blank.initNodes();
    }


}