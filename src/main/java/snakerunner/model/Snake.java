package snakerunner.model;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

import snakerunner.commons.Point2D;

//public interface  Snake {
//   public void move();

//   public void setDirection(Direction direction);

//    public Point2D<Integer, Integer> getHead();

//    public List<Point2D<Integer, Integer>> getBody();

//    public boolean isCollidingWithItself();

//}

/**
 * MISSING JAVADOC.
 */
public final class Snake {

    private static final int FIXED_SIZE = 5; //the lenght never changes
    private final LinkedList<SnakeSegment> body = new LinkedList<>(); //the list
    private Direction currentDirection = Direction.RIGHT; //initial direction

    /**
     * MISSING JAVADOC.
     * 
     * @param startPosition MISSING JAVADOC.
     */
    public Snake(final Point2D<Integer, Integer> startPosition) {

        for (int i = 0; i < FIXED_SIZE; i++) {
            //we create the points, if the head is at point X the pieces behind are ate X-1, X-2 ETC
            final Point2D<Integer, Integer> p = new Point2D<>(startPosition.getX() - i, startPosition.getY());
            //at first the will be empty cuz update logic () will fill them
            body.add(new SnakeSegment(p, SnakeSegment.SegmentType.BODY_STRAIGHT, null, null, null));
        }
        updateLogic(); //makes head, tail and directions

    }

    /**
     * the movement like a train : the ereditate the position left by the previous pieces.
     */
    public void move() {
        //actual head position
        final Point2D<Integer, Integer> headPos = body.getFirst().pos;
        int nextX = headPos.getX();
        int nextY = headPos.getY();

        //calculates new position base on where we are going
        switch (currentDirection) {
            case UP: nextY -= 1; break;
            case DOWN: nextY += 1; break;
            case LEFT: nextX -= 1; break;
            case RIGHT: nextX += 1; break;
        }

        //we add the new piece on top of the list (becomes the new head)
        body.addFirst(new SnakeSegment(new Point2D<>(nextX, nextY), SnakeSegment.SegmentType.HEAD, currentDirection, null, null));

        //we remove the last piece so we maintain the 5 lenght
        body.removeLast();
        //we must redo who is he head, the tail etc.
        updateLogic();

    }

    /**
     * change direction so it doesn't turn 180 degrees.
     * 
     * @param d MISSING JAVADOC.
     */
    public void setDirection(final Direction d) {
        if (d == null) {
            return;
        }
        if (currentDirection == Direction.UP && d == Direction.DOWN) {
            return;
        }
        if (currentDirection == Direction.DOWN && d == Direction.UP) {
            return;
        }
        if (currentDirection == Direction.LEFT && d == Direction.RIGHT) {
            return;
        }

        if (currentDirection == Direction.RIGHT && d == Direction.LEFT) {
            return;
        }

        currentDirection = d;

    }

    /**
     * MISSING JAVADOC.
     * 
     * @return MISSING JAVADOC.
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /**
     * returns the head position.
     * 
     * @return MISSING JAVADOC.
     */
    public Point2D<Integer, Integer> getHead() {
        return body.getFirst().pos;
    }

    /**
     * Return the list of the segment for the view to draw.
     * 
     * @return MISSING JAVADOC.
     */
    public List<SnakeSegment> getFullBody() {
        return Collections.unmodifiableList(body);
    }

    /**
     * collision with itself.
     * 
     * @return MISSING JAVADOC.
     */
    public boolean isCollidingWithItself() {
        final Point2D<Integer, Integer> head = body.getFirst().pos;
        for (int i = 1; i < body.size(); i++) {
            final Point2D<Integer, Integer> p = body.get(i).pos;
            if (head.getX().equals(p.getX()) && head.getY().equals(p.getY())) {
                return true;
            }
        }
        return false;

    }

    //update logics
    //this method decides what each piece should be

    private void updateLogic() {
        if (body.isEmpty()) {
            return;
        }

        for (int i = 0; i < body.size(); i++) {
            final Point2D<Integer, Integer> curr = body.get(i).pos;

            //first case : it's the head
            if (i == 0) {
                final Direction toTail = getRelativeDirection(curr, body.get(1).pos);
                body.set(i, new SnakeSegment(curr, SnakeSegment.SegmentType.HEAD, currentDirection, null, toTail));

            }
            //second case : it's the tail
            else if (i == body.size() - 1) {
                final Direction toHead = getRelativeDirection(curr, body.get(i - 1).pos);
                body.set(i, new SnakeSegment(curr, SnakeSegment.SegmentType.TAIL, null, toHead, null));

            }
            //third case : it's the body
            else {
                final Point2D<Integer, Integer> prev = body.get(i - 1).pos; //toward the head
                final Point2D<Integer, Integer> next = body.get(i + 1).pos; //toward the tail

                final Direction toHead = getRelativeDirection(curr, prev);
                final Direction toTail = getRelativeDirection(curr, next);

                //if prev dir and next dirr are on the same line it's going ahead, else is curving
                final SnakeSegment.SegmentType t = isStraight(prev, next) ? SnakeSegment.SegmentType.BODY_STRAIGHT : SnakeSegment.SegmentType.BODY_CURVE;
                body.set(i, new SnakeSegment(curr, t, null, toHead, toTail));
            }
        }
    }

    private boolean isStraight(final Point2D<Integer, Integer> prev, final Point2D<Integer, Integer> next) {
        return prev.getX().equals(next.getX()) || prev.getY().equals(next.getY());
    }

    //given two close points, tells the direction of the seocnd one given the first
    private Direction getRelativeDirection(final Point2D<Integer, Integer> from, final Point2D<Integer, Integer> to) {
        if (to.getX() > from.getX()) {
            return Direction.RIGHT;
        }

        if (to.getX() < from.getX()) {
            return Direction.LEFT;
        }

        if (to.getY() > from.getY()) {
            return Direction.DOWN;
        }

        return Direction.UP;

    }

}
