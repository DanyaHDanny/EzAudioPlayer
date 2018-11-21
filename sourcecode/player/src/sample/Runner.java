package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Runner extends Application {

    /**
     * JavaFX start method.
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {

        new Player();

    }

    /**
     * Main method with launch.
     */
    public static void main(final String[] args) {

        launch(args);

    }

}
