package gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Wolf implements Collidable, Movable {

    private Picture picture;

    private final int SPEED = 30;
    private boolean abletoMoveUp = true;
    private boolean abletoMoveDown = true;
    private boolean abletoMoveLeft = true;
    private boolean abletoMoveRight = true;
    //private Random random;



    public Wolf(int x,int y, String resource){
        picture = new Picture(x, y,resource);
        picture.draw();
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










    public void moveUp() {

        if (!abletoMoveUp){
            allowAllMoves();
            return;
        }

        if(picture.getY()<=10){

            return;
        }

        picture.translate(0, -SPEED);

    }

    public void moveLeft() {

        if (!abletoMoveLeft){
            allowAllMoves();
            return;
        }

        if(picture.getX()<=10){

            return;
        }
        picture.translate(-SPEED,0);


    }

    public void moveDown() {

        if (!abletoMoveDown){
            allowAllMoves();
            return;
        }

        if(picture.getY()>=570){

            return;
        }

        picture.translate(0,SPEED);

    }

    public void moveRight() {

        if (!abletoMoveRight){
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

    public void move() throws InterruptedException {

        int direction = (int) (Math.random() * 4);


        switch (direction) {
            case 0:
                moveUp();
                break;
            case 1:
                moveDown();
                break;
            case 2:
                moveLeft();
                break;
            case 3:
                moveRight();
                break;
            default:
                break;
        }
    }


}
