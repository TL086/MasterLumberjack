import gameobjects.*;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import utils.CollisionDetector;
import utils.MyKeyboard;

public class Game {

    private static final String PREFIX = "resources/";
    private final int delay;
    private static int PADDING = 10;
    private static int cellSize = 30;
    private static int cellQty = 20;

    private Player player;
    private Tree[] trees;
    private Stone[] stones;
    private Wolf[] wolfes;
    private int treeNumb;
    private Text text;
    private Picture picture;

    private int score = 0;


    public Game(int delay, int numOfTrees, int numOfStones) {
        this.delay = delay;
        trees = new Tree[numOfTrees];
        stones = new Stone[numOfStones];
    }

    public void init(){

        Picture picture = new Picture(PADDING, PADDING, PREFIX + "Grass1.png");
        picture.draw();

        //Generate random trees
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree(PADDING + ((int) (Math.random()*cellQty))*cellSize,PADDING + ((int) (Math.random()*cellQty))*cellSize, PREFIX + "Tree.png");
        }
        treeNumb = trees.length;

        //Generate random stones
        for (int i = 0; i < stones.length; i++) {
            stones[i] = new Stone(PADDING + ((int) (Math.random()*cellQty))*cellSize,PADDING + ((int) (Math.random()*cellQty))*cellSize, PREFIX + "stone.png");
        }

        //Generate random wolfs
        /*for (int i = 0; i < stones.length; i++) {
            wolfes[i] = new Wolf(PADDING + ((int) (Math.random()*cellQty))*cellSize,PADDING + ((int) (Math.random()*cellQty))*cellSize, PREFIX + "stone1.png");
        }*/


        //Generate player
        player = new Player(PADDING + ((int) (Math.random()*cellQty))*cellSize, PADDING + ((int) (Math.random()*cellQty))*cellSize, PREFIX + "StandStill.png");

        MyKeyboard keyboard = new MyKeyboard();
        keyboard.init();
        keyboard.setPlayer(player);

        text = new Text(10, 2*PADDING + cellQty * cellSize, "Score: " + score);
        text.draw();

    }


    public void start() throws InterruptedException{

        while (treeNumb>0){

            Thread.sleep(delay);

            for (int i = 0; i < trees.length; i++) {

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsUp(player, trees[i])){
                    player.setabletoMoveUp(false);
                    if (player.getCut()==3){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsDown(player, trees[i])){
                    player.setabletoMoveDown(false);
                    if (player.getCut() == 3){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsLeft(player, trees[i])){
                    player.setabletoMoveLeft(false);
                    if (player.getCut() == 3){
                        cutTree(i);
                    }
                }

                if(trees[i] == null){
                    continue;
                }

                if(CollisionDetector.elementIsRight(player, trees[i])){
                    player.setabletoMoveRight(false);
                    if (player.getCut() == 3){
                        cutTree(i);
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

}
