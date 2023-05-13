import java.util.*;


public class Main {

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
            for (Player player:gamePlayers) {
                System.out.println("Your turn Player " + player.name + "! " + "Please type in your command, or 'options' for a list of available commands.\n");
                String action = input.next();

                if (action.equals("options")) {
                    System.out.println("\n" + "'move [locationName]': Moves player to desired location, if possible.");
                    System.out.println("'stats': Shows current player's stats and info.");
                    System.out.println("'scenestats': Shows scene card's information that player is currently on/next to. ");
                    System.out.println("'boardstats': Shows location player is on, including available board roles and neighboring locations.");
                    System.out.println("'day': Shows current day in game.");
                    System.out.println("'takerole [roleName]': Takes the role that you specified with [roleName]. Only works if your rank is equal to or higher than the role's rank.");
                    System.out.println("'upgrade [rankLevel]': Upgrade your rank level (only works if you are at location 'Casting Office').");
                    System.out.println("'act': Act your role (only works if you have taken a role in a scene).");
                    System.out.println("'endturn': Ends current Player's turn. ");
                    System.out.println("'quit': Quits the game.\n");
                }

                else if (action.equals("stats")) {
                    player.checkInfo();
                }

                else if (action.equals("day")) {
                    System.out.println("\n" +"This is day " + day.dayCount + "\n");
                }

                else if (action.equals("quit")) {
                    System.out.println("Thank you! We are still working on the rest, so stay tuned!");
                    System.exit(1);
                }
                else if (action.equals("endturn")) {
                    System.out.println("Turn ended. \n");
                    break;
                }
                else{
                    System.out.println("\n" + "Sorry, that command is not available. Please type 'options' to see the list of available options. \n");
                }
            }
        }   
    input.close();
}

}