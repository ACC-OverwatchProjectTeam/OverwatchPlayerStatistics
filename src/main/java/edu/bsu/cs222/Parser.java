package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Parser {
    public String accessUsername(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..name");
        JSONArray playerName = path.read(profileDataStream);
        return playerName.get(0).toString();
    }

    public String accessPlayerIcon(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..icon");
        JSONArray playerIcon = path.read(profileDataStream);
        return String.valueOf(playerIcon.get(0));
    }

    public String accessSkillRating(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..rating");
        JSONArray skillRating = path.read(profileDataStream);
        return String.valueOf(skillRating.get(0));
    }

    public String accessRatingIcon(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..ratingIcon");
        JSONArray ratingIcon = path.read(profileDataStream);
        return String.valueOf(ratingIcon.get(0));
    }

    public String accessLevel(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..level");
        JSONArray level = path.read(profileDataStream);
        return String.valueOf(level.get(0));
    }

    public String accessPrestige(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..prestige");
        JSONArray prestige = path.read(profileDataStream);
        return String.valueOf(prestige.get(0));
    }


    public String accessTotalQuickPlayGames(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.played");
        JSONArray totalQuickPlayGames = path.read(profileDataStream);
        return String.valueOf(totalQuickPlayGames.get(0));
    }

    public String accessTotalQuickPlayWins(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..quickPlayStats.games.won");
        JSONArray totalQuickPlayWins = path.read(profileDataStream);
        return String.valueOf(totalQuickPlayWins.get(0));
    }
}
