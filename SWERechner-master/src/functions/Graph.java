package functions;

import javax.swing.*;
import java.awt.*;
import java.util.function.DoubleUnaryOperator;

public class Graph extends JPanel {
    private DoubleUnaryOperator function;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private int pixelsPerUnit;

    public Graph(DoubleUnaryOperator function, double minX, double maxX, double minY, double maxY, int pixelsPerUnit) {
        this.function = function;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.pixelsPerUnit = pixelsPerUnit;

        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.white);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = (double) getWidth() / (maxX - minX);
        double yScale = (double) getHeight() / (maxY - minY);

        int xStart = (int) ((-minX) * xScale);
        int yStart = (int) ((maxY) * yScale);

        g2d.drawLine(0, yStart, getWidth(), yStart);
        g2d.drawLine(xStart, 0, xStart, getHeight());

        for (int i = 0; i <= 10; i++) {
            int x = xStart + (int) (i * xScale);
            int y = yStart - (int) (i * yScale);
            g2d.drawLine(x, yStart, x, yStart + 5);
            g2d.drawString(String.valueOf(i * (maxX - minX) / 10 + minX), x - 10, yStart + 20);

            x = xStart - (int) (i * xScale);
            y = yStart - (int) (i * yScale);
            g2d.drawLine(x, yStart, x, yStart + 5);
            g2d.drawString(String.valueOf(i * (maxX - minX) / 10 + minX), x - 25, yStart + 20);

            x = xStart;
            y = yStart - (int) (i * yScale);
            g2d.drawLine(x, y, x + 5, y);
            g2d.drawString(String.valueOf(i * (maxY - minY) / 10 + minY), x - 20, y + 5);

            x = xStart;
            y = yStart - (int) (i * yScale);
            g2d.drawLine(x, y, x - 5, y);
            g2d.drawString(String.valueOf(i * (maxY - minY) / 10 + minY), x - 20, y + 5);
        }

        for (double x = minX; x <= maxX; x += 0.01) {
            double y = function.applyAsDouble(x);
            if (Double.isNaN(y)) {
                continue;
            }
            int x1 = (int) ((x - minX) * xScale) + xStart;
            int y1 = (int) ((maxY - y) * yScale);
            int x2 = (int) ((x - minX) * xScale) + xStart;
            int y2 = yStart;
            g2d.drawLine(x1, y1, x2, y2);
        }
    }
}