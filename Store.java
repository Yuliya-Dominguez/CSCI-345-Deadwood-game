public class Store {

    public int[][] rankUpgradeValues;

    Player player = new Player();
    Dice dice = new Dice();
    SceneCards sceneCards = new SceneCards();
    public int cardRolePayment1 = 0;
    public int cardRolePayment2 = 0;
    public int cardRolePayment3 = 0;

    public void payForShot() {
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
            calcBonus();
            if (player.playerRolePosition == 1) {
                player.dollarCount+= cardRolePayment1;
            }
            else if (player.playerRolePosition == 2) {
                player.dollarCount+= cardRolePayment2;
            }
            else {
                player.dollarCount+= cardRolePayment3;
            }
        }
        else {
            int payment = sceneCards.boardRoleRank;
            player.dollarCount+= payment;
        }
    }

    public void calcBonus() {
        if (sceneCards.cardRoles.length == 3) {
            int i = 0;
            while (i < sceneCards.cardRoleRank) {
                cardRolePayment1+= dice.bonusDice[i];
                i++;
                cardRolePayment2+= dice.bonusDice[i];
                i++;
                cardRolePayment3+= dice.bonusDice[i];
                i++;
            }
        }
        else {
            int i = 0;
            while (i < sceneCards.cardRoleRank) {
                cardRolePayment1+= dice.bonusDice[i];
                i++;
                cardRolePayment2+= dice.bonusDice[i];
                i++;
            }
        }
    }

    public void validatePayment() {

    }

    public void upgradeRank() {

    }
}
