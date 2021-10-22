package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Parser {
    private final String dataStream;
    private final DataFormatter formatter = new DataFormatter();

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

    public Integer accessSkillRating() {
        JsonPath path = JsonPath.compile("$..rating");
        JSONArray skillRating = path.read(dataStream);
        return formatter.convertStringToInteger(String.valueOf(skillRating.get(0)));
    }

    public String accessRatingIcon() {
        JsonPath path = JsonPath.compile("$..ratingIcon");
        JSONArray ratingIcon = path.read(dataStream);
        return String.valueOf(ratingIcon.get(0));
    }

    public Integer accessLevel() {
        JsonPath path = JsonPath.compile("$..level");
        JSONArray level = path.read(dataStream);
        return formatter.convertStringToInteger(String.valueOf(level.get(0)));
    }

    public Integer accessPrestige() {
        JsonPath path = JsonPath.compile("$..prestige");
        JSONArray prestige = path.read(dataStream);
        return formatter.convertStringToInteger(String.valueOf(prestige.get(0)));
    }

    public Integer accessTotalQuickPlayGames() {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.played");
        JSONArray totalQuickPlayGames = path.read(dataStream);
        return formatter.convertStringToInteger(String.valueOf(totalQuickPlayGames.get(0)));
    }

    public Integer accessTotalQuickPlayWins() {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.won");
        JSONArray totalQuickPlayWins = path.read(dataStream);
        return formatter.convertStringToInteger(String.valueOf(totalQuickPlayWins.get(0)));
    }
}