package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import snakerunner.commons.Point2D;
import snakerunner.controller.Controller;
import snakerunner.model.Collectible;
import snakerunner.model.SnakeSegment;

public final class GameBoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int CELL = 15;
    private final Controller controller;
    private Image foodImage, clockImage, keyImage, obstacleImage;

    public GameBoardPanel(final Controller controller) {
        this.controller = controller;
        setOpaque(true);
        setBackground(Color.GRAY);
        loadImages();
    }

    /**
     * Draw all Components
     * @param g Graphics g
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        drawGrid(g);
        drawSnake(g);
        drawObstacle(g);
        drawCollectibles(g);
    }

    private void loadImages() {
        foodImage = loadImage("images/food.png");
        clockImage = loadImage("images/clock.png");
        keyImage = loadImage("images/key.png");
        obstacleImage =loadImage("images/obstacle.png");
    }

    private Image loadImage(String path) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                return null;
            }
            
            Image img = ImageIO.read(is);
            return img;
            
        } catch (IOException e) {
            throw new RuntimeException("Load Images Error", e);
        }
    }

    /**
     * Draw Grid
     * @param g Graphics g
     */
    private void drawGrid(final Graphics g) {
        g.setColor(Color.BLACK);

        final int panelWidth = getWidth();
        final int panelHeight = getHeight();

        final int cols = panelWidth / CELL;
        final int rows = panelHeight / CELL;

        final int gridWidth = cols * CELL;
        final int gridHeight = rows * CELL;

        for (int x = 0; x <= cols; x++) {
            g.drawLine(x * CELL, 0, x * CELL, gridHeight);
        }

        for (int y = 0; y <= rows; y++) {
            g.drawLine(0, y * CELL,gridWidth, y * CELL);
        }
    }

    /**
     * Draw snake
     * @param g
     */
    private void drawSnake(final Graphics g) {
        var snake = controller.getSnake();

        g.setColor(Color.GREEN);

        if (snake == null) {
            return;
        }

        g.setColor(Color.GREEN);

        for (SnakeSegment s : snake.getFullBody()) {
            Point2D<Integer, Integer> p = s.pos;
            final int x = p.getX() * CELL;
            final int y = p.getY() * CELL;
            g.fillRect(x, y, CELL, CELL);
        }
    }

    /**
     * Draw obstacle
     * @param g
     */
    private void drawObstacle(final Graphics g) {
        g.setColor(Color.RED);

        for (final Point2D<Integer, Integer> p : controller.getObstacles()) {
            final int x = p.getX() * CELL;
            final int y = p.getY() * CELL;

            //g.fillRect(x * CELL, y * CELL, CELL, CELL);
            g.drawImage(obstacleImage, x, y, CELL, CELL, this);
        }
    }

    /**
     * Draw collectibles
     * @param g
     */
    private void drawCollectibles(final Graphics g) {
       for (final Collectible collectible : controller.getCollectibles()) {
        final Point2D<Integer, Integer> p = collectible.getPosition();
        final int x = p.getX() * CELL;
        final int y = p.getY() * CELL;

        switch (collectible.getType()) {
            case FOOD -> g.drawImage(foodImage, x, y, CELL + 2, CELL + 2, this);
            case CLOCK -> g.drawImage(clockImage, x, y, CELL + 2, CELL + 2, this);
            case KEY -> g.drawImage(keyImage, x, y, CELL + 2, CELL + 2, this);
            default -> {
                g.setColor(Color.YELLOW);
                g.fillOval(x, y, CELL, CELL);
            }
        }
       }
    }
}
