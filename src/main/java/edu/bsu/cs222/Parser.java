package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;

public class Parser {
    public String accessUsername(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..name");
        JSONArray playerName = path.read(profileDataStream);
        return playerName.get(0).toString();
    }

    public String accessSkillRating(String profileDataStream) {
        JsonPath path = JsonPath.compile("$..rating");
        JSONArray skillRating = path.read(profileDataStream);
        return String.valueOf(skillRating.get(0));
    }
}
