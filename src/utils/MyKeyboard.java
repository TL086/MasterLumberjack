package utils;
import gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.*;



public class MyKeyboard implements KeyboardHandler {

    public Keyboard keyboard;
    public Player player;
    public static boolean start = false;


    public void setPlayer(Player player) {
        this.player = player;
    }


    public void init() {

        keyboard = new Keyboard(this);

        int[] keys = {
                KeyboardEvent.KEY_ENTER,
                KeyboardEvent.KEY_SPACE,
                KeyboardEvent.KEY_LEFT,
                KeyboardEvent.KEY_RIGHT,
                KeyboardEvent.KEY_UP,
                KeyboardEvent.KEY_DOWN
        };


        for (int i = 0; i < keys.length; i++) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            event.setKey(keys[i]);
            keyboard.addEventListener(event);
        }
        for (int i = 0; i < keys.length; i++) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            event.setKey(keys[i]);
            keyboard.addEventListener(event);
        }
    }

    public void init2() {

        keyboard = new Keyboard(this);

        int key =  KeyboardEvent.KEY_ENTER;

            KeyboardEvent event1 = new KeyboardEvent();

            event1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            event1.setKey(key);
            keyboard.addEventListener(event1);

            event1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            event1.setKey(key);
            keyboard.addEventListener(event1);
    }




    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_ENTER:
                start = true;
                break;
            case KeyboardEvent.KEY_SPACE:
                player.axlStroke();
                break;
            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                break;
            case KeyboardEvent.KEY_UP:
                player.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                break;
        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                player.axlStroke();
                break;
            case KeyboardEvent.KEY_ENTER:
                start = false;
                break;
        }
    }

}