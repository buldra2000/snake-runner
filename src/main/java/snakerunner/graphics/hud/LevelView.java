package snakerunner.graphics.hud;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*TimerView is a HUD component and is used to show level in GamePanel*/
public class LevelView extends JPanel{

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    private int level;

    public LevelView(){
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
    }

    public void setLevel(int level){
        this.level = level;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        String levelText = String.format("Level : %1d", level);

        g.setColor(Color.BLACK);
        g.drawString(levelText, 5, 15);
    }
    
}
