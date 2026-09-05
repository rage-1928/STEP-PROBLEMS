import java.util.*;

class Player implements Comparable<Player> {

    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(
            other.battingAverage,
            this.battingAverage
        );
    }

    static String draftAndRank(Player[] players) {
        int count = 0;
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed) || isDraftable(player.matchesPlayed, player.injured)) {
                count++;
            }
        }
        Player[] draftable = new Player[count];
        int index = 0;
        for (Player player : players) {

            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {

                draftable[index] = player;
                index++;
            }
        }
        Arrays.sort(draftable);
        String result = "";
        for (int i = 0; i < draftable.length; i++) {
            result = result + (i + 1) + ". " + draftable[i].name;
            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}