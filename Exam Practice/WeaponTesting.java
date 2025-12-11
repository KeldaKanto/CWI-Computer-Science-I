import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This program represents a weapon test for a tabletop game. It
 * includes a GUI with weapon and die sprites that display each
 * weapon and their attack value as a die roll.
 */
public class WeaponTesting extends Application {

    /**
     * Creates a Scene with a Pane and adds it to the Stage.
     * @param primaryStage The primary Stage used for the app
     */
    @Override
    public void start(Stage primaryStage) {
        final Weapon[] weapons = {
                new Weapon("Sword", Die.D10),
                new Weapon("Axe", Die.D12),
                new Weapon("Mace", Die.D8)
        };
        Scene scene = new Scene(new WeaponPane(weapons), 675, 875);

        primaryStage.setTitle("Weapon Testing...");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX app
     * @param args (args passed through the launch() method)
     */
    public static void main(String[] args) {
        launch(args);
    }
}