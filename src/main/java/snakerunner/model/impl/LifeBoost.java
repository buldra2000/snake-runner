package snakerunner.model.impl;

import snakerunner.audio.AudioPlayer;
import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.CollectibleType;
import snakerunner.model.GameModel;

/**
 * The LifeBoost class represents a collectible item in the Snake Runner game
 * that, when consumed, grants the player an extra life.
 */
public final class LifeBoost implements Collectible {
    private static final String LIFE_BOOST_SOUND = "sounds/lifeup.wav";
    private final Point2D<Integer, Integer> position;

    /**
     * Constructs a LifeBoost collectible at the specified position.
     *
     * @param position The coordinates where the life boost is located in the game world.
     */
    public LifeBoost(final Point2D<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public void consume(final GameModel model) {
        AudioPlayer.playSound(LIFE_BOOST_SOUND);
        model.addLife(); 
    }

    @Override
    public Point2D<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public CollectibleType getType() {
        return CollectibleType.LIFE_BOOST;
    }
}
