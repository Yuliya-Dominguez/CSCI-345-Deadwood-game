public class Player {

    public String name;
    public String playerRole;
    public int playerRolePosition;
    public int rank;
    public int dollarCount;
    public int creditCount;
    public int rehearseCounter;

    Dice dice = new Dice();
    Store store = new Store();
    LocationManager locManager = new LocationManager();
    SceneCards scene = new SceneCards();
    Acting act = new Acting();

    public String move() {
        //Need location man and board probably for this, and XML.
        return null;
    }

    public void act() {
        int roll = dice.readDice();
        if (playerRole.equals("Extra")) {
            if ((roll + rehearseCounter) >= scene.boardRoleRank) {
                act.successExtraRole();
                rehearseCounter = 0;
            }
            else {
                act.failureExtraRole();
            }
        }
        else if (playerRole.equals("Main")) {
            if (roll + rehearseCounter >= scene.cardRoleRank) {
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

    public void takeRole() {

    }

    public void checkInfo() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + playerRole);
        System.out.println("Role Position: " + playerRolePosition);
        System.out.println("Rank: " + rank);
        System.out.println("Dollars:" + dollarCount);
        System.out.println("Credits: " + creditCount);
        System.out.println("Reheases: " + rehearseCounter);
    }

    public void endTurn() {
        
    }

}