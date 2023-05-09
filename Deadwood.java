

public class Deadwood {

    private String recordRole;
    private int rehearseCounter;
    private int score;
    private int dayCount;
    public static String[] players;
    private int[] gageStats;

    Player player = new Player();

    public void gamePrep() {
        
    }

    public void validate() {

    }

    public String displayStats() {
        String stats = ("Name: " + player.name + "\n" + "Role: " + 
        player.playerRole + "\n" + "Rank: " + player.rank + "\n" +
        "Dollars: " + player.dollarCount + "\n" + "Credits: " + player.creditCount + "\n");
        return stats;
    }

    public int scoring() {
        int result;
        result = player.creditCount + player.dollarCount + (player.rank * 5);

        return result;
    }

    public String decideWinner() {
        int winner = 0;
        String winningPlayer;
        for (int i = 0; i < players.length; i++) {
            //Code here to figure out highest score.
        }
        return ("The winner is player " );
    }

}