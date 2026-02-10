package snakerunner.graphics.hud;

/**
 * HUDFactory create BaseHUD.
 */
public final class HUDFactory {

    private HUDFactory() { }

    /**
     * Create new TimerView.
     * 
     * @return TimerView.
     */
    public static BaseHUD createTimerView() {
        return new TimerView();
    }

    /**
     * Create new ScoreView.
     * 
     * @return ScoreView.
     */
    public static BaseHUD createScoreView() {
        return new ScoreView();
    }

    /**
     * Create new LevelView.
     * 
     * @return LevelView.
     */
    public static BaseHUD createLevelView() {
        return new LevelView();
    }

    /**
     * Create new LifeView.
     * 
     * @return LifeView.
     */
    public static BaseHUD createLifeView() {
        return new LifeView();
    }

}
