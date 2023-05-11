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
    //private Square square;
    private Tree[] trees;
    private int treeNumb;
    private Text text;
    private Picture picture;



    private int score = 0;


    public Game(int delay, int numOfSquares) {
        this.delay = delay;
        trees = new Tree[numOfSquares];
    }

    public void init(){

        Picture picture = new Picture(PADDING, PADDING, PREFIX + "Grass1.png");
        picture.draw();

        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree(PADDING + ((int) (Math.random()*cellQty))*cellSize,PADDING + ((int) (Math.random()*cellQty))*cellSize, PREFIX + "Tree.png");
        }
        treeNumb = trees.length;

        player = new Player(PADDING + ((int) (Math.random()*cellQty))*cellSize, PADDING + ((int) (Math.random()*cellQty))*cellSize, PREFIX + "archer-1.png");

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

                if(CollisionDetector.hasCollided(player, trees[i])){
                    System.out.println("COLLISION");
                    trees[i].cutTree();
                    trees[i] = null;
                    treeNumb--;
                    score += 10;
                    text.setText("Score: " + score);
                    //player gets some points
                }

            }








        }

        text.setText("YOU WIN!!!!!!!!!! " + score + " points");

    }

}
