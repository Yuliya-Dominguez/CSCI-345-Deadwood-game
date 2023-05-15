public class LocationManager {

    //Board board = new Board();
    Player player = new Player();

    public String[] playerLocations;
    public String[] sceneNames;

    public boolean validateMove() {
        return true;
    }

    public void updateLocation(int location) {
        player.playerLocation = location;
    } 
}
