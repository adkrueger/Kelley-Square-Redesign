import java.awt.*;
import java.util.ArrayList;


public class NodeSystem {

    private ArrayList<Node> nodes = new ArrayList<Node>();
    private ArrayList<Circle> circles = new ArrayList<Circle>();

    public NodeSystem()
    {
        Node node = new Node(0, 0, "blank");
        nodes = node.getNodes();
    }

    public ArrayList<Node> getNodes () {
        return nodes;
    }

    public ArrayList<Circle> getCircles() {
        for (Node node : nodes)
        {
            Circle circle = new Circle();
            circle.setColor(Color.red);
            circle.setXPos(node.getX());
            circle.setYPos(node.getY());
            circle.setName(node.getName());
            circles.add(circle);
        }
        return circles;
    }

}
