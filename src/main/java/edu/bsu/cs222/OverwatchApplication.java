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

import java.io.IOException;
import java.net.URISyntaxException;

public class OverwatchApplication extends Application {
    private final Runnable initializeApplicationTask = new InitializeApplicationTask();
    private final VBox applicationContainerBox = new VBox();
    private final HBox searchHBox = new HBox();
    private final TextField searchInputField = new TextField("Enter your exact BattleTag");
    private final Button searchButton = new Button("Search");
    private final HBox playerInfoBox = new HBox();
    private final TextField playerName = new TextField();
    private final TextField playerLevel = new TextField();
    private final ImageView playerIconView = new ImageView();
    private final HBox gamemodeSelectionBox = new HBox();
    private final Button competitiveButton = new Button("Competitive Stats");
    private final VBox competitiveStatsVBox = new VBox();
    private final ImageView ratingIconView = new ImageView();
    private final TextField skillRating = new TextField();
    private final TextField competitiveGamesPlayed = new TextField();
    private final TextField competitiveGamesWon = new TextField();
    private final Button quickPlayButton = new Button("QuickPlay Stats");
    private final VBox quickPlayStatsVBox = new VBox();
    private final TextField quickPlayGamesPlayed = new TextField();
    private final TextField quickPlayGamesWon = new TextField();
    private String playerData;
    private Player player;


    public OverwatchApplication(){
        searchButton.setOnAction(event -> initializeApplicationTask.run());
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
        setupSearchHBox();
        setupPlayerInfoBox();
        setupGamemodeSelectionBox();
        setupCompetitiveStatsBox();
        setupQuickPlayStatsBox();

        applicationContainerBox.getChildren().addAll(searchHBox, playerInfoBox, gamemodeSelectionBox,
                new HBox(competitiveStatsVBox, quickPlayStatsVBox));
        int sceneWidth = 1280;
        int sceneHeight = 720;
        return new Scene(applicationContainerBox,sceneWidth,sceneHeight);
    }

    private void setupSearchHBox() {
        searchHBox.getChildren().addAll(searchInputField, searchButton);
        searchHBox.setAlignment(Pos.TOP_CENTER);
        searchHBox.setMaxHeight(75);

        searchInputField.setMinHeight(75);
        searchInputField.setMinWidth(400);
        searchInputField.setFont(Font.font(30));

        searchButton.setMinHeight(75);
        searchButton.setMinWidth(200);
        searchButton.setFont(Font.font(30));
    }

    private void setupPlayerInfoBox() {
        playerInfoBox.getChildren().addAll(playerIconView, playerName, playerLevel);
        playerInfoBox.setAlignment(Pos.CENTER);
        playerInfoBox.setVisible(false);

        playerName.setMinSize(400,75);
        playerName.setFont(Font.font(30));

        playerLevel.setFont(Font.font(30));
        playerLevel.autosize();
    }

    private void setupGamemodeSelectionBox() {
        gamemodeSelectionBox.getChildren().addAll(competitiveButton,quickPlayButton);
        gamemodeSelectionBox.setAlignment(Pos.CENTER);
        gamemodeSelectionBox.setMinWidth(1280);
        gamemodeSelectionBox.setVisible(false);

        competitiveButton.setMinSize(200, 75);
        competitiveButton.setFont(Font.font(30));

        quickPlayButton.setMinSize(200, 75);
        quickPlayButton.setFont(Font.font(30));
    }

    private void setupCompetitiveStatsBox() {
        competitiveStatsVBox.getChildren().addAll(ratingIconView, skillRating, competitiveGamesPlayed,
                competitiveGamesWon);
        competitiveStatsVBox.setAlignment(Pos.TOP_CENTER);
        competitiveStatsVBox.setVisible(false);

        skillRating.setFont(Font.font(30));
        skillRating.autosize();

        competitiveGamesPlayed.setFont(Font.font(30));
        competitiveGamesPlayed.autosize();

        competitiveGamesWon.setFont(Font.font(30));
        competitiveGamesWon.autosize();
    }

    private void setupQuickPlayStatsBox() {
        quickPlayStatsVBox.getChildren().addAll(quickPlayGamesPlayed, quickPlayGamesWon);
        quickPlayStatsVBox.setAlignment(Pos.TOP_RIGHT);
        quickPlayStatsVBox.setVisible(false);

        quickPlayGamesPlayed.setFont(Font.font(30));
        quickPlayGamesPlayed.autosize();

        quickPlayGamesWon.setFont(Font.font(30));
        quickPlayGamesWon.autosize();
    }

    private ImageView loadPlayerIcon(){
        Image playerIcon = new Image(player.accessPlayerIcon());
        ImageView playerIconView = new ImageView();
        playerIconView.setImage(playerIcon);
        return playerIconView;
    }

    private void loadRatingIcon() {
        Image ratingIcon = new Image(player.accessRatingIcon());
        ImageView ratingIconView = new ImageView();
        ratingIconView.setImage(ratingIcon);
        competitiveStatsVBox.getChildren().add(0,ratingIconView);
    }

    private void setBasicPlayerInfo() {
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

    private final class InitializeApplicationTask implements Runnable {
        private final OverwatchApplication application = OverwatchApplication.this;

        @Override
        public void run() {
            checkPlayerDataNotNull();
            setPlayerData();
            setPlayer();
            callSetBasicPlayerInfo();
            setBoxesVisible();

        }

        private void checkPlayerDataNotNull() {
            if (application.playerData != null){
                removeIconChildren();
                setBoxesInvisible();
            }
        }

        private void setPlayerData(){
            SearchQuery searchQuery = new SearchQuery();
            String playerBattleTag = searchInputField.getText();
            try {
                application.playerData = searchQuery.createURLFromSearchQuery(playerBattleTag);
            } catch (URISyntaxException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }

        private void setPlayer(){
            application.player = new Player.Builder().parserSetup(playerData)
                    .withPlayerData()
                    .withPlayerRatingInfo()
                    .withPlayerLevel()
                    .withCompetitiveGameData()
                    .withQuickPlayGameData();
        }

        private void callSetBasicPlayerInfo(){
            application.setBasicPlayerInfo();
        }

        private void removeIconChildren(){
            application.playerInfoBox.getChildren().remove(0);
            application.competitiveStatsVBox.getChildren().remove(0);
            application.searchHBox.getChildren().remove(1,2);

        }

        private void setBoxesVisible() {
            application.playerInfoBox.setVisible(true);
            application.gamemodeSelectionBox.setVisible(true);
        }

        private void setBoxesInvisible() {
            application.competitiveStatsVBox.setVisible(false);
            application.quickPlayStatsVBox.setVisible(false);
            application.gamemodeSelectionBox.setVisible(false);
            application.playerInfoBox.setVisible(false);
        }
    }
}
