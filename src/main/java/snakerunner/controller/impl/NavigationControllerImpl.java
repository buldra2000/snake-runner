package snakerunner.controller.impl;

import snakerunner.controller.GameController;
import snakerunner.controller.NavigationController;
import snakerunner.controller.WorldController;
import snakerunner.graphics.MainFrame;
import snakerunner.graphics.panel.BasePanel;
import snakerunner.graphics.panel.GamePanel;
import snakerunner.graphics.panel.PanelFactory;
import snakerunner.model.GameModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * NavigationControllerImpl define methods for NavigationController'Interface.
 */
public final class NavigationControllerImpl implements NavigationController, KeyListener {

    private final MainFrame mainFrame;
    private final GameModel gameModel;
    private GameController gameController;
    private BasePanel menuPanel;
    private BasePanel optionPanel;
    private BasePanel tutorialPanel;

    /**
     * Constructor for NavigationControllerImpl.
     * 
     * @param mainFrame main frame for the application.
     * @param gameModel game model for the application.
     */
    public NavigationControllerImpl(final MainFrame mainFrame, final GameModel gameModel) {
        this.mainFrame = mainFrame;
        this.gameModel = gameModel;
    }

    @Override
    public void init() {
        menuPanel = PanelFactory.createMenuPanel(this);
        optionPanel = PanelFactory.createOptionPanel(this);
        tutorialPanel = PanelFactory.createTutorialPanel(this);

        mainFrame.addKeyListener(this);

        if (mainFrame instanceof javax.swing.JFrame) {
        final javax.swing.JFrame frame = (javax.swing.JFrame) mainFrame;
        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

        mainFrame.setPanels(menuPanel, null, optionPanel, tutorialPanel);
        mainFrame.showMenu();
        mainFrame.display();
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        // Non necessario qui
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        // Non necessario qui, la logica è in GameControllerImpl
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        // Non necessario qui
    }

    @Override
    public void startGame() {
        if (gameController == null) {
            gameController = new GameControllerImpl(mainFrame, gameModel);
        }

        mainFrame.addKeyListener((KeyListener) gameController);

        final WorldController wc = new WorldControllerImpl(gameModel);

        final BasePanel gamePanel = PanelFactory.createGamePanel(gameController);

        if (gamePanel instanceof final GamePanel gp) {
            gp.setWorldController(wc);
            gameController.setHUD(gp.getTimerView(), gp.getScoreView(), gp.getLevelView(), gp.getLifeView());
        }

        mainFrame.setPanels(menuPanel, gamePanel, optionPanel, tutorialPanel);
        mainFrame.showGame();
        gameController.start();

    }

    @Override
    public void onOption() {
        mainFrame.showOption();
    }

    @Override
    public void onBackMenu() {
        mainFrame.showMenu();
    }

    @Override
    public void onTutorial() {
        mainFrame.showTutorial();
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public MainFrame getView() {
        return mainFrame;
    }

}
