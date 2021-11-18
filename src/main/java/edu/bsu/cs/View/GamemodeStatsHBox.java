package edu.bsu.cs.View;

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
    private final TextField skillRating = new TextField();
    private final TextField competitiveGamesPlayed = new TextField();
    private final TextField competitiveGamesWon = new TextField();
    public final VBox quickPlayStatsVBox = new VBox();
    private final TextField quickPlayGamesPlayed = new TextField();
    private final TextField quickPlayGamesWon = new TextField();
    private final HeroStatsBox heroBox;

    public GamemodeStatsHBox(HeroStatsBox heroBox) {
        this.heroBox = heroBox;
        getChildren().addAll(competitiveStatsVBox, quickPlayStatsVBox);
        setAlignment(Pos.CENTER);
        competitiveStatsVBox.setMaxWidth(640);
        quickPlayStatsVBox.setMaxWidth(1280);
        setVisible(false);
    }


    private void setupCompetitiveStatsBox(Player player) {
        competitiveStatsVBox.getChildren().clear();
        competitiveStatsVBox.getChildren().addAll(new ImageView(), skillRating, competitiveGamesPlayed,
            competitiveGamesWon);
        competitiveStatsVBox.setAlignment(Pos.CENTER);

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

        skillRating.setText(String.format("Average SR: %d", player.accessSkillRating()));
        competitiveGamesPlayed.setText(String.format("Played: %d", player.accessTotalCompetitiveGames()));
        competitiveGamesWon.setText(String.format("Won: %d", player.accessTotalCompetitiveWins()));

        addCompetitiveHeroSelection(player);

        setVisible(true);
        quickPlayStatsVBox.setVisible(false);
        competitiveStatsVBox.setVisible(true);
    }

    private void addCompetitiveHeroSelection(Player player) {
        HeroChoiceBox competitiveHeroSelection = new HeroChoiceBox(player.accessCompetitiveHeroes());
        competitiveHeroSelection.setMaxWidth(640);
        competitiveHeroSelection.setOnAction(event ->
                heroBox.updateHeroInfo(competitiveHeroSelection.getSelectionModel().getSelectedIndex(),
                        player.accessCompetitiveHeroes()));
        competitiveStatsVBox.getChildren().add(competitiveHeroSelection);
    }

    private void setupQuickPlayStatsBox() {
        quickPlayStatsVBox.setMaxWidth(1280);
        quickPlayStatsVBox.getChildren().clear();
        quickPlayStatsVBox.getChildren().addAll(quickPlayGamesPlayed, quickPlayGamesWon);
        quickPlayStatsVBox.setAlignment(Pos.CENTER);


        quickPlayGamesPlayed.setFont(Font.font(20));
        quickPlayGamesPlayed.autosize();

        quickPlayGamesWon.setFont(Font.font(20));
        quickPlayGamesWon.autosize();
    }

    public void updateQuickPlayInfo(Player player) {
        setupQuickPlayStatsBox();

        quickPlayGamesPlayed.setText(String.format("Played: %d", player.accessTotalQuickPlayGames()));
        quickPlayGamesWon.setText(String.format("Won: %d", player.accessTotalQuickPlayWins()));

        addQuickPlayHeroSelection(player);

        setVisible(true);
        competitiveStatsVBox.setVisible(false);
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
