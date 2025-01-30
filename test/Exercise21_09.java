package test;

import java.util.*;

public class Exercise21_09 {
  public static void main(String[] args) {
    // Create a map to store state and capital pairs
    Map<String, String> stateCapitalMap = new HashMap<>();
    
    // Fill the map with state-capital pairs
    stateCapitalMap.put("Alabama", "Montgomery");
    stateCapitalMap.put("Alaska", "Juneau");
    stateCapitalMap.put("Arizona", "Phoenix");
    stateCapitalMap.put("Arkansas", "Little Rock");
    stateCapitalMap.put("California", "Sacramento");
    stateCapitalMap.put("Colorado", "Denver");
    stateCapitalMap.put("Connecticut", "Hartford");
    stateCapitalMap.put("Delaware", "Dover");
    stateCapitalMap.put("Florida", "Tallahassee");
    stateCapitalMap.put("Georgia", "Atlanta");
    stateCapitalMap.put("Hawaii", "Honolulu");
    stateCapitalMap.put("Idaho", "Boise");
    stateCapitalMap.put("Illinois", "Springfield");
    stateCapitalMap.put("Indiana", "Indianapolis");
    stateCapitalMap.put("Iowa", "Des Moines");
    stateCapitalMap.put("Kansas", "Topeka");
    stateCapitalMap.put("Kentucky", "Frankfort");
    stateCapitalMap.put("Louisiana", "Baton Rouge");
    stateCapitalMap.put("Maine", "Augusta");
    stateCapitalMap.put("Maryland", "Annapolis");
    stateCapitalMap.put("Massachusetts", "Boston");
    stateCapitalMap.put("Michigan", "Lansing");
    stateCapitalMap.put("Minnesota", "Saint Paul");
    stateCapitalMap.put("Mississippi", "Jackson");
    stateCapitalMap.put("Missouri", "Jefferson City");
    stateCapitalMap.put("Montana", "Helena");
    stateCapitalMap.put("Nebraska", "Lincoln");
    stateCapitalMap.put("Nevada", "Carson City");
    stateCapitalMap.put("New Hampshire", "Concord");
    stateCapitalMap.put("New Jersey", "Trenton");
    stateCapitalMap.put("New York", "Albany");
    stateCapitalMap.put("New Mexico", "Santa Fe");
    stateCapitalMap.put("North Carolina", "Raleigh");
    stateCapitalMap.put("North Dakota", "Bismarck");
    stateCapitalMap.put("Ohio", "Columbus");
    stateCapitalMap.put("Oklahoma", "Oklahoma City");
    stateCapitalMap.put("Oregon", "Salem");
    stateCapitalMap.put("Pennsylvania", "Harrisburg");
    stateCapitalMap.put("Rhode Island", "Providence");
    stateCapitalMap.put("South Carolina", "Columbia");
    stateCapitalMap.put("South Dakota", "Pierre");
    stateCapitalMap.put("Tennessee", "Nashville");
    stateCapitalMap.put("Texas", "Austin");
    stateCapitalMap.put("Utah", "Salt Lake City");
    stateCapitalMap.put("Vermont", "Montpelier");
    stateCapitalMap.put("Virginia", "Richmond");
    stateCapitalMap.put("Washington", "Olympia");
    stateCapitalMap.put("West Virginia", "Charleston");
    stateCapitalMap.put("Wisconsin", "Madison");
    stateCapitalMap.put("Wyoming", "Cheyenne");

    // Create a scanner for user input
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter a state and display its capital
    while (true) {
      System.out.print("Enter the name of a state (or 'exit' to quit): ");
      String state = input.nextLine().trim();

      if (state.equalsIgnoreCase("exit")) {
        break;
      }

      // Check if the state exists in the map
      if (stateCapitalMap.containsKey(state)) {
        System.out.println("The capital of " + state + " is " + stateCapitalMap.get(state));
      } else {
        System.out.println("State not found. Please enter a valid state.");
      }
    }

    input.close();
  }
}