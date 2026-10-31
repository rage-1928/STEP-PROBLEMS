public class Token {
    private static int inOrder(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i] < arr[i - 1]) {
                return i; 
            }
        }
        return -1; 
    }    
    public static void main(String[] args) {
        int[] arr = {3, 5, 5, 8, 6, 9};
        System.out.println(inOrder(arr));
    }
}
