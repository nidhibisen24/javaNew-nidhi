import java.util.Scanner; // Ensure import is at the top

public class Solution {
    static int B; // Static variable for breadth
    static int H; // Static variable for height
    static boolean flag; // Static flag to validate input

    // Static initialization block
    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt(); // Read breadth
        H = scanner.nextInt(); // Read height
        scanner.close();

        // Validate input
        if (B > 0 && H > 0) {
            flag = true; // Valid dimensions
        } else {
            flag = false; // Invalid dimensions
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H; // Calculate area of the parallelogram
            System.out.println(area); // Print the area
        }
    }
}
