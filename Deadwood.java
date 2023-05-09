

public class Deadwood {

    private String recordRole;
    private int rehearseCounter;
    private int score;
    private int dayCount;
    public static String[] players;
    private int[] gameStats;

    Player player = new Player();
    LocationManager locManager = new LocationManager();

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

        String winningPlayer = "";
        int highestScore = Integer.MIN_VALUE;
        int highestRank = Integer.MIN_VALUE;
        boolean tie = false;

        for (int i = 0; i < players.length; i++) {
            //figure out highest score.
            int score = scoring();

            if (score > highestScore) {
                highestScore = score;
                highestRank = player.rank;
                winningPlayer = player.name;
                tie = false;

            } else if (score == highestScore && player.rank > highestRank) {
                highestRank = player.rank;
                winningPlayer = player.name;
                tie = false;

            } else if (score == highestScore && player.rank == highestRank) {
                tie = true;
            }
        }

        score = highestScore; //
        
        //handle the tie case
        if (tie) {
            return "There is no winner. It's a tie.";
        } else {
            return "The winner is player " + winningPlayer + ", with the score = " + score;
        }
    }
}