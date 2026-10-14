import java.util.*;
public class RowGrid {
    int[] busiestRow(int grid[][]) {
        int index = -1;
        int count, maxCount = 0;
        for(int i = 0; i < grid.length; i++) {
            count = 0;
            for(int j = 0; j < grid[i].length; j++) {
                count += grid[i][j];
            }
            if(count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
        return new int[]{index, maxCount};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];

        System.out.println("Enter the grid values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        RowGrid rg = new RowGrid();
        int[] result = rg.busiestRow(grid);
        System.out.println("Busiest row index: " + result[0]);
        System.out.println("Number of present students in that row: " + result[1]);
        sc.close();
    }
}
/*
Time Complexity: O(m * n) - The algorithm iterates through each row and each column of the grid, resulting in a time complexity proportional to the number of elements in the grid.
Space Complexity: O(1) - The algorithm uses a constant amount of space to store the indices and counters, regardless of the size of the input grid.
*/
    