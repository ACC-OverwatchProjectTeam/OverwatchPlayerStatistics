package edu.bsu.cs;

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
    private final HeroStatsBox heroStatsBox = new HeroStatsBox();
    String playerData;
    Player player;

    public OverwatchApplication() {
        this.gamemodeStatsHBox = new GamemodeStatsHBox(heroStatsBox);
        this.gamemodeSelectionBox = new GamemodeSelectionBox(gamemodeStatsHBox);
        this.playerInfoBox = new PlayerInfoBox();
        this.searchHBox = new SearchHBox(player, playerData, playerInfoBox, gamemodeSelectionBox, gamemodeStatsHBox, heroStatsBox);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Application");
        primaryStage.setScene(createGUI());
        primaryStage.show();
    }

    private Scene createGUI() {
        applicationContainerBox.getChildren().addAll(searchHBox, playerInfoBox, gamemodeSelectionBox, gamemodeStatsHBox, heroStatsBox);
        int sceneWidth = 1280;
        int sceneHeight = 720;
        return new Scene(applicationContainerBox, sceneWidth, sceneHeight);
    }
}
