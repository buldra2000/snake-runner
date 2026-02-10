package snakerunner.graphics.hud;

public final class HUDFactory {

    private HUDFactory(){}

    public static BaseHUD createTimerView() {
        return new TimerView();
    }

    public static BaseHUD createScoreView() {
        return new ScoreView();
    }

    public static BaseHUD createLevelView() {
        return new LevelView();
    }

    public static BaseHUD createLifeView() {
        return new LifeView();
    }
    
}
