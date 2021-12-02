package edu.bsu.cs.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OverwatchApplication extends Application {
    private final ApplicationContainerBox applicationContainerBox = new ApplicationContainerBox();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Application");
        primaryStage.setScene(createGUI());
        primaryStage.show();
    }

    private Scene createGUI() {
        int sceneWidth = 1280;
        int sceneHeight = 720;
        return new Scene(applicationContainerBox, sceneWidth, sceneHeight);
    }
}
