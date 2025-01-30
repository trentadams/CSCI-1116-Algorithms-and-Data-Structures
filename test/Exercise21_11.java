package test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // Add items to the ComboBox for year selection
    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001); // Default to 2001
        
    // Add items to the ComboBox for gender selection
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male"); // Default to Male

    // Load data from the URLs into the arrays
    loadData();

    // Set the action for the Find Ranking button
    btFindRanking.setOnAction(e -> findRanking());
  }

  // Method to load the data from the URLs into the arrays
  private void loadData() {
    // URL for 2001 data (Male and Female)
    String[] urls = {
      "http://liveexample.pearsoncmg.com/data/babynamesranking2001.txt",
      "http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt"
    };

    try {
      for (int i = 0; i < urls.length; i++) {
        URL url = new URL(urls[i]);
        Scanner scanner = new Scanner(url.openStream());
        
        while (scanner.hasNext()) {
          String line = scanner.nextLine();
          String[] data = line.split("\t");

          // Process Male data
          if (data.length == 6) {
            String maleName = data[1];
            String femaleName = data[3];
            int maleRank = Integer.parseInt(data[0]);
            int femaleRank = Integer.parseInt(data[2]);

            // Store Male name data
            if (mapForBoy[i] == null) mapForBoy[i] = new HashMap<>();
            mapForBoy[i].put(maleName, maleRank);
            
            // Store Female name data
            if (mapForGirl[i] == null) mapForGirl[i] = new HashMap<>();
            mapForGirl[i].put(femaleName, femaleRank);
          }
        }
        scanner.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Method to handle the Find Ranking button click
  private void findRanking() {
    int year = cboYear.getValue();
    String gender = cboGender.getValue();
    String name = tfName.getText().trim();

    // Get the correct index for the year
    int yearIndex = year - 2001;

    // Based on gender, get the map and check the ranking
    Map<String, Integer> nameMap = gender.equals("Male") ? mapForBoy[yearIndex] : mapForGirl[yearIndex];

    if (nameMap != null && nameMap.containsKey(name)) {
      int rank = nameMap.get(name);
      lblResult.setText("The rank of " + name + " in " + year + " is " + rank);
    } else {
      lblResult.setText("Name not found in " + year + " for " + gender);
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}