package edu.bsu.cs.View;

import edu.bsu.cs.Model.Hero;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

public class HeroChoiceBox extends ChoiceBox<String> {
    public final List<Hero> heroList;

    public HeroChoiceBox(List<Hero> heroList) {
        this.heroList = heroList;
        addHeroes();
        addBorder();
        getSelectionModel().selectFirst();
    }

    private void addBorder() {
        Border border = new Border((new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(2))));
        setBorder(border);
    }

    private void addHeroes() {
        for(Hero hero: heroList){
            String heroName = hero.accessHeroName().trim();
            heroName = heroName.substring(0, 1).toUpperCase() + heroName.substring(1);
            getItems().add(heroName);
        }
    }
}
