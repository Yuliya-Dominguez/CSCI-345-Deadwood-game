import java.util.*;

public class Board {

    public int takesLeft;
    SceneCards sceneCards = new SceneCards();
    private static List<BoardData> sets = new ArrayList<BoardData>();

    //Sets up the map by assigning the int values from scenesDrawn to every location on the board.
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

    //Getter function to return the List of type BoardData to give the list of all the locations on the board.
    public static List<BoardData> getBoardLocations() {
        return sets;
    }
} 
