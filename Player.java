public class Player {

    public String name;
    public String playerRole;
    public String playerRoleName;
    public int playerRolePosition;
    public int sceneIndexNumber;
    public int rank;
    public int dollarCount;
    public int creditCount;
    public int rehearseCounter;

    Dice dice = new Dice();
    Board board = new Board();
    LocationManager locManager = new LocationManager();
    SceneCards scene = new SceneCards();
    Acting act = new Acting();

    Store store = Store.getStoreInstance();

    public String move() {
        //Need location man and board probably for this, and XML.
        return null;
    }

    public void act() {
        int roll = dice.readDice();
        if (playerRole.equals("Extra")) {
            if ((roll + rehearseCounter) >= ) { //board budget here.
                act.successExtraRole();
                rehearseCounter = 0;
            }
            else {
                act.failureExtraRole();
                dollarCount++;
            }
        }
        else if (playerRole.equals("Main")) {
            if (roll + rehearseCounter >= scene.getCardBudget()) {
                act.successMainRole();
                rehearseCounter = 0;
            }
            else {
                act.failureMainRole();
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
        if (sceneOrBoard.equals("scene")) {
            playerRole = "Main";
            playerRoleName = SceneCards.getPartName(, partIndex);
            playerRolePosition = partIndex;
            sceneIndexNumber = ; //get from board.
            return 1;
        }
        else if(sceneOrBoard.equals("board")) {
            playerRole = "Extra";
            playerRoleName = ;//board part name here.
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
        System.out.println("Rank: " + rank);
        System.out.println("Dollars:" + dollarCount);
        System.out.println("Credits: " + creditCount);
        System.out.println("Reheases: " + rehearseCounter);
    }
}