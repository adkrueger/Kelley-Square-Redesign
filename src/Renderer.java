import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;

public class Renderer extends JFrame {
    private int width = 1260;
    private int height = 1360;

    public Renderer() {
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Renderer();
    }

    public void paint(Graphics g) {
        // Circular Surface
        drawCircleWithCenter(g, width / 2, height / 2, 200);
        Point center = new Point();
        center.x = 200;
        center.y = 400;
    }

    void drawCircleWithCenter(Graphics g, int x, int y, int radius) {
        g.setColor(Color.BLACK);
        // g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}