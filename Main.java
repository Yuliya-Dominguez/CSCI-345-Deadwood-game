import java.util.Scanner;

public class Main {

    Player player = new Player();
    Deadwood deadwood = new Deadwood();
    Day day = new Day();
    Store store = new Store();
    Board board = new Board();
    WrappingUp wrapUp = new WrappingUp();
    SceneCards sceneCards = new SceneCards();
    LocationManager locManager = new LocationManager();
    Acting acting = new Acting();
    Dice dice = new Dice();

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Deadwood! Please enter the number of players: ");
        int playerNum = input.nextInt();

        if ((playerNum < 2) || (playerNum > 8)) {
            System.out.println("Error. Please enter a number between 2 and 8.");
        }
        else {
            int i = 0;
            while (i < playerNum) {
                System.out.println(("What is Player ") + i + (" name? \n"));
                //Something here to keep track of player names and store them from input.
                i++;
            }
            
        }
    input.close();
}

}