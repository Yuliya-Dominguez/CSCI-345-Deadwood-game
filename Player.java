import java.util.List;

public class Player {

    public String name;
    public String playerRole;
    public String playerRoleName;
    public int playerRolePosition;
    public int playerLocation;
    public int sceneIndexNumber;
    public int rank;
    public int dollarCount;
    public int creditCount;
    public int rehearseCounter;

    Dice dice = new Dice();
    Board board = new Board();
    SceneCards scene = new SceneCards();
    Acting act = new Acting();

    Store store = Store.getStoreInstance();
    public List<BoardData> boardLocations = Board.getBoardLoactions();
    

    

    public void move(int neighborMove) {
        playerLocation = neighborMove;
        //Need location man and board probably for this, and XML.
    }


    public void act() {
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
            }
            else {
                //act.failureExtraRole();
                System.out.println("Failure. Dollar gained.");
                dollarCount++;
            }
        }
        else if (playerRole.equals("Main")) {
            if (roll + rehearseCounter >= scene.getCardBudget(sceneIndexNumber)) {
                //act.successMainRole();
                System.out.println("Success! Gain two credits.");
                creditCount+= 2;
                //store.payForShot(playerRole);
                rehearseCounter = 0;
            }
            else {
                //act.failureMainRole();
                System.out.println("Failure. Nothing gained.");
            }
        }
    }

    public void rehearse() {
        System.out.println("You've rehearsed! Take one rehearse counter.");
        rehearseCounter++;
    }

    public void upgrade(int rankWanted, String paymentType) {
        store.upgradeRank(rankWanted, paymentType);
    }

    public int takeRole(String sceneOrBoard, int partIndex) {
        BoardData currentSet = boardLocations.get(playerLocation);
        if (sceneOrBoard.equals("scene")) {
            playerRole = "Main";
            playerRoleName = SceneCards.getPartName(sceneIndexNumber, partIndex);
            playerRolePosition = partIndex;
            sceneIndexNumber = currentSet.getSceneIndex();
            return 1;
        }
        else if(sceneOrBoard.equals("board")) {
            playerRole = "Extra";
            playerRoleName = BoardData.getPartName(playerLocation, playerRolePosition);
            playerRolePosition = partIndex;
            return 1;
        }
        else {
            return 0;
        } 
    } 

    public void checkInfo() {
        System.out.println("Name: " + name);
        if ( playerRoleName == null){
            System.out.println("Role Name: None");
        }
        else {
            System.out.println("Role: " + playerRoleName);    
        }
        if ( playerRole == null){
            System.out.println("Role: None");
        }
        else {
            System.out.println("Role: " + playerRole);    
        }
        System.out.println("Role Position: " + playerRolePosition);
        System.out.println("Set Location: " + BoardData.getSetName(playerLocation));
        System.out.println("Rank: " + rank);
        System.out.println("Dollars:" + dollarCount);
        System.out.println("Credits: " + creditCount);
        System.out.println("Reheases: " + rehearseCounter);
    }
}