public class LocationManager {

    Board board = new Board();

    public String[] playerLocations;
    public String[] sceneNames;

    public boolean validateMove() {
        return true;
    }

    public void updateLocation() {
        board.setPlayerPos();
    }
}
