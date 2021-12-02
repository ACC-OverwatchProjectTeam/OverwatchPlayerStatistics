package edu.bsu.cs.Model;

import java.util.ArrayList;
import java.util.List;

public class HeroListFactory {
    private final List<Hero> competitiveHeroList;
    private final List<Hero> quickPlayHeroList;

    public HeroListFactory(Parser parser){
        parser.accessTopCompetitiveHeroesData();
        this.competitiveHeroList = new ArrayList<>(createHeroList(parser.accessTopCompetitiveHeroesData()));
        this.quickPlayHeroList = new ArrayList<>(createHeroList(parser.accessTopQuickPlayHeroesData()));
    }

    private List<Hero> createHeroList(String heroesData) {
        heroesData = heroesData.substring(1, heroesData.length() - 2);
        List<String> heroDataList = new ArrayList<>(List.of(heroesData.split("},")));

        List<Hero> heroList = new ArrayList<>();
        for(String heroData: heroDataList){
            Hero hero = new Hero.Builder().withHeroData(heroData);
            heroList.add(hero);
        }
        return heroList;
    }

    public List<Hero> accessQuickPlayHeroList() {
        return List.copyOf(quickPlayHeroList);
    }

    public List<Hero> accessCompetitiveHeroList() {
        return List.copyOf(competitiveHeroList);
    }
}
