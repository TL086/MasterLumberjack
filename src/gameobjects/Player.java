package gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.CollisionDetector;

public class Player implements Collidable {

    private Picture picture;

    private final int SPEED = 30;


    private int spiriteNumb=1;

    private int spiriteCut=1;

    private String lastmove;
    private Tree tree;
    private boolean abletoMoveUp = true;
    private boolean abletoMoveDown = true;
    private boolean abletoMoveLeft = true;
    private boolean abletoMoveRight = true;
    private boolean abletoMove = true;


    public Player(int x,int y, String resource){
        picture = new Picture(x, y,resource);
        picture.draw();
    }





    public void moveUp(){



        if(spiriteNumb==1) {
            picture.load("resources/walkUp.png");
            spiriteNumb++;
            lastmove = "up";
        }
        else if (spiriteNumb==2) {
            picture.load("resources/walkUp1.png");
            spiriteNumb++;
            lastmove = "up";

        } else if(spiriteNumb==3) {
            picture.load("resources/walkUp.png");
            spiriteNumb++;
            lastmove = "up";
        }else {
            picture.load("resources/walkUp2.png");
            spiriteNumb=1;
            lastmove = "up";
        }

        if (!abletoMoveUp){
            allowAllMoves();
            return;
        }

        if(picture.getY()<=10){
            return;
        }

        picture.translate(0, -SPEED);

    }

    public void moveLeft(){

        if(spiriteNumb==1) {
            picture.load("resources/walkLeft.png");
            spiriteNumb++;
            lastmove = "left";

        }else if (spiriteNumb==2) {
            picture.load("resources/walkLeft1.png");
            spiriteNumb++;
            lastmove = "left";
        }else if(spiriteNumb==3){
            picture.load("resources/walkLeft.png");
            spiriteNumb++;
            lastmove = "left";

        }else {
            picture.load("resources/walkLeft2.png");
            spiriteNumb=1;
            lastmove = "left";

        }

        if (!abletoMoveLeft){
            allowAllMoves();
            return;
        }

        if(picture.getX()<=10){
            return;
        }
        picture.translate(-SPEED,0);


    }

    public void moveDown(){

        if(spiriteNumb==1) {
            picture.load("resources/StandStill.png");
            spiriteNumb++;
            lastmove = "down";

        }else if (spiriteNumb==2) {
            picture.load("resources/walkDown1.png");
            spiriteNumb++;
            lastmove = "down";

        }else if(spiriteNumb==3){
            picture.load("resources/StandStill.png");
            spiriteNumb++;
            lastmove = "down";

        }else {
            picture.load("resources/walkDown2.png");
            spiriteNumb=1;
            lastmove = "down";
        }

        if (!abletoMoveDown){
            allowAllMoves();
            return;
        }

        if(picture.getY()>=580){
            return;
        }

        picture.translate(0,SPEED);

    }

    public void moveRight(){

        if(spiriteNumb==1) {
            picture.load("resources/walkRight.png");
            spiriteNumb++;
            lastmove = "right";

        }else if (spiriteNumb==2) {
            picture.load("resources/walkRight1.png");
            spiriteNumb++;
            lastmove = "right";
        }else if(spiriteNumb==3){
            picture.load("resources/walkRight.png");
            spiriteNumb++;
            lastmove = "right";
        }else{
            picture.load("resources/walkRight2.png");
            spiriteNumb=1;
            lastmove = "right";
        }

        if (!abletoMoveRight){
            allowAllMoves();
            return;
        }

        if(picture.getX()>=580){
            return;
        }

        picture.translate(SPEED,0);

    }



    public void cutTree(){
        switch (lastmove) {
            case "right":
                if (spiriteCut == 1) {
                    picture.load("resources/Rightcut1.png");
                    spiriteCut++;
                } else if (spiriteCut == 2) {
                    picture.load("resources/Rightcut.png");
                    spiriteCut--;
                }
                break;
            case "down":
                if (spiriteCut == 1) {
                    picture.load("resources/Downcut1.png");
                    spiriteCut++;
                } else if (spiriteCut == 2) {
                    picture.load("resources/Downcut.png");
                    spiriteCut--;
                }
                break;
            case "up":
                if (spiriteCut == 1) {
                    picture.load("resources/Upcut1.png");
                    spiriteCut++;
                } else if (spiriteCut == 2) {
                    picture.load("resources/Upcut.png");
                    spiriteCut--;
                }
                break;
            case "left":
                if (spiriteCut == 1) {
                    picture.load("resources/Leftcut1.png");
                    spiriteCut++;
                } else if (spiriteCut == 2) {
                    picture.load("resources/Leftcut.png");
                    spiriteCut--;
                }
                break;
        }
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