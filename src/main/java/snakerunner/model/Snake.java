package snakerunner.model;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<SnakeSegment> body;
    private double speed;
    private String currentDirection;//memorises where it's going
    private final int FIXED_SIZE =5;

    public Snake() {
        //first position spawn
        this.body = new LinkedList<>();
        this.speed =20.0;
        this.currentDirection = "RIGHT";

        //Body inatialization, creates a horizonal row of five pieces
        for (int i = 0; i < FIXED_SIZE; i++){
            //every new segment is born with a new Position, the sprite is later given
            body.add(new SnakeSegment(new Position(100-(i*20),200),""));
        }
        updateSprites();
    }

    public void setSpeed(double newSpeed){
        this.speed =newSpeed;
    }

    //Move is called by the GameLoop
    //the snake goes in the direction set
    //move now adds the head and removes the last tail

    public void move() {
        //takes the head position from the current head
        Position oldHeadPos = body.getFirst().pos;
        int x = oldHeadPos.getX();
        int y = oldHeadPos.getY();

        //generates new coordinate based on the direction
        switch (currentDirection){
            case "UP": y -=speed;  break;
            case "DOWN": y+= speed; break;
            case "LEFT": x -= speed; break;
            case "RIGHT": x+= speed; break;
        }
            //the new segment is added to the top and removed from the tail to keep the same lenghth
            body.addFirst(new SnakeSegment(new Position(x,y),""));
            body.removeLast();

            updateSprites();
    }
     
    //Logic to assign the correct sprite 

    private void updateSprites(){
        for (int i = 0; i < body.size(); i++){
            SnakeSegment current = body.get(i);
                
            if (i == 0){
                    current.sprite = "head_" + currentDirection.toLowerCase() + ".png";
                }
            else if (i == body.size()-1){
                  //it's the tail, looks at the previous piece to guide itself
                    current.sprite = getTailSprite(current.pos, body.get(i-1).pos);
                }
            else {
                    //the body watched the piece in the front and the one in the back to undertsand if it goes ahead or curves
                    current.sprite = getBodySprite(body.get(i-1).pos, current.pos, body.get(i+1).pos);


                }
            }
        }

    

    //Sees if the body goes ahead or if it has to use a curved image
    private String getBodySprite(Position prev, Position curr, Position next){
        //difference among the pieces
        int dx1 = curr.getX() - prev.getX();
        int dy1 = curr.getY() - prev.getY();
        int dx2 = next.getX() - curr.getX();
        int dy2 = next.getY() - curr.getY();

        //if X and Y are the same, the snake is going the same direction
        if (dx1 == dx2) return "body_vertical.png";
        if (dy1 == dy2) return "body_horizontal.png";

        //if it gets here, the snake is curving
        //movement vectors to choose the right angle 
        if ((dx1 > 0 && dy2 < 0) || (dy1 > 0 && dx2 < 0)) return "body_topright.png";
        if ((dx1 < 0 && dy2 < 0) || (dy1 > 0 && dx2 > 0 )) return "body_topleft.png";
        if ((dx1 > 0 && dy2 > 0) || (dy1 < 0 && dx2 < 0 )) return "body_bottomright.png";
        if ((dx1 < 0 && dy2 > 0) || (dy1 < 0 && dx2 > 0 )) return "body_bottomleft.png";

        return "body_horizontal.png";//security fallback

    }

    //guides the tail in the direction of the previous segment

    private String getTailSprite(Position curr, Position prev){
        if (curr.getX() < prev.getX()) return "tail_right.png";
        if (curr.getX() > prev.getX()) return "tail_left.png";
        if (curr.getY() < prev.getY()) return "tail_down.png";
        return "tail_up.png";

    }

    //to avoid inversion

    public void setDirectionUp(){
        if (!currentDirection.equals("DOWN")){
            currentDirection = "UP";
        }
    }

    public void setDirectionDown(){
        if (!currentDirection.equals("UP")){
            currentDirection = "DOWN";
        }
    }

    public void setDirectionLeft(){
        if (!currentDirection.equals("RIGHT")){
            currentDirection = "LEFT";
        }
    }

    public void setDirectionRight(){
        if (!currentDirection.equals("LEFT")){
            currentDirection = "RIGHT";
        }
    }

    public List<SnakeSegment> getFullBody(){
        return this.body;
    }


    public double getSpeed() {
        return this.speed;
    }

    public Position getHeadPosition() {
    return body.getFirst().pos;
}

}


class SnakeSegment {
    public Position pos;
    public String sprite;

    public SnakeSegment(Position pos, String sprite) {
        this.pos = pos;
        this.sprite = sprite;
}

}
