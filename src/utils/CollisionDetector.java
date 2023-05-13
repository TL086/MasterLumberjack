package utils;

import gameobjects.Collidable;
import gameobjects.Player;

public class CollisionDetector {



    public static boolean hasCollided(Collidable c1, Collidable c2){
        return (c1.getX() + c1.getWidth()) > c2.getX() &&
                c1.getX() < (c2.getX() + c2.getWidth()) &&
                (c1.getY() + c1.getHeight()) > c2.getY() &&
                c1.getY() < (c2.getY() + c2.getHeight());

    }

    public static boolean elementIsUp(Player c1, Collidable c2){
        return c1.getY() == (c2.getY() + c2.getHeight()) &&
                (c1.getX() == c2.getX() || c1.getX()+c1.getHeight() == c2.getX()+c2.getHeight());
    }

    public static boolean elementIsDown(Player c1, Collidable c2){
        return (c1.getY() + c1.getHeight()) == c2.getY() &&
                (c1.getX() == c2.getX() || c1.getX()+c1.getHeight() == c2.getX()+c2.getHeight());
    }

    public static boolean elementIsLeft(Player c1, Collidable c2){
        return c1.getX() == (c2.getX() + c2.getWidth()) &&
                (c1.getY() == c2.getY() || c1.getY()+c1.getWidth() == c2.getY()+c2.getWidth());
    }

    public static boolean elementIsRight(Player c1, Collidable c2){
        return (c1.getX() + c1.getWidth()) == c2.getX() &&
                (c1.getY() == c2.getY() || c1.getY()+c1.getWidth() == c2.getY()+c2.getWidth());
    }









}
