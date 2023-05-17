import java.lang.Math;

public class Day {
    public int numOfPlayers;
    public int dayCount = 0;
    private int[] scenesDrawn = new int[10];

    //BoardData boardData = new BoardData();
    Board board = new Board();
    LocationManager locManager = new LocationManager();


    public void endDay() {
        drawScenes();
        board.setMapLayout(scenesDrawn);
        System.out.println("\nA new day has started!");
    }

    public void finalDay() {

    }

    private void drawScenes() {
        //scenesDrawn = new int[10];
        int i = 0;
        while(i < 10){
            int randomScene = ((int) Math.floor(Math.random() * (39)));
            for (int a = 0; a < 10; a++) {
                if (scenesDrawn[a] == randomScene) {
                    randomScene = ((int) Math.floor(Math.random() * (39)));
                }
            }
            scenesDrawn[i] = randomScene;
            i++;
        }
    }

    public void setUp() {
        drawScenes();
        board.setMapLayout(scenesDrawn);
        locManager.updateLocation(0);
    }
}
