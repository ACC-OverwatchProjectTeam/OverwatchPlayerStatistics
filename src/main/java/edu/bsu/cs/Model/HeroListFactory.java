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

        int firstMiscellaneousIndex = heroesData.indexOf("miscellaneous");
        heroesData = heroesData.substring(heroesData.indexOf("}, ", firstMiscellaneousIndex) + 2,
                heroesData.length() - 1);

        List<String> heroDataList = new ArrayList<>(List.of(heroesData.split("miscellaneous")));
        heroDataList.remove(heroDataList.size() - 1);

        List<Hero> heroList = new ArrayList<>();
        for(String heroData: heroDataList){
            heroData = heroData.substring(heroData.indexOf(" "), heroData.length() - 2);

            if (heroData.indexOf("turretsDestroyed") < 20) {
                heroData = heroData.substring(heroData.indexOf("}}") + 1, heroData.length() - 1);
            }

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
