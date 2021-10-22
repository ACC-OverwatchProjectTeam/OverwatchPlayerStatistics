package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PlayerTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.txt");
    Player player;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);
        String testData = byteArrayOutputStream.toString();

        Builder builder = new Builder();
        this.player = builder.build(testData);
    }

    @Test
    public void testAccessPlayerName() {
        Assertions.assertEquals("Loupine#1170", player.accessPlayerName());
    }

    @Test
    public void testAccessPlayerIcon() {
        Assertions.assertEquals("https://d15f34w2p8l1cc.cloudfront.net/overwatch/f7d2e053297f05c7ed5c32c7367" +
                        "94ebdfd53d9337d4f714d5958c68aacc134b5.png",
                player.accessPlayerIcon());
    }

    @Test
    public void testAccessSkillRating() {
        Assertions.assertEquals("2785", player.accessSkillRating());
    }

    @Test
    public void testAccessRatingIcon() {
        Assertions.assertEquals("https://d1u1mce87gyfbn.cloudfront.net/game/rank-icons/rank-PlatinumTier.png",
                player.accessRatingIcon());
    }

    @Test
    public void testAccessLevel() {
        Assertions.assertEquals("21", player.accessLevel());
    }

    @Test
    public void testAccessPrestige() {
        Assertions.assertEquals("5", player.accessPrestige());
    }

    @Test
    public void testAccessTotalQuickPlayGames() {
        Assertions.assertEquals("1264", player.accessTotalQuickPlayGames());
    }

    @Test
    public void testAccessTotalQuickPlayWins() {
        Assertions.assertEquals("660", player.accessTotalQuickPlayWins());
    }
}
