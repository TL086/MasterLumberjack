package utils;

import gameobjects.Player;
import org.academiadecodigo.simplegraphics.keyboard.*;


import java.security.Key;

public class MyKeyboard implements KeyboardHandler {



    public Keyboard keyboard;
    public Player player;


    public void setPlayer(Player player){
        this.player = player;
    }

    public void init(){

        keyboard = new Keyboard(this);

        int[] keys = {
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
    }


    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                System.out.println("space was pressed");
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

    }
}