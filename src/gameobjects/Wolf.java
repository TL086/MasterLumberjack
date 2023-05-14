package gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.CollisionDetector;

public class Wolf implements Collidable, Movable {

    private Picture picture;

    private final int SPEED = 30;
    private boolean abletoMoveUp = true;
    private boolean abletoMoveDown = true;
    private boolean abletoMoveLeft = true;
    private boolean abletoMoveRight = true;


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



    public void move() throws InterruptedException {

        while (abletoMoveUp){
            Thread.sleep(200);
            moveUp();
        }
        while (abletoMoveRight){
            Thread.sleep(200);

            moveRight();
        }
        while (abletoMoveDown){
            Thread.sleep(200);
            moveDown();
        }
        while (abletoMoveLeft){
            Thread.sleep(200);
            moveLeft();
        }

    }



    public void moveUp() {

        if (abletoMoveUp){
            allowAllMoves();
            return;
        }

        if(picture.getY()<=10){
            return;
        }

        picture.translate(0, -SPEED);

    }

    public void moveLeft() {

        if (abletoMoveLeft){
            allowAllMoves();
            return;
        }

        if(picture.getX()<=10){
            return;
        }
        picture.translate(-SPEED,0);


    }

    public void moveDown() {

        if (abletoMoveDown){
            allowAllMoves();
            return;
        }

        if(picture.getY()>=570){
            return;
        }

        picture.translate(0,SPEED);

    }

    public void moveRight() {

        if (abletoMoveRight){
            allowAllMoves();
            return;
        }

        if(picture.getX()>=870){
            return;
        }

        picture.translate(SPEED,0);

    }


    public void setabletoMoveUp(boolean check){
        abletoMoveUp = check;
    }
    public void setabletoMoveDown(boolean check){
        abletoMoveDown = check;
    }
    public void setabletoMoveLeft(boolean check){
        abletoMoveLeft = check;
    }
    public void setabletoMoveRight(boolean check){
        abletoMoveRight = check;
    }

    public void allowAllMoves(){
        abletoMoveUp = true;
        abletoMoveDown = true;
        abletoMoveLeft = true;
        abletoMoveRight = true;
    }


}
