package gameobjects;

import org.academiadecodigo.simplegraphics.graphics.*;


public class Square implements Collidable{

    private Rectangle rectangle;

    public Square (int x, int y, int size){
        rectangle = new Rectangle(x, y, size, size);
        rectangle.setColor(Color.GRAY);
        rectangle.fill();
    }


    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getWidth() {
        return rectangle.getWidth();
    }

    public int getHeight() {
        return rectangle.getHeight();
    }
}
