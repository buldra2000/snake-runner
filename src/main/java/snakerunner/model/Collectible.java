package snakerunner.model;

import snakerunner.commons.Point2D;

public interface Collectible {
    public void consume(GameModel model);

    public Point2D<Integer, Integer> getPosition();

    public CollectibleType getType();
}
