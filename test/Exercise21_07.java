package test;
import java.util.*;

public class Exercise21_07 {
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
            "Have a good visit. Have fun!";

        // Create a HashMap to hold words as key and count as value
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();
            
            if (key.length() > 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        // Sort the entries based on the count (value) in ascending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        // Display key and value for each entry in ascending order of occurrence counts
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}