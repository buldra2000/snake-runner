package snakerunner.model;

/**
 * MISSING JAVADOC.
 */
public class Entity {
    protected int x;
    protected int y;

    /**
     * MISSING JAVADOC.
     */
    public void generate() {

    }

    /**
     * To read the coordinates.
     * 
     * @return X-coordinate.
     */
    public int getX() {
       return x;
    }

    /**
     * To read the coordinates.
     * 
     * @return Y-coordinate.
     */
    public int getY() {
       return y;
    }

    /**
     * Setting the coordinates.
     * 
     * @param x set X-coordinate.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Setting the coordinates.
     * 
     * @param y set Y-coordinate.
     */
    public void setY(final int y) {
        this.y = y;
    }
}
