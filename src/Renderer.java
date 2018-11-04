import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Renderer extends JPanel {
    private final float SCALE = 70;
    private final int RADIUS = 20;
    private final float scaleConv = (SCALE / 100);
    private final int width = (int) (1260 * scaleConv);
    private final int height = (int) (1360 * scaleConv);

    // CHANGE THESE
    private int start = 0;
    private int end = 18;

    private Image background;
    private Thread animator;
    private NodeSystem nodeSystem = new NodeSystem();

    public static void main(String[] args) {
            JFrame jFrame = new JFrame("Kelley Square Demo");
            Renderer renderer = new Renderer();
            jFrame.setSize(renderer.width + 30, renderer.height + 70);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.getContentPane().add(renderer);
            jFrame.setVisible(true);
    }

    public void paint(Graphics g) {
        ImageIcon ii = new ImageIcon("images/kelley.png");
        ii.setImage(ii.getImage().getScaledInstance(width, height, Image.SCALE_FAST));
        g.drawImage(ii.getImage(), 0, 0, this);
        g.setFont(g.getFont().deriveFont(20.0f));
        try {
            for (Circle circle : nodeSystem.getCircles()) {
                int x = (int) (circle.getXPos() * scaleConv);
                int y = (int) (circle.getYPos() * scaleConv);
                drawCircleWithCenter(g, x, y, RADIUS, circle.getColor());
                g.setColor(Color.black);
                g.drawString(circle.getName(), x, y);
            }
            Node startNode = nodeSystem.getNodes().get(start);
            Node endNode = nodeSystem.getNodes().get(end);
            ArrayList<Node> nodePath = startNode.getPath(startNode, endNode, new ArrayList<Node>());
            for (int i = 0; i < nodePath.size() - 1; i++)
            {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.blue);
                g2d.setStroke(new BasicStroke(6.0F));
                g2d.drawLine((int) (nodePath.get(i).getX() * scaleConv),(int) (nodePath.get(i).getY() * scaleConv),
                        (int) (nodePath.get(i + 1).getX() * scaleConv),(int) (nodePath.get(i + 1).getY() * scaleConv));
            }
        }
        catch (Exception ConcurrentModificationException)
        {
            System.out.println("Tried to modify two things together...");
        }
    }

    private void drawCircleWithCenter(Graphics g, int x, int y, int radius, Color color) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}