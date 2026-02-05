package snakerunner.controller;

import snakerunner.graphics.MainFrame;
import snakerunner.model.GameModel;

//LinkedBlockingQueue -> thread safe
//Il controller non deve vedere Swing

public interface Controller {

    void init();

    /**
     * Starts the game loop.
     */
    void start();

    void onStart();

    void onOption();

    void pause();

    GameModel getModel();

    void resume();

    //GamePanel
    void onPause();

    void onResume();

    void onBackToMenu();

    MainFrame getView();

    void updateGame();

    void setSoundEnable(boolean isEnable);

    void loadLevelFromFile(String filepath);

    void onBackMenu();

    void exit();
}
