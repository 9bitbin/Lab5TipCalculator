// This line tells the program which package (folder) the file belongs to. 
// Think of it as organizing the code into specific folders for easy access.
package himal.lab5tipcalculator;

// These lines import tools we need from the JavaFX library to create a graphical application.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This section contains information about the author, course, and purpose of the file.
 * Author: Himal Shrestha
 * Course: CSC 325 - Software Engineering
 * Purpose: LAB5 TIP CALCULATOR
 */
public class TipCalculator extends Application { // Start of the TipCalculator class, which is the main part of the program
    
    // This is the main method that JavaFX automatically calls to start the app.
    @Override
    public void start(Stage stage) throws Exception {
        // Loads the layout from the TipCalculator.fxml file, which defines how the app looks on the screen.
        Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

        // Creates a "Scene" which is like a frame in a photo. It holds everything the user will see.
        Scene scene = new Scene(root); // Attach the app layout to the scene

        // Sets the title that appears at the top of the application window.
        stage.setTitle("Himal's Tip Calculator"); 

        // Attaches the scene to the stage (window) so it can be shown to the user.
        stage.setScene(scene); 

        // Makes the application window visible on the screen.
        stage.show(); 
    }

    // The main method is the first part of the program that runs.
    // Here, it calls the "launch" method to start the JavaFX application.
    public static void main(String[] args) {
        launch(args); // Begins running the TipCalculator application
    }
}
