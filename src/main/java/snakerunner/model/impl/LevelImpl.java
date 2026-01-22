package snakerunner.model.impl;

import snakerunner.model.Grid;
import snakerunner.model.Level;

public class LevelImpl implements Level{
    // GRANDEZZA LIVELLO
    private final Grid grid;
    private final int baseSpeed;
    private final int ItemCount;
    private final int levelDuration;

    public LevelImpl(Grid grid, int baseSpeed, int itemCount, int levelDuration) {
        this.grid = grid;
        this.baseSpeed = baseSpeed;
        this.ItemCount = itemCount;
        this.levelDuration = levelDuration;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }
}
