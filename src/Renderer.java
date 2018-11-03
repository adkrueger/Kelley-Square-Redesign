import java.awt.*;
import javax.swing.*;

public class Renderer extends JFrame {
    private int width = 1260 / 2;
    private int height = 1360 / 2;
    private Traffic traffic = new Traffic();
    ImageIcon imageIcon = new ImageIcon("memes.png");

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
        g.drawImage(imageIcon.getImage(), 0, 0, this);
        traffic.addCar(200, 300);
        traffic.addCar(100, 200);
        for (Position pos : traffic.getPositions())
        {
            drawCircleWithCenter(g, pos.getXPos(), pos.getYPos(), 200);
        }
    }

    void drawCircleWithCenter(Graphics g, int x, int y, int radius) {
        g.setColor(Color.BLACK);
        // g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}