package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Parser {
    private final String dataStream;

    public Parser(String dataStream){
        this.dataStream = dataStream;
    }

    public String accessUsername() {
        JsonPath path = JsonPath.compile("$..name");
        JSONArray playerName = path.read(dataStream);
        return playerName.get(0).toString();
    }

    public String accessPlayerIcon() {
        JsonPath path = JsonPath.compile("$..icon");
        JSONArray playerIcon = path.read(dataStream);
        return String.valueOf(playerIcon.get(0));
    }

    public int accessSkillRating() {
        JsonPath path = JsonPath.compile("$..rating");
        JSONArray skillRating = path.read(dataStream);
        return Integer.parseInt(String.valueOf(skillRating.get(0)));
    }

    public String accessRatingIcon() {
        JsonPath path = JsonPath.compile("$..ratingIcon");
        JSONArray ratingIcon = path.read(dataStream);
        return String.valueOf(ratingIcon.get(0));
    }

    public int accessLevel() {
        JsonPath path = JsonPath.compile("$..level");
        JSONArray level = path.read(dataStream);
        return Integer.parseInt(String.valueOf(level.get(0)));
    }

    public int accessPrestige() {
        JsonPath path = JsonPath.compile("$..prestige");
        JSONArray prestige = path.read(dataStream);
        return Integer.parseInt(String.valueOf(prestige.get(0)));
    }

    public int accessTotalQuickPlayGames() {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.played");
        JSONArray totalQuickPlayGames = path.read(dataStream);
        return Integer.parseInt(String.valueOf(totalQuickPlayGames.get(0)));
    }

    public int accessTotalQuickPlayWins() {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.won");
        JSONArray totalQuickPlayWins = path.read(dataStream);
        return Integer.parseInt(String.valueOf(totalQuickPlayWins.get(0)));
    }

    public int accessTotalCompetitiveGames() {
        JsonPath path = JsonPath.compile("$..competitiveStats.games.played");
        JSONArray totalCompetitiveGames = path.read(dataStream);
        return Integer.parseInt(String.valueOf(totalCompetitiveGames.get(0)));
    }

    public int accessTotalCompetitiveWins() {
        JsonPath path = JsonPath.compile("$..competitiveStats.games.won");
        JSONArray totalCompetitiveWins = path.read(dataStream);
        return Integer.parseInt(String.valueOf(totalCompetitiveWins.get(0)));
    }

    public String accessAsheCriticalHitsAccuracy() {
        JsonPath path = JsonPath.compile("$..competitiveStats.careerStats.ashe.combat.criticalHitsAccuracy");
        JSONArray asheCriticalHitsAccuracy = path.read(dataStream);
        return String.valueOf(asheCriticalHitsAccuracy.get(0));
    }

    public String accessAsheWeaponAccuracy() {
        JsonPath path = JsonPath.compile("$..competitiveStats.careerStats.ashe.combat.weaponAccuracy");
        JSONArray asheWeaponAccuracy = path.read(dataStream);
        return String.valueOf(asheWeaponAccuracy.get(0));
    }

    public String accessAsheScopedAccuracy() {
        JsonPath path = JsonPath.compile("$..competitiveStats.careerStats.ashe.heroSpecific.scopedAccuracy");
        JSONArray asheScopedAccuracy = path.read(dataStream);
        return String.valueOf(asheScopedAccuracy.get(0));
    }

    public String accessAsheScopedCriticalHitsAccuracy() {
        JsonPath path = JsonPath.compile("$..competitiveStats.careerStats.cassidy.heroSpecific.scopedCriticalHitsAccuracy");
        JSONArray asheScopedCriticalHitsAccuracy = path.read(dataStream);
        return String.valueOf(asheScopedCriticalHitsAccuracy.get(0));
    }

    public String accessCassidyCriticalHitsAccuracy() {
        JsonPath path = JsonPath.compile("$..competitiveStats.careerStats.cassidy.combat.criticalHitsAccuracy");
        JSONArray cassidyCriticalHitsAccuracy = path.read(dataStream);
        return String.valueOf(cassidyCriticalHitsAccuracy.get(0));
    }

    public String accessCassidyWeaponAccuracy() {
        JsonPath path = JsonPath.compile("$..competitiveStats.careerStats.ashe.combat.weaponAccuracy");
        JSONArray cassidyWeaponAccuracy = path.read(dataStream);
        return String.valueOf(cassidyWeaponAccuracy.get(0));
    }

}