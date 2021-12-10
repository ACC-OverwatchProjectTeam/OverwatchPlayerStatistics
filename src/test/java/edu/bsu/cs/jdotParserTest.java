package edu.bsu.cs;

import edu.bsu.cs.Model.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class jdotParserTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdotData.json");
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
        Assertions.assertEquals("jdot#11195", parser.accessUsername());
    }

    @Test
    public void testAccessPrivateStatus() {
        Assertions.assertFalse(parser.accessPrivateStatus());
    }

    @Test
    public void testAccessSkillRating() {
        Assertions.assertEquals(1688, parser.accessSkillRating());
    }

    @Test
    public void testAccessLevel() {
        Assertions.assertEquals(14, parser.accessLevel());
    }

    @Test
    public void testAccessPrestige() {
        Assertions.assertEquals(2, parser.accessPrestige());
    }

    @Test
    public void testAccessRankIcon() {
        Assertions.assertEquals("https://d1u1mce87gyfbn.cloudfront.net/game/rank-icons/rank-SilverTier.png",
                parser.accessRatingIcon());
    }

    @Test
    public void testAccessPlayerIcon() {
        Assertions.assertEquals("https://d15f34w2p8l1cc.cloudfront.net/overwatch/9cefefc00bd5fde0a69689ea53bae9dec6bceb2c106ce20369163833118ff587.png",
                parser.accessPlayerIcon());
    }

    @Test
    public void testAccessTotalQuickPlayGames() {
        Assertions.assertEquals(417, parser.accessTotalQuickPlayGames());
    }

    @Test
    public void testAccessTotalQuickPlayWins() {
        Assertions.assertEquals(186, parser.accessTotalQuickPlayWins());
    }

    @Test
    public void testAccessTotalCompetitiveGames() {
        Assertions.assertEquals(74, parser.accessTotalCompetitiveGames());
    }

    @Test
    public void testAccessTotalCompetitiveWins() {
        Assertions.assertEquals(32, parser.accessTotalCompetitiveWins());
    }

    @Test
    public void testAccessTopCompetitiveHeroes() {
        Assertions.assertEquals("{ana={timePlayed=53:43, " +
                        "gamesWon=3, winPercentage=51, weaponAccuracy=24, eliminationsPerLife=2.11, " +
                        "multiKillBest=3, objectiveKills=40}, ashe={timePlayed=08:32, gamesWon=1, " +
                        "winPercentage=65, weaponAccuracy=41, eliminationsPerLife=1.25, multiKillBest=0, " +
                        "objectiveKills=1}, baptiste={timePlayed=20:09, gamesWon=1, winPercentage=57, " +
                        "weaponAccuracy=35, eliminationsPerLife=2.53, multiKillBest=0, objectiveKills=28}, " +
                        "bastion={timePlayed=04:28, gamesWon=0, winPercentage=0, weaponAccuracy=25, " +
                        "eliminationsPerLife=2.33, multiKillBest=0, objectiveKills=1}, cassidy={timePlayed=42:00, " +
                        "gamesWon=1, winPercentage=34, weaponAccuracy=44, eliminationsPerLife=1.91, multiKillBest=4, " +
                        "objectiveKills=22}, dVa={timePlayed=01:39:16, gamesWon=2, winPercentage=25, " +
                        "weaponAccuracy=23, eliminationsPerLife=2.95, multiKillBest=4, objectiveKills=72}, " +
                        "doomfist={timePlayed=02:52, gamesWon=0, winPercentage=0, weaponAccuracy=36, " +
                        "eliminationsPerLife=0.4, multiKillBest=0, objectiveKills=0}, echo={timePlayed=15:22, " +
                        "gamesWon=0, winPercentage=21, weaponAccuracy=30, eliminationsPerLife=2.45, multiKillBest=0, " +
                        "objectiveKills=12}, hanzo={timePlayed=06:50, gamesWon=0, winPercentage=78, weaponAccuracy=29, " +
                        "eliminationsPerLife=1.67, multiKillBest=0, objectiveKills=3}, junkrat={timePlayed=20:54, " +
                        "gamesWon=2, winPercentage=77, weaponAccuracy=35, eliminationsPerLife=3.4, multiKillBest=3, " +
                        "objectiveKills=18}, lucio={timePlayed=04:48, gamesWon=0, winPercentage=0, weaponAccuracy=29, " +
                        "eliminationsPerLife=1, multiKillBest=0, objectiveKills=0}, mei={timePlayed=41:28, " +
                        "gamesWon=2, winPercentage=50, weaponAccuracy=40, eliminationsPerLife=2.21, multiKillBest=3, " +
                        "objectiveKills=31}, mercy={timePlayed=07:06, gamesWon=0, winPercentage=0, weaponAccuracy=0, " +
                        "eliminationsPerLife=0, multiKillBest=0, objectiveKills=0}, moira={timePlayed=09:22, " +
                        "gamesWon=0, winPercentage=0, weaponAccuracy=0, eliminationsPerLife=0.75, multiKillBest=0, " +
                        "objectiveKills=3}, orisa={timePlayed=24:42, gamesWon=0, winPercentage=27, weaponAccuracy=34, " +
                        "eliminationsPerLife=1.14, multiKillBest=0, objectiveKills=7}, pharah={timePlayed=14:09, " +
                        "gamesWon=0, winPercentage=31, weaponAccuracy=52, eliminationsPerLife=2.38, multiKillBest=3, " +
                        "objectiveKills=13}, reaper={timePlayed=30:46, gamesWon=2, winPercentage=71, weaponAccuracy=26, " +
                        "eliminationsPerLife=3.91, multiKillBest=3, objectiveKills=45}, reinhardt={timePlayed=05:28:03, " +
                        "gamesWon=13, winPercentage=46, weaponAccuracy=0, eliminationsPerLife=1.92, multiKillBest=4, " +
                        "objectiveKills=237}, roadhog={timePlayed=08:31, gamesWon=1, winPercentage=100, " +
                        "weaponAccuracy=20, eliminationsPerLife=1.57, multiKillBest=0, objectiveKills=4}, " +
                        "sigma={timePlayed=21:52, gamesWon=1, winPercentage=82, weaponAccuracy=0, eliminationsPerLife=1.93, " +
                        "multiKillBest=3, objectiveKills=12}, soldier76={timePlayed=08:56, gamesWon=0, winPercentage=0, " +
                        "weaponAccuracy=36, eliminationsPerLife=3.13, multiKillBest=3, objectiveKills=18}, " +
                        "symmetra={timePlayed=12:41, gamesWon=1, winPercentage=64, weaponAccuracy=47, " +
                        "eliminationsPerLife=3.55, multiKillBest=3, objectiveKills=33}, torbjorn={timePlayed=18:12, " +
                        "gamesWon=1, winPercentage=60, weaponAccuracy=33, eliminationsPerLife=3.6, multiKillBest=3, " +
                        "objectiveKills=25}, tracer={timePlayed=15:04, gamesWon=1, winPercentage=44, weaponAccuracy=29, " +
                        "eliminationsPerLife=1.56, multiKillBest=0, objectiveKills=17}, widowmaker={timePlayed=02:36, " +
                        "gamesWon=0, winPercentage=0, weaponAccuracy=49, eliminationsPerLife=1, multiKillBest=0, " +
                        "objectiveKills=0}, winston={timePlayed=03:48, gamesWon=0, winPercentage=0, weaponAccuracy=0, " +
                        "eliminationsPerLife=3, multiKillBest=3, objectiveKills=6}, wreckingBall={timePlayed=03:35, " +
                        "gamesWon=0, winPercentage=13, weaponAccuracy=33, eliminationsPerLife=0.67, multiKillBest=0, " +
                        "objectiveKills=2}, zarya={timePlayed=12:25, gamesWon=0, winPercentage=0, weaponAccuracy=45, " +
                        "eliminationsPerLife=2.38, multiKillBest=0, objectiveKills=8}, zenyatta={timePlayed=02:26, " +
                        "gamesWon=0, winPercentage=0, weaponAccuracy=21, eliminationsPerLife=1.5, multiKillBest=3, " +
                        "objectiveKills=3}}",
                parser.accessTopCompetitiveHeroesData());
    }

    @Test
    public void testAccessRoleRating(){
        Assertions.assertEquals("[{\"level\":2191,\"role\":\"tank\",\"roleIcon\":\"https:\\/\\" +
                "/static.playoverwatch.com\\/img\\/pages\\/career\\/icon-tank-8a52daaf01.png\"," +
                "\"rankIcon\":\"https:\\/\\/d1u1mce87gyfbn.cloudfront.net\\/game\\/rank-icons\\" +
                "/rank-GoldTier.png\"},{\"level\":1363,\"role\":\"damage\",\"roleIcon\":\"https:" +
                "\\/\\/static.playoverwatch.com\\/img\\/pages\\/career\\/icon-offense-6267addd52.png\"," +
                "\"rankIcon\":\"https:\\/\\/d1u1mce87gyfbn.cloudfront.net\\/game\\/rank-icons\\" +
                "/rank-BronzeTier.png\"},{\"level\":1511,\"role\":\"support\",\"roleIcon\":\"https:\\" +
                "/\\/static.playoverwatch.com\\/img\\/pages\\/career\\/icon-support-46311a4210.png\"," +
                "\"rankIcon\":\"https:\\/\\/d1u1mce87gyfbn.cloudfront.net\\/game\\/rank-icons\\" +
                "/rank-SilverTier.png\"}]", parser.accessRoleRating());
    }
}
