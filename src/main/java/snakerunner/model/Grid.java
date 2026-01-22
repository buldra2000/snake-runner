package snakerunner.model;

import snakerunner.commons.Point2D;

public interface Grid {
    public boolean isInsideGrid(Point2D<Integer, Integer> position);
}
