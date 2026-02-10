package snakerunner.model;

import snakerunner.commons.Point2D;

/**
 * MISSING JAVADOC.
 */
 public final class SnakeSegment {

    /**
     * MISSING JAVADOC.
     */
    public enum SegmentType {
        HEAD,
        BODY_STRAIGHT,
        BODY_CURVE,
        TAIL
    }

        public final Point2D<Integer, Integer> pos;
        public final SegmentType type;
        /*where the head is looking */
        public final Direction facing;
        /*direction of the previous piece closer to the head */
        public final Direction toHead;
        /*direction the next piece closer to the tail */
        public final Direction toTail;

        /**
         * MISSING JAVADOC.
         * 
         * @param pos MISSING JAVADOC.
         * @param type MISSING JAVADOC.
         * @param facing MISSING JAVADOC.
         * @param toHead MISSING JAVADOC.
         * @param toTail MISSING JAVADOC.
         */
        public SnakeSegment(final Point2D<Integer, Integer> pos, final SegmentType type,
                            final Direction facing, final Direction toHead, final Direction toTail) {

            this.pos = pos;
            this.type = type;
            this.facing = facing;
            this.toHead = toHead;
            this.toTail = toTail;
        }
}
