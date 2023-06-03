import java.util.ArrayList;

import java.util.*;

public class PlayersList {
    
    Player player = new Player();
    List<Player> gamePlayers = new ArrayList<Player>();



    public void createPlayerList(int size) {
        for (int i = 0; i < size; i++) {
            Player players = new Player();
            players.gamePlayersListIndex = i;
            gamePlayers.add(players);
        }
    }

    public List<Player> getPlayerList() {
        return gamePlayers;
    }

}
