import java.util.Scanner;
public class SecondBest {

    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
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
        System.out.println(secondHighest(scores));
        sc.close();
    }
}

/*
Time Complexity: O(n) - The algorithm iterates through the array of scores once to find the highest and second highest scores, resulting in linear time complexity.
space Complexity: O(1) - The algorithm uses a constant amount of space to store the highest and second highest scores, regardless of the size of the input array.
Sorting the array would take O(n log n) time at best, which is less efficient than the current approach.
*/