package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OverwatchApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Application");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    private Scene createScene() {
        HBox searchHBox = createSearchHBox();

        int sceneWidth = 1280;
        int sceneHeight = 720;
        return new Scene(searchHBox, sceneWidth,sceneHeight);
    }

    private HBox createSearchHBox() {
        TextField searchLine = new TextField("Enter your exact BattleTag");
        searchLine.setPrefWidth(200);
        searchLine.setPrefHeight(100);

        Button searchButton = new Button("Search");
        searchButton.setPrefWidth(200);
        searchButton.setPrefHeight(100);

        HBox searchHBox = new HBox(searchLine, searchButton);
        searchHBox.setAlignment(Pos.TOP_CENTER);
        return searchHBox;
    }

}
