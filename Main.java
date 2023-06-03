
import java.util.*;
import java.util.List;


public class Main {
    
    static int players_num;
    static int DAY_MAX = 1;
    int playerturn = 1;
    int scenesFinished = 0;

    Deadwood deadwood = new Deadwood();
    static List<Player> gamePlayers = new ArrayList<Player>();
    Day day = new Day();
    BoardData boardData = new BoardData();
    SceneCards sceneCards = new SceneCards();
    WrappingUp wrapUp = new WrappingUp();
    Board board = new Board();
    List<BoardData> sets = Board.getBoardLocations();

    public static void setPlayersNum(int number) {
        players_num = number;
    }

    public static int getPlayersNum() {
        return players_num;
    }
    

    //Planned to use method for action listeners and buttons.
    public void move(Player player) {

        System.out.println("\nWhich neighbor will you move to? (Enter neighbor's number (1,2,3,etc.)");
        int neighborMove = 0;//change later!
        int moveSuccess = 0;

        //MoveCheck if the player is trying to move from the trailer.
        if (player.isInTrailer == true) {

            //Move player location to Main Street if they choose 1.
            if (BoardData.getTrailNeighbor(neighborMove-1).equals("Main Street")) {
                player.move(4);
                System.out.println("Moved to Main Street.");
                player.isInTrailer = false;
                moveSuccess = 1;

                player.playerCoordinates[0] = BoardData.getSetArea(4).getX();
                player.playerCoordinates[1] = BoardData.getSetArea(4).getY();
            }
            //Move player location to Saloon if they choose 2.
            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Saloon")) {
                player.move(9);
                System.out.println("Moved to Saloon.");
                player.isInTrailer =false;
                moveSuccess = 1;

                player.playerCoordinates[0] = BoardData.getSetArea(9).getX();
                player.playerCoordinates[1] = BoardData.getSetArea(9).getY();
            }
            //Move player location to Hotel if they choose 3.
            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Hotel")) {
                player.move(3);
                System.out.println("Moved to Hotel.");
                player.isInTrailer = false;
                moveSuccess = 1;

                player.playerCoordinates[0] = BoardData.getSetArea(3).getX();
                player.playerCoordinates[1] = BoardData.getSetArea(3).getY();
            }
        }

        //MoveCheck if the player is trying to move from the casting office.
        else if (player.isInOffice == true) {

            //Move player location to Train Station if they choose 1.
            if (BoardData.getOffNeighbor(neighborMove-1).equals("Train Station")) {
                player.move(0);
                System.out.println("Moved to Train Station.");
                player.isInOffice = false;
                moveSuccess = 1;

                player.playerCoordinates[0] = BoardData.getSetArea(0).getX();
                player.playerCoordinates[1] = BoardData.getSetArea(0).getY();
            }

            //Move player location to Ranch if they choose 2.
            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Ranch")) {
                player.move(7);
                System.out.println("Moved to Ranch.");
                player.isInOffice =false;
                moveSuccess = 1;

                player.playerCoordinates[0] = BoardData.getSetArea(7).getX();
                player.playerCoordinates[1] = BoardData.getSetArea(7).getY();
            }

            //Move player location to Secret Hideout if they choose 3.
            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Secret Hideout")) {
                player.move(1);
                System.out.println("Moved to Secret Hideout.");
                player.isInOffice = false;
                moveSuccess = 1;

                player.playerCoordinates[0] = BoardData.getSetArea(1).getX();
                player.playerCoordinates[1] = BoardData.getSetArea(1).getY();
            }
        }

        //General check for loactions aside from trailer and casting
        else {
            for (int a = 0; a < (BoardData.getNeighborsList(player.playerLocation).size()+1); a++) {

                if (BoardData.getNeighborName(player.playerLocation, a).equals(BoardData.getNeighborName(player.playerLocation, neighborMove))){
                    int loactionToMove = 0;

                    //Check if player is moving to trailer from another location.
                    if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("trailer")) {
                        player.isInTrailer = true;
                        moveSuccess = 1;

                        //store player's x and y coordinates
                        player.playerCoordinates[0] = BoardData.getTrailerArea().getX();
                        player.playerCoordinates[1] = BoardData.getTrailerArea().getY();
                    }
                    
                    //Check if player is moving to office from another loaction.
                    else if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("office")) {
                        player.isInOffice = true;
                        moveSuccess = 1;

                        //store player's x and y coordinates
                        player.playerCoordinates[0] = BoardData.getOfficeArea().getX();
                        player.playerCoordinates[1] = BoardData.getOfficeArea().getY();
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

                        //store player's x and y coordinates
                        player.playerCoordinates[0] = BoardData.getSetArea(player.playerLocation).getX();
                        player.playerCoordinates[1] = BoardData.getSetArea(player.playerLocation).getY();
                    }
                }
            }
            
        }
        //if (moveSuccess == 1) {
            //break;
        //}

        // else {
        //     System.out.println("Sorry, that move is invalid. Choose a different neighbor.");
        // }
    }
    
    //Planned to use method for action listeners and buttons.
    public void act(Player player) {


            //need a check in here to wrap up based on the shot counter.
            if (player.playerRole != null) {
                System.out.println("Rolling for acting...");
                //int roll = dice.readDice();
                int attempt = player.act();
                if (attempt == 1){
                    board.takesLeft++;
                    if ((BoardData.getTakesList(player.playerLocation).size() - board.takesLeft) == 0) {
                        Board.getBoardLocations().get(player.playerLocation).takeSceneIndex(-1);
                        if (player.playerRole.equals("Main")) {
                            wrapUp.playerMainBonus();
                            player.playerRole = "None";
                            scenesFinished++;
                        }
                        else {
                            if (sets.get(player.playerLocation).isMainRoleFilled() == 1){
                                wrapUp.mainActorRoleFilled = true;
                            }
                            wrapUp.playerExtraBonus();
                            player.playerRole = "None";
                            scenesFinished++;
                        }
                        //System.out.println("That's a wrap! Scene is over!");
                    }
                    //break;
                }

                // else {
                //     break;
                // }
                
            }

            else {
                System.out.println("Error. Player needs to have taken a role from a scene before they can act.");
            }
    }

    //Planned to use method for action listeners and buttons.
    public void rehearse(Player player) {
        if (player.playerRole != null){
            player.rehearse();
            //break;
        }
        else {
            System.out.println("Error. Cannot take this action without a role chosen.");
        }
    }

    //Planned to use method for action listeners and buttons.
    public void winner() {
        int[] scores = new int[gamePlayers.size()];
        int[] ranks = new int[gamePlayers.size()];
        String[] names = new String[gamePlayers.size()];
        int c = 0;
        for (Player player:gamePlayers) {
            scores[c] = deadwood.scoring(player);
            ranks[c] = player.rank;
            names[c] = player.name;
            c++;
        }
        deadwood.decideWinner(scores, ranks, names);
    }

    public void upgrade(Player player) {
         //Code here to check if player's location is Casting Office.
         if (player.isInOffice != true) {
            System.out.println("There is no upgrade attached to this location. Move to Office to upgrade rank. \n");
        }
        else {

           
            System.out.println("\n" + "What rank would you like to upgrade to? (enter number between 2 and 6)\n");
            int rankWanted = 2; //change later
            System.out.println("What will you pay with? ('credit' or 'dollar')");

            String payment = "credits"; //change later
            player.upgrade(rankWanted, payment);

            //break;
        }
    }

    public void endTurn() {
        //Set up later to use GUI to change what is visiable/ pass on control to next player's stats.
    }

    //Planned to use method for action listeners and buttons.
    public void takeRole(Player player) {


        if ((player.isInTrailer == true) || (player.isInOffice == true)) {
            System.out.println("There is no scene attached to this location. \n");
        }
        else {

            System.out.println("\n" + "Will you take a scene part or board part? (Enter 'scene' or 'board') \n");
            String roleSection = "scene"; //change to fit GUI
            System.out.println("Which part number will you take? (Type in 1,2,3, or 4 depending on part number.) \n");
            int partToTake = 2; //change later

            //Code here to print success or failure message.
            int success = player.takeRole(roleSection, (partToTake-1));
            

            if (success == 1) {
                System.out.println("Role "+ SceneCards.getPartName(player.sceneIndexNumber, (partToTake-1)) + " has been taken!");
                sets.get(player.playerLocation).fillMainRoll(1);

                //store player's x and y coordinates
                player.playerCoordinates[0] = SceneCards.getPartArea(player.sceneIndexNumber, player.playerRolePosition).getX();
                player.playerCoordinates[1] = SceneCards.getPartArea(player.sceneIndexNumber, player.playerRolePosition).getY();

                //break;
            }
            else if (success == 2) {
                System.out.println("Role "+ SceneCards.getPartName(player.sceneIndexNumber, (partToTake-1)) + " has been taken!");

                //store player's x and y coordinates
                player.playerCoordinates[0] = BoardData.getPartArea(player.playerLocation, player.playerRolePosition).getX();
                player.playerCoordinates[1] = BoardData.getPartArea(player.playerLocation, player.playerRolePosition).getY();

                //break;
            }

            else if (success == -1){
                System.out.println("Error. Invalid set type ('scene' or 'board') invalid part number. Please try again.");
            }
        }
    }

public static void main(String[] args) {

    //Initiallizing the classes to be used in main.
    Deadwood deadwood = new Deadwood();
    List<Player> gamePlayers = new ArrayList<Player>();
    Day day = new Day();
    //BoardData boardData = new BoardData();
    //SceneCards sceneCards = new SceneCards();
    WrappingUp wrapUp = new WrappingUp();
    Board board = new Board();
    List<BoardData> sets = Board.getBoardLocations();
    PlayersList plrs = new PlayersList();

   
    /*
     * Beginning of game. Prompt player for input to ender number of players to create player classes and set DAY_MAX.
     */
    
    Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Deadwood! Please enter the number of players: ");
        int playerNum = input.nextInt();

        //Check if player does not enter correct number of players.
        if ((playerNum < 2) || (playerNum > 8)) {
            System.out.println("Error. Please enter a number between 2 and 8.");
        }
        //Set the maximum number of days. Set to 3 if 2-3 players, 4 otherwise.
        else {
            if (playerNum <= 3) {
                DAY_MAX = 3;
            }
            else {
                DAY_MAX = 4;
            }

            plrs.createPlayerList(playerNum);
            
            //Create player classes to go into List gamePlayers.
            for(int a = 0; a < playerNum; a++) {
                Player player1 = new Player();
                gamePlayers.add(player1);
            }

            int i = 0;
            
            //
            for (Player player: plrs.getPlayerList()) {
                System.out.println(("What is Player ") + (i + 1) + (" name? \n"));
                String inputName = input.next();
                player.name = inputName;
                player.isInTrailer = true;
                i++;

                player.playerCoordinates[0] = BoardData.getTrailerArea().getX();
                player.playerCoordinates[1] = BoardData.getTrailerArea().getY();
                
                //Below is index number for all locations excluding Trailer and Office.
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
                
            }
            //Call day.setUp() to draw scenes, set up the board, and fully start the game.
            day.setUp();
            System.out.println("Game is set up! \n"); 

        }
        //Extra variables. playerturn checks if it is still the current player's turn, 
        //  scenesFinished checks how many scenes have been completed.
        int playerturn = 1;
        int scenesFinished = 0;
        //Whole game, doesn't end until all days are up.
        while (day.dayCount <= DAY_MAX) {

            //Loop to iterate through every player's turn.
            for (Player player: plrs.getPlayerList()) {


                View.createGUI(plrs.getPlayerList());

                //Check to keep turn on player if action they take doesn't end their turn.
                while(playerturn > 0){

                    //Accepting player input of commands. Recommends 'options' for player to see what they can type.
                    System.out.println("Your turn Player " + player.name + "! " + "Please type in your command, or 'options' for a list of available commands.\n");
                    String action = input.next(); 



                    //If 'move' was chosen, prompt the player for which neighbor location they want to move to.
                    if (action.equals("move")) {

                        //Prompt user about which neighbor to move to.
                        System.out.println("\nWhich neighbor will you move to? (Enter neighbor's number (1,2,3,etc.)");
                        int neighborMove = input.nextInt();
                        int moveSuccess = 0;

                        //MoveCheck if the player is trying to move from the trailer.
                        if (player.isInTrailer == true) {

                            //Move player location to Main Street if they choose 1.
                            if (BoardData.getTrailNeighbor(neighborMove-1).equals("Main Street")) {
                                player.move(4);
                                System.out.println("Moved to Main Street.");
                                player.isInTrailer = false;
                                moveSuccess = 1;

                                player.playerCoordinates[0] = BoardData.getSetArea(4).getX();
                                player.playerCoordinates[1] = BoardData.getSetArea(4).getY();
                            }
                            //Move player location to Saloon if they choose 2.
                            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Saloon")) {
                                player.move(9);
                                System.out.println("Moved to Saloon.");
                                player.isInTrailer =false;
                                moveSuccess = 1;

                                player.playerCoordinates[0] = BoardData.getSetArea(9).getX();
                                player.playerCoordinates[1] = BoardData.getSetArea(9).getY();
                            }
                            //Move player location to Hotel if they choose 3.
                            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Hotel")) {
                                player.move(3);
                                System.out.println("Moved to Hotel.");
                                player.isInTrailer = false;
                                moveSuccess = 1;

                                player.playerCoordinates[0] = BoardData.getSetArea(3).getX();
                                player.playerCoordinates[1] = BoardData.getSetArea(3).getY();
                            }
                        }

                        //MoveCheck if the player is trying to move from the casting office.
                        else if (player.isInOffice == true) {

                            //Move player location to Train Station if they choose 1.
                            if (BoardData.getOffNeighbor(neighborMove-1).equals("Train Station")) {
                                player.move(0);
                                System.out.println("Moved to Train Station.");
                                player.isInOffice = false;
                                moveSuccess = 1;

                                player.playerCoordinates[0] = BoardData.getSetArea(0).getX();
                                player.playerCoordinates[1] = BoardData.getSetArea(0).getY();
                            }

                            //Move player location to Ranch if they choose 2.
                            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Ranch")) {
                                player.move(7);
                                System.out.println("Moved to Ranch.");
                                player.isInOffice =false;
                                moveSuccess = 1;

                                player.playerCoordinates[0] = BoardData.getSetArea(7).getX();
                                player.playerCoordinates[1] = BoardData.getSetArea(7).getY();
                            }

                            //Move player location to Secret Hideout if they choose 3.
                            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Secret Hideout")) {
                                player.move(1);
                                System.out.println("Moved to Secret Hideout.");
                                player.isInOffice = false;
                                moveSuccess = 1;

                                player.playerCoordinates[0] = BoardData.getSetArea(1).getX();
                                player.playerCoordinates[1] = BoardData.getSetArea(1).getY();
                            }
                        }

                        //General check for loactions aside from trailer and casting
                        else {
                            for (int a = 0; a < (BoardData.getNeighborsList(player.playerLocation).size()+1); a++) {

                                if (BoardData.getNeighborName(player.playerLocation, a).equals(BoardData.getNeighborName(player.playerLocation, neighborMove))){
                                    int loactionToMove = 0;

                                    //Check if player is moving to trailer from another location.
                                    if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("trailer")) {
                                        player.isInTrailer = true;
                                        moveSuccess = 1;

                                        //store player's x and y coordinates
                                        player.playerCoordinates[0] = BoardData.getTrailerArea().getX();
                                        player.playerCoordinates[1] = BoardData.getTrailerArea().getY();
                                    }
                                    
                                    //Check if player is moving to office from another loaction.
                                    else if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("office")) {
                                        player.isInOffice = true;
                                        moveSuccess = 1;

                                        //store player's x and y coordinates
                                        player.playerCoordinates[0] = BoardData.getOfficeArea().getX();
                                        player.playerCoordinates[1] = BoardData.getOfficeArea().getY();
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

                                        //store player's x and y coordinates
                                        player.playerCoordinates[0] = BoardData.getSetArea(player.playerLocation).getX();
                                        player.playerCoordinates[1] = BoardData.getSetArea(player.playerLocation).getY();
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
                            

                            if (success == 1) {
                                System.out.println("Role "+ SceneCards.getPartName(player.sceneIndexNumber, (partToTake-1)) + " has been taken!");
                                sets.get(player.playerLocation).fillMainRoll(1);

                                //store player's x and y coordinates
                                player.playerCoordinates[0] = SceneCards.getPartArea(player.sceneIndexNumber, player.playerRolePosition).getX();
                                player.playerCoordinates[1] = SceneCards.getPartArea(player.sceneIndexNumber, player.playerRolePosition).getY();

                                break;
                            }
                            else if (success == 2) {
                                System.out.println("Role "+ SceneCards.getPartName(player.sceneIndexNumber, (partToTake-1)) + " has been taken!");

                                //store player's x and y coordinates
                                player.playerCoordinates[0] = BoardData.getPartArea(player.playerLocation, player.playerRolePosition).getX();
                                player.playerCoordinates[1] = BoardData.getPartArea(player.playerLocation, player.playerRolePosition).getY();

                                break;
                            }

                            else if (success == -1){
                                System.out.println("Error. Invalid set type ('scene' or 'board') invalid part number. Please try again.");
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
                                    Board.getBoardLocations().get(player.playerLocation).takeSceneIndex(-1);
                                    if (player.playerRole.equals("Main")) {
                                        wrapUp.playerMainBonus();
                                        player.playerRole = "None";
                                        scenesFinished++;
                                    }
                                    else {
                                        if (sets.get(player.playerLocation).isMainRoleFilled() == 1){
                                            wrapUp.mainActorRoleFilled = true;
                                        }
                                        wrapUp.playerExtraBonus();
                                        player.playerRole = "None";
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
                            System.out.println("Thank you! We hope to see you again!");
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
        //If statement here for a counter of scenes left. If scenecounter == 9, increase day.dayCount.
            if (scenesFinished == 9) {
                day.endDay();
                for (Player player:gamePlayers) {
                    player.isInTrailer = true;
                }
                day.dayCount++;
            } 
        }

    //Finish the game by calculating the score of each player and declare winner! 
    System.out.println("\nGame is over! Calculating scores...\n");
    int[] scores = new int[gamePlayers.size()];
    int[] ranks = new int[gamePlayers.size()];
    String[] names = new String[gamePlayers.size()];
    int c = 0;
    for (Player player:gamePlayers) {
        scores[c] = deadwood.scoring(player);
        ranks[c] = player.rank;
        names[c] = player.name;
        c++;
    }
    deadwood.decideWinner(scores, ranks, names);
    input.close();
}

}