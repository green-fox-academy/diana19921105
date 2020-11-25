import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void mainDraw(Graphics graphics) {
        // Draw a box that has different colored lines on each edge.
        for (int i = 1; i <= 4; i++) {
            graphics.drawLine(0, 0, 0, 0);
            if (i == 1) {
                graphics.setColor(Color.BLUE);
                graphics.drawLine(20, 20, 20, 300);
            }
            if (i == 2) {
                graphics.setColor(Color.GREEN);
                graphics.drawLine(20, 20, 280, 20);
            }
            if (i == 3) {
                graphics.setColor(Color.RED);
                graphics.drawLine(280, 300, 280, 20);
            }
            if (i == 4) {
                graphics.setColor(Color.black);
                graphics.drawLine(20, 300, 280, 300);
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
            this.setBackground(Color.WHITE);
            mainDraw(graphics);
        }
    }
}
