package chapter22;
import java.util.Scanner;

public class Exercise22_03 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first string
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        // Prompt the user to enter the second string
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Check if str2 is a substring of str1 and print the index
        int index = findSubstringIndex(str1, str2);
        if (index != -1) {
            System.out.println("Substring matched at index: " + index);
        } else {
            System.out.println("The second string is not a substring of the first string.");
        }

        scanner.close();
    }

    // Method to find the index of str2 in str1
    public static int findSubstringIndex(String str1, String str2) {
        // If the second string is longer than the first, it cannot be a substring
        if (str2.length() > str1.length()) {
            return -1;
        }

        // Iterate over str1 with a window of the length of str2
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            // Check if the substring of str1 starting at index i matches str2
            boolean match = true;
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            // If match is found, return the starting index
            if (match) {
                return i;
            }
        }

        // No match found, return -1
        return -1;
    }
}
