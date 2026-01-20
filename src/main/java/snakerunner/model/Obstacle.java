package snakerunner.model;

public class Obstacle {
    
    //Obstacle's position
    private Position position;

    public Obstacle(Position position){

        this.position= position;
    }

    public Position getPosition(){
        return position;
    }
}
