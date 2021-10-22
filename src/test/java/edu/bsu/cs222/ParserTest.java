package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ParserTest {
    private final Parser parser = new Parser();
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.txt");
    private String testData;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);
        this.testData = byteArrayOutputStream.toString();
    }

    @Test
    public void testAccessUsername() {
        Assertions.assertEquals("Loupine#1170", parser.accessUsername(testData));
    }

    @Test
    public void testAccessSkillRating() {
        Assertions.assertEquals("2785", parser.accessSkillRating(testData));
    }
    
    @Test
    public void testAccessLevel() {
        Assertions.assertEquals("21", parser.accessLevel(testData));
    }

    @Test
    public void testAccessPrestige() {
        Assertions.assertEquals("5", parser.accessPrestige(testData));
    }

    @Test
    public void testAccessRankIcon() {
        Assertions.assertEquals("https://d1u1mce87gyfbn.cloudfront.net/game/rank-icons/rank-PlatinumTier.png",
                parser.accessRatingIcon(testData));
    }

    @Test
    public void testAccessPlayerIcon() {
        Assertions.assertEquals("https://d15f34w2p8l1cc.cloudfront.net/overwatch/f7d2e053297f05c7ed5c32c736794" +
                "ebdfd53d9337d4f714d5958c68aacc134b5.png",
                parser.accessPlayerIcon(testData));
    }

    @Test
    public void testAccessTotalQuickPlayGames(){
        Assertions.assertEquals("1264", parser.accessTotalQuickPlayGames(testData));
    }

    @Test
    public void testAccessTotalQuickPlayWins(){
        Assertions.assertEquals("660", parser.accessTotalQuickPlayWins(testData));
    }
}
