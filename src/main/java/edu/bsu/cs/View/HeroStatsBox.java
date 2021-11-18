package edu.bsu.cs.View;

import edu.bsu.cs.Model.Hero;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;

public class HeroStatsBox extends VBox {
    private final Label heroName = new Label("");
    private final Label weaponAccuracy = new Label("");
    private final Label winPercentage = new Label("");
    private final Label gamesWon = new Label("");
    private final Text eliminationsPerLife = new Text("");

    public HeroStatsBox() {
        setAlignment(Pos.CENTER);
        getChildren().addAll(heroName, weaponAccuracy, winPercentage, gamesWon, eliminationsPerLife);
    }

    public void updateHeroInfo(int index, List<Hero> heroList) {
        setVisible(true);
        heroName.setText(heroList.get(index).accessHeroName());
        heroName.setFont(Font.font(20));
        weaponAccuracy.setText(heroList.get(index).accessWeaponAccuracy());
        weaponAccuracy.setFont(Font.font(20));
        winPercentage.setText(heroList.get(index).accessWinPercentage());
        winPercentage.setFont(Font.font(20));
        gamesWon.setText(heroList.get(index).accessGamesWon());
        gamesWon.setFont(Font.font(20));
        eliminationsPerLife.setText(heroList.get(index).accessEliminationsPerLife());
        eliminationsPerLife.setFont(Font.font(20));
    }
}
