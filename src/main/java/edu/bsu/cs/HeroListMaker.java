package edu.bsu.cs;

import java.util.ArrayList;
import java.util.List;

public class HeroListMaker {
    private final Parser parser;
    private final List<Hero> competitiveHeroList = new ArrayList<>();
    private final List<Hero> quickPlayHeroList = new ArrayList<>();

    public HeroListMaker(Parser parser){
        this.parser = parser;
        createCompetitiveHeroList();
        createQuickPlayHeroList();
    }

    private void createQuickPlayHeroList() {
        String quickPlayHeroesData = parser.accessTopQuickPlayHeroesData();
        quickPlayHeroesData = quickPlayHeroesData.substring(1, quickPlayHeroesData.length() - 2);

        String[] quickPlayHeroesArray = quickPlayHeroesData.split("},");
        for(String heroData: quickPlayHeroesArray){
            Hero hero = new Hero.Builder().withHeroData(heroData);
            quickPlayHeroList.add(hero);
        }
    }

    public List<Hero> accessQuickPlayHeroList() {
        return List.copyOf(quickPlayHeroList);
    }

    private void createCompetitiveHeroList() {
        String competitiveHeroesData = parser.accessTopCompetitiveHeroesData();
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
