package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Player extends Stage {

    private static final String TITLE_WINDOW;

    /**
     * Value of the object AnchorPane.
     */
    private AnchorPane pane;

    static {
        TITLE_WINDOW = "EzAudioPlayer";
    }

    /**
     * Public default constructor.
     */
    public Player() {

        try {
            pane = FXMLLoader.load(Player.class.getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.setScene(new Scene(this.pane));
        super.setTitle(TITLE_WINDOW);
        super.setResizable(false);
        super.show();

    }

}
