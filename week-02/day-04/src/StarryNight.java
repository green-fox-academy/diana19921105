import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void mainDraw(Graphics graphics) {
        // Draw the night sky:
        //  - The background should be black
        //  - The stars can be small squares
        //  - The stars should have random positions on the canvas
        //  - The stars should have random color (some shade of grey)


        int height = 10;
        int width = 10;

        int min = 1;
        int max = 10;
        int range = max - min + 1;
        int random = 0;

        for (int i = 0; i < 10; i++) {
           random = (int) (Math.random() * range) + min;
        }

        Color color = new Color(random, random, random);

        for (int i = 0; i < 20; i++) {

            int startX = (int) (100 * Math.random());
            int startY = (int) (100 * (Math.random()));

            graphics.setColor(color);
            graphics.fillRect(startX, startY, width, height);
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
            this.setBackground(Color.black);
            mainDraw(graphics);
        }
    }
}