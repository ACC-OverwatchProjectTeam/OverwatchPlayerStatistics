package edu.bsu.cs.View;

import edu.bsu.cs.Model.DataFormatter;
import edu.bsu.cs.Model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GamemodeStatsHBox extends HBox {
    public final VBox competitiveStatsVBox = new VBox();
    private final TextField averageRank = new TextField();
    private final TextField specificRanks = new TextField();
    private final TextField competitiveGamesPlayed = new TextField();
    private final TextField competitiveGamesWon = new TextField();
    public final VBox quickPlayStatsVBox = new VBox();
    private final TextField quickPlayGamesPlayed = new TextField();
    private final TextField quickPlayGamesWon = new TextField();
    private final HeroStatsBox heroBox;
    private final Font font = new Font(20);

    public GamemodeStatsHBox(HeroStatsBox heroBox) {
        this.heroBox = heroBox;
        setAlignment(Pos.CENTER);
        setVisible(false);
    }


    private void setupCompetitiveStatsBox(Player player) {
        getChildren().clear();
        competitiveStatsVBox.getChildren().clear();
        competitiveStatsVBox.getChildren().addAll(new ImageView(), averageRank, specificRanks, competitiveGamesPlayed,
            competitiveGamesWon);
        competitiveStatsVBox.setAlignment(Pos.CENTER);

        averageRank.setFont(font);
        averageRank.setAlignment(Pos.CENTER);

        specificRanks.setFont(font);
        specificRanks.setMinWidth(500);
        specificRanks.setAlignment(Pos.CENTER);

        competitiveGamesPlayed.setFont(font);
        competitiveGamesPlayed.setAlignment(Pos.CENTER);

        competitiveGamesWon.setFont(font);
        competitiveGamesWon.setAlignment(Pos.CENTER);
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
        getChildren().add(competitiveStatsVBox);

        DataFormatter dataFormatter = new DataFormatter();
        averageRank.setText(String.format("Average Rank: %s", dataFormatter.formatSkillRatingAsRankName(player.accessSkillRating())));
        averageRank.setEditable(false);
        specificRanks.setText(String.format("Tank SR: %d  Damage SR: %d  Support SR: %d",
                player.accessRatingList().get(0), player.accessRatingList().get(1),
                player.accessRatingList().get(2)));
        specificRanks.setEditable(false);
        competitiveGamesPlayed.setText(String.format("Played: %d", player.accessTotalCompetitiveGames()));
        competitiveGamesPlayed.setEditable(false);
        competitiveGamesWon.setText(String.format("Won: %d", player.accessTotalCompetitiveWins()));
        competitiveGamesWon.setEditable(false);

        addCompetitiveHeroSelection(player);

        setVisible(true);
        competitiveStatsVBox.setVisible(true);
    }

    private void addCompetitiveHeroSelection(Player player) {
        HeroChoiceBox competitiveHeroSelection = new HeroChoiceBox(player.accessCompetitiveHeroes());
        competitiveHeroSelection.setMaxWidth(1280);
        competitiveHeroSelection.setOnAction(event ->
                heroBox.updateHeroInfo(competitiveHeroSelection.getSelectionModel().getSelectedIndex(),
                        player.accessCompetitiveHeroes()));
        competitiveStatsVBox.getChildren().add(competitiveHeroSelection);
    }

    private void setupQuickPlayStatsBox() {
        getChildren().clear();
        quickPlayStatsVBox.setMinWidth(500);
        quickPlayStatsVBox.getChildren().clear();
        quickPlayStatsVBox.getChildren().addAll(quickPlayGamesPlayed, quickPlayGamesWon);

        quickPlayGamesPlayed.setFont(font);
        quickPlayGamesPlayed.setAlignment(Pos.CENTER);
        quickPlayGamesWon.setFont(font);
        quickPlayGamesWon.setAlignment(Pos.CENTER);
    }

    public void updateQuickPlayInfo(Player player) {
        setupQuickPlayStatsBox();
        getChildren().add(quickPlayStatsVBox);

        quickPlayGamesPlayed.setText(String.format("Played: %d", player.accessTotalQuickPlayGames()));
        quickPlayGamesPlayed.setEditable(false);
        quickPlayGamesWon.setText(String.format("Won: %d", player.accessTotalQuickPlayWins()));
        quickPlayGamesWon.setEditable(false);

        addQuickPlayHeroSelection(player);

        setVisible(true);
        quickPlayStatsVBox.setVisible(true);
    }

    private void addQuickPlayHeroSelection(Player player) {
        HeroChoiceBox quickPlayHeroSelection = new HeroChoiceBox(player.accessQuickPlayHeroes());
        quickPlayHeroSelection.setMaxWidth(1280);
        quickPlayHeroSelection.setOnAction(event ->
                heroBox.updateHeroInfo(quickPlayHeroSelection.getSelectionModel().getSelectedIndex(),
                        player.accessQuickPlayHeroes()));
        quickPlayStatsVBox.getChildren().add(quickPlayHeroSelection);
    }
}
