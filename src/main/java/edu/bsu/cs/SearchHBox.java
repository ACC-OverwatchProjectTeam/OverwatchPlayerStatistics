package edu.bsu.cs;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URISyntaxException;

public class SearchHBox extends HBox {
    public final TextField textField = createTextField();
    private Player player;
    private String playerData;
    PlayerInfoBox playerInfoBox;
    GamemodeSelectionBox gamemodeSelectionBox;
    GamemodeStatsHBox gamemodeStatsHBox;

    public SearchHBox(Player player, String playerData, PlayerInfoBox playerInfoBox, GamemodeSelectionBox gamemodeSelectionBox, GamemodeStatsHBox gamemodeStatsHBox) {
        this.player = player;
        this.playerData = playerData;
        this.gamemodeStatsHBox = gamemodeStatsHBox;
        this.gamemodeSelectionBox = gamemodeSelectionBox;
        this.playerInfoBox = playerInfoBox;
        setAlignment(Pos.CENTER);
        getChildren().addAll(new HBox(textField, createSearchButton()));

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
            if (playerData != null){
                setBoxesInvisible();
            }
        }

        private void setPlayerData(){
            SearchQuery searchQuery = new SearchQuery();
            String playerBattleTag = searchHBox.textField.getText();
            try {
                playerData = searchQuery.createURLFromSearchQuery(playerBattleTag);
            } catch (URISyntaxException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }

        private void setPlayer(){
            player = new Player.Builder().parserSetup(playerData)
                    .withPlayerData()
                    .withPlayerRatingInfo()
                    .withPlayerLevel()
                    .withCompetitiveGameData()
                    .withQuickPlayGameData();
        }

        private void callSetBasicPlayerInfo(){
            playerInfoBox.modifyPlayerInfo(player);
            gamemodeSelectionBox.boxSetup(player);
        }

        private void setBoxesVisible() {
            searchHBox.playerInfoBox.setVisible(true);
            gamemodeSelectionBox.setVisible(true);
        }

        private void setBoxesInvisible() {
            gamemodeStatsHBox.competitiveStatsVBox.setVisible(false);
            gamemodeStatsHBox.quickPlayStatsVBox.setVisible(false);
            gamemodeSelectionBox.setVisible(false);
            searchHBox.playerInfoBox.setVisible(false);
        }
    }
}