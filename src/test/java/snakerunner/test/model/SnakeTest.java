package snakerunner.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import snakerunner.commons.Point2D;
import snakerunner.model.Direction;
import snakerunner.model.Snake;

class SnakeTest {

    @Test
    void mySnakeTest() {

        final Point2D<Integer, Integer> startPos = new Point2D<>(10, 10);
        final Snake testSnake = new Snake(startPos);

        
        assertEquals(10, testSnake.getHead().getX());
        assertEquals(10, testSnake.getHead().getY());

        
        final int size = testSnake.getFullBody().size();
        assertEquals(5, size);
    }

    @Test
    void movementTest() {
        final Point2D<Integer, Integer> p = new Point2D<>(5, 5);
        final Snake s = new Snake(p);
        
        s.move();

        assertEquals(6, s.getHead().getX());
        assertEquals(5, s.getHead().getY());

        
        s.setDirection(Direction.UP);
        s.move();

        
        assertEquals(6, s.getHead().getX());
        assertEquals(4, s.getHead().getY());
    }

    @Test
    void testWrongTurn() {
        final Snake s = new Snake(new Point2D<>(5, 5));

        
        s.setDirection(Direction.LEFT);

        
        final Direction current = s.getCurrentDirection();
        assertEquals(Direction.RIGHT, current);
    }
}

