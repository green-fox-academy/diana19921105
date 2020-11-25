import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void mainDraw(Graphics graphics) {
        // draw four different size and color rectangles.
        // avoid code duplication.

       int r = (int) (100 * Math.random());
       int g = (int) (100 * Math.random());
       int b = (int) (100 * Math.random());

        for (int i = 0; i < 4; i++) {
            int height = (int) (100 * Math.random());
            int width = (int) (100 * Math.random());
            int startX = (int) (100 * Math.random());
            int startY = (int) (100 * Math.random());

            Color randomColor = new Color(r, g, b);

            graphics.fillRect(startX, startY, width, height);
            graphics.setColor(randomColor);
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