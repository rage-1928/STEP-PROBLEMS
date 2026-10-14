import java.util.*;

public class RotateArr {

    public static void rotateRoster(String[] names, int k) {
        int n = names.length;
        k %= n;
        reverse(names, 0, n - 1);
        reverse(names, 0, k - 1);
        reverse(names, k, n - 1);
    }

    static void reverse(String[] names, int left, int right) {
        while (left < right) {
            String temp = names[left];
            names[left] = names[right];
            names[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        System.out.print("Enter the number of rotations: ");
        int k = sc.nextInt();
        rotateRoster(names, k);
        System.out.println(Arrays.toString(names));
    }
}
/* 
Time Complexity: O(n) - The algorithm reverses the array three times, each reversal taking linear time.
Space Complexity: O(1) - The algorithm uses a constant amount of space to store the indices, regardless of the size of the input array.
Rotating one place at a time is slow when k is large as it requires multiple passes through the array. 
*/