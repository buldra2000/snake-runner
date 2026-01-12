package snakerunner.core;

import snakerunner.controller.impl.ControllerImpl;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.MainFrameImpl;
import snakerunner.graphics.panel.GamePanel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Snake Runner!");

        //Creating Frame
        MainFrame mainFrame = new MainFrameImpl();

        GamePanel gamePanel = new GamePanel(mainFrame);

        ControllerImpl controller = new ControllerImpl(mainFrame, gamePanel);
        
        controller.init();
        };
}
