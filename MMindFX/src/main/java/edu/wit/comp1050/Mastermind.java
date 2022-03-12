package edu.wit.comp1050;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Mastermind extends Application{
    public static void main(String[] args) {
        Thread t1 = new Thread(new Timer());
        t1.start();
        Thread t2 = new Thread(new soundPlayer());
        t2.start();

        Application.launch(edu.wit.comp1050.Mastermind.class, args);
    }
    @Override
    public void init() {
        // System.out.println("Before!");
    }

    public static Parent root;

    public static Scene startScene;

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("config.fxml")));
        startScene = new Scene(root);
        stage.setTitle("Master Mind");
        stage.setScene(startScene);
        stage.show();

        stage.setOnCloseRequest( e -> {
            Platform.exit();
            System.exit(0);
        });

        new Thread(
                new Runnable() {
                    final boolean run = true;
                    public void run() {
                        while (run) {
                            try {
                                Text t = (Text) Controller.box_List.get(13).getChildren().get(0);
                                t.setText(Timer.getTime() + " / " + Controller.time_limit+":00");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
    }

    @Override
    public void stop() {
        // System.out.println("After!");
    }
}
