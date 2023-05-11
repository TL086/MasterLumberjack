package gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Collidable {

    private Picture picture;
    private final int SPEED = 5;


    public Player(int x, int y, String resource) {
        picture = new Picture(x, y, resource);
        picture.draw();
    }



    public void moveUp(){
        if(picture.getY()<=10){
            return;
        }
        picture.translate(0, -SPEED);
    }

    public void moveDown(){
        if(picture.getY()>=580){
            return;
        }

        picture.translate(0, SPEED);
    }

    public void moveLeft(){
        if(picture.getX()<=10){
            return;
        }
        picture.translate(-SPEED, 0);
    }

    public void moveRight(){
        if(picture.getX()>=580){
            return;
        }
        picture.translate(SPEED, 0);
    }


    public int getX() {
        return picture.getX();
    }

    public int getY() {
        return picture.getY();
    }

    public int getWidth() {
        return picture.getWidth();
    }

    public int getHeight() {
        return picture.getHeight();
    }
}
