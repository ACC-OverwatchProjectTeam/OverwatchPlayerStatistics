package edu.bsu.cs;

import edu.bsu.cs.Model.Hero;
import edu.bsu.cs.Model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PlayerTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.json");
    Player player;
    private String testData;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);

        String testData = byteArrayOutputStream.toString();

        this.testData = testData;
        player = new Player.Builder().parserSetup(testData)
                .withPlayerData()
                .withPrivacyStatus()
                .withPlayerRatingInfo()
                .withPlayerLevel()
                .withCompetitiveHeroes()
                .withCompetitiveGameData()
                .withQuickPlayHeroes()
                .withQuickPlayGameData()
                .returnPlayer();
    }

    @Test
    public void accessPlayerName() {
        Assertions.assertEquals("Loupine#1170", player.accessPlayerName());
    }

    @Test
    public void accessPlayerIcon() {
        Assertions.assertEquals("https://d15f34w2p8l1cc.cloudfront.net/overwatch/983f04ba9e4a2ff022f" +
                        "b6c36a8021569c1938830912a2e418b1ec18337205113.png", player.accessPlayerIcon());
    }

    @Test
    public void accessPrivacySetting() {
        Assertions.assertFalse(player.accessPrivacySetting());
    }

    @Test
    public void accessSkillRating() {
        Assertions.assertEquals(2627, player.accessSkillRating());
    }

    @Test
    public void accessRatingIcon() {
        Assertions.assertEquals("https://d1u1mce87gyfbn.cloudfront.net/game/rank-icons/rank-PlatinumTier.png", player.accessRatingIcon());
    }

    @Test
    public void accessLevel() {
        Assertions.assertEquals(42, player.accessLevel());
    }

    @Test
    public void accessPrestige() {
        Assertions.assertEquals(5, player.accessPrestige());
    }

    @Test
    public void accessQuickPlayHeroes() {
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: player.accessQuickPlayHeroes()){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals(" ana ashe baptiste bastion brigitte cassidy dVa doomfist " +
                        "echo genji hanzo junkrat lucio mei mercy moira orisa pharah reaper " +
                        "reinhardt roadhog sigma soldier76 sombra symmetra torbjorn tracer " +
                        "widowmaker winston wreckingBall zarya zenyatta",
                heroNames.toString());
    }

    @Test
    public void accessTotalQuickPlayGames() {
        Assertions.assertEquals(1285, player.accessTotalQuickPlayGames());
    }

    @Test
    public void accessTotalQuickPlayWins() {
        Assertions.assertEquals(673, player.accessTotalQuickPlayWins());
    }

    @Test
    public void accessCompetitiveHeroes() {
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: player.accessCompetitiveHeroes()){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals(" ashe cassidy hanzo reaper soldier76 symmetra tracer",
                heroNames.toString());
    }

    @Test
    public void accessTotalCompetitiveGames() {
        Assertions.assertEquals(5, player.accessTotalCompetitiveGames());
    }

    @Test
    public void accessTotalCompetitiveWins() {
        Assertions.assertEquals(2, player.accessTotalCompetitiveWins());
    }

    @Test
    public void accessPrivacyStatus() {
        Assertions.assertFalse(new Player.Builder().parserSetup(testData).accessPrivacyStatus());
    }

    @Test
    public void accessRatingList() {
        Assertions.assertEquals("[2437, 2623, 2823]", player.accessRatingList().toString());
        }
}