import java.util.Random;
import java.util.Scanner;
public class BattleshipInput {
    //Global Board setup
    private static final int ROW = 10;
    private static final int COL = 10;
    private static String board [][] = new String[ROW][COL];

    //Global ShipLengths
    private static int PATROL = 1;
    private static int SUB = 2;
    private static int GUNNER = 3;
    private static int CARRIER = 4;


    //Method for Displaying Board
    public static void display(){
        //Print top Letters
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
        //Print top border
        for (int c = 0; c < 30; c++){
            System.out.print("-");
        }
        System.out.println();
        for (int row = 0; row < ROW; row++){
            //Print side Numbers && Border
            System.out.print(row + 1);
            System.out.print("| ");
            //Print Board
            for (int col = 0; col < COL; col++){
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
    }

    //Method that places all boats
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

    //Method for determining hit or miss when playerMove
    public static boolean playerMove() {
        Scanner scan = new Scanner(System.in);
        int userRow;
        String tempCol = "";
        int userCol = -1;
        //Collect player's move (row && column)
        userRow = (SafeInput.getRangedInt(scan, "Row (1-10): ", 1, ROW)) - 1;
        do {
            tempCol = SafeInput.getNonZeroLenString(scan, "Col (A-J): ");
            tempCol = tempCol.toLowerCase();
            switch (tempCol) {
                case "a":
                    userCol = 0;
                    break;
                case "b":
                    userCol = 1;
                    break;
                case "c":
                    userCol = 2;
                    break;
                case "d":
                    userCol = 3;
                    break;
                case "e":
                    userCol = 4;
                    break;
                case "f":
                    userCol = 5;
                    break;
                case "g":
                    userCol = 6;
                    break;
                case "h":
                    userCol = 7;
                    break;
                case "i":
                    userCol = 8;
                    break;
                case "j":
                    userCol = 9;
                    break;
            }
        }
        while (userCol == -1);

        return true;
        //Have they moved to that location already? - if they have, loop until they give us a valid location

        //If they haven't moved to that location already...

        //If there's a ship in that location, it's a hit - return true

        //Else if a wave is in that location (not a ship) - it's a miss - return false

    }



/*
//Method for making a move on the board - TicTacToe
    private static void makeMove(String player){
        int userRow;
        int userCol;
        //Get Row and Column (subtract 1 for the array)
        userRow = (SafeInput.getRangedInt(scan, "Row " + "[" + player + "]: ", 1, ROW)) - 1;
        userCol = (SafeInput.getRangedInt(scan, "Column " + "[" + player + "]: ", 1, COL)) - 1;
        System.out.println();
        //if spot is taken (validMove is false)...
        if (!isValidMove(userRow,userCol)){
            //loop until user gives a valid location
            do {
                System.out.println();
                System.out.println("Invalid Move. Try Again.");
                userRow = (SafeInput.getRangedInt(scan, "Row: ", 1, ROW)) - 1;
                userCol = (SafeInput.getRangedInt(scan, "Column: ", 1, COL)) - 1;
            }
            while (!isValidMove(userRow,userCol));
        }
        //Make move if valid
        board[userRow][userCol] = player;
    }
 */
/*
//TicTacToe - Valid move method
private static boolean isValidMove(int row, int col){
        //If space is not filled, return true
        if (board[row][col] == "-"){
            return true;
        }
        return false;
    }
 */





}
