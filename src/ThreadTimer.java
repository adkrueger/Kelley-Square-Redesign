import java.awt.EventQueue;
import javax.swing.JFrame;

public class ThreadTimer extends JFrame {

    public ThreadTimer() {
        initUI();
    }

    private void initUI() {

        add(new Renderer());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new ThreadTimer();
            ex.setVisible(true);
        });
    }
}