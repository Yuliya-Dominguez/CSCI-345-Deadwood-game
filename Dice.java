import java.lang.Math;

public class Dice {

    //private int gameDice;
    public int[] bonusDice;

    SceneCards sceneCards = new SceneCards();
    //Board board = new Board();

    //Rolls a D6 (six-sided die).
    public int readDice() {
        return ((int) Math.floor(Math.random() * (6 - 1 + 1) + 1));
    }

    //Rolls multiple dice based on the budget of a card in order to calculate the rolls for bonus payement for main role actors.
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