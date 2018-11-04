import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Math;
import java.util.EmptyStackException;

public class Node {
    private int _xPos;
    private int _yPos;
    private String name;
    private ArrayList<Node> exits = new ArrayList<Node>();

    /**
     * the constructor for a Node
     *
     * @param x     the x-coordinate of the node
     * @param y     the y-coordinate of the node
     * @param newName the possible exits from this node to the next
     */
    public Node(int x, int y, String newName) {
        _xPos = x;
        _yPos = y;
        name = newName;
    }

    public int getX ()
    {
        return _xPos;
    }

    public int getY () {
        return _yPos;
    }

    public String getName () {
        return name;
    }

    public void setExits(ArrayList<Node> exits) {
        this.exits = exits;
    }

    public void addNodeToExit(Node node) {
        this.exits.add(node);
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

    public ArrayList<Node> getNodes() {
        ArrayList<Node> nodeList = new ArrayList<Node>();

        Node node0 = new Node(490, 25, "0");
        Node node1 = new Node(475, 465, "1");
        Node node2 = new Node(25, 450, "2");
        Node node3 = new Node(430, 560, "3");
        Node node4 = new Node(25, 475, "4");
        Node node5 = new Node(520, 700, "5");
        Node node6 = new Node(90,1340, "6");
        Node node7 = new Node(560, 960, "7");
        Node node8 = new Node(365, 1340, "8");
        Node node9 = new Node(625, 980, "9");
        Node node10 = new Node(845, 1355, "10");
        Node node11 = new Node(690, 940, "11");
        Node node12 = new Node(865, 1355, "12");
        Node node13 = new Node(690, 825, "13");
        Node node14 = new Node(1250, 60, "14");
        Node node15 = new Node(585, 495, "15");
        Node node16 = new Node(960,20, "16");
        Node node17 = new Node(520, 465, "17");
        Node node18 = new Node(520, 25, "18");

        node0.addNodeToExit(node1);
        node1.addNodeToExit(node2);
        node1.addNodeToExit(node3);
        node4.addNodeToExit(node3);
        node3.addNodeToExit(node5);
        node5.addNodeToExit(node6);
        node5.addNodeToExit(node7);
        node8.addNodeToExit(node7);
        node7.addNodeToExit(node9);
        node9.addNodeToExit(node10);
        node9.addNodeToExit(node11);
        node12.addNodeToExit(node11);
        node11.addNodeToExit(node13);
        node13.addNodeToExit(node14);
        node13.addNodeToExit(node15);
        node15.addNodeToExit(node16);
        node15.addNodeToExit(node17);
        node17.addNodeToExit(node18);
        node17.addNodeToExit(node1);

        nodeList.add(node0);
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);
        nodeList.add(node7);
        nodeList.add(node8);
        nodeList.add(node9);
        nodeList.add(node10);
        nodeList.add(node11);
        nodeList.add(node12);
        nodeList.add(node13);
        nodeList.add(node14);
        nodeList.add(node15);
        nodeList.add(node16);
        nodeList.add(node17);
        nodeList.add(node18);

        return nodeList;
    }
}