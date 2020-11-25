import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GoToCenter {
    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Draw at least 3 lines with that function using a loop.


        Random random = new Random();



        for (int i = 0; i < 3; i++) {
            int startX = (int) (100 * Math.random());
            int startY = 20;
            int endX = startX + 100;
            int endY = startY;

            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();

            Color randomColor = new Color(r, g, b);

            graphics.drawLine(startX, startY, endX, endY);
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
            this.setBackground(Color.WHITE);
            mainDraw(graphics);
        }
    }
}
