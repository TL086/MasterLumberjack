import gameobjects.*;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.*;


public class Game{

    private static final String PREFIX = "resources/";
    private final int delay;
    private static int PADDING = 10;
    private static int cellSize = 30;
    private static int cellQtyX = 30;
    private static int cellQtyY = 20;
    private Player player;
    private Tree[] trees;
    private Stone[] stones;
    private Wolf[] wolfes;
    private int treeNumb;
    private Text text;
    private Text text1;
    private boolean killedInAction;
    private int score ;


    public Game(int delay, int numOfTrees, int numOfStones, int numOfwolfes) {
        this.delay = delay;
        trees = new Tree[numOfTrees];
        stones = new Stone[numOfStones];
        wolfes = new Wolf[numOfwolfes];
        killedInAction = false;
        score = 0;
    }


    public void init() throws InterruptedException {

        Picture picture1 = new Picture(PADDING , PADDING , PREFIX + "lumberjack-start.png");
        picture1.draw();

        MyKeyboard keyboard = new MyKeyboard();
        keyboard.init();

        //Wait for user to start
        while (!MyKeyboard.start){
            Thread.sleep(10);
        }

        // Background image
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
        keyboard.setPlayer(player);

        //Generate text (SCORE)
        text = new Text(2 * PADDING , 2 * PADDING + cellQtyY * cellSize, "Score: " + score);
        text.draw();

    }



    public void start() throws InterruptedException{

        while (treeNumb > 0 && !killedInAction){

            Thread.sleep(delay);
            moveAllWolfes();

            for (int i = 0; i < trees.length; i++) {

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsUp(player, trees[i])){
                    player.setabletoMoveUp(false);
                    if (player.getCut() != 0){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsDown(player, trees[i])){
                    player.setabletoMoveDown(false);
                    if (player.getCut() != 0){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsLeft(player, trees[i])){
                    player.setabletoMoveLeft(false);
                    if (player.getCut() != 0){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsRight(player, trees[i])){
                    player.setabletoMoveRight(false);
                    if (player.getCut() != 0){
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

                    if (CollisionDetector.hasCollided(wolfes[i], player)) {
                        killedInAction = true;
                    }

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

                    if (CollisionDetector.hasCollided(wolfes[i], player)) {
                        killedInAction = true;
                    }

                    if(trees[j] == null){
                        continue;
                    }

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

        if (killedInAction){
            gameOver();
        }else {
            gameWin();
        }
    }

    public void gameWin() throws InterruptedException{
        Picture picture = new Picture(PADDING, PADDING, PREFIX + "winner.png");
        picture.draw();

        text1 = new Text(350, 2 * PADDING + cellQtyY * cellSize, "YOU WON! PRESS ENTER TO RESTART");
        text1.draw();

        while (!MyKeyboard.start){
            Thread.sleep(10);
        }
        text.delete();
        text1.delete();
        Main.main(new String[0]);
    }


    public void gameOver() throws InterruptedException {
        Picture picture1 = new Picture(PADDING , PADDING , PREFIX + "gameover.png");
        picture1.draw();

        text1 = new Text(350, 2 * PADDING + cellQtyY * cellSize, "GAME OVER! PRESS ENTER TO RESTART");
        text1.draw();
        while (!MyKeyboard.start){
            Thread.sleep(10);
        }
        text.delete();
        text1.delete();
        Main.main(new String[0]);
    }

    public void cutTree(int i){
        trees[i].cutTree();
        trees[i] = null;
        treeNumb--;
        score += 10;
        text.setText("Score: " + score);
        player.setCut(0);
    }

    public void moveAllWolfes() throws InterruptedException {
        
        for (Wolf c:wolfes) {
            killedInAction = CollisionDetector.hasCollided(player, c);
            c.move();
        }
    }

}
