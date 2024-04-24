import java.util.Random;
import java.util.Scanner;
public class BattleshipInput {
    //Global Board setup
    private static final int ROW = 10;
    private static int COL = 10;
    private static String board [][] = new String[ROW][COL];

    //Global ShipLengths
    private static int PATROL = 1;
    private static int SUB = 2;
    private static int GUNNER = 3;
    private static int CARRIER = 4;


    //Method for Displaying Board
    public static void display(){
        //Need to simplify
        System.out.print("   ");
        System.out.print("\uFF21"+" "); //A
        System.out.print("\uFF22"+" "); //B
        System.out.print("\uFF23"+" "); //C
        System.out.print("\uFF24"+" "); //D
        System.out.print("\uFF25"+" "); //E
        System.out.print("\uFF26"+" "); //F
        System.out.print("\uFF27"+" "); //G
        System.out.print("\uFF28"+" "); //H
        System.out.print("\uFF29"+" "); //I
        System.out.print("\uFF2A"); //J
        System.out.print("    ");
        System.out.println();

        for (int c = 0; c < 30; c++){
            System.out.print("-");
        }
        System.out.println();
        for (int row = 0; row < ROW; row++){
            System.out.print(row + 1);
            System.out.print("| ");
            for (int col = 0; col < COL; col++){
                //System.out.print(board[row][col] + " | ");
                System.out.print(board[row][col] + " ");
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
        placeShip(PATROL);
        placeShip(SUB);
        placeShip(GUNNER);
        placeShip(CARRIER);
        //patrolBoat() - 2
        //submarine() - 3
        //destroyer() - 3
        //battleShip() - 4
        //carrier() - 5
    }
/*
    //Method for creating patrol boats
    public static void patrolBoat(Random rand) {
        int direction = rand.nextInt(2);
        int randRow = 0;
        int randCol = 0;
        boolean validPlacement = false;


        //Determine valid location
        while (!validPlacement){
            randRow = rand.nextInt(8);
            randCol = rand.nextInt(8);
            validPlacement = isValidMove(randRow, randCol, 2, direction);
        }

        //Place ship if Valid
        if (validPlacement){
            //Place ship along row
            if (direction == 0) {
                for(int i = 0; i<= 2; i++){
                    board[randRow+i][randCol] = "ship";
                }
            }

            //Place ship along column
            else if (direction == 1) {
                for (int i = 0; i < 2; i++) {
                    board[randRow][randCol + i] = "ship";
                }
            }
        }


    }
*/
/*
    //Method for Valid Move
    private static boolean isValidMove(int row, int col, int shipLength, int direction){
        //0 = rows, 1 = cols
        int count = 0;


        //if the first spot is valid
        if (board[row][col] == "\uD83C\uDF0A"){
            count += 1;
            //if we're placing along the row...
            if (direction == 0) {
                //Check for amount of available space
                for (int i = 0; i < (shipLength -= 1); i++) {
                    if (board[row + i][col] == "\uD83C\uDF0A") {
                        //add to count of available space
                        count++;
                    }
                }
            }
            //if we're placing along the column...
            if (direction == 1) {
                //Check for amount of available space
                for (int i = 0; i < (shipLength -= 1); i++) {
                    if (board[row][col + i] == "\uD83C\uDF0A") {
                        //add to count of available space
                        count++;
                    }
                }
            }
        }
        //determine based on shipLength && amount of available space if valid
        if (shipLength == 2 && count == 2){
            return true;
        }
        else if (shipLength == 3 && count == 3){
            return true;
        }
        else if (shipLength == 4 && count == 4){
            return true;
        }
        else if (shipLength == 5 && count == 5){
            return true;
        }
        //...Otherwise, return false
        return false;
    }
*/

    //Method that places all boats - shown in class
    public static void placeShip(int shipLength) {
        Random rand = new Random();
        //Vert or Hora needs to be bound to 2 (0,1)
        int direction = rand.nextInt(2);
        //need to count valid spaces
        int validSpaces = 0;
        int row = 0;
        int col = 0;
        //place ships vertically
        if (direction == 0){
            //rely on column - check all positions to see if valid
            do {
                //reset the validSpaces (counter), if enough spaces = valid - exit & place boats
                validSpaces = 0;
                //account for space needed to place rest of boat
                row = rand.nextInt(10 - shipLength);
                col = rand.nextInt(10 - shipLength + 1);
                //System.out.println("Vertically placing " + shipLength + " in position: " + row + " " + col);
                for (int i = 0; i <= shipLength; i++){
                    if (board[row + i][col].equals ("\uD83C\uDF0A")){
                        //sub needs 2 more spaces, gunner needs 3, carrier needs
                        validSpaces ++;
                    }
                }
            }
            while(validSpaces != (shipLength+1));
            //we have a valid row area, place the ship
            for(int i = 0; i<= shipLength; i++){
                board[row+i][col] =  "\u26F4";
            }
        }
        //place ship horizontally
        else{
            //rely on column - check positions
            do {
                //reset the validSpaces (counter), if enough spaces = valid - exit & place boats
                validSpaces = 0;
                //account for space needed to place rest of boat
                row = rand.nextInt(10 - shipLength + 1);
                col = rand.nextInt(10 - shipLength);
                //System.out.println("Horizontally placing " + shipLength + " in position: " + row + " " + col);
                for (int i = 0; i <= shipLength; i++){
                    if (board[row][col + i].equals ("\uD83C\uDF0A")){
                        //sub needs 2 more spaces, gunner needs 3, carrier needs 4
                        validSpaces ++;
                    }
                }
            }
            while(validSpaces!=(shipLength+1));
            //we have a valid row area, place the ship
            for(int i = 0; i<= shipLength; i++){
                board[row][col+i] =  "\u26F4";
            }
        }
    }

}
