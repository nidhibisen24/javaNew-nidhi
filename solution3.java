public import java.util.Scanner;

public class solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input
        int t = scanner.nextInt(); // Read the number of test cases

        for (int i = 0; i < t; i++) {
            try {
                // Read the input number as a long (to handle larger integers)
                long n = scanner.nextLong();

                System.out.println(n + " can be fitted in:");
                if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                System.out.println("* long");
            } catch (Exception e) {
                // Handle numbers that exceed the range of a long
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }
        }

        scanner.close(); // Close the Scanner
    }
}
 {
    
}
