package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class OverwatchApplication extends Application {
    private final Runnable initializePlayerTask = new OverwatchApplication.InitializePlayerTask();
    private final TextField searchInputField;
    private final Button searchButton;
    public HBox searchHBox = new HBox();
    public String playerData;
    public Player player;


    public OverwatchApplication(){
        searchInputField = new TextField("Enter your exact BattleTag");
        searchButton = new Button("Search");
        searchButton.setOnAction(event -> initializePlayerTask.run());
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
        searchHBox.getChildren().add(searchInputField);
        searchHBox.getChildren().add(searchButton);
        searchHBox.setAlignment(Pos.TOP_CENTER);
        return searchHBox;
    }

    public ImageView loadPlayerIcon(){
        Image playerIcon = new Image(player.accessPlayerIcon());
        ImageView playerIconView = new ImageView();
        playerIconView.setImage(playerIcon);
        return playerIconView;
    }

    public ImageView loadRatingIcon(){
        Image ratingIcon = new Image(player.accessRatingIcon());
        ImageView ratingIconView = new ImageView();
        ratingIconView.setImage(ratingIcon);
        return ratingIconView;
    }

    private final class InitializePlayerTask implements Runnable {
        private final OverwatchApplication application = OverwatchApplication.this;

        @Override
        public void run() {
            setPlayerData();
            setPlayer();
            addPlayerIconToGUI();
            addRankingIconToGUI();
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

        private void addPlayerIconToGUI(){
            application.searchHBox.getChildren()
                    .add(application.loadPlayerIcon());
        }

        private void addRankingIconToGUI(){
            application.searchHBox.getChildren()
                    .add(application.loadRatingIcon());
        }
    }
}
