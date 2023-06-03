import java.util.List;

public class Player {

    public String name;
    public String playerRole;
    public String playerRoleName;
    public int playerRolePosition;
    public int playerLocation;
    public int[] playerCoordinates = new int[2];
    public boolean isInTrailer;
    public boolean isInOffice;
    public int sceneIndexNumber;
    public int rank = 1;
    public int dollarCount;
    public int creditCount;
    public int rehearseCounter;
    public int gamePlayersListIndex;

    //Board board = new Board();
    SceneCards scene = new SceneCards();

    Store store = Store.getStoreInstance();
    public List<BoardData> boardLocations = Board.getBoardLocations();
    

    
    //Move the player to neighborMove's location.
    public void move(int neighborMove) {
        playerLocation = neighborMove;
        //Need location man and board probably for this, and XML.
    }
    /*
     * Rolls dice to generate a roll for the player. roll is then compared to the budget of the scene.
     * If the roll is high enough then the roll is a success. Pay the according amount based on the role of the player, Main or Extra.
     * If the roll fails, then give nothing or a dollar based on their role.
     */
    public int act() {
        //BoardData currentSet = boardLocations.get(playerLocation);
        Dice dice = new Dice();
        int roll = dice.readDice();
        //BoardData currentSet = boardLocations.get(playerLocation);

        if (playerRole.equals("Extra")) {
            if ((roll + rehearseCounter) >= scene.getCardBudget(sceneIndexNumber)) {
                //act.successExtraRole();
                System.out.println("Success! Gain a credit and dollar!");
                dollarCount++;
                creditCount++;
                //store.payForShot(playerRole);
                
                rehearseCounter = 0;
                return 1;
            }
            else {
                //act.failureExtraRole();
                System.out.println("Failure. Dollar gained.");
                dollarCount++;
                return 0;
            }
        }
        else if (playerRole.equals("Main")) {
            if ((roll + rehearseCounter) >= scene.getCardBudget(sceneIndexNumber)) {
                //act.successMainRole();
                System.out.println("Success! Gain two credits.");
                creditCount+= 2;
                //store.payForShot(playerRole);
                rehearseCounter = 0;
                return 1;
            }
            else {
                //act.failureMainRole();
                System.out.println("Failure. Nothing gained.");
                return 0;
            }
            
        }
        return 0;
    }

    //Add a rehearse token to be used for acting rolls.
    public void rehearse() {
        System.out.println("You've rehearsed! Take one rehearse counter.");
        rehearseCounter++;
    }

    //Calls store.upgradeRank to upgrade the player's rank, if they can pay for it.
    public void upgrade(int rankWanted, String paymentType) {
        store.upgradeRank(rankWanted, paymentType);
    }

    /*
     * Takes in a string and int. The string represents the player's choice of scene or board. The int is
     * the part on the scene or board the player wishes to take.
     * From here the rank of the player is compared to the level of the part. If high enough then success, role is given.
     * If not high enough, role is not given.
     */
    public int takeRole(String sceneOrBoard, int partIndex) {
        BoardData currentSet = boardLocations.get(playerLocation);
        
        if (sceneOrBoard.equals("scene")) {
            if (rank < SceneCards.getPartLevel(sceneIndexNumber, (partIndex))) {
                System.out.println("Sorry, your rank is not high enough to take this role.");
                return 0;
            }
            else {
                playerRole = "Main";
                playerRoleName = SceneCards.getPartName(sceneIndexNumber, partIndex);
                playerRolePosition = partIndex;
                sceneIndexNumber = currentSet.getSceneIndex();
                return 1;
            }
            
        }
        else if(sceneOrBoard.equals("board")) {
            if (rank < BoardData.getPartLevel(playerLocation, (partIndex))) {
                System.out.println("Sorry, your rank is not high enough to take this role.");
                return 0;
            }
            else {
                playerRole = "Extra";
                playerRoleName = BoardData.getPartName(playerLocation, playerRolePosition);
                playerRolePosition = partIndex;
                return 2;
            }
           
        }
        else {
            return -1;
        } 
    } 

    //Displays all the info about the current player.
    public void checkInfo() {
        System.out.println("Name: " + name);
        if ( playerRoleName == null){
            System.out.println("Role Name: None");
        }
        else {
            System.out.println("Role Name: " + playerRoleName);    
        }
        if ( playerRole == null){
            System.out.println("Role: None");
        }
        else {
            System.out.println("Role: " + playerRole);    
        }
        System.out.println("Role Position: " + playerRolePosition);
        if (isInTrailer == true) {
            System.out.println("Set Location: Trailer");
        }
        else if (isInOffice == true) {
            System.out.println("Set Location: Office");
        }
        else {
            System.out.println("Set Location: " + BoardData.getSetName(playerLocation));
        }
        System.out.println("Rank: " + rank);
        System.out.println("Dollars:" + dollarCount);
        System.out.println("Credits: " + creditCount);
        System.out.println("Reheases: " + rehearseCounter);
    }
}