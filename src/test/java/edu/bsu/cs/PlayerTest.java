package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.json");
    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);

        String testData = byteArrayOutputStream.toString();
    }

    @Test
    public void accessPlayerName() {
    }

    @Test
    public void accessPlayerIcon() {
    }

    @Test
    public void accessPrivacySetting() {
    }

    @Test
    public void accessSkillRating() {
    }

    @Test
    public void accessRatingIcon() {
    }

    @Test
    public void accessLevel() {
    }

    @Test
    public void accessPrestige() {
    }

    @Test
    public void accessQuickPlayHeroes() {
    }

    @Test
    public void accessTotalQuickPlayGames() {
    }

    @Test
    public void accessTotalQuickPlayWins() {
    }

    @Test
    public void accessCompetitiveHeroes() {
    }

    @Test
    public void accessTotalCompetitiveGames() {
    }

    @Test
    public void accessTotalCompetitiveWins() {
    }
}