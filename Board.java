import java.util.*;

public class Board {


    //private int[] mapLayout;
    //public String playerPosition;
    public  int takesLeft;

    SceneCards sceneCards = new SceneCards();
    //LocationManager locManager = new LocationManager();
    
    //Player player = new Player();
   
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

    /*public int getTakesLeft() {
        return takesLeft;
    }

    public void setTakesLeft(int takes) {
        takesLeft = takes;
    }
    */
    //public void setPlayerPos(int location) {
    //    locManager.updateLocation(location);
    //}
} 
