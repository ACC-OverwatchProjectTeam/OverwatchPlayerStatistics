package edu.bsu.cs;

import javafx.scene.control.ChoiceBox;

import java.util.List;

public class HeroChoiceBox extends ChoiceBox<String> {
    public final List<Hero> heroList;

    public HeroChoiceBox(List<Hero> heroList) {
        this.heroList = heroList;
        addHeroes();
        getSelectionModel().selectFirst();
    }

    private void addHeroes() {
        for(Hero hero: heroList){
            getItems().add(hero.accessHeroName());
        }
    }
}
