package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class HeroListMaker {
    private final Parser parser;
    private final List<Hero> competitiveHeroList = new ArrayList<>();

    public HeroListMaker(Parser parser){
        this.parser = parser;
        createCompetitiveHeroesList();
    }

    private void createCompetitiveHeroesList() {
        String competitiveHeroesData = parser.accessTopCompetitiveHeroes();
        competitiveHeroesData = competitiveHeroesData.substring(1, competitiveHeroesData.length() - 2);

        String[] competitiveHeroesArray = competitiveHeroesData.split("},");
        for(String heroData: competitiveHeroesArray){
            Hero hero = new Hero.Builder().withHeroData(heroData);
            competitiveHeroList.add(hero);
        }
    }

    public List<Hero> accessCompetitiveHeroList() {
        return List.copyOf(competitiveHeroList);
    }
}
