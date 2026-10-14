import java.util.*;
public class LongStreak {

    int longestStreak(int[] scores) {
        if(scores.length == 0) return 0;
        int streak = 1;
        int maxStreak = 1;
        for(int i = 1; i < scores.length; i++) {
            if(scores[i] == 1) {
                streak++;
                maxStreak = Math.max(maxStreak, streak);
            } else {
                streak = 0;
            }
        }
        return maxStreak;
    }
    int countPresent(int[] scores) {
        int count = 0;
        for(int score : scores) {
            if(score == 1) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of scores: ");
        int n = sc.nextInt();
        int[] scores = new int[n];

        System.out.println("Enter the scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        LongStreak ls = new LongStreak();
        System.out.println("Count of present scores: " + ls.countPresent(scores));
        System.out.println("Longest streak of present scores: " + ls.longestStreak(scores));
        sc.close();
    }
}
/* 
Time Complexity: O(n) - The algorithm iterates through the array twice, each iteration taking linear time.
Space Complexity: O(1) - The algorithm uses a constant amount of space to store the indices and counters, regardless of the size of the input array.
Both answers can be found in a single pass through the array, but they are separated for clarity.
*/