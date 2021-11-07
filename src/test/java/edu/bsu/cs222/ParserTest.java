package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
    void accessAsheCriticalHitsAccuracy() {
        Assertions.assertEquals("16%", parser.accessAsheCriticalHitsAccuracy());
    }

    @Test
    public void testAsheWeaponAccuracy(){
        Assertions.assertEquals("49%", parser.accessAsheWeaponAccuracy());
    }

    @Test
    void accessAsheScopedAccuracy() {
        Assertions.assertEquals("49%", parser.accessAsheScopedAccuracy());
    }

    @Test
    void accessAsheScopedCriticalHitsAccuracy() {
        Assertions.assertEquals("16%", parser.accessAsheScopedCriticalHitsAccuracy());
    }
}
