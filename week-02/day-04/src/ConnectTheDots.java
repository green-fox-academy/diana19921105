import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void mainDraw(Graphics graphics) {
        // Create a function that takes 2 parameters:
        // An array of {x, y} points and graphics
        // and connects them with green lines.
        // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
        // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
        // {120, 100}, {85, 130}, {50, 100}}

        int[][] dots = {
                {10, 10},
                {290, 10},
                {290, 290},
                {10, 290}
        };
        int[][] lines = {
                {50, 100},
                {70, 70},
                {80, 90},
                {90, 90},
                {100, 70},
                {120, 100},
                {85, 130},
                {50, 100},
        };

        int startX;
        int startY;
        int endX;
        int endY;

        for (int i = 0; i < dots.length - 1; i++) {
            startX = dots[i][0];
            startY = dots[i][1];
            endX = dots[i + 1][0];
            endY = dots[i + 1][1];

            graphics.setColor(Color.green);
            graphics.drawLine(startX, startY, endX, endY);

        }
        graphics.drawLine(dots[dots.length - 1][0], dots[dots.length - 1][1], dots[0][0], dots[0][1]);


        for (int i = 0; i < lines.length - 1; i++) {
            startX = lines[i][0];
            startY = lines[i][1];
            endX = lines[i + 1][0];
            endY = lines[i + 1][1];

            graphics.setColor(Color.GREEN);
            graphics.drawLine(startX, startY, endX, endY);
        }
        graphics.drawLine(lines[lines.length - 1][0], lines[lines.length - 1][1], lines[0][0], lines[0][1]);

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
