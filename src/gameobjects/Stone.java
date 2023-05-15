package gameobjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Stone implements Collidable{

    private Picture picture;

    public Stone(int x, int y, String resource){
        picture = new Picture(x, y, resource);
        picture.draw();
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
