package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OverwatchApplication extends Application {
    private final TextField searchInputField;
    private final Button searchButton;

    public OverwatchApplication(){
        searchInputField = new TextField("Enter your exact BattleTag");
        searchButton = new Button("Search");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Application");
        primaryStage.setScene(createGUI());
        primaryStage.show();
    }

    private Scene createGUI() {
        HBox searchHBox = createSearchHBox();
        int sceneWidth = 1280;
        int sceneHeight = 720;
        return new Scene(searchHBox,sceneWidth,sceneHeight);
    }

    private HBox createSearchHBox() {
        HBox searchHBox = new HBox(searchInputField, searchButton);
        searchHBox.setAlignment(Pos.TOP_CENTER);
        return searchHBox;
    }
}
