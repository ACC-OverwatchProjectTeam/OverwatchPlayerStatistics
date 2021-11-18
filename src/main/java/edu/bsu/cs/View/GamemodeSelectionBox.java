package edu.bsu.cs.View;

import edu.bsu.cs.Model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class GamemodeSelectionBox extends HBox {
    private final Button competitiveButton;
    private final Button quickPlayButton;
    private Player player;

    public GamemodeSelectionBox(GamemodeStatsHBox gamemodeStatsHBox) {
        this.competitiveButton = new Button("Competitive Stats");
        this.quickPlayButton = new Button("QuickPlay Stats");
        competitiveButton.setOnAction(event -> gamemodeStatsHBox.updateCompetitiveInformation(player));
        quickPlayButton.setOnAction(event -> gamemodeStatsHBox.updateQuickPlayInfo(player));
    }

    public void boxSetup(Player player) {
        this.player = player;
        getChildren().clear();
        addElements();
        setAlignment(Pos.CENTER);
        setMinWidth(1280);
        setVisible(false);

        competitiveButton.setMinSize(200, 75);
        competitiveButton.setFont(Font.font(20));

        quickPlayButton.setMinSize(200, 75);
        quickPlayButton.setFont(Font.font(20));
    }

    private void addElements() {
        if (player.accessPrivacySetting()) {
            getChildren().add(createProfileStatusLabel());
        }else {
            getChildren().addAll(competitiveButton, quickPlayButton);
        }
    }

    private Label createProfileStatusLabel() {
        Label privateProfileLabel = new Label("This profile is private. No further data can be found...");
        privateProfileLabel.setFont(Font.font(20));
        return privateProfileLabel;
    }
}
