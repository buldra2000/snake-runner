package snakerunner.controller.impl;

import snakerunner.controller.Controller;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.GamePanel;

public class ControllerImpl implements Controller {

    private final MainFrame mainFrame;
    private final GamePanel gamePanel;


    public ControllerImpl(MainFrame mainFrame, GamePanel gamePanel) {
        this.mainFrame = mainFrame;
        this.gamePanel = gamePanel;
    }

    @Override
    public void init() {
        mainFrame.display();
        mainFrame.showMenu();
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hide'");
    }

}
