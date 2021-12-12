package edu.bsu.cs;

import edu.bsu.cs.Model.Hero;
import edu.bsu.cs.Model.HeroListFactory;
import edu.bsu.cs.Model.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HeroListFactoryTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.json");
    private HeroListFactory heroListFactory;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);

        String testData = byteArrayOutputStream.toString();
        this.heroListFactory = new HeroListFactory(new Parser(testData));
    }

    @Test
    public void testAccessCompetitiveHeroList() {
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals(" ashe cassidy hanzo reaper soldier76 symmetra tracer",
                heroNames.toString());
    }

    @Test
    public void testAccessQuickPlayHeroList() {
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: heroListFactory.accessQuickPlayHeroList()){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals(" ana ashe baptiste bastion brigitte cassidy dVa doomfist " +
                        "echo genji hanzo junkrat lucio mei mercy moira orisa pharah reaper " +
                        "reinhardt roadhog sigma soldier76 sombra symmetra torbjorn tracer " +
                        "widowmaker winston wreckingBall zarya zenyatta",
                heroNames.toString());
    }

    @Test
    public void testAccessListHeroesWeaponAccuracies() {
        StringBuilder weaponAccuracies = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            weaponAccuracies.append(hero.accessWeaponAccuracy()).append(" ");
        }
        Assertions.assertEquals("weaponAccuracy=49 weaponAccuracy=51 weaponAccuracy=29" +
                " weaponAccuracy=33 weaponAccuracy=46 weaponAccuracy=17 weaponAccuracy=43",
                weaponAccuracies.toString().trim());
    }

    @Test
    public void testAccessListHeroesWinPercentage() {
        StringBuilder winPercentages = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            winPercentages.append(hero.accessWinPercentage()).append(" ");
        }
        Assertions.assertEquals("winPercentage=100 winPercentage=68 winPercentage=48 " +
                        "winPercentage = N/A winPercentage = N/A winPercentage = N/A winPercentage = N/A",
                winPercentages.toString().trim());
    }

    @Test
    public void testAccessListHeroesEliminationsPerLife() {
        StringBuilder eliminationsPerLife = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            eliminationsPerLife.append(hero.accessEliminationsPerLife()).append(" ");
        }
        Assertions.assertEquals("eliminationsPerLife=6.33 eliminationsPerLife=1.53 " +
                        "eliminationsPerLife=1.2 eliminationsPerLife=2.33 eliminationsPerLife=2.2" +
                        " eliminationsPerLife=6 eliminationsPerLife=3",
                eliminationsPerLife.toString().trim());
    }

    @Test
    public void testAccessListHeroesGamesWon() {
        StringBuilder gamesWon = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            gamesWon.append(hero.accessGamesWon()).append(" ");
        }
        Assertions.assertEquals("gamesWon=0 gamesWon = N/A gamesWon=1 gamesWon = N/A" +
                        " gamesWon = N/A gamesWon = N/A gamesWon = N/A",
                gamesWon.toString().trim());
    }

    @Test
    public void testAccessScopedAccuracies() {
        StringBuilder scopedAccuracies = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            scopedAccuracies.append(hero.accessScopedAccuracy()).append(" ");
        }
        Assertions.assertEquals("scopedAccuracy=49% scopedAccuracy = N/A " + "scopedAccuracy = N/A " +
                        "scopedAccuracy = N/A scopedAccuracy = N/A " + "scopedAccuracy = N/A " +
                        "scopedAccuracy = N/A",
                scopedAccuracies.toString().trim());
    }

    @Test
    public void testAccessCriticalHitsAccuracies() {
        StringBuilder criticalHitsAccuracies = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            criticalHitsAccuracies.append(hero.accessCriticalHitAccuracy()).append(" ");
        }
        Assertions.assertEquals("criticalHitsAccuracy=16% criticalHitsAccuracy=5% " +
                        "criticalHitsAccuracy=7% criticalHitsAccuracy=7% criticalHitsAccuracy=3% " +
                        "criticalHitsAccuracy = N/A criticalHitsAccuracy=7%",
                criticalHitsAccuracies.toString().trim());
    }

    @Test
    public void testAccessTimePlayed() {
        StringBuilder timesPlayed = new StringBuilder();
        for(Hero hero: heroListFactory.accessCompetitiveHeroList()){
            timesPlayed.append(hero.accessTimePlayed()).append(" ");
        }
        Assertions.assertEquals("timePlayed=06:11 timePlayed=14:26 timePlayed=10:38 " +
                        "timePlayed=03:25 timePlayed=04:35 timePlayed=07:46 " +
                        "timePlayed=06:21",
                timesPlayed.toString().trim());
    }
}
