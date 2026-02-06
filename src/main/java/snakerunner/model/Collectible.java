package snakerunner.model;

import snakerunner.commons.Point2D;
import snakerunner.model.impl.GameModelImpl;

public interface Collectible {
    public void consume(GameModelImpl model);

    public Point2D<Integer, Integer> getPosition();

    CollectibleType getType();
}
