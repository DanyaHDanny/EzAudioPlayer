package sample;

import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class PlayerController {

    @FXML
    private Button PlayButton;
    @FXML
    private Button PauseButton;
    @FXML
    private Button StopButton;
    @FXML
    private Button FileButton;
    @FXML
    private Text TimerText;
    @FXML
    private Text FileNameText;
    @FXML
    private Slider TimeSlider;
    @FXML
    private Slider VolumeSlider;

    private MediaPlayer mediaPlayer;

    private FileChooser fc;

    private File file;

    private String path;

    @FXML
    Button VolumeButton;

    /**
     * Initialization actions.
     */
    @FXML
    public void initialize() {

        TimeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                Duration d = new Duration(TimeSlider.getValue() * 1000);
                if (mediaPlayer != null) {
                    if (TimeSlider.isValueChanging()) {
                        mediaPlayer.seek(d);
                    }
                    if (TimeSlider.isPressed()) {
                        mediaPlayer.seek(d);
                    }
                }
            }
        });

        VolumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                if (mediaPlayer != null) {
                    if (VolumeSlider.isValueChanging()) {
                        if (mediaPlayer.isMute())
                            mediaPlayer.setMute(false);
                        mediaPlayer.setVolume(VolumeSlider.getValue());
                    }
                    if (VolumeSlider.isPressed()) {
                        if (mediaPlayer.isMute())
                            mediaPlayer.setMute(false);
                        mediaPlayer.setVolume(VolumeSlider.getValue());
                    }
                }
            }
        });

        FileButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {

                        Stage stage = (Stage) FileButton.getScene().getWindow();
                        fc = new FileChooser();
                        fc.getExtensionFilters().addAll(
                                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3"));
                        Media media;
                        file = fc.showOpenDialog(stage);
                        path = file.getAbsolutePath();
                        path = path.replace("\\", "/");
                        media = new Media(new File(path).toURI().toString());
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }
                        mediaPlayer = new MediaPlayer(media);
                        TimeSlider.setValue(0);
                        mediaPlayer.setAutoPlay(true);
                        VolumeSlider.setValue(VolumeSlider.getMax());
                        mediaPlayer.setVolume(VolumeSlider.getValue());
                        FileNameText.setText(file.getName());

                        TimeSlider.setMin(0);

                        mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
                            @Override
                            public void invalidated(javafx.beans.Observable observable) {

                                if (mediaPlayer != null) {
                                    TimeSlider.setMax(mediaPlayer.getTotalDuration().toSeconds());
                                    int i1 = (int) (mediaPlayer.getCurrentTime().toMinutes());
                                    int i = (int) (mediaPlayer.getCurrentTime().toSeconds());
                                    TimerText.setText(String.format("%02d:%02d", i1, i - i1 * 60));
                                    TimeSlider.setValue(i);
                                }
                            }
                        });

                    }
                });

        PlayButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        if (mediaPlayer != null) {
                            mediaPlayer.setVolume(VolumeSlider.getValue());
                            mediaPlayer.play();
                        }
                    }
                });

        PauseButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        if (mediaPlayer != null)
                            mediaPlayer.pause();

                    }
                });

        StopButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        if (mediaPlayer != null)
                            mediaPlayer.stop();
                    }
                });

        VolumeButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        if (mediaPlayer != null) {
                            if (mediaPlayer.isMute())
                                mediaPlayer.setMute(false);
                            else mediaPlayer.setMute(true);
                        }
                    }
                });
    }
}
