package snakerunner.model.impl;

import snakerunner.audio.AudioPlayer;
import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

public class Bomb implements Collectible {

    private final Point2D<Integer, Integer> position;

    public Bomb(final Point2D<Integer, Integer> position) {
        this.position = position;
    }


    @Override
    public void consume(GameModel model) {
        AudioPlayer.playSound("sounds/bomb.wav");
        model.killSnake();
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public CollectibleType getType() {
        return CollectibleType.BOMB;
    }
    
}
