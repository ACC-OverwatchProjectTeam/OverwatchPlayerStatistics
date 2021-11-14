package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.txt");
    Parser parser;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);

        String testData = byteArrayOutputStream.toString();
        this.parser = new Parser(testData);
    }

    @Test
    public void testAccessUsername() {
        Assertions.assertEquals("Loupine#1170", parser.accessUsername());
    }

    @Test
    public void testAccessPrivateStatus(){
        Assertions.assertFalse(parser.accessPrivateStatus());
    }

    @Test
    public void testAccessSkillRating() {
        Assertions.assertEquals(2487, parser.accessSkillRating());
    }
    
    @Test
    public void testAccessLevel() {
        Assertions.assertEquals(42, parser.accessLevel());
    }

    @Test
    public void testAccessPrestige() {
        Assertions.assertEquals(5, parser.accessPrestige());
    }

    @Test
    public void testAccessRankIcon() {
        Assertions.assertEquals("https://d1u1mce87gyfbn.cloudfront.net/game/rank-icons/rank-GoldTier.png",
                parser.accessRatingIcon());
    }

    @Test
    public void testAccessPlayerIcon() {
        Assertions.assertEquals("https://d15f34w2p8l1cc.cloudfront.net/overwatch/983f04ba9e4a2ff022f" +
                        "b6c36a8021569c1938830912a2e418b1ec18337205113.png",
                parser.accessPlayerIcon());
    }

    @Test
    public void testAccessTotalQuickPlayGames(){
        Assertions.assertEquals(1285, parser.accessTotalQuickPlayGames());
    }

    @Test
    public void testAccessTotalQuickPlayWins(){
        Assertions.assertEquals(673, parser.accessTotalQuickPlayWins());
    }

    @Test
    public void testAccessTotalCompetitiveGames(){
        Assertions.assertEquals(5, parser.accessTotalCompetitiveGames());
    }

    @Test
    public void testAccessTotalCompetitiveWins(){
        Assertions.assertEquals(2, parser.accessTotalCompetitiveWins());
    }

    @Test
    public void accessAsheCriticalHitsAccuracy() {
        Assertions.assertEquals("16%", parser.accessAsheCriticalHitsAccuracy());
    }

    @Test
    public void testAsheWeaponAccuracy(){
        Assertions.assertEquals("49%", parser.accessAsheWeaponAccuracy());
    }

    @Test
    public void accessAsheScopedAccuracy() {
        Assertions.assertEquals("49%", parser.accessAsheScopedAccuracy());
    }

    @Test
    public void accessAsheScopedCriticalHitsAccuracy() {
        Assertions.assertEquals("16%", parser.accessAsheScopedCriticalHitsAccuracy());
    }

    @Test
    public void accessCassidyCriticalHitsAccuracy() {
        Assertions.assertEquals("5%", parser.accessCassidyCriticalHitsAccuracy());
    }

    @Test
    public void accessCassidyWeaponAccuracy() {
        Assertions.assertEquals("51%", parser.accessCassidyWeaponAccuracy());
    }

    @Test
    public void accessHanzoCriticalHitsAccuracy() {
        Assertions.assertEquals("7%", parser.accessHanzoCriticalHitsAccuracy());
    }

    @Test
    public void accessHanzoWeaponAccuracy() {
        Assertions.assertEquals("29%", parser.accessHanzoWeaponAccuracy());
    }

    @Test
    public void testReadHeroData() {
        List<String> heroNames = new ArrayList<>(
                List.of("ana", "ashe", "baptiste", "bastion", "brigitte", "cassidy", "dVa",
                        "doomfist", "echo", "genji", "hanzo", "junkrat", "lucio", "mei", "mercy",
                        "moira", "orisa", "pharah", "reaper", "reinhardt", "roadhog", "sigma",
                        "soldier76", "sombra", "symmetra", "torbjorn", "tracer", "widowmaker",
                        "winston", "wreckingBall", "zarya", "zenyatta"));
        Assertions.assertEquals("[49%, 51%, 29%, 33%, 46%, 17%, 43%]",
                parser.accessCompetitiveHeroWeaponAccuracies(heroNames));
    }

    @Test
    public void testAccessTopCompetitiveHeroes() {
        Assertions.assertEquals("{ashe={timePlayed=06:11, " +
                "gamesWon=0, winPercentage=100, weaponAccuracy=49, eliminationsPerLife=6.33, " +
                "multiKillBest=0, objectiveKills=7}, cassidy={timePlayed=14:26, gamesWon=1, " +
                "winPercentage=68, weaponAccuracy=51, eliminationsPerLife=1.53, multiKillBest=0, " +
                "objectiveKills=8}, hanzo={timePlayed=10:38, gamesWon=1, winPercentage=48, " +
                "weaponAccuracy=29, eliminationsPerLife=1.2, multiKillBest=0, objectiveKills=0}, " +
                "reaper={timePlayed=03:25, gamesWon=0, winPercentage=0, weaponAccuracy=33, " +
                "eliminationsPerLife=2.33, multiKillBest=3, objectiveKills=3}, " +
                "soldier76={timePlayed=04:35, gamesWon=0, winPercentage=0, weaponAccuracy=46, " +
                "eliminationsPerLife=2.2, multiKillBest=0, objectiveKills=2}, " +
                "symmetra={timePlayed=07:46, gamesWon=0, winPercentage=0, weaponAccuracy=17, " +
                "eliminationsPerLife=6, multiKillBest=3, objectiveKills=8}, " +
                "tracer={timePlayed=06:21, gamesWon=0, winPercentage=0, weaponAccuracy=43, " +
                "eliminationsPerLife=3, multiKillBest=0, objectiveKills=4}}", parser.accessTopCompetitiveHeroesData());
    }
}
