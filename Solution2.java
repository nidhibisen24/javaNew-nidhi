import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input
        
        int lineNumber = 1; // Initialize line counter
        
        // Read input until EOF
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read a line from input
            System.out.println(lineNumber + " " + line); // Print line number and content
            lineNumber++; // Increment the line counter
        }
        
        scanner.close(); // Close the Scanner
    }
}
