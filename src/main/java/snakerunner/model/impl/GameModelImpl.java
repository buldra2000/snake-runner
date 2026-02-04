package snakerunner.model.impl;

import java.util.Collections;
import java.util.List;

import snakerunner.commons.Point2D;
import snakerunner.model.Collectible;
import snakerunner.model.GameModel;
import snakerunner.model.Level;
import snakerunner.model.LevelData;
import snakerunner.model.Snake;

public class GameModelImpl implements GameModel {

    private Level currentLevel;
    private Snake snake;
    private List<Collectible> collectibles;
    //private LevelManager levelManager;

    public GameModelImpl() {
    }

    @Override
    public void update() {
        // Every game update logic goes here and updates the game state accordingly.
        
        //snake.move();
        //checkCollisions();
        
    }

    @Override
    public void checkCollisions() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isGameOver() {
        /*
        if (level.IsBlocked(snake.getHead())) {
            return true;
        } else {
            return false;
        }
        */
       return false;
    }

    @Override
    public void loadLevel(LevelData data) {
        this.currentLevel = new LevelImpl(data);
        this.collectibles = data.getCollectibles();
        //this.snake = new SnakeImpl(new Point2D<>(5,5), 3);
        debugPrintLevel();
    }

    @Override
    public void resetLevel() {
        //this.snake = new SnakeImpl();
        //this.food = new FoodImpl();
    }

    @Override
    public Snake getSnake() {
        return this.snake;
    }

    @Override
    public List<Collectible> getCollectibles() {
        return Collections.unmodifiableList(collectibles);    
    }

    @Override
    public Level getLevel() {
        return this.currentLevel;
    }

    private void debugPrintLevel() {
        System.out.println("=== LEVEL DEBUG ===");

        System.out.println("Walls:");
        for (Point2D<Integer, Integer> p : currentLevel.getObstacles()) {
            System.out.println("  wall at " + p);
        }

        System.out.println("Collectibles:");
        for (Collectible c : collectibles) {
            System.out.println("  collectible at " + c.getPosition());
        }

        System.out.println("===================");
    }
}
