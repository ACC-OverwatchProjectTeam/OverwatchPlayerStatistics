package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OverwatchApplication extends Application {
    private final VBox applicationContainerBox = new VBox();
    private final SearchHBox searchHBox;
    private final PlayerInfoBox playerInfoBox;
    private final GamemodeSelectionBox gamemodeSelectionBox;
    private final GamemodeStatsHBox gamemodeStatsHBox;
    String playerData;
    Player player;


    public OverwatchApplication() {
        this.gamemodeStatsHBox = new GamemodeStatsHBox();
        this.gamemodeSelectionBox = new GamemodeSelectionBox(gamemodeStatsHBox);
        this.playerInfoBox = new PlayerInfoBox();
        this.searchHBox = new SearchHBox(player, playerData, playerInfoBox, gamemodeSelectionBox, gamemodeStatsHBox);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Application");
        primaryStage.setScene(createGUI());
        primaryStage.show();
    }

    private Scene createGUI() {
        applicationContainerBox.getChildren().addAll(searchHBox, playerInfoBox, gamemodeSelectionBox, gamemodeStatsHBox);
        int sceneWidth = 1280;
        int sceneHeight = 720;
        return new Scene(applicationContainerBox, sceneWidth, sceneHeight);
    }
}
