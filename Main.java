import java.util.*;


public class Main {

    Deadwood deadwood = new Deadwood();
    //Store store = Store.getStoreInstance();
    WrappingUp wrapUp = new WrappingUp();
    
    Board board = new Board();
    LocationManager locManager = new LocationManager();
    Acting acting = new Acting();
    Dice dice = new Dice();
    
    static int DAY_MAX = 1;

public static void main(String[] args) {

    List<Player> gamePlayers = new ArrayList<Player>();
    Day day = new Day();
    BoardData boardData = new BoardData();
    SceneCards sceneCards = new SceneCards();
    

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
                player.move(9);
                //0 = Train Station
                //1 = Secret Hideout
                //2 = Church
                //3 = Hotel
                //4 = Main Street
                //5 = Jail
                //6 = General Store
                //7 = Ranch
                //8 = Bank
                //9 = Saloon
                //10 = 
                i++;
                
            }
            day.setUp();
            System.out.println("Game is set up! \n"); 

        }
        int playerturn = 1;
        //Whole game, doesn't end until all days are up.
        while (day.dayCount <= DAY_MAX) {
            //Loop to iterate through every player's turn.
            for (Player player:gamePlayers) {
                //Check to keep turn on player if action they take doesn't end their turn.
                while(playerturn > 0){
                    //Accepting player input of commands. Recommends 'options' for player to see what they can type.
                    System.out.println("Your turn Player " + player.name + "! " + "Please type in your command, or 'options' for a list of available commands.\n");
                    String action = input.next(); 

                    //If 'options' was chosen, print out all possible actions player can take, what to type, and what each action does.
                    if (action.equals("options")) {

                        System.out.println("\n" + "'move': Moves player to desired location, if possible.");
                        System.out.println("'stats': Shows current player's stats and info.");
                        System.out.println("'scenestats': Shows scene card's information that player is currently on/next to. ");
                        System.out.println("'boardstats': Shows location player is on, including available board roles and neighboring locations.");
                        System.out.println("'day': Shows current day in game.");
                        System.out.println("'takerole': Takes the role that you specify. Only works if your rank is equal to or higher than the role's rank.");
                        System.out.println("'upgrade': Upgrade your rank level (only works if you are at location 'Casting Office').");
                        System.out.println("'act': Act your role (only works if you have taken a role in a scene).");
                        System.out.println("'rehearse': Rehearse your role. Add a token to your acting roll.");
                        System.out.println("'endturn': Ends current Player's turn. ");
                        System.out.println("'quit': Quits the game.\n");
                    }


                    //If 'move' was chosen, prompt the player for which neighbor location they want to move to.
                    else if (action.equals("move")) {

                        System.out.println("\nWhich neighbor will you move to? (Enter neighbor's number (1,2,etc.)");
                        int neighborMove = input.nextInt();
                        int moveSuccess = 0;

                        for (int a = 0; a < BoardData.getNeighborsList(player.playerLocation).size(); a++) {
                            if (BoardData.getNeighborName(player.playerLocation, a).equals(BoardData.getNeighborName(player.playerLocation, neighborMove))){
                                player.move(neighborMove);
                                System.out.println("Moved to " + BoardData.getSetName(player.playerLocation));
                                moveSuccess = 1;
                            }
                        }
                        if (moveSuccess == 1) {
                            break;
                        }
                        else {
                            System.out.println("Sorry, that move is invalid. Choose a different neighbor.");
                        }
                        System.out.println("This command is still in progress."); //delete later!
                    }


                    //If 'scenestats' was chosen, display information about the scene card on the location the player is at currently.
                    else if (action.equals("scenestats")){

                        System.out.println("\n" + "Scene Name: " + SceneCards.getName(player.sceneIndexNumber));
                        System.out.println("Scene Number: " + sceneCards.getSceneNumber(player.sceneIndexNumber));
                        System.out.println("Scene Budget: " + sceneCards.getCardBudget(player.sceneIndexNumber));
                        System.out.println("Scene Description: " + sceneCards.getSceneDescription(player.sceneIndexNumber));
                        
                        //Iterates through all parts contained in the scene card.
                        for (int i = 0; i < SceneCards.getPartsList(player.sceneIndexNumber).size(); i++) {
                            System.out.println("Scene Part " + (i + 1));
                            System.out.println("\t Name: " + SceneCards.getPartName(player.sceneIndexNumber, i));
                            System.out.println("\t Level: " + SceneCards.getPartLevel(player.sceneIndexNumber, i));
                            System.out.println("\t Line: " + SceneCards.getPartLine(player.sceneIndexNumber, i) + "\n");
                        }
                        System.out.println("This command is still in progress."); //delete later!
                    }


                    //If 'boardstats' was chosen, display information about the board location the player is at currently.
                    else if (action.equals("boardstats")){

                        System.out.println("\nBoard Name: " + BoardData.getSetName(player.playerLocation));
                        System.out.println("Number of Board Takes: " + BoardData.getTakesList(player.playerLocation).size());
                        System.out.println("Scene Index number: " + boardData.getSceneIndex());
                        
                        for (int a = 0; a < BoardData.getNeighborsList(player.playerLocation).size(); a++) {
                            System.out.println("Board Neighbor " + (a+1) + "'s Name: " + BoardData.getNeighborName(player.playerLocation, a));
                            
                        }

                        for (int i = 0; i < BoardData.getPartsList(player.playerLocation).size(); i++) {
                            System.out.println("Board Part " + (i + 1));
                            System.out.println("\t Name: " + BoardData.getPartName(player.playerLocation, i));
                            System.out.println("\t Level: " + BoardData.getPartLevel(player.playerLocation, i));
                            System.out.println("\t Line: " + BoardData.getPartLine(player.playerLocation, i) + "\n");
                        }

                        System.out.println("This command is still in progress."); //delete later!
                    }


                    //If 'takerole' was chosen, have player choose their role from the scene they are on or board they are on.
                    else if (action.equals("takerole")){

                        System.out.println("\n" + "Will you take a scene part or board part? (Enter 'scene' or 'board') \n");
                        String roleSection = input.next();
                        System.out.println("Which part number will you take? (Type in number of part) \n");
                        int partToTake = input.nextInt();

                        //Code here to print success or failure message.
                        int success = player.takeRole(roleSection, partToTake);
                        System.out.println("This command is still in progress."); //delete later!

                        if (success == 1) {
                            System.out.println("Role has been taken!");
                            break;
                        }

                        else if (success == 0){
                            System.out.println("Error. Invalid set type ('scene' or 'board') or invalid part number. Please try again.");
                        }
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

                    //If 'rehearse' was chosen, add a rehearse counter to player if they have a role chosen.
                    else if (action.equals("rehearse")) {
                        if (player.playerRole != null){
                            player.rehearse();
                            break;
                        }
                        else {
                            System.out.println("Error. Cannot take this action without a role chosen.");
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
                        System.out.println("\n" + 
                        "Sorry, that command is not available. Please type 'options' to see the list of available options. \n");
                    }
                    
                }
            }
        }
    input.close();
}

}