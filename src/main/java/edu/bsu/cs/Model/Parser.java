package edu.bsu.cs.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Parser {
    private final String heroData;

    public Parser(String heroData){
        this.heroData = heroData;
    }

    public String accessUsername() {
        JsonPath path = JsonPath.compile("$..name");
        JSONArray playerName = path.read(heroData);
        return playerName.get(0).toString();
    }

    public boolean accessPrivateStatus() {
        JsonPath path = JsonPath.compile("$..private");
        JSONArray privateStatus = path.read(heroData);
        return Boolean.parseBoolean(privateStatus.get(0).toString());
    }

    public String accessPlayerIcon() {
        JsonPath path = JsonPath.compile("$..icon");
        JSONArray playerIcon = path.read(heroData);
        return String.valueOf(playerIcon.get(0));
    }

    public int accessSkillRating() {
        JsonPath path = JsonPath.compile("$..rating");
        JSONArray skillRating = path.read(heroData);
        return Integer.parseInt(String.valueOf(skillRating.get(0)));
    }

    public String accessRatingIcon() {
        JsonPath path = JsonPath.compile("$..ratingIcon");
        JSONArray ratingIcon = path.read(heroData);
        return String.valueOf(ratingIcon.get(0));
    }

    public int accessLevel() {
        JsonPath path = JsonPath.compile("$..level");
        JSONArray level = path.read(heroData);
        return Integer.parseInt(String.valueOf(level.get(0)));
    }

    public int accessPrestige() {
        JsonPath path = JsonPath.compile("$..prestige");
        JSONArray prestige = path.read(heroData);
        return Integer.parseInt(String.valueOf(prestige.get(0)));
    }

    public int accessTotalQuickPlayGames() {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.played");
        JSONArray totalQuickPlayGames = path.read(heroData);
        return Integer.parseInt(String.valueOf(totalQuickPlayGames.get(0)));
    }

    public int accessTotalQuickPlayWins() {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.won");
        JSONArray totalQuickPlayWins = path.read(heroData);
        return Integer.parseInt(String.valueOf(totalQuickPlayWins.get(0)));
    }

    public int accessTotalCompetitiveGames() {
        JsonPath path = JsonPath.compile("$..competitiveStats.games.played");
        JSONArray totalCompetitiveGames = path.read(heroData);
        return Integer.parseInt(String.valueOf(totalCompetitiveGames.get(0)));
    }

    public int accessTotalCompetitiveWins() {
        JsonPath path = JsonPath.compile("$..competitiveStats.games.won");
        JSONArray totalCompetitiveWins = path.read(heroData);
        return Integer.parseInt(String.valueOf(totalCompetitiveWins.get(0)));
    }

    public String accessTopCompetitiveHeroesData() {
        JsonPath path = JsonPath.compile("$..competitiveStats.careerStats");
        JSONArray topCompetitiveHeroesData = path.read(heroData);
        return String.valueOf(topCompetitiveHeroesData.get(0));
    }

    public String accessTopQuickPlayHeroesData() {
        JsonPath path = JsonPath.compile("$..quickPlayStats.careerStats");
        JSONArray topQuickPlayHeroesData = path.read(heroData);
        return String.valueOf(topQuickPlayHeroesData.get(0));
    }

    public JSONArray accessRoleRating() {
        JsonPath path = JsonPath.compile("$..ratings..level");
        return path.read(heroData);
    }
}