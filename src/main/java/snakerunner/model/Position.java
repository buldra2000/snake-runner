package snakerunner.model;

public class Position {
    //Coordinates 
 private int x;
 private int y;   


 public Position(int x, int y){
    this.x=x;
    this.y=y;
 }
//To read the coordinates
 public int getX(){
    return x;
 }
 public int getY(){
    return y;
 }

}
