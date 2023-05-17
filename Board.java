import java.util.*;

public class Board {

    public int takesLeft;
    SceneCards sceneCards = new SceneCards();
    private static List<BoardData> sets = new ArrayList<BoardData>();

    public void setMapLayout(int[] scenesDrawn) {
        //put sets inside the ArrayList here.
        for (int a = 0; a < 12; a++) {
            BoardData boardData = new BoardData();
            sets.add(boardData);
        }

        for (int i = 0; i < (scenesDrawn.length-1); i++) {
            int sceneIndex = sceneCards.getSceneNumber(scenesDrawn[i]);
            sets.get(i).takeSceneIndex(sceneIndex);
        }
    }

    public static List<BoardData> getBoardLoactions() {
        return sets;
    }
} 
