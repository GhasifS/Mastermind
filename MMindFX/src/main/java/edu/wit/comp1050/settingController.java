package edu.wit.comp1050;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class settingController {

    public ObservableList<String> maxList = FXCollections.observableArrayList("6", "8", "10");
    public ObservableList<String> timeList = FXCollections.observableArrayList("0", "1", "3", "5", "10", "15");

    @FXML
    private CheckBox dupe_check;

    @FXML
    private CheckBox blank_check;

    @FXML
    private CheckBox sound_check;

    @FXML
    private ChoiceBox<String> guess_choice;

    @FXML
    private ChoiceBox<String> time_choice;

    @FXML
    public void initialize() {
        guess_choice.setValue(UserConfig.getInstance().getProperty("codePegRows"));
        guess_choice.setItems(maxList);
        time_choice.setValue(UserConfig.getInstance().getProperty("maxTime"));
        time_choice.setItems(timeList);
        dupe_check.setSelected(Boolean.parseBoolean(UserConfig.getInstance().getProperty("dupesAllowedInCode")));
        blank_check.setSelected(Boolean.parseBoolean(UserConfig.getInstance().getProperty("blanksAllowedInCode")));
        sound_check.setSelected(Boolean.parseBoolean(UserConfig.getInstance().getProperty("playSounds")));
    }

    @FXML
    void goBack(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        window.setScene(Mastermind.startScene);
        window.show();
    }

    @FXML
    void applySettings(ActionEvent event) {
        UserConfig.modifyLine("codePegRows", guess_choice.getValue());
        UserConfig.modifyLine("maxTime", time_choice.getValue());
        UserConfig.modifyLine("dupesAllowedInCode", String.valueOf(dupe_check.selectedProperty().get()));
        UserConfig.modifyLine("blanksAllowedInCode", String.valueOf(blank_check.selectedProperty().get()));
        UserConfig.modifyLine("playSounds", String.valueOf(sound_check.selectedProperty().get()));
        colorChanger.clearGameBoard();
        Stage window = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        window.setScene(Mastermind.startScene);
        window.show();
    }
}
