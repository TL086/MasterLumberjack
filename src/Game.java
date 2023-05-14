import gameobjects.*;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.*;


public class Game{

    private static final String PREFIX = "resources/";
    private final int delay;
    private static int PADDING = 10;
    private static int cellSize = 30;
    private static int cellQtyX = 30;
    private static int cellQtyY = 20;
    private static int gridSizeX = cellSize * cellQtyX;
    private static int SPEED;


    private Player player;
    private Tree[] trees;
    private Stone[] stones;
    private Wolf[] wolfes;
    private int treeNumb;
    private Text text;
    private boolean startKey = false;

    private int score = 0;


    public Game(int delay, int numOfTrees, int numOfStones, int numOfwolfes, int SPEED) {
        this.delay = delay;
        trees = new Tree[numOfTrees];
        stones = new Stone[numOfStones];
        wolfes = new Wolf[numOfwolfes];
        this.SPEED = SPEED;
    }




/*
    public void firstScreen(){

        Picture picture = new Picture(PADDING , PADDING , PREFIX + "lumberjack.png");
        picture.draw();
        MyKeyboard keyboard = new MyKeyboard();
        keyboard.init();

        while (!MyKeyboard.startON){}


    }*/


    public void init(){


        Picture picture = new Picture(PADDING , PADDING , PREFIX + "Grass1.png");
        picture.draw();

        //Generate random trees
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree(PADDING + ((int) (Math.random()*cellQtyX))*cellSize,PADDING + ((int) (Math.random()*cellQtyY))*cellSize, PREFIX + "Tree.png");
        }
        treeNumb = trees.length;

        //Generate random stones
        for (int i = 0; i < stones.length; i++) {
            stones[i] = new Stone(PADDING + ((int) (Math.random()*cellQtyX))*cellSize,PADDING + ((int) (Math.random()*cellQtyY))*cellSize, PREFIX + "stone.png");
        }

        //Generate random wolfs
        for (int i = 0; i < wolfes.length; i++) {
            wolfes[i] = new Wolf(PADDING + ((int) (Math.random()*cellQtyX))*cellSize,PADDING + ((int) (Math.random()*cellQtyY))*cellSize, PREFIX + "Wolf.png");
        }


        //Generate player
        player = new Player(PADDING + ((int) (Math.random()*cellQtyX))*cellSize, PADDING + ((int) (Math.random()*cellQtyY))*cellSize, PREFIX + "StandStill.png");

        MyKeyboard keyboard = new MyKeyboard();
        keyboard.init();
        keyboard.setPlayer(player);

        text = new Text(2 * PADDING , 2 * PADDING + cellQtyY * cellSize, "Score: " + score);
        text.draw();

    }





    public void start() throws InterruptedException{

        while (treeNumb>0){
            
            
            //moveAllWolfes();

            Thread.sleep(delay);



            for (int i = 0; i < trees.length; i++) {

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsUp(player, trees[i])){
                    player.setabletoMoveUp(false);
                    if (player.getCut()==4){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsDown(player, trees[i])){
                    player.setabletoMoveDown(false);
                    if (player.getCut() == 4){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsLeft(player, trees[i])){
                    player.setabletoMoveLeft(false);
                    if (player.getCut() == 4){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsRight(player, trees[i])){
                    player.setabletoMoveRight(false);
                    if (player.getCut() == 4){
                        cutTree(i);
                    }
                }
            }


            for (int i = 0; i < stones.length; i++) {

                if(CollisionDetector.elementIsUp(player, stones[i])){
                    player.setabletoMoveUp(false);
                }

                if(CollisionDetector.elementIsDown(player, stones[i])){
                    player.setabletoMoveDown(false);
                }

                if(CollisionDetector.elementIsLeft(player, stones[i])){
                    player.setabletoMoveLeft(false);
                }

                if(CollisionDetector.elementIsRight(player, stones[i])){
                    player.setabletoMoveRight(false);
                }
            }







            for (int i = 0; i < wolfes.length; i++) {
                for (int j = 0; j < stones.length; j++) {

                    if (CollisionDetector.elementIsUp(wolfes[i], stones[j])) {
                        wolfes[i].setabletoMoveUp(false);
                    }

                    if (CollisionDetector.elementIsDown(wolfes[i], stones[j])) {
                        wolfes[i].setabletoMoveDown(false);
                    }

                    if (CollisionDetector.elementIsLeft(wolfes[i], stones[j])) {
                        wolfes[i].setabletoMoveLeft(false);
                    }

                    if (CollisionDetector.elementIsRight(wolfes[i], stones[j])) {
                        wolfes[i].setabletoMoveRight(false);
                    }
                }
            }

            for (int i = 0; i < wolfes.length; i++) {
                for (int j = 0; j < trees.length; j++) {

                    if (CollisionDetector.elementIsUp(wolfes[i], trees[j])) {
                        wolfes[i].setabletoMoveUp(false);
                    }

                    if (CollisionDetector.elementIsDown(wolfes[i], trees[j])) {
                        wolfes[i].setabletoMoveDown(false);
                    }

                    if (CollisionDetector.elementIsLeft(wolfes[i], trees[j])) {
                        wolfes[i].setabletoMoveLeft(false);
                    }

                    if (CollisionDetector.elementIsRight(wolfes[i], trees[j])) {
                        wolfes[i].setabletoMoveRight(false);
                    }
                }
            }










        }
        text.setText("YOU WIN!!!!!!!!!! " + score + " points");
    }

    public void cutTree(int i){
        trees[i].cutTree();
        trees[i] = null;
        treeNumb--;
        score += 10;
        text.setText("Score: " + score);
    }


    public static int getSPEED() {
        return SPEED;
    }

    public void moveAllWolfes() throws InterruptedException {
        
        for (int i = 0; i < wolfes.length; i++) {
            wolfes[i].move();
        }
    }


}
