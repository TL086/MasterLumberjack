package gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Collidable{

    private Picture picture;

    private final int SPEED = 8;

    public Player(int x,int y, String resource){
        picture = new Picture(x, y,resource);
        picture.draw();
    }


    public void moveUP(){
        picture.translate(0, -SPEED);
    }

    public void moveLeft(){
        picture.translate(-SPEED,0);
            }

    public void moveDown(){
        picture.translate(0,SPEED);
    }

    public void moveRight(){
        picture.translate(SPEED,0);
    }

    @Override
    public int getX() {
        return picture.getX();
    }

    @Override
    public int getY() {
        return picture.getY();
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }
}
