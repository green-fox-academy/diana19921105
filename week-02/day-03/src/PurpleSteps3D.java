import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3D {

    // Don't touch the code below
    static int WIDTH = 700;
    static int HEIGHT = 700;

    public static void mainDraw(Graphics graphics) {
        int width = 20;
        int height = 20;
        int startX = 10;
        int startY = 10;

        for (int i = 0; i < 7; i++) {
            graphics.setColor(Color.PINK);
            graphics.fillRect(startX, startY, width, height);
            startX += width;
            startY += height;
            width += 20;
            height += 20;
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