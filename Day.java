import java.lang.Math;

public class Day {
    public int numOfPlayers;
    public int dayCount = 0;
    private int[] scenesDrawn;

    //BoardData boardData = new BoardData();
    Board board = new Board();
    LocationManager locManager = new LocationManager();


    public void endDay() {

    }

    public void finalDay() {

    }

    private void drawScenes() {
        scenesDrawn = new int[10];
        int i = 0;
        while(i < 10){
            scenesDrawn[i] = ((int) Math.floor(Math.random() * (39)));
            i++;
        }
    }

    public void setUp() {
        drawScenes();
        board.setMapLayout(scenesDrawn);
        locManager.updateLocation(0);
    }
}
