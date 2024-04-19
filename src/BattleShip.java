import java.util.Random;
import java.util.Scanner;

public class BattleShip {
    //Global Board setup
    private static final int ROW = 10;
    private static int COL = 10;

    private static String board [][] = new String[ROW][COL];

    //Global imports
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();


    public static void main(String[] args) {

        BattleshipInput.clearBoard();
        BattleshipInput.display();



    }


}