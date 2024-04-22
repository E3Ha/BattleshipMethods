import java.util.Random;
import java.util.Scanner;
public class BattleshipInput {
    //Global Board setup
    private static final int ROW = 10;
    private static int COL = 10;
    private static String board [][] = new String[ROW][COL];

    //Global key for Row identification
    private static String rowKey [] = new String[COL];


    //Method for Displaying Board
    public static void display(){
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
            System.out.print(rowKey[row]);
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
        //patrolBoat() - 2
        //sub() - 3
        //carrier - 4
        //
    }
    //Method for creating patrol boats
    public static void patrolBoat(Random rand) {
        int direction = rand.nextInt(2);
        int randRow = rand.nextInt(8);
        int randCol = rand.nextInt(8);

    }

    //Method for Valid Move
    private static boolean isValidMove(int row, int col, String shipType, int direction){
        //If space is not filled, return true
        //0 = rows
        //1 = cols
        int count = 0;

        //if the first spot is valid
        if (board[row][col] == "\uD83C\uDF0A"){
            count += 1;
            //if we're placing along the row...
            if (direction == 0) {
                //Check for amount of available space - need to find contiguous space
                for (int i = 0; i < COL; i++) {
                    if (board[row + i][col] == "\uD83C\uDF0A") {
                        count++;
                    }
                }
            }
            //if we're placing along the column...
            if (direction == 1) {
                //Check for amount of available space - need to find contiguous space
                for (int i = 0; i < COL; i++) {
                    if (board[row][col + i] == "\uD83C\uDF0A") {
                        count++;
                    }
                }
            }
        }
        //if (shipType == "" && count = #) {return true}
        //else if (shipType == patrolBoat && count == 2){return true}

        return false;
    }


}
