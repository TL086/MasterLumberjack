package gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Wolf implements Collidable{

    private Picture picture;


    public Wolf(int x,int y, String resource){
        picture = new Picture(x, y,resource);
        picture.draw();
    }


    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }
}
