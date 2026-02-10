package snakerunner.controller;

import snakerunner.graphics.hud.BaseHUD;

/**
 * GameController for the game sequences.
 */
public interface GameController {

    /**
     * Starts the game loop.
     */
    void start();

    /**
     * Pause Game (Model - Controller - View).
     */
    void pause();

    /**
     * Set the HUD components for view.
     * 
     * @param timerView for visualization the timer.
     * @param scoreView for visualization the score.
     * @param levelView for visualization the level.
     * @param lifeView for visualization the lives.
     */
    void setHUD(BaseHUD timerView, BaseHUD scoreView, BaseHUD levelView, BaseHUD lifeView);

    /**
     * Resume game.
     */
    void resume();

    /**
     * Update gameLoop.
     */
    void updateGame();

    /**
     * Load level from file.
     * 
     * @param filepath path file levels.
     */
    void loadLevelFromFile(String filepath);
}
