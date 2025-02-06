package chapter22;
import java.util.Scanner;

/*
Time complexity explanation:
The loop runs through the string once, which takes O(n) time where n is the length of the string.
However, the overall time complexity can be O(n^2) in the worst case (when the string is strictly increasing).
*/

public class Exercise22_01 {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find and print the maximum increasing substring
        String result = findMaxIncreasingSubstring(input);
        System.out.println("Maximum consecutive substring: " + result);

        scanner.close();
    }

    // Method to find the maximum consecutive increasing substring
    public static String findMaxIncreasingSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String maxSubstring = "";
        String currentSubstring = "" + input.charAt(0);

        // Traverse through the string to find the longest increasing substring
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) > input.charAt(i - 1)) {
                currentSubstring += input.charAt(i);
            } else {
                if (currentSubstring.length() > maxSubstring.length()) {
                    maxSubstring = currentSubstring;
                }
                currentSubstring = "" + input.charAt(i);
            }
        }

        // Check the last increasing substring
        if (currentSubstring.length() > maxSubstring.length()) {
            maxSubstring = currentSubstring;
        }

        return maxSubstring;
    }
}