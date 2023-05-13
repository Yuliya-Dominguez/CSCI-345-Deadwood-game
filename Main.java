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
    
    static int DAY_MAX = 1;

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
            
            for (Player player: gamePlayers) {
                System.out.println(("What is Player ") + (i + 1) + (" name? \n"));
                String inputName = input.next();
                player.name = inputName;
                i++;
                
            }
            System.out.println("Game is set up! \n"); 
        }
        int playerturn = 1;
        while (day.dayCount <= DAY_MAX) {
            for (Player player:gamePlayers) {
                while(playerturn > 0){
                    System.out.println("Your turn Player " + player.name + "! " + "Please type in your command, or 'options' for a list of available commands.\n");
                    String action = input.next(); 

                    if (action.equals("options")) {
                        System.out.println("\n" + "'move': Moves player to desired location, if possible.");
                        System.out.println("'stats': Shows current player's stats and info.");
                        System.out.println("'scenestats': Shows scene card's information that player is currently on/next to. ");
                        System.out.println("'boardstats': Shows location player is on, including available board roles and neighboring locations.");
                        System.out.println("'day': Shows current day in game.");
                        System.out.println("'takerole': Takes the role that you specified with [roleName]. Only works if your rank is equal to or higher than the role's rank.");
                        System.out.println("'upgrade': Upgrade your rank level (only works if you are at location 'Casting Office').");
                        System.out.println("'act': Act your role (only works if you have taken a role in a scene).");
                        System.out.println("'endturn': Ends current Player's turn. ");
                        System.out.println("'quit': Quits the game.\n");
                    }
                    //If 'move' was chosen, prompt the player for which neighbor location they want to move to.
                    else if (action.equals("move")){
                        System.out.println("This command is still in progress."); //delete later!
                        break;
                    }
                    //If 'scenestats' was chosen, display information about the scene card on the location the player is at currently.
                    else if (action.equals("scenestats")){
                        System.out.println("This command is still in progress."); //delete later!
                    }
                    //If 'boardstats' was chosen, display information about the board location the player is at currently.
                    else if (action.equals("boardstats")){
                        System.out.println("This command is still in progress."); //delete later!
                    }

                    //If 'takerole' was chosen, have player choose their role from the scene they are on or board they are on.
                    else if (action.equals("takerole")){
                        System.out.println("Which role will you take? (Type in name of role) \n");
                        String roleToTake = input.next();
                        //Code here to detect if role is from board or scene card.
                        //Code here to print success or failure message.
                        //player.takeRole();
                        System.out.println("This command is still in progress."); //delete later!
                        break;
                    }

                    //If 'upgrade' was chosen, upgrade the player's rank if they have enough credits or dollars.
                    else if (action.equals("upgrade")){
                        //Code here to check if player's location is Casting Office.
                        System.out.println("\n" + "What rank would you like to upgrade to? (enter number between 2 and 6)\n");
                        int rankWanted = input.nextInt();
                        System.out.println("What will you pay with? ('credit' or 'dollar')");
                        String payment = input.next();
                        player.upgrade(rankWanted, payment);
                        break;
                    }

                    //If 'act' was chosen, have the player act out their role if they have taken one.
                    else if (action.equals("act")){
                        if (player.playerRole != null) {
                            System.out.println("Rolling for acting...");
                            player.act();
                            break;
                        }
                        else {
                            System.out.println("Error. Player needs to have taken a role from a scene before they can act.");
                            System.out.println("This command is still in progress."); //delete later!
                        }
                    }

                    //If 'stat' was chosen, show current player's stats.
                    else if (action.equals("stats")) {
                        player.checkInfo();
                    }

                    //If 'day' was chosen, print the current day (1, 2, 3, or 4).
                    else if (action.equals("day")) {
                        System.out.println("\n" +"This is day " + day.dayCount + "\n");
                    }

                    //If 'quit' was chosen, prompt to exit the program or not.
                    else if (action.equals("quit")) {
                        System.out.println("Are you sure you want to quit? 'y/n'");
                        String response = input.next();
                        if ((response.equals("yes")) || (response.equals("y"))){
                            System.out.println("Thank you! We are still working on the rest, so stay tuned!");
                            System.exit(1);
                        }
                        else if ((response.equals("no")) || (response.equals("n"))) {
                            System.out.println("Okay! Resuming game. \n");
                        }
                        else {
                            System.out.println("Error. Please answer yes or no if you would like to quit.");
                        }
                    }
                    //If 'endturn' was chosen, end current player's turn.
                    else if (action.equals("endturn")) {
                        System.out.println("Turn ended. \n");
                        break;
                    }
                    //Check if something other than above commands is typed.
                    else{
                        System.out.println("\n" + "Sorry, that command is not available. Please type 'options' to see the list of available options. \n");
                    }
                }
            }
        }   
    input.close();
}

}