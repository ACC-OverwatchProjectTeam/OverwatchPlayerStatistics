package edu.bsu.cs.View;

import javafx.scene.layout.VBox;

public class ApplicationContainerBox extends VBox {
    private final PlayerInfoBox playerInfoBox;
    private final GamemodeSelectionBox gamemodeSelectionBox;
    private final GamemodeStatsHBox gamemodeStatsHBox;
    private final HeroStatsBox heroStatsBox = new HeroStatsBox();

    public ApplicationContainerBox() {
        this.gamemodeStatsHBox = new GamemodeStatsHBox(heroStatsBox);
        this.gamemodeSelectionBox = new GamemodeSelectionBox(gamemodeStatsHBox);
        this.playerInfoBox = new PlayerInfoBox();
        SearchHBox searchHBox = new SearchHBox(this);
        getChildren().addAll(searchHBox, playerInfoBox, gamemodeSelectionBox, gamemodeStatsHBox, heroStatsBox);
    }

    public PlayerInfoBox accessPlayerInfoBox() {
        return playerInfoBox;
    }

    public GamemodeSelectionBox accessGamemodeSelectionBox() {
        return gamemodeSelectionBox;
    }

    public GamemodeStatsHBox accessGamemodeStatsHBox() {
        return gamemodeStatsHBox;
    }

    public HeroStatsBox accessHeroStatsBox() {
        return heroStatsBox;
    }
}
