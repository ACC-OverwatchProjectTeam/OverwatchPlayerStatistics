package edu.bsu.cs222;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URISyntaxException;

public class SearchHBox extends HBox {
    public final TextField textField = createTextField();
    OverwatchApplication application;
    PlayerInfoBox playerInfoBox;

    public SearchHBox(OverwatchApplication application, PlayerInfoBox playerInfoBox) {
        this.application = application;
        setAlignment(Pos.CENTER);
        getChildren().addAll(new HBox(textField, createSearchButton()));
        this.playerInfoBox = playerInfoBox;
    }

    private Button createSearchButton() {
        InitializeApplicationTask initializeTask = new InitializeApplicationTask();
        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> initializeTask.run());
        searchButton.setFont(Font.font(20));
        return searchButton;
    }

    private TextField createTextField() {
        TextField textField = new TextField("Enter your exact BattleTag");
        textField.setFont(Font.font(20));
        return textField;
    }

    private final class InitializeApplicationTask implements Runnable {
        SearchHBox searchHBox = SearchHBox.this;

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
            String playerBattleTag = searchHBox.textField.getText();
            try {
                application.playerData = searchQuery.createURLFromSearchQuery(playerBattleTag);
            } catch (URISyntaxException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }

        private void setPlayer(){
            application.player = new Player.Builder().parserSetup(application.playerData)
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
            application.competitiveStatsVBox.getChildren().remove(0);
        }

        private void setBoxesVisible() {
            searchHBox.playerInfoBox.setVisible(true);
            application.gamemodeSelectionBox.setVisible(true);
        }

        private void setBoxesInvisible() {
            application.competitiveStatsVBox.setVisible(false);
            application.quickPlayStatsVBox.setVisible(false);
            application.gamemodeSelectionBox.setVisible(false);
            searchHBox.playerInfoBox.setVisible(false);
        }
    }
}
