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

    //Global key for Row identification
    private static String rowKey [] = new String[COL];

    public static void main(String[] args) {

        BattleshipInput.clearBoard();
        BattleshipInput.display();
        //Need to simplify
        rowKey[0] = "A";
        rowKey[1] = "B";
        rowKey[2] = "C";
        rowKey[3] = "D";
        rowKey[4] = "E";
        rowKey[5] = "F";
        rowKey[6] = "G";
        rowKey[7] = "H";
        rowKey[8] = "I";
        rowKey[9] = "J";


    }


}