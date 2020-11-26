import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Mozaik {
    // Don't touch the code below
    static int WIDTH = 640;
    static int HEIGHT = 640;

    public static void mainDraw(Graphics graphics) {
        // Fill the canvas with a checkerboard pattern.
        int startX;
        int startY;
        int width = 20;
        int height = 20;


        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                startX = i * width;
                startY = j * height;


                int r = (int) (100 * Math.random());
                int g = (int) (100 * Math.random());
                int b = (int) (100 * Math.random());
                Color randomColor = new Color(r, g, b);
                graphics.setColor(randomColor);
                graphics.fillRect(startX, startY, width, height);
            }
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}