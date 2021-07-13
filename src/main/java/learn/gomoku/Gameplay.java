package learn.gomoku;
import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Stone;
import learn.gomoku.game.Result;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class Gameplay {
    private static Scanner scanner = new Scanner( System.in );
    public String[][] stones = new String[16][16];
    public static Menu menu = new Menu();
    private final Random random = new Random();
//    private HumanPlayer humanPlayer;
    private Player one;
    private Player two;
    private Gomoku game;
    private Player turn;
    public int ranx = random.nextInt(Gomoku.WIDTH);
    public int rany = random.nextInt(Gomoku.WIDTH);


    public Gameplay(){
        one = menu.playersetup(1);
        two = menu.playersetup(2);
        game = new Gomoku(one, two);
        turn = game.getCurrent();
        setupstones();
    }


    public void run() {
        while(!game.isOver()) {
            Stone stone = game.getCurrent().generateMove(game.getStones());
            System.out.println("It's " + turn.getName() + " Turn");
            if (stone == null){
                move();
                printworld();
                System.out.println(" ");
//                System.out.println("It's " + turn.getName() + " Turn");


            } else{
                if (checkmove(game.getStones()));{
                    generatemove();
                    printworld();
                    System.out.println(" ");
//                    System.out.println("It's " + turn.getName() + " Turn");
                }
            }
        } gameover();
    }





    public void printworld() {
        for(int i = 0; i <= 15; i++){ //row
            for(int j = 0; j<=15; j++){ //Col
                if(j == 0){
                    System.out.println("");
                }
                System.out.print(stones[i][j]);
            }//After 15 J deletes itself
        }

    }

    public void setupstones(){
        stones[0][0] = "  ";
        for(int i = 1; i <= 15; i++) {
            if (i < 10) {
                stones[0][i] = "0" + i + " ";
                stones[i][0] = "0" + i;
            } else {
                stones[0][i] = i + " ";
                stones[i][0] = String.valueOf(i);
            }
        }
        for(int j = 1; j <= 15; j++){
            for(int k =1; k<=15; k++){
                stones[j][k] = " - ";
            }
        }
    }





    public boolean checkmove(List<Stone> previousMoves){
        boolean isBlack = true;
        if (previousMoves != null && !previousMoves.isEmpty()) {
            Stone lastMove = previousMoves.get(previousMoves.size() - 1);
            isBlack = !lastMove.isBlack();
        }
        return isBlack;

    }

    public void swap(){
        if (turn == one){
            turn = two;
        }else{
            turn = one;
        }

    }

    public void generatemove(){
        boolean isBlack = checkmove(game.getStones());
        ranx = random.nextInt(Gomoku.WIDTH);
        rany = random.nextInt(Gomoku.WIDTH);
        Result actual = game.place(new Stone(ranx-1 , rany-1, isBlack));
        Result expected = new Result("The stone is in the wrong position");
        if(expected != actual){
            if(actual.isSuccess()){
                if(isBlack){
                    stones[ranx][rany] = " X ";

                } else{
                    stones[ranx][rany] = " O ";
                }
                swap();
            }else{
                System.out.println(expected.getMessage());
            }
        }
    }

    public void move(){
        boolean isBlack = checkmove(game.getStones());
        System.out.print("Enter a row");
        int row = scanner.nextInt();
        System.out.print("Enter a column");
        int column = scanner.nextInt();
        Result actual = game.place(new Stone(row-1, column-1, isBlack));
        Result expected = new Result("The stone is in the wrong position");
        if(expected != actual){
            if(actual.isSuccess()){
                if(isBlack){
                    stones[row][column] = " X ";
                } else{
                    stones[row][column] = " O ";
                }
                swap();
            } else{
                System.out.println(expected.getMessage());
            }
        }
    }

    public void restartquest(){
        Scanner myObj = new Scanner(System.in);
        System.out.print("Play Again? [y/n]: ");
        String  option = myObj.nextLine();
        if(option.equals("y")){
            restart();
;
        }
        else if (option.equals("n")){
            System.out.println("goodbye");
        }
    }
    public void restart(){
        one = menu.playersetup(1);
        two = menu.playersetup(2);
        game = new Gomoku(one, two);
        turn = game.getCurrent();
        setupstones();
        run();
    }

    public void gameover(){
        swap();
        System.out.println(turn.getName() + " has won");
        restartquest();
    }
}











        /*if (turn == one) {
            System.out.print("Enter a row");
            int row = scanner.nextInt();
            System.out.print("Enter a column");
            int column = scanner.nextInt();


            if (stones[row][column] == " - "){
                stones[row][column]= " X ";
                turn = two;
                game.place(new Stone (row, column, true));
                stones[row][column]= " X ";
                turn = two;
            }else{
//                Result actual = game.place(new Stone(row, column, false));
//                System.out.println(actual);
                game.place(new Stone (row, column, false));
                System.out.println("Line Already taken try again");
                move();
            }

        } else if(turn == two) {
            System.out.print("Enter a row");
            int row = scanner.nextInt();
            System.out.print("Enter a column");
            int column = scanner.nextInt();
            if (stones[row][column] == " - "){
                stones[row][column]= " O ";
                printworld();
                turn = one;

            }else{
                System.out.println("Line Already taken try again");
                move();
            }
        }*/



 /*
 * Constructor where we pass a Gomoku object
 * */