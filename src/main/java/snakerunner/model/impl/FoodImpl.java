package snakerunner.model.impl;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.Snake;

public class FoodImpl implements Collectible{
    private final Point2D<Integer, Integer> position;

    public FoodImpl(Point2D<Integer, Integer> position){
        this.position = position;
    }

    @Override
    public void consume(Snake snake) {
        // Implement consumption logic here
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public CollectibleType getType() {
        return CollectibleType.FOOD;
    }
}
