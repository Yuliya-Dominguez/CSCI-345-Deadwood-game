import java.lang.Math;

public class Dice {

    private int gameDice;
    private int[] bonusDice;

    SceneCards sceneCards = new SceneCards();

    public int readDice() {
        gameDice = ((int) Math.random() * (6 - 1) + 1);

        return gameDice;
    }

    public void readBonus() {
        int i = 0;
        bonusDice = new int[sceneCards.cardRoleRank];
        while (i < sceneCards.cardRoleRank) {
            int roll = readDice();
            bonusDice[i] = roll;
            i++;
        }

    }

}