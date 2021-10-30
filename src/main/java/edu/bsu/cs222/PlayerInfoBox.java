package edu.bsu.cs222;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerInfoBox extends HBox {
    private final OverwatchApplication application;
    private Text playerName;
    private Text playerLevel;
    private ImageView playerIcon = new ImageView();

    public PlayerInfoBox(OverwatchApplication application) {
        this.application = application;
        setAlignment(Pos.CENTER);
        setVisible(false);

        getChildren().addAll(playerIcon, createPlayerNameText(), createPlayerLevelText());
    }

    private Text createPlayerNameText() {
        this.playerName = new Text();
        playerName.setFont(Font.font(20));
        playerName.autosize();
        return playerName;
    }

    private Text createPlayerLevelText() {
        this.playerLevel = new Text();
        playerLevel.setFont(Font.font(20));
        playerLevel.autosize();
        return playerLevel;
    }

    public void modifyPlayerInfo() {
        playerName.setText(application.player.accessPlayerName());
        playerLevel.setText(String.format("Lv.%d%d",
                application.player.accessPrestige(),
                application.player.accessLevel()));
        playerIcon = loadPlayerIcon();
    }

    private ImageView loadPlayerIcon() {
        Image playerIcon = new Image(application.player.accessPlayerIcon());
        ImageView playerIconView = new ImageView();
        playerIconView.setImage(playerIcon);
        return playerIconView;
    }
}
