public class Store {

    public int[][] rankUpgradeValues = new int[2][5];

    Player player = new Player();
    Dice dice = new Dice();
    SceneCards sceneCards = new SceneCards();
    BoardData boardData = new BoardData();
    public int cardRolePayment1 = 0;
    public int cardRolePayment2 = 0;
    public int cardRolePayment3 = 0;

    private static Store instance = new Store();

    private Store(){}

    public static Store getStoreInstance() {
        return instance;
    }

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

    public void payBonusExtra() {
        int payment = BoardData.getPartLevel(player.playerLocation, player.playerRolePosition);
        player.dollarCount+= payment;
    }

    private void calcBonus() {
        dice.readBonus(player.sceneIndexNumber);
        if (SceneCards.getPartsList(player.sceneIndexNumber).size() == 3) {
            int i = 0;
            while (i < sceneCards.getCardBudget(sceneCards.cardRoleRank)) {
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
            while (i < sceneCards.getCardBudget(sceneCards.cardRoleRank)) {
                cardRolePayment1+= dice.bonusDice[i];
                i++;
                cardRolePayment2+= dice.bonusDice[i];
                i++;
            }
        }
    }

    private void setRankPrices() {
        rankUpgradeValues[0][0] = 4;
        rankUpgradeValues[0][1] = 10; 
        rankUpgradeValues[0][2] = 18; 
        rankUpgradeValues[0][3] = 28; 
        rankUpgradeValues[0][4] = 40; 
        rankUpgradeValues[1][0] = 5; 
        rankUpgradeValues[1][1] = 10; 
        rankUpgradeValues[1][2] = 15; 
        rankUpgradeValues[1][3] = 20; 
        rankUpgradeValues[1][4] = 25;  
    }

    public void upgradeRank(int rankLevel, String paymentType) {
        setRankPrices();
        if (paymentType.equals("dollar")) {
            if(player.dollarCount >= rankUpgradeValues[0][rankLevel - 2]) {
                player.dollarCount-= rankUpgradeValues[0][rankLevel - 2];
                player.rank = (rankLevel + 2);
            }
            else {
                System.out.println("Sorry, you do not have enough dollars to upgrade to this rank.");
            }
        }
        else if (paymentType.equals("credit")) {
            if(player.creditCount >= rankUpgradeValues[1][rankLevel - 2]) {
                player.creditCount-= rankUpgradeValues[1][rankLevel - 2];
                player.rank = (rankLevel + 2);
            }
            else {
                System.out.println("Sorry, you do not have enough credits to upgrade to this rank.");
            }
        }
    }
}
