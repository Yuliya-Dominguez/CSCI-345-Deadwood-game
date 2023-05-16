import java.util.*;


public class Main {

    Deadwood deadwood = new Deadwood();
    //Store store = Store.getStoreInstance();
    
    Dice dice = new Dice();
   
    LocationManager locManager = new LocationManager();
    Acting acting = new Acting();
    
    
    static int DAY_MAX = 1;

public static void main(String[] args) {

    List<Player> gamePlayers = new ArrayList<Player>();
    Day day = new Day();
    BoardData boardData = new BoardData();
    SceneCards sceneCards = new SceneCards();
    WrappingUp wrapUp = new WrappingUp();
    Board board = new Board();

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
                player.isInTrailer = true;
                //player.isInOffice = true;
                //player.move(9);
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
        int scenesFinished = 0;
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

                        //Prompt user about which neighbor to move to.
                        System.out.println("\nWhich neighbor will you move to? (Enter neighbor's number (1,2,3,etc.)");
                        int neighborMove = input.nextInt();
                        int moveSuccess = 0;

                        //MoveCheck if the player is trying to move from the trailer.
                        if (player.isInTrailer == true) {
                            if (BoardData.getTrailNeighbor(neighborMove-1).equals("Main Street")) {
                                player.move(4);
                                System.out.println("Moved to Main Street.");
                                player.isInTrailer = false;
                                moveSuccess = 1;
                            }
                            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Saloon")) {
                                player.move(9);
                                System.out.println("Moved to Saloon.");
                                player.isInTrailer =false;
                                moveSuccess = 1;
                            }
                            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Hotel")) {
                                player.move(3);
                                System.out.println("Moved to Hotel.");
                                player.isInTrailer = false;
                                moveSuccess = 1;
                            }
                        }

                        //MoveCheck if the player is trying to move from the casting office.
                        else if (player.isInOffice == true) {
                            if (BoardData.getOffNeighbor(neighborMove-1).equals("Train Station")) {
                                player.move(0);
                                System.out.println("Moved to Train Station.");
                                player.isInOffice = false;
                                moveSuccess = 1;
                            }
                            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Ranch")) {
                                player.move(7);
                                System.out.println("Moved to Ranch.");
                                player.isInOffice =false;
                                moveSuccess = 1;
                            }
                            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Secret Hideout")) {
                                player.move(1);
                                System.out.println("Moved to Secret Hideout.");
                                player.isInOffice = false;
                                moveSuccess = 1;
                            }
                        }

                        //General check for loactions aside from trailer and casting
                        else {
                            for (int a = 0; a < BoardData.getNeighborsList(player.playerLocation).size(); a++) {

                                if (BoardData.getNeighborName(player.playerLocation, a).equals(BoardData.getNeighborName(player.playerLocation, neighborMove))){
                                    int loactionToMove = 0;
                                    //Check if player is moving to trailer from another location.
                                    if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("trailer")) {
                                        player.isInTrailer = true;
                                        moveSuccess = 1;
                                    }
                                    //Check if player is moving to office from another loaction.
                                    else if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("office")) {
                                        player.isInOffice = true;
                                        moveSuccess = 1;
                                    }
                                    else {
                                        //Check for index of location to move player properly!
                                        for (int i = 0; i < 10; i++) {

                                            if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals(BoardData.getSetName(i))) {
                                                loactionToMove = i;
                                            }
                                        }
                                        player.move(loactionToMove);
                                        System.out.println("Moved to " + BoardData.getSetName(player.playerLocation));
                                        moveSuccess = 1;
                                    }
                                }
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

                        if ((player.isInTrailer == true) || (player.isInOffice == true)) {
                            System.out.println("There is no scene attached to this location. \n");
                        }
                        else if (Board.getBoardLoactions().get(player.playerLocation).getSceneIndex() == -1) {
                            System.out.println("The scene here is completed! Find an open scene on a different set. \n");
                        }
                        else {

                            System.out.println("\n" + "Scene Name: " + SceneCards.getName(boardData.getSceneIndex()));
                            System.out.println("Scene Number: " + sceneCards.getSceneNumber(boardData.getSceneIndex()));
                            System.out.println("Scene Budget: " + sceneCards.getCardBudget(boardData.getSceneIndex()));
                            System.out.println("Scene Description: " + sceneCards.getSceneDescription(boardData.getSceneIndex()));
                            
                            //Iterates through all parts contained in the scene card.
                            for (int i = 0; i < SceneCards.getPartsList(boardData.getSceneIndex()).size(); i++) {
                                System.out.println("Scene Part " + (i + 1));
                                System.out.println("\t Name: " + SceneCards.getPartName(boardData.getSceneIndex(), i));
                                System.out.println("\t Level: " + SceneCards.getPartLevel(boardData.getSceneIndex(), i));
                                System.out.println("\t Line: " + SceneCards.getPartLine(boardData.getSceneIndex(), i) + "\n");
                            }
                        }
                        System.out.println("This command is still in progress."); //delete later!
                    }


                    //If 'boardstats' was chosen, display information about the board location the player is at currently.
                    else if (action.equals("boardstats")){

                        if (player.isInTrailer == true) {
                            System.out.println("\nBoard Name: Trailer");
                            for (int x = 0; x < BoardData.getTrailerNeighbors().size(); x++){
                                System.out.println("Neighbor " + (x+1) + "'s Name: " + BoardData.getTrailNeighbor(x));
                            }
                            
                        }
                        else if (player.isInOffice == true) {
                            System.out.println("\nBoard Name: Office");
                            for (int x = 0; x < BoardData.getOfficeNeighbors().size(); x++){
                                System.out.println("Neighbor " + (x+1) + "'s Name: " + BoardData.getOffNeighbor(x));
                            }
                            
                        }
                        else {

                            System.out.println("\nBoard Name: " + BoardData.getSetName(player.playerLocation));
                            System.out.println("Number of Board Takes Left: " + (BoardData.getTakesList(player.playerLocation).size() - board.takesLeft));
                            if (boardData.getSceneIndex() == -1) {
                                System.out.println("Scene: Finished ");
                            }
                            else {
                                System.out.println("Scene: " + SceneCards.getName(boardData.getSceneIndex()) + "\tIndex: " + boardData.getSceneIndex());
                            }
                
                            for (int a = 0; a < BoardData.getNeighborsList(player.playerLocation).size(); a++) {
                                System.out.println("Board Neighbor " + (a+1) + "'s Name: " + BoardData.getNeighborName(player.playerLocation, a));
                                
                            }

                            for (int i = 0; i < BoardData.getPartsList(player.playerLocation).size(); i++) {
                                System.out.println("Board Part " + (i + 1));
                                System.out.println("\t Name: " + BoardData.getPartName(player.playerLocation, i));
                                System.out.println("\t Level: " + BoardData.getPartLevel(player.playerLocation, i));
                                System.out.println("\t Line: " + BoardData.getPartLine(player.playerLocation, i) + "\n");
                            }
                        }

                        System.out.println("This command is still in progress."); //delete later!
                    }


                    //If 'takerole' was chosen, have player choose their role from the scene they are on or board they are on.
                    else if (action.equals("takerole")){

                        if ((player.isInTrailer == true) || (player.isInOffice == true)) {
                            System.out.println("There is no scene attached to this location. \n");
                        }
                        else {

                            System.out.println("\n" + "Will you take a scene part or board part? (Enter 'scene' or 'board') \n");
                            String roleSection = input.next();
                            System.out.println("Which part number will you take? (Type in 1,2,3, or 4 depending on part number.) \n");
                            int partToTake = input.nextInt();

                            //Code here to print success or failure message.
                            int success = player.takeRole(roleSection, (partToTake-1));
                            System.out.println("This command is still in progress."); //delete later!

                            if (success == 1) {
                                System.out.println("Role has been taken!");
                                break;
                            }

                            else if (success == 0){
                                System.out.println("Error. Invalid set type ('scene' or 'board') or invalid part number. Please try again.");
                            }
                        }
                    }


                    //If 'upgrade' was chosen, upgrade the player's rank if they have enough credits or dollars.
                    else if (action.equals("upgrade")){

                        //Code here to check if player's location is Casting Office.
                        if (player.isInOffice != true) {
                            System.out.println("There is no upgrade attached to this location. Move to Office to upgrade rank. \n");
                        }
                        else {

                           
                            System.out.println("\n" + "What rank would you like to upgrade to? (enter number between 2 and 6)\n");
                            int rankWanted = input.nextInt();
                            System.out.println("What will you pay with? ('credit' or 'dollar')");

                            String payment = input.next();
                            player.upgrade(rankWanted, payment);

                            break;
                        }
                    }


                    //If 'act' was chosen, have the player act out their role if they have taken one.
                    else if (action.equals("act")){

                        //need a check in here to wrap up based on the shot counter.
                        if (player.playerRole != null) {
                            System.out.println("Rolling for acting...");
                            //int roll = dice.readDice();
                            int attempt = player.act();
                            if (attempt == 1){
                                board.takesLeft++;
                                if ((BoardData.getTakesList(player.playerLocation).size() - board.takesLeft) == 0) {
                                    Board.getBoardLoactions().get(player.playerLocation).takeSceneIndex(-1);
                                    if (player.playerRole.equals("Main")) {
                                        wrapUp.playerMainBonus();
                                        scenesFinished++;
                                    }
                                    else {
                                        wrapUp.playerExtraBonus();
                                        scenesFinished++;
                                    }
                                    //System.out.println("That's a wrap! Scene is over!");
                                }
                                break;
                            }

                            else {
                                break;
                            }
                            
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

                    //Need a check down here to see how many scenes are left on the board, then call endDay().
                    
                }
            }
            if (scenesFinished == 9) {
                day.dayCount++;
            }
            //If statement here for a counter of scenes left. If scenecounter == 9, increase day.dayCount.
        }

    //Finish the game by calculating the score of each player and declare winner! 
    input.close();
}

}