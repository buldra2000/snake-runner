package snakerunner.model;

import snakerunner.commons.Point2D;


 public final class SnakeSegment {

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

        public SnakeSegment(Point2D<Integer, Integer> pos, SegmentType type,
                            Direction facing, Direction toHead, Direction toTail){
                            
            this.pos =pos;
            this.type =type;
            this.facing = facing;
            this.toHead = toHead;
            this.toTail = toTail;                
        }
        
    }