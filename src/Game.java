import Utils.CollisionDetector;
import Utils.MyKeyboard;
import gameObjects.Player;
import gameObjects.Square;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {


    private static final String PREFIX = "resources/";
    private final int delay;

    private Player player;

    private Square[] squares;

    private int score = 0 ;

    private Text text;

    public Game(int delay, int numOfSquares){
        this.delay = delay;
        squares = new Square[numOfSquares];
            }

    public void init(){


        player = new Player(10,10,PREFIX + "sonic3.png");

        for (int i = 0; i <squares.length ; i++) {
            squares[i] = new Square(100 * i ,150 , 20);
                   }

        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.init();
        myKeyboard.setPlayer(player);
        text = new Text(10,10, "Score: " + score);
        text.draw();

    }


    public void start() throws InterruptedException{

        while(true){

            Thread.sleep(delay);


            for (int i = 0; i <squares.length ; i++) {

                if(squares[i]==null){
                    continue;
                }

                if(CollisionDetector.hasCollided(player, squares[i])){

                    squares[i].removeSquare();
                    squares[i]=null;
                    score+= 100;
                    text.setText("Score:" + score);

                }
            }

            }

    }





}
