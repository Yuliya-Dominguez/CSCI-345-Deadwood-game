import java.lang.Math;

public class Dice {

    private int gameDice;
    public int[] bonusDice;

    SceneCards sceneCards = new SceneCards();
    Board board = new Board();

    public int readDice() {
        gameDice = ((int) Math.random() * (6 - 1) + 1);

        return gameDice;
    }

    public void readBonus(int sceneIndex) {
        int i = 0;
        bonusDice = new int[sceneCards.getCardBudget(sceneIndex)];
        while (i < sceneCards.getCardBudget(sceneIndex)) {
            int roll = readDice();
            bonusDice[i] = roll;
            i++;
        }

    }

}