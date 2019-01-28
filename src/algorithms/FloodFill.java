package algorithms;

public class FloodFill {
    private static char[][] arr;
    
    public static void main(String[] args) {
        arr = new char[][] {
            {'#', '-', '-', '#', '-'},
            {'#', '#', '-', '-', '-'},
            {'-', '-', '#', '#', '#'},
            {'-', '-', '-', '-', '-'}
        };
        System.out.println("Before floodFill:");
        showArr();

        floodFill(0, 1, '-', '#');
        System.out.println("After floodFill:");
        showArr();
    }
    
    private static void floodFill(int i, int j, char oldVal, char newVal) {
        if (i < 0 || i > arr.length-1) return; // check array bounds
        if (j < 0 || j > arr[i].length-1) return;
        
        if (arr[i][j] != oldVal) // Base case
            return;

        arr[i][j] = newVal;
        floodFill(i + 1, j, oldVal, newVal); // down
        floodFill(i - 1, j, oldVal, newVal); // up
        floodFill(i, j + 1, oldVal, newVal); // right
        floodFill(i, j - 1, oldVal, newVal); // left
    }
    
    private static void showArr() {
        for (char[] row : arr)  {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
