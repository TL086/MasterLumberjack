package gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Square implements Collidable {

    private Rectangle rectangle;

    public Square(int x, int y, int size){
        rectangle = new Rectangle(x,y,size,size);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
    }


    public void removeSquare(){
        rectangle.delete();
    }
    @Override
    public int getX() {
        return rectangle.getX();
    }

    @Override
    public int getY() {
        return rectangle.getY();
    }

    @Override
    public int getWidth() {
        return rectangle.getWidth();
    }

    @Override
    public int getHeight() {
        return rectangle.getWidth();
    }
}
