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
    private HeroListFactory heroListMaker;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);

        String testData = byteArrayOutputStream.toString();
        this.heroListMaker = new HeroListFactory(new Parser(testData));
    }

    @Test
    public void testAccessCompetitiveHeroList() {
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: heroListMaker.accessCompetitiveHeroList()){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals("ashe cassidy hanzo reaper soldier76 symmetra tracer",
                heroNames.toString());
    }

    @Test
    public void testAccessQuickPlayHeroList() {
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: heroListMaker.accessQuickPlayHeroList()){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals("ana ashe baptiste bastion brigitte cassidy dVa doomfist " +
                        "echo genji hanzo junkrat lucio mei mercy moira orisa pharah reaper " +
                        "reinhardt roadhog sigma soldier76 sombra symmetra torbjorn tracer " +
                        "widowmaker winston wreckingBall zarya zenyatta",
                heroNames.toString());
    }

    @Test
    public void testAccessListHeroesWeaponAccuracies() {
        StringBuilder weaponAccuracies = new StringBuilder();
        for(Hero hero: heroListMaker.accessCompetitiveHeroList()){
            weaponAccuracies.append(hero.accessWeaponAccuracy());
        }
        Assertions.assertEquals("weaponAccuracy=49 weaponAccuracy=51 weaponAccuracy=29" +
                " weaponAccuracy=33 weaponAccuracy=46 weaponAccuracy=17 weaponAccuracy=43",
                weaponAccuracies.toString().trim());
    }

    @Test
    public void testAccessListHeroesWinPercentage() {
        StringBuilder winPercentages = new StringBuilder();
        for(Hero hero: heroListMaker.accessCompetitiveHeroList()){
            winPercentages.append(hero.accessWinPercentage());
        }
        Assertions.assertEquals("winPercentage=100 winPercentage=68 winPercentage=48" +
                        " winPercentage=0 winPercentage=0 winPercentage=0 winPercentage=0",
                winPercentages.toString().trim());
    }

    @Test
    public void testAccessListHeroesEliminationsPerLife() {
        StringBuilder eliminationsPerLife = new StringBuilder();
        for(Hero hero: heroListMaker.accessCompetitiveHeroList()){
            eliminationsPerLife.append(hero.accessEliminationsPerLife());
        }
        Assertions.assertEquals("eliminationsPerLife=6.33 eliminationsPerLife=1.53 " +
                        "eliminationsPerLife=1.2 eliminationsPerLife=2.33 eliminationsPerLife=2.2" +
                        " eliminationsPerLife=6 eliminationsPerLife=3",
                eliminationsPerLife.toString().trim());
    }

    @Test
    public void testAccessListHeroesGamesWon() {
        StringBuilder gamesWon = new StringBuilder();
        for(Hero hero: heroListMaker.accessCompetitiveHeroList()){
            gamesWon.append(hero.accessGamesWon());
        }
        Assertions.assertEquals("gamesWon=0 gamesWon=1 gamesWon=1 " +
                        "gamesWon=0 gamesWon=0 gamesWon=0 gamesWon=0",
                gamesWon.toString().trim());
    }
}
