import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {

    //Global imports
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {

        BattleshipInput.clearBoard();
        BattleshipInput.placeBoats();
        BattleshipInput.display();

    }
}