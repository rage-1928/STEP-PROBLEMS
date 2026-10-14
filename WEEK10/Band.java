import java.util.Scanner;
public class Band {

    public static int countInBand(int[] scores, int low, int high) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < low) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = left;
        left = 0;
        right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= high) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int end = left;
        return end - start;
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

        System.out.print("Enter the lower bound: ");
        int low = sc.nextInt();
        System.out.print("Enter the upper bound: ");
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}
/* 
Time Complexity: O(log n) - The algorithm uses binary search to find the positions of the lower and upper bounds, resulting in logarithmic time complexity.
Space Complexity: O(1) - The algorithm uses a constant amount of space to store the indices, regardless of the size of the input array.
Duplicate values at the edges of the band affect the algorithm of binary search as it may lead to incorrect counts if not handled properly. The algorithm ensures that the search for the lower and upper bounds is inclusive, counting all occurrences of the boundary values.
*/