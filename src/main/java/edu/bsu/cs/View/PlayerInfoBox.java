package edu.bsu.cs.View;

import edu.bsu.cs.Model.Player;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerInfoBox extends HBox {
    private Player player;
    private Text playerName;
    private Text playerLevel;

    public PlayerInfoBox() {
        setAlignment(Pos.CENTER);
        setVisible(false);
        ImageView playerIcon = new ImageView();
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

    public void modifyPlayerInfo(Player player) {
        this.player = player;
        playerName.setText(this.player.accessPlayerName());
        playerLevel.setText(String.format(" Lv.%d%d",
                player.accessPrestige(),
                player.accessLevel()));
        getChildren().remove(0);
        getChildren().add(0, loadPlayerIcon());
    }

    public ImageView loadPlayerIcon() {
        Image playerIcon = new Image(player.accessPlayerIcon());
        ImageView playerIconView = new ImageView();
        playerIconView.setImage(playerIcon);
        return playerIconView;
    }
}
