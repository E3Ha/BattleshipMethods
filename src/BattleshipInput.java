import java.util.Random;
import java.util.Scanner;
public class BattleshipInput {
    //Global Board setup
    private static final int ROW = 10;
    private static int COL = 10;
    private static String board [][] = new String[ROW][COL];

    //Method for Displaying Board
    public static void display(){
        System.out.print("    ");
        for (int i = 1; i < ROW + 1; i++){
            System.out.print(i + "   ");
        }
        System.out.println();
        for (int c = 0; c < 40; c++){
            System.out.print("-");
        }
        System.out.println();
        for (int row = 0; row < ROW; row++){
            System.out.print("A ");
            System.out.print("| ");
            for (int col = 0; col < COL; col++){
                //System.out.print(board[row][col] + " | ");
                System.out.print(board[row][col] + "  ");
            }
            System.out.println();
        }
    }

    //Method for Clearing Board
    public static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = "\uD83C\uDF0A";
            }
        }
    }
    //Method for placing ships
    public static void placeBoats() {

    }
    //Method for creating patrol boats
    public static void patrolBoat(Random rand) {
        int direction;

    }


}
