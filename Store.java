public class Store {

    public int[][] rankUpgradeValues;

    Player player = new Player();
    Dice dice = new Dice();
    SceneCards sceneCards = new SceneCards();

    public void payForShot() {
        //Change this to detect for actor on scene card role.
        if (player.playerRole.equals("Main")) {
            player.creditCount+= 2;
        }
        else {
            player.creditCount++;
            player.dollarCount++;
        }
    }
    public void payBonus() {
        if (player.playerRole.equals("Main")) {
            
        }
        else {
            int payment = sceneCards.boardRoleRank;
            player.dollarCount+= payment;
        }
    }

    public void calcBonus() {

    }

    public void validatePayment() {

    }

    public void upgradeRank() {

    }

    public void updateBalance() {
        
    }
}
