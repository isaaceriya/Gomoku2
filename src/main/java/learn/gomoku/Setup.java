package learn.gomoku;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.RandomPlayer;

import java.util.Scanner;

public class Setup {
    private static Scanner scanner = new Scanner( System.in );
    private HumanPlayer humanplayer;
    public static RandomPlayer randomplayer = new RandomPlayer();

    public void greeting(){
        System.out.println("Welcome to Gomoku");
    }


    public static void setup(){
        RandomPlayer randomplayer = new RandomPlayer();
        System.out.print("Player1 is: " +"\n" +
                "1.Human" +"\n"+
                "2.Random player"+"\n"+
                "Select [1-2]: ");
        System.out.print("Option: ");
        int option = scanner.nextInt();
        if (option == 1){
            System.out.print("Option1");
            System.out.println("Enter Player1 Name");
            String name = scanner.nextLine();
        } else if(option == 2){
            System.out.print("Option2");
            String name = randomplayer.getName();
            System.out.print(name);

        }




    }





}
