package learn.gomoku;
import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Stone;

import java.util.Arrays;
import java.util.Scanner;


public class App {
    public static Menu menu = new Menu();
    public static Gameplay gameplay = new Gameplay();
    public static Gomoku game;


    public static void main(String[] args) {
         gameplay.run();

    }


}
