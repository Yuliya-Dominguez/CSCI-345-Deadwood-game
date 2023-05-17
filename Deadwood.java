

public class Deadwood {

    private int score;
    public static String[] players;

    Player player = new Player();
    //LocationManager locManager = new LocationManager();

    //Print out the stats of the player.
    public String displayStats() {
        String stats = ("Name: " + player.name + "\n" + "Role: " + 
        player.playerRole + "\n" + "Rank: " + player.rank + "\n" +
        "Dollars: " + player.dollarCount + "\n" + "Credits: " + player.creditCount + "\n");
        return stats;
    }

    /*
     * Takes in Player class 'player', and calculates the score of that player by adding their credits, dollars,
     * and their player rank mulitiplied by 5, and returns and in of their total score.
     */
    public int scoring(Player player) {
        int result;
        result = player.creditCount + player.dollarCount + (player.rank * 5);

        return result;
    }

    /*
     * Takes in three arrays, the scores, ranks, and names of all the players in the game.
     * deciderWinner will iterate through each element, and compare the score to see which score is the highest.
     * Whoever has the highest score and highest rank is the winner. If there are multiple people with the same highest score and rank, then there is a tie.
     */
    public String decideWinner(int[] playerScores, int[] playerRanks, String[] playerNames) {

        String winningPlayer = "";
        int highestScore = Integer.MIN_VALUE;
        int highestRank = Integer.MIN_VALUE;
        boolean tie = false;

        for (int i = 0; i < playerScores.length; i++) {
            //figure out highest score.
            //int score = scoring();

            if (playerScores[i] > highestScore) {
                highestScore = playerScores[i];
                highestRank = playerRanks[i];
                winningPlayer = playerNames[i];
                tie = false;

            } else if (playerScores[i] == highestScore && playerRanks[i] > highestRank) {
                highestRank = playerRanks[i];
                winningPlayer = playerNames[i];
                tie = false;

            } else if (playerScores[i] == highestScore && playerRanks[i] == highestRank) {
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