import java.awt.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Renderer extends JPanel implements Runnable {
    private final int WIDTH = 1260;
    private final int HEIGHT = 1360;

    private Image background;
    private Thread animator;

    private static Traffic traffic = new Traffic();

    public Renderer() {
        initRenderer();
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("images/memes.png");
        background = ii.getImage();
    }

    private void initRenderer() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        loadImage();
    }

    private void cycle() {
        traffic.update();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 25 - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTraffic(g);
    }


    public void drawTraffic(Graphics g) {
        g.drawImage(background, 0, 0, this);
        try {
            for (VehicleCircle vehicleCircle : traffic.getVCircles()) {
                drawCircleWithCenter(g, vehicleCircle.getXPos(), vehicleCircle.getYPos(), vehicleCircle.getRadius(), vehicleCircle.getColor());
            }
        }
        catch (Exception ConcurrentModificationException)
        {
            System.out.println("Tried to modify two things together...");
        }
    }

    private void drawCircleWithCenter(Graphics g, int x, int y, int radius, Color color) {
        g.setColor(color);
        // g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}