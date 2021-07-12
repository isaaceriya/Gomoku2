package learn.gomoku;
import learn.gomoku.game.Gomoku;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.RandomPlayer;
import learn.gomoku.players.Player;

import javax.swing.event.HyperlinkEvent;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner( System.in );
//    private HumanPlayer humanPlayer;
    Player one;


    public Player playersetup(int i){
        Scanner myObj = new Scanner(System.in);
            System.out.print("Player"+ i+ " is: " +"\n" +
                    "1.Human" +"\n"+
                    "2.Random player"+"\n"+
                    "Select [1-2]: ");
            int option = scanner.nextInt();
            if (option == 1){
                System.out.print("Enter Player"+ i + " Name: ");
                Player one = new HumanPlayer(myObj.nextLine());
                return one;
            }else if(option == 2){
                Player one = randomPlayer();
                return one;
            }

        return one;
    }

    public Player randomPlayer(){
        Player randomPlay = new RandomPlayer();
      return randomPlay;

    }

}








//    private RandomPlayer randomPlayer;
//    public static RandomPlayer randomplayer = new RandomPlayer();
//    public static String playerOne;
//    public static String playerTwo;

    /*public void greeting(){
        System.out.println("Welcome to Gomoku");
        setup();
    }


    public void setup(){
        Player one = playeroneSetup();
        Player two = playertwoSetup();
        Gomoku game = new Gomoku(one,two);
//        Player tsss = game.getCurrent();
//        System.out.println(tsss);
        System.out.println(one);
//        System.out.println(two);


    }

        public Player playeroneSetup(){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Player1 is: " +"\n" +
                "1.Human" +"\n"+
                "2.Random player"+"\n"+
                "Select [1-2]: ");
        int option = scanner.nextInt();
        if (option == 1){
            System.out.print("Enter Player1 Name: ");
            Player one = new HumanPlayer(myObj.nextLine());
            return one;
        } else if(option == 2){
           Player one = randomOne();
           return one;
        }
        return humanPlayer;
    }

        public Player playertwoSetup(){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Player2 is: " +"\n" +
                "1.Human" +"\n"+
                "2.Random player"+"\n"+
                "Select [1-2]: ");
        int option = scanner.nextInt();
        if (option == 1){
            System.out.print("Enter Player1 Name: ");
            String theplayer2 = myObj.nextLine();
            Player two = new HumanPlayer(theplayer2);
            return two;
        } else if(option == 2){
            Player two = randomOne();
            return two;
        }
        return humanPlayer;
    }

    public Player randomTwo(){
        Player randomPlay2 = new RandomPlayer();
        return randomPlay2;

    }



    */




