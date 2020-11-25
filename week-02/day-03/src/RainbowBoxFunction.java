import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
    // Don't touch the code below
    static int WIDTH = 720;
    static int HEIGHT = 720;

    public static void mainDraw(Graphics graphics) {
        // Create a square drawing function that takes 3 parameters:
        // The square size, the fill color, graphics
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).

        List<Color> colors = new ArrayList<>();
        colors = List.of(Color.red, Color.orange, Color.yellow, Color.green, Color.BLUE, Color.MAGENTA, Color.pink);

        int width = 700;
        int height = 700;

        for (int i = 0; i < colors.size(); i++) {
            graphics.fillRect(350, 10, width, height);
            width = width - 10;
            height = height - 10;
            graphics.setColor(colors.get(i));
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
