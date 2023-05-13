import java.util.*;


public class Main {

    Player player = new Player();
    Deadwood deadwood = new Deadwood();
    Store store = Store.getStoreInstance();
    Board board = new Board();
    WrappingUp wrapUp = new WrappingUp();
    SceneCards sceneCards = new SceneCards();
    LocationManager locManager = new LocationManager();
    Acting acting = new Acting();
    Dice dice = new Dice();
    
    static int DAY_MAX = 0;

public static void main(String[] args) {

    List<Player> gamePlayers = new ArrayList<Player>();
    Day day = new Day();

    Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Deadwood! Please enter the number of players: ");
        int playerNum = input.nextInt();

        if ((playerNum < 2) || (playerNum > 8)) {
            System.out.println("Error. Please enter a number between 2 and 8.");
        }
        else {
            if (playerNum <= 3) {
                DAY_MAX = 3;
            }
            else {
                DAY_MAX = 4;
            }

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
            System.out.println("Game is set up! \n"); 
        }

        while (day.dayCount < DAY_MAX) {
            System.out.println("Your turn! please type in your command, or 'options' for a list of available commands.\n");
            String action = input.next();

            if (action.equals("quit")) {
                break;
            }
        }   

    System.out.println("Thank you! We are still working on the rest, so stay tuned!");
    input.close();
}

}