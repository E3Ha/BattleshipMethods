import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {

    //Global imports
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {

        int hitCount = 0;
        int missCount = 0;

        BattleshipInput.clearBoard();
        BattleshipInput.placeBoats();
        BattleshipInput.display();

        do {
            if (BattleshipInput.playerMove()){
                hitCount++;
                missCount = 0;
            }
            else{
                missCount++;
            }
            BattleshipInput.display();
        }
        while(hitCount != 5);

        System.out.println("You have hit 5 times!");


    }
}