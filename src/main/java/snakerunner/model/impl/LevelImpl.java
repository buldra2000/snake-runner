package snakerunner.model.impl;

import snakerunner.model.Level;

public class LevelImpl implements Level{
    // GRANDEZZA LIVELLO
    // private final int width;
    // private final int height;
    private final int baseSpeed;
    private final int ItemCount;
    private final int levelDuration;

    public LevelImpl(int baseSpeed, int itemCount, int levelDuration) {
        this.baseSpeed = baseSpeed;
        this.ItemCount = itemCount;
        this.levelDuration = levelDuration;
    }
}
