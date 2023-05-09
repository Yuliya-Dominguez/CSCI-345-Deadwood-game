import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

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
    List<Player> gamePlayers = new ArrayList<Player>();

    Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Deadwood! Please enter the number of players: ");
        int playerNum = input.nextInt();

        if ((playerNum < 2) || (playerNum > 8)) {
            System.out.println("Error. Please enter a number between 2 and 8.");
        }
        else {
            for(int a = 0; a < playerNum; a++) {
                Player player1 = new Player();
                gamePlayers.add(player1);
            }


            int i = 0;
            
            while (i < playerNum) {
                System.out.println(("What is Player ") + (i + 1) + (" name? \n"));
                String inputName = input.next();
                for(Player player:gamePlayers) {
                    player.name = inputName;
                }
                i++;
            } 
        }

    System.out.println("Thank you! We are still working on the rest, so stay tuned!");
    input.close();
}

}