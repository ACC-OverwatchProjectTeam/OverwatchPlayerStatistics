package edu.bsu.cs.View;

import edu.bsu.cs.Model.Hero;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;

public class HeroStatsBox extends VBox {
    private final Label heroName = new Label("");
    private final Label weaponAccuracy = new Label("");
    private final Text criticalHitsAccuracy = new Text("");
    private final Text scopedAccuracy = new Text("");
    private final Text eliminationsPerLife = new Text("");
    private final Label winPercentage = new Label("");
    private final Label gamesWon = new Label("");
    private final Text timePlayed = new Text("");
    private final Font font = new Font(20);

    public HeroStatsBox() {
        setAlignment(Pos.CENTER);
        getChildren().addAll(heroName, weaponAccuracy, criticalHitsAccuracy, scopedAccuracy,
                winPercentage, gamesWon, eliminationsPerLife, timePlayed);
    }

    public void updateHeroInfo(int index, List<Hero> heroList) {
        setVisible(true);
        heroName.setText(reformatText(heroList.get(index).accessHeroName()));
        heroName.setFont(font);
        weaponAccuracy.setText(reformatText(heroList.get(index).accessWeaponAccuracy()));
        weaponAccuracy.setFont(font);
        winPercentage.setText(reformatText(heroList.get(index).accessWinPercentage()));
        winPercentage.setFont(font);
        gamesWon.setText(reformatText(heroList.get(index).accessGamesWon()));
        gamesWon.setFont(font);
        criticalHitsAccuracy.setText(reformatText(heroList.get(index).accessCriticalHitAccuracy()));
        criticalHitsAccuracy.setFont(font);
        scopedAccuracy.setText(reformatText(heroList.get(index).accessScopedAccuracy()));
        scopedAccuracy.setFont(font);
        timePlayed.setText(reformatText(heroList.get(index).accessTimePlayed()));
        timePlayed.setFont(font);
        eliminationsPerLife.setText(reformatText(heroList.get(index).accessEliminationsPerLife()));
        eliminationsPerLife.setFont(font);
    }

    private String reformatText(String text) {
        String reformattedText = text.replace("=", " = ").trim();
        reformattedText = reformattedText.substring(0,1).toUpperCase() + reformattedText.substring(1);
        return reformattedText;
    }
}
