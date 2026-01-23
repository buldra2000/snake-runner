package snakerunner.model;

public class Obstacle extends Entity{
    
    //Obstacle's position
    public Obstacle(int x, int y){
        this.x=x;
        this.y=y;
    }
 
    //Obstacle generation
    public void generate(){

    }

//We check if the obstacle is hit by the snake
    public boolean isHit(int snakeX, int snakeY){
        //If obstacle's and snake's coordinates are the same then this means that there is a collision.
 if (this.x==snakeX && this.y==snakeY){
    return true;
 }
//... else it's false
    return false;       

    
}
  
}
 