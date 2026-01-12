package snakerunner.controller;

//LinkedBlockingQueue -> thread safe
//Il controller non deve vedere Swing

public interface Controller {

    public void init();

    public void show();

    public void hide();
}
