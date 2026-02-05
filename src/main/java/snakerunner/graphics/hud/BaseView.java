package snakerunner.graphics.hud;

import java.awt.Dimension;

import javax.swing.JLabel;

//Base Graphics for HUD element
public abstract class BaseView extends JLabel implements BaseHUD{

    private static final long serialVersionUID = 1L;

    public BaseView(final int width, final int height){
        init(width,height);
    }

    private void init(final int width, final int height){
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
    }
}
