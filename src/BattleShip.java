import java.util.Random;
import java.util.Scanner;

public class Main {
    //Global Board setup
    private static final int ROW = 10;
    private static int COL = 10;
    private static String board [][] = new String[ROW][COL];

    //Global imports
    private static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {




        
    }
    //Method for Displaying Board
    private static void display(){
        for (int row = 0; row < ROW; row++){
            System.out.print("| ");
            for (int col = 0; col < COL; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    //Method for Clearing Board
    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = "-";
            }
        }
    }

}