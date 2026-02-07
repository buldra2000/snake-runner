package snakerunner.model.impl;

import java.util.Set;

import snakerunner.commons.Point2D;
import snakerunner.model.Grid;
import snakerunner.model.Level;
import snakerunner.model.LevelData;

public class LevelImpl implements Level{
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    private final Grid grid;
    private final Set<Point2D<Integer, Integer>> obstacles;

    public LevelImpl(LevelData data) {
        this.grid = new GridImpl(WIDTH, HEIGHT);
        this.obstacles = data.getObstacles();
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    @Override
    public Set<Point2D<Integer, Integer>> getObstacles() {
        return obstacles;
    }

    @Override
    public boolean isBlocked(Point2D<Integer, Integer> position) {
        return !grid.isInsideGrid(position) || obstacles.contains(position);
    }
}
