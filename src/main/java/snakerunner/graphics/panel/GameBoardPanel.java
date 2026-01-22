package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import snakerunner.model.Position;

public class GameBoardPanel extends JPanel {

    private static final int CELL = 10;

    private Point apple;
    private List<Position> snakeBody = new ArrayList<>();


    public GameBoardPanel(){
        setOpaque(true);
        setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        for(Position p : snakeBody){
            g.fillRect(p.getX() * CELL, p.getY() * CELL, CELL, CELL);
        }

        if(apple != null){
            g.setColor(Color.RED);
            g.fillOval(apple.x * CELL, apple.y * CELL, CELL, CELL);
        }
    }

    public void setApple(Point apple) {
        this.apple = apple;
    }

    public void setSnakeBody(List<Position> snakeBody) {
        this.snakeBody = snakeBody;
    }
}
