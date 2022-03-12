package edu.wit.comp1050;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Controller {
    @FXML
    public void initialize() {
        box_List.add(guess_box1);
        box_List.add(guess_box11);
        box_List.add(guess_box12);
        box_List.add(guess_box13);
        box_List.add(guess_box14);
        box_List.add(guess_box15);
        box_List.add(guess_box16);
        box_List.add(guess_box17);
        box_List.add(guess_box18);
        box_List.add(guess_box19);
        box_List.add(win_box);
        box_List.add(triangle);
        box_List.add(button_box);
        box_List.add(text_box);
    }

    @FXML
    private HBox win_box;
    @FXML
    private HBox guess_box1;
    @FXML
    private HBox guess_box11;
    @FXML
    private HBox guess_box12;
    @FXML
    private HBox guess_box13;
    @FXML
    private HBox guess_box14;
    @FXML
    private HBox guess_box15;
    @FXML
    private HBox guess_box16;
    @FXML
    private HBox guess_box17;
    @FXML
    private HBox guess_box18;
    @FXML
    private HBox guess_box19;
    @FXML
    private HBox triangle;
    @FXML
    private HBox button_box;
    @FXML
    private HBox text_box;

    @FXML
    private MenuBar mainMenuBar;

    @FXML
    void bluClicked() { colorChanger.colorGuess("b"); }

    @FXML
    void greClicked() {
        colorChanger.colorGuess("g");
    }

    @FXML
    void oraClicked() {
        colorChanger.colorGuess("o");
    }

    @FXML
    void purClicked() {
        colorChanger.colorGuess("p");
    }

    @FXML
    void redClicked() {
        colorChanger.colorGuess("r");
    }

    @FXML
    void yelClicked() {
        colorChanger.colorGuess("y");
    }

    @FXML
    void traClicked() {
        colorChanger.colorGuess(" ");
    }

    @FXML
    void checkcodeClicked() {
        if (max_guess - 1 > index) {
            // System.out.println(guesses);
            Circle g1 = (Circle) box_List.get(index).getChildren().get(0);
            Circle g2 = (Circle) box_List.get(index).getChildren().get(1);
            Circle g3 = (Circle) box_List.get(index).getChildren().get(2);
            Circle g4 = (Circle) box_List.get(index).getChildren().get(3);

            if (Arrays.equals(guesses.toArray(), code)) {
                if (sounds) {
                    soundPlayer.playSound("src/main/resources/Winning sound effect.wav");
                }
                colorChanger.winBox();
            }

            if (guesses.size() == 4) {
                colorChanger.colorHint(code, guesses.toArray(new String[0]));
                guesses.clear();
                colors.clear();
                index++;
                box_List.get(11).setTranslateY(-(index * 60));
            } else {
                // System.out.println("ADD MORE COLORS");
                guesses.clear();
                g1.setFill(Color.WHITE);
                g2.setFill(Color.WHITE);
                g3.setFill(Color.WHITE);
                g4.setFill(Color.WHITE);
            }
        } else {
            // LOSE SOUND EFFECT
            if (sounds) {
                soundPlayer.playSound("src/main/resources/The Price is Right Losing Horn - Gaming Sound Effect (HD).wav");
            }
            // System.out.println("MAX GUESSES REACHED");
            colorChanger.winBox();
        }
    }

    @FXML
    void del_Clicked() {
        Circle g1 = (Circle) box_List.get(index).getChildren().get(0);
        Circle g2 = (Circle) box_List.get(index).getChildren().get(1);
        Circle g3 = (Circle) box_List.get(index).getChildren().get(2);
        Circle g4 = (Circle) box_List.get(index).getChildren().get(3);

        if (!guesses.isEmpty()) {
            guesses.remove(guesses.size() - 1);
        }

        if (guesses.size() == 1) {
            g2.setFill(Color.WHITE);
            g3.setFill(Color.WHITE);
            g4.setFill(Color.WHITE);
        }

        if (guesses.size() == 2) {
            g3.setFill(Color.WHITE);
            g4.setFill(Color.WHITE);
        }

        if (guesses.size() == 3) {
            g4.setFill(Color.WHITE);
        }

        if (guesses.isEmpty()) {
            g1.setFill(Color.WHITE);
            g2.setFill(Color.WHITE);
            g3.setFill(Color.WHITE);
            g4.setFill(Color.WHITE);
        }
    }

    @FXML
    void closeApp() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void resetDefault() {
        UserConfig.resetDefault();
        colorChanger.clearGameBoard();
    }

    @FXML
    void resetApp() {
        colorChanger.clearGameBoard();
    }


    @FXML
    void configApp() throws IOException {
        Parent configParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("settings.fxml")));
        Scene configScene = new Scene(configParent);
        Stage window = (Stage) mainMenuBar.getScene().getWindow();
        window.setScene(configScene);
        window.show();
    }

    @FXML
    void showSol() {
        colorChanger.winBox();
    }

    public static boolean getConfirm = true;

    public static int codeSize = Integer.parseInt(UserConfig.getInstance().getProperty("codeSize"));

    public static int index = 0;

    public static int time_limit = Integer.parseInt(UserConfig.getInstance().getProperty("maxTime"));

    public static int max_guess = Integer.parseInt(UserConfig.getInstance().getProperty("codePegRows"));

    public static boolean dupes = Boolean.parseBoolean(UserConfig.getInstance().getProperty("dupesAllowedInCode"));

    public static boolean blanks = Boolean.parseBoolean(UserConfig.getInstance().getProperty("blanksAllowedInCode"));

    public static boolean sounds = Boolean.parseBoolean(UserConfig.getInstance().getProperty("playSounds"));

    public static String[] code = CodeMaker.createCode(dupes, blanks);

    public static ArrayList<HBox> box_List = new ArrayList<>();

    public static ArrayList<String> guesses = new ArrayList<>();

    public static ArrayList<Integer> colors = new ArrayList<>();
}
