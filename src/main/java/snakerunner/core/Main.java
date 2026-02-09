package snakerunner.core;

import snakerunner.controller.NavigationController;
import snakerunner.controller.impl.NavigationControllerImpl;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.impl.MainFrameImpl;
import snakerunner.model.GameModel;
import snakerunner.model.impl.GameModelImpl;

public final class Main {

    private Main(){}

    public static void main(final String[] args) {

        final MainFrame mainFrame = new MainFrameImpl();
        final GameModel gameModel = new GameModelImpl();
        final NavigationController navigationController = new NavigationControllerImpl(mainFrame, gameModel);
        
        navigationController.init();
    }
}

