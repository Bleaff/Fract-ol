package org.example;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Surface extends JPanel implements ActionListener {

    private final int DELAY = 150;
    private Timer timer;

    public Surface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer() {

        return timer;
    }
    public Color getRGB(int col)
    {
        return new Color((col) | (col << 8) | (col << 16));
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        Fractal fr = new Mandelbrot();

        int w = getWidth();
        int h = getHeight();

        PositionFr zoom = fr.getZoom();

        for (int y = 0; y < w; y++) {
            for (int x = 0; x < h; x++)
            {
                double x1 = zoom.getMx() + (x + 0.5) / w * (zoom.getBx() - zoom.getMx());
                double y1 = zoom.getMy() - (y + 0.5) / h * (zoom.getBy() - zoom.getMy());
                int color = fr.getFunction(x1 ,y1, 255);
                g2d.setPaint(getRGB(color));
                System.out.println(color);
                g2d.drawLine((int)x1,(int) y1,(int) x1,(int) y1);
            }

        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class Main extends JFrame {

    public Main() {

        initUI();
    }

    private void initUI() {

        final Surface surface = new Surface();
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Fractol");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
}