package edu.bsu.cs;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GamemodeStatsHBox extends HBox {
    public final VBox competitiveStatsVBox;
    private final TextField skillRating = new TextField();
    private final TextField competitiveGamesPlayed = new TextField();
    private final TextField competitiveGamesWon = new TextField();
    public final VBox quickPlayStatsVBox;
    private final TextField quickPlayGamesPlayed = new TextField();
    private final TextField quickPlayGamesWon = new TextField();

    public GamemodeStatsHBox() {
        this.competitiveStatsVBox = new VBox();
        this.quickPlayStatsVBox = new VBox();
        getChildren().addAll(competitiveStatsVBox, quickPlayStatsVBox);
        setAlignment(Pos.CENTER);
        setVisible(false);

        competitiveStatsVBox.getChildren().addAll(new ImageView(), skillRating, competitiveGamesPlayed,
                competitiveGamesWon);
        quickPlayStatsVBox.getChildren().addAll(quickPlayGamesPlayed, quickPlayGamesWon);
    }

    private void setupCompetitiveStatsBox(Player player) {
        competitiveStatsVBox.setAlignment(Pos.CENTER);
        competitiveStatsVBox.setVisible(false);

        skillRating.setFont(Font.font(20));
        skillRating.autosize();

        competitiveGamesPlayed.setFont(Font.font(20));
        competitiveGamesPlayed.autosize();

        competitiveGamesWon.setFont(Font.font(20));
        competitiveGamesWon.autosize();
        loadRatingIcon(player);
    }

    private void loadRatingIcon(Player player) {
        Image ratingIcon = new Image(player.accessRatingIcon(), 100, 100, false, false);
        ImageView ratingIconView = new ImageView();
        ratingIconView.setImage(ratingIcon);
        competitiveStatsVBox.getChildren().remove(0);
        competitiveStatsVBox.getChildren().add(0, ratingIconView);
    }

    public void updateCompetitiveInformation(Player player) {
        setupCompetitiveStatsBox(player);
        competitiveStatsVBox.setAlignment(Pos.CENTER);
        competitiveStatsVBox.setMaxWidth(640);
        skillRating.setText(String.format("Average SR: %d", player.accessSkillRating()));
        competitiveGamesPlayed.setText(String.format("Played: %d", player.accessTotalCompetitiveGames()));
        competitiveGamesWon.setText(String.format("Won: %d", player.accessTotalCompetitiveWins()));

        setVisible(true);
        quickPlayStatsVBox.setVisible(false);
        competitiveStatsVBox.setVisible(true);
    }

    private void setupQuickPlayStatsBox() {
        quickPlayStatsVBox.setAlignment(Pos.TOP_RIGHT);
        quickPlayStatsVBox.setVisible(false);

        quickPlayGamesPlayed.setFont(Font.font(20));
        quickPlayGamesPlayed.autosize();

        quickPlayGamesWon.setFont(Font.font(20));
        quickPlayGamesWon.autosize();
    }

    public void setQuickPlayInfo(Player player) {
        setupQuickPlayStatsBox();
        quickPlayStatsVBox.setAlignment(Pos.TOP_RIGHT);
        quickPlayStatsVBox.setMaxWidth(1280);
        quickPlayGamesPlayed.setText(String.format("Played: %d", player.accessTotalQuickPlayGames()));
        quickPlayGamesWon.setText(String.format("Won: %d", player.accessTotalQuickPlayWins()));

        setVisible(true);
        competitiveStatsVBox.setVisible(false);
        quickPlayStatsVBox.setVisible(true);
    }
}
