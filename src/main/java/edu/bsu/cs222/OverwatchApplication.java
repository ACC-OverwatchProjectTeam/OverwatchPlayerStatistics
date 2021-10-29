package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OverwatchApplication extends Application {
    final VBox applicationContainerBox = new VBox();
    final HBox playerInfoBox = new HBox();
    final TextField playerName = new TextField();
    final TextField playerLevel = new TextField();
    final ImageView playerIconView = new ImageView();
    final HBox gamemodeSelectionBox = new HBox();
    final Button competitiveButton = new Button("Competitive Stats");
    final VBox competitiveStatsVBox = new VBox();
    final ImageView ratingIconView = new ImageView();
    final TextField skillRating = new TextField();
    final TextField competitiveGamesPlayed = new TextField();
    final TextField competitiveGamesWon = new TextField();
    final Button quickPlayButton = new Button("QuickPlay Stats");
    final VBox quickPlayStatsVBox = new VBox();
    final TextField quickPlayGamesPlayed = new TextField();
    final TextField quickPlayGamesWon = new TextField();
    String playerData;
    Player player;


    public OverwatchApplication() {
        competitiveButton.setOnAction(event -> setCompetitiveInfo());
        quickPlayButton.setOnAction(event -> setQuickPlayInfo());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Application");
        primaryStage.setScene(createGUI());
        primaryStage.show();
    }

    private Scene createGUI() {
        setupPlayerInfoBox();
        setupGamemodeSelectionBox();
        setupCompetitiveStatsBox();
        setupQuickPlayStatsBox();

        OverwatchApplication application = OverwatchApplication.this;

        applicationContainerBox.getChildren().addAll(new SearchHBox(application), playerInfoBox, gamemodeSelectionBox,
                new HBox(competitiveStatsVBox, quickPlayStatsVBox));
        int sceneWidth = 1280;
        int sceneHeight = 720;
        return new Scene(applicationContainerBox, sceneWidth, sceneHeight);
    }

    private void setupPlayerInfoBox() {
        playerInfoBox.getChildren().addAll(playerIconView, playerName, playerLevel);
        playerInfoBox.setAlignment(Pos.CENTER);
        playerInfoBox.setVisible(false);

        playerName.setFont(Font.font(20));
        playerName.autosize();

        playerLevel.setFont(Font.font(20));
        playerLevel.autosize();
    }

    private void setupGamemodeSelectionBox() {
        gamemodeSelectionBox.getChildren().addAll(competitiveButton, quickPlayButton);
        gamemodeSelectionBox.setAlignment(Pos.CENTER);
        gamemodeSelectionBox.setMinWidth(1280);
        gamemodeSelectionBox.setVisible(false);

        competitiveButton.setMinSize(200, 75);
        competitiveButton.setFont(Font.font(20));

        quickPlayButton.setMinSize(200, 75);
        quickPlayButton.setFont(Font.font(20));
    }

    private void setupCompetitiveStatsBox() {
        competitiveStatsVBox.getChildren().addAll(ratingIconView, skillRating, competitiveGamesPlayed,
                competitiveGamesWon);
        competitiveStatsVBox.setAlignment(Pos.TOP_CENTER);
        competitiveStatsVBox.setVisible(false);

        skillRating.setFont(Font.font(20));
        skillRating.autosize();

        competitiveGamesPlayed.setFont(Font.font(20));
        competitiveGamesPlayed.autosize();

        competitiveGamesWon.setFont(Font.font(20));
        competitiveGamesWon.autosize();
    }

    private void setupQuickPlayStatsBox() {
        quickPlayStatsVBox.getChildren().addAll(quickPlayGamesPlayed, quickPlayGamesWon);
        quickPlayStatsVBox.setAlignment(Pos.TOP_RIGHT);
        quickPlayStatsVBox.setVisible(false);

        quickPlayGamesPlayed.setFont(Font.font(20));
        quickPlayGamesPlayed.autosize();

        quickPlayGamesWon.setFont(Font.font(20));
        quickPlayGamesWon.autosize();
    }

    private ImageView loadPlayerIcon() {
        Image playerIcon = new Image(player.accessPlayerIcon());
        ImageView playerIconView = new ImageView();
        playerIconView.setImage(playerIcon);
        return playerIconView;
    }

    private void loadRatingIcon() {
        Image ratingIcon = new Image(player.accessRatingIcon(), 100, 100, false, false);
        ImageView ratingIconView = new ImageView();
        ratingIconView.setImage(ratingIcon);
        competitiveStatsVBox.getChildren().add(0, ratingIconView);
    }

    public void setBasicPlayerInfo() {
        playerName.setText(player.accessPlayerName());
        playerLevel.setText(String.format("Lv.%d%d",
                player.accessPrestige(),
                player.accessLevel()));
        playerInfoBox.getChildren().add(0, loadPlayerIcon());
        loadRatingIcon();
    }

    private void setCompetitiveInfo() {
        competitiveStatsVBox.setAlignment(Pos.TOP_LEFT);
        competitiveStatsVBox.setMaxWidth(640);
        skillRating.setText(String.format("Average SR: %d", player.accessSkillRating()));
        competitiveGamesPlayed.setText(String.format("Played: %d", player.accessTotalCompetitiveGames()));
        competitiveGamesWon.setText(String.format("Won: %d", player.accessTotalCompetitiveWins()));

        quickPlayStatsVBox.setVisible(false);
        competitiveStatsVBox.setVisible(true);
    }

    private void setQuickPlayInfo() {
        quickPlayStatsVBox.setAlignment(Pos.TOP_RIGHT);
        quickPlayStatsVBox.setMaxWidth(1280);
        quickPlayGamesPlayed.setText(String.format("Played: %d", player.accessTotalQuickPlayGames()));
        quickPlayGamesWon.setText(String.format("Won: %d", player.accessTotalQuickPlayWins()));

        competitiveStatsVBox.setVisible(false);
        quickPlayStatsVBox.setVisible(true);
    }
}
