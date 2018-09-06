import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyHandler extends KeyAdapter {
    private GraphicsSurface surface;

    KeyHandler(GraphicsSurface surf) {
        this.surface = surf;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                surface.left();
                break;
            case KeyEvent.VK_RIGHT:
                surface.right();
                break;
            case KeyEvent.VK_DOWN:
                surface.down();
                break;
            case KeyEvent.VK_UP:
                surface.up();
                break;
        }
    }
}

class GraphicsSurface extends JPanel implements ActionListener {
    private final int REPAINT_DELAY_MS = 10;
    int x;
    int y;
    int offset;
    int rectSize;
    private Timer timer;

    public GraphicsSurface() {
        initTimer();
        addKeyListener(new KeyHandler(this));
        setFocusable(true);
        x = 0;
        y = 0;
        offset = 5;
        rectSize = 10;
    }

    private void initTimer() {
        timer = new Timer(REPAINT_DELAY_MS, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void left() {
        if (x - offset >= 0)
            x -= offset;
    }

    public void up() {
        if (y - offset >= 0)
            y -= offset;
    }

    public void down() {
        if (y + offset + rectSize <= getHeight())
            y += offset;
    }

    public void right() {
        if (x + offset + rectSize <= getWidth())
            x += offset;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        g2d.drawRect(x, y, rectSize, rectSize);
    }
}

public class GraphicsWindow extends JFrame {
    public GraphicsWindow(String title) {
        add(new GraphicsSurface());
        setTitle(title);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GraphicsWindow m = new GraphicsWindow("2D Window");
            m.setVisible(true);
        });
    }
}
