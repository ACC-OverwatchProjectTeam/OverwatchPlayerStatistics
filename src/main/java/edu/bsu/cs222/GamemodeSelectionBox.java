package edu.bsu.cs222;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
        quickPlayButton.setOnAction(event -> gamemodeStatsHBox.setQuickPlayInfo(player));
    }

    public void boxSetup(Player player) {
        this.player = player;
        getChildren().addAll(competitiveButton, quickPlayButton);
        setAlignment(Pos.CENTER);
        setMinWidth(1280);
        setVisible(false);

        competitiveButton.setMinSize(200, 75);
        competitiveButton.setFont(Font.font(20));

        quickPlayButton.setMinSize(200, 75);
        quickPlayButton.setFont(Font.font(20));
    }
}
