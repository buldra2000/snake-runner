package snakerunner.model;

import snakerunner.commons.Point2D;

/**
 * The SnakeSegment class represents a single segment of the snake.
 */
 public final class SnakeSegment {

    /**
     * Enum representing the type of a snake segment.
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
         * Constructs a SnakeSegment with the specified position, type, facing direction, and directional information.
         * 
         * @param pos The position of the snake segment.
         * @param type The type of the snake segment.
         * @param facing The direction the head is facing (if this is a head segment).
         * @param toHead The direction towards the previous segment closer to the head.
         * @param toTail The direction towards the next segment closer to the tail.
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
