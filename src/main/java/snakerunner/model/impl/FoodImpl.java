package snakerunner.model.impl;

import snakerunner.model.FoodEffect;
import snakerunner.model.Snake;

public class FoodImpl {
    //position
    private FoodEffect effect;

    public FoodImpl(FoodEffect effect) {
        //this.position = position;
        this.effect = effect;
    }

    public void consume(Snake snake) {
        effect.apply(snake);
    }
}
