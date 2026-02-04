package snakerunner.graphics.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

    private static final int CELL = 10;


    public GameBoardPanel(){
        setOpaque(true);
        setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        //Grid
        //Snake
        //Obstacle
        //Food
        
    }
}
