import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Renderer extends JFrame {
    private int width = 1260;
    private int height = 1360;
    private Traffic traffic = new Traffic();

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
        try {
            g.drawImage(ImageIO.read(new File("images/memes.png")), 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        traffic.addCar(200, 300);
        traffic.addCar(100, 200);
        for (Position pos : traffic.getPositions())
        {
            drawCircleWithCenter(g, pos.getXPos(), pos.getYPos(), 10);
        }
    }

    void drawCircleWithCenter(Graphics g, int x, int y, int radius) {
        g.setColor(Color.BLACK);
        // g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}