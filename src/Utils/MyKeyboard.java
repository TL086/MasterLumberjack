package Utils;

import gameObjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler {

    private Keyboard keyboard;

    private Player player;


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void init(){

        keyboard = new Keyboard(this);

        int[] keys ={
            KeyboardEvent.KEY_A,
            KeyboardEvent.KEY_D,
            KeyboardEvent.KEY_S,
            KeyboardEvent.KEY_W
        };

        for (int i = 0; i <keys.length ; i++) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            event.setKey(keys[i]);
            keyboard.addEventListener(event);

        }





    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){


            case KeyboardEvent.KEY_A:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_D:
                player.moveRight();
                break;
            case KeyboardEvent.KEY_S:
                player.moveDown();
                break;
            case KeyboardEvent.KEY_W:
                player.moveUP();
                break;



        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
