package gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Tree implements Collidable{

    private Picture picture;


    public Tree(int x, int y, String resource) {
        picture = new Picture(x, y, resource);
        picture.draw();
    }

    public void cutTree(){
        picture.delete();
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
