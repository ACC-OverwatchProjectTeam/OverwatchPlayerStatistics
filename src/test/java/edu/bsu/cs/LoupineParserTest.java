package edu.bsu.cs;

import edu.bsu.cs.Model.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoupineParserTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.json");
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
        Assertions.assertEquals(2627, parser.accessSkillRating());
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
        Assertions.assertEquals("https://d1u1mce87gyfbn.cloudfront.net/game/rank-icons/rank-PlatinumTier.png",
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
    public void testAccessTopCompetitiveHeroes() {
        Assertions.assertEquals("{allHeroes={assists={defensiveAssists=3, healingDone=1430, reconAssists=2}, average={allDamageDoneAvgPer10Min=11021, barrierDamageDoneAvgPer10Min=2794, deathsAvgPer10Min=8.43, eliminationsAvgPer10Min=20.8, finalBlowsAvgPer10Min=12.74, healingDoneAvgPer10Min=268, heroDamageDoneAvgPer10Min=8174, objectiveKillsAvgPer10Min=6, objectiveTimeAvgPer10Min=00:41, soloKillsAvgPer10Min=3.37, timeSpentOnFireAvgPer10Min=00:34}, best={allDamageDoneMostInGame=17497, barrierDamageDoneMostInGame=4412, defensiveAssistsMostInGame=3, eliminationsMostInGame=31, finalBlowsMostInGame=19, healingDoneMostInGame=760, heroDamageDoneMostInGame=14178, killsStreakBest=14, meleeFinalBlowsMostInGame=2, multikillsBest=3, objectiveKillsMostInGame=9, objectiveTimeMostInGame=01:16, offensiveAssistsMostInGame=4, reconAssistsMostInGame=2, soloKillsMostInGame=19, timeSpentOnFireMostInGame=01:18}, combat={barrierDamageDone=14911, damageDone=43619, deaths=45, eliminations=111, finalBlows=68, heroDamageDone=43619, meleeFinalBlows=3, multikills=2, objectiveKills=32, objectiveTime=03:38, soloKills=18, timeSpentOnFire=03:02}, deaths=null, heroSpecific=null, game={gamesLost=3, gamesPlayed=5, gamesWon=2, timePlayed=53:22}, matchAwards={cards=1, medals=12, medalsBronze=4, medalsGold=3, medalsSilver=5}, miscellaneous=null}, ashe={assists=null, average={allDamageDoneAvgPer10Min=10770, barrierDamageDoneAvgPer10Min=2403, criticalHitsAvgPer10Min=14.57, deathsAvgPer10Min=4.86, eliminationsAvgPer10Min=30.76, eliminationsPerLife=6.33, finalBlowsAvgPer10Min=11.33, heroDamageDoneAvgPer10Min=8367, objectiveKillsAvgPer10Min=11.33, objectiveTimeAvgPer10Min=01:37, soloKillsAvgPer10Min=3.24}, best={allDamageDoneMostInGame=6653, allDamageDoneMostInLife=2470, barrierDamageDoneMostInGame=1484, criticalHitsMostInGame=9, criticalHitsMostInLife=3, eliminationsMostInGame=19, eliminationsMostInLife=7, finalBlowsMostInGame=7, heroDamageDoneMostInGame=5168, heroDamageDoneMostInLife=1721, killsStreakBest=7, objectiveKillsMostInGame=7, objectiveTimeMostInGame=01:00, soloKillsMostInGame=2, weaponAccuracyBestInGame=49%}, combat={barrierDamageDone=1484, criticalHits=9, criticalHitsAccuracy=16%, damageDone=6653, deaths=3, eliminations=19, finalBlows=7, heroDamageDone=5168, objectiveKills=7, objectiveTime=01:00, soloKills=2, weaponAccuracy=49%}, deaths=null, heroSpecific={bobKills=1, bobKillsAvgPer10Min=1.62, bobKillsMostInGame=1, coachGunKills=1, coachGunKillsAvgPer10Min=1.62, coachGunKillsMostInGame=1, dynamiteKills=4, dynamiteKillsAvgPer10Min=6.48, dynamiteKillsMostInGame=4, scopedAccuracy=49%, scopedAccuracyBestInGame=49%, scopedCriticalHitKills=1, scopedCriticalHits=9, scopedCriticalHitsAccuracy=16%, scopedCriticalHitsAvgPer10Min=14.57, scopedCriticalHitsKillsAvgPer10Min=1.62, scopedCriticalHitsMostInGame=9}, game={gamesLost=0, gamesPlayed=0, gamesWon=0, timePlayed=06:11, winPercentage=100%}, matchAwards={medals=1, medalsBronze=0, medalsGold=0, medalsSilver=0}, miscellaneous=null}, cassidy={assists=null, average={allDamageDoneAvgPer10Min=10557, barrierDamageDoneAvgPer10Min=2358, criticalHitsAvgPer10Min=6.23, deathsAvgPer10Min=10.39, eliminationsAvgPer10Min=15.93, eliminationsPerLife=1.53, finalBlowsAvgPer10Min=14.55, heroDamageDoneAvgPer10Min=8199, objectiveKillsAvgPer10Min=5.54, objectiveTimeAvgPer10Min=00:16, soloKillsAvgPer10Min=3.46, timeSpentOnFireAvgPer10Min=00:25}, best={allDamageDoneMostInGame=8581, allDamageDoneMostInLife=2775, barrierDamageDoneMostInGame=1420, criticalHitsMostInGame=9, criticalHitsMostInLife=4, eliminationsMostInGame=16, eliminationsMostInLife=5, finalBlowsMostInGame=16, heroDamageDoneMostInGame=7185, heroDamageDoneMostInLife=1964, killsStreakBest=5, objectiveKillsMostInGame=7, objectiveTimeMostInGame=00:21, soloKillsMostInGame=5, timeSpentOnFireMostInGame=00:36, weaponAccuracyBestInGame=54%}, combat={barrierDamageDone=3404, criticalHits=9, criticalHitsAccuracy=5%, damageDone=15241, deaths=15, eliminations=23, finalBlows=21, heroDamageDone=11836, objectiveKills=8, objectiveTime=00:24, soloKills=5, timeSpentOnFire=00:36, weaponAccuracy=51%}, deaths=null, heroSpecific={deadeyeKills=1, deadeyeKillsAvgPer10Min=0.69, deadeyeKillsMostInGame=1, fanTheHammerKills=11, fanTheHammerKillsAvgPer10Min=7.62, fanTheHammerKillsMostInGame=8}, game={gameWon=1, gamesLost=0, gamesPlayed=1, timePlayed=14:26, winPercentage=68%}, matchAwards={medals=3, medalsBronze=1, medalsGold=0, medalsSilver=1}, miscellaneous=null}, hanzo={assists={reconAssists=2, reconAssistsAvgPer10Min=1.88, reconAssistsMostInGame=2}, average={allDamageDoneAvgPer10Min=10688, barrierDamageDoneAvgPer10Min=4364, criticalHitsAvgPer10Min=3.76, deathsAvgPer10Min=9.41, eliminationsAvgPer10Min=11.29, eliminationsPerLife=1.2, finalBlowsAvgPer10Min=7.53, heroDamageDoneAvgPer10Min=6258, objectiveTimeAvgPer10Min=00:01, soloKillsAvgPer10Min=1.88}, best={allDamageDoneMostInGame=8249, allDamageDoneMostInLife=2566, barrierDamageDoneMostInGame=2927, criticalHitsMostInGame=4, criticalHitsMostInLife=3, eliminationsMostInGame=8, eliminationsMostInLife=3, finalBlowsMostInGame=6, heroDamageDoneMostInGame=5252, heroDamageDoneMostInLife=1592, killsStreakBest=3, objectiveTimeMostInGame=00:01, soloKillsMostInGame=2, weaponAccuracyBestInGame=30%}, combat={barrierDamageDone=4638, criticalHits=4, criticalHitsAccuracy=7%, damageDone=11359, deaths=10, eliminations=12, finalBlows=8, heroDamageDone=6651, objectiveTime=00:01, soloKills=2, weaponAccuracy=29%}, deaths=null, heroSpecific={dragonstrikeKills=1, dragonstrikeKillsAvgPer10Min=0.94, dragonstrikeKillsMostInGame=1, stormArrowKills=5, stormArrowKillsAvgPer10Min=4.7, stormArrowKillsMostInGame=3}, game={gamesLost=1, gamesPlayed=1, gamesWon=1, timePlayed=10:38, winPercentage=48%}, matchAwards={medals=2, medalsBronze=1, medalsGold=1, medalsSilver=1}, miscellaneous=null}, reaper={assists=null, average={allDamageDoneAvgPer10Min=11533, barrierDamageDoneAvgPer10Min=4124, criticalHitsAvgPer10Min=75.96, deathsAvgPer10Min=8.76, eliminationsAvgPer10Min=20.45, eliminationsPerLife=2.33, finalBlowsAvgPer10Min=14.61, healingDoneAvgPer10Min=1345, heroDamageDoneAvgPer10Min=7409, objectiveKillsAvgPer10Min=8.76, objectiveTimeAvgPer10Min=00:52, timeSpentOnFireAvgPer10Min=00:54}, best={allDamageDoneMostInGame=3948, allDamageDoneMostInLife=2145, barrierDamageDoneMostInGame=1411, criticalHitsMostInGame=26, criticalHitsMostInLife=12, eliminationsMostInGame=7, eliminationsMostInLife=5, finalBlowsMostInGame=5, heroDamageDoneMostInGame=2536, heroDamageDoneMostInLife=1395, killsStreakBest=5, multikillsBest=3, objectiveKillsMostInGame=3, objectiveTimeMostInGame=00:18, timeSpentOnFireMostInGame=00:19, weaponAccuracyBestInGame=33%}, combat={barrierDamageDone=1411, criticalHits=26, criticalHitsAccuracy=7%, damageDone=3948, deaths=3, eliminations=7, finalBlows=5, heroDamageDone=2536, multikills=1, objectiveKills=3, objectiveTime=00:18, timeSpentOnFire=00:19, weaponAccuracy=33%}, deaths=null, heroSpecific={deathsBlossomKills=3, deathsBlossomKillsAvgPer10Min=8.76, deathsBlossomKillsMostInGame=3, selfHealing=460, selfHealingAvgPer10Min=1345, selfHealingMostInGame=460}, game={gamesLost=0, gamesPlayed=0, timePlayed=03:25}, matchAwards={medals=1, medalsSilver=1}, miscellaneous=null}, soldier76={assists={defensiveAssists=3, defensiveAssistsAvgPer10Min=6.55, defensiveAssistsMostInGame=3, healingDone=970, healingDoneMostInGame=670}, average={allDamageDoneAvgPer10Min=15057, barrierDamageDoneAvgPer10Min=3494, criticalHitsAvgPer10Min=15.29, deathsAvgPer10Min=10.92, eliminationsAvgPer10Min=24.02, eliminationsPerLife=2.2, finalBlowsAvgPer10Min=10.92, healingDoneAvgPer10Min=2118, heroDamageDoneAvgPer10Min=11563, meleeFinalBlowsAvgPer10Min=2.18, objectiveKillsAvgPer10Min=4.37, objectiveTimeAvgPer10Min=00:33, soloKillsAvgPer10Min=6.55}, best={allDamageDoneMostInGame=3548, allDamageDoneMostInLife=3548, barrierDamageDoneMostInGame=1600, criticalHitsMostInGame=4, criticalHitsMostInLife=3, eliminationsMostInGame=6, eliminationsMostInLife=5, finalBlowsMostInGame=3, heroDamageDoneMostInGame=3347, heroDamageDoneMostInLife=1948, killsStreakBest=5, meleeFinalBlowsMostInGame=1, objectiveKillsMostInGame=1, objectiveTimeMostInGame=00:13, soloKillsMostInGame=2, weaponAccuracyBestInGame=47%}, combat={barrierDamageDone=1600, criticalHits=7, criticalHitsAccuracy=3%, damageDone=6895, deaths=5, eliminations=11, finalBlows=5, heroDamageDone=5295, meleeFinalBlows=1, objectiveKills=2, objectiveTime=00:15, quickMeleeAccuracy=50%, soloKills=3, weaponAccuracy=46%}, deaths=null, heroSpecific={bioticFieldHealingDone=970, bioticFieldsDeployed=7, helixRocketKills=6, helixRocketKillsAvgPer10Min=13.1, helixRocketKillsMostInGame=4, selfHealing=610, selfHealingAvgPer10Min=1331, selfHealingMostInGame=324, tacticalVisorKills=3, tacticalVisorKillsAvgPer10Min=6.55, tacticalVisorKillsMostInGame=2}, game={gamesLost=0, gamesPlayed=0, timePlayed=04:35}, matchAwards={medals=1, medalsBronze=0, medalsGold=0, medalsSilver=1}, miscellaneous=null}, symmetra={assists=null, average={allDamageDoneAvgPer10Min=11101, barrierDamageDoneAvgPer10Min=2429, deathsAvgPer10Min=5.15, eliminationsAvgPer10Min=30.92, eliminationsPerLife=6, finalBlowsAvgPer10Min=16.75, heroDamageDoneAvgPer10Min=8403, objectiveKillsAvgPer10Min=10.31, objectiveTimeAvgPer10Min=00:55, soloKillsAvgPer10Min=5.15, timeSpentOnFireAvgPer10Min=01:41}, best={allDamageDoneMostInGame=6992, allDamageDoneMostInLife=4429, barrierDamageDoneMostInGame=1130, eliminationsMostInGame=21, eliminationsMostInLife=14, finalBlowsMostInGame=12, heroDamageDoneMostInGame=5819, heroDamageDoneMostInLife=3763, killsStreakBest=14, multikillsBest=3, objectiveKillsMostInGame=6, objectiveTimeMostInGame=00:39, soloKillsMostInGame=3, timeSpentOnFireMostInGame=01:18, weaponAccuracyBestInGame=29%}, combat={barrierDamageDone=1885, damageDone=8615, deaths=4, eliminations=24, finalBlows=13, heroDamageDone=6521, multikills=1, objectiveKills=8, objectiveTime=00:43, soloKills=4, timeSpentOnFire=01:18, weaponAccuracy=17%}, deaths=null, heroSpecific={damageBlocked=5221, damageBlockedAvgPer10Min=6727, damageBlockedMostInGame=5221, playersTeleported=27, playersTeleportedAvgPer10Min=34.79, playersTeleportedMostInGame=24, primaryFireAccuracy=39%, secondaryDirectHitsAvgPer10Min=5.15, secondaryFireAccuracy=17%, sentryTurretsKills=10, sentryTurretsKillsAvgPer10Min=12.88, sentryTurretsKillsMostInGame=8}, game={gamesLost=1, gamesPlayed=1, timePlayed=07:46}, matchAwards={cards=1, medals=3, medalsBronze=1, medalsGold=1, medalsSilver=1}, miscellaneous=null}, tracer={assists=null, average={allDamageDoneAvgPer10Min=9591, barrierDamageDoneAvgPer10Min=767, criticalHitsAvgPer10Min=94.38, deathsAvgPer10Min=7.86, eliminationsAvgPer10Min=23.59, eliminationsPerLife=3, finalBlowsAvgPer10Min=14.16, heroDamageDoneAvgPer10Min=8825, meleeFinalBlowsAvgPer10Min=3.15, objectiveKillsAvgPer10Min=6.29, objectiveTimeAvgPer10Min=01:31, soloKillsAvgPer10Min=3.15, timeSpentOnFireAvgPer10Min=01:17}, best={allDamageDoneMostInGame=5948, allDamageDoneMostInLife=2034, barrierDamageDoneMostInGame=487, criticalHitsMostInGame=60, criticalHitsMostInLife=21, eliminationsMostInGame=15, eliminationsMostInLife=6, finalBlowsMostInGame=9, heroDamageDoneMostInGame=5460, heroDamageDoneMostInLife=1756, killsStreakBest=6, meleeFinalBlowsMostInGame=2, objectiveKillsMostInGame=4, objectiveTimeMostInGame=00:53, soloKillsMostInGame=2, timeSpentOnFireMostInGame=00:49, weaponAccuracyBestInGame=43%}, combat={barrierDamageDone=487, criticalHits=60, criticalHitsAccuracy=7%, damageDone=6098, deaths=5, eliminations=15, finalBlows=9, heroDamageDone=5610, meleeFinalBlows=2, objectiveKills=4, objectiveTime=00:58, quickMeleeAccuracy=13%, soloKills=2, timeSpentOnFire=00:49, weaponAccuracy=43%}, deaths=null, heroSpecific={healthRecovered=615, healthRecoveredAvgPer10Min=968, healthRecoveredMostInGame=615, pulseBombsAttached=3, pulseBombsAttachedAvgPer10Min=4.72, pulseBombsAttachedMostInGame=3, pulseBombsKills=3, pulseBombsKillsAvgPer10Min=4.72, pulseBombsKillsMostInGame=3, selfHealing=615, selfHealingAvgPer10Min=968, selfHealingMostInGame=615}, game={gamesLost=0, gamesPlayed=0, timePlayed=06:21}, matchAwards={medals=1, medalsBronze=0, medalsGold=0, medalsSilver=1}, miscellaneous=null}}",
                parser.accessTopCompetitiveHeroesData());
    }

    @Test
    public void testAccessRoleRating() {
        Assertions.assertEquals("[2437,2623,2823]", parser.accessRoleRating().toString());
    }
}
