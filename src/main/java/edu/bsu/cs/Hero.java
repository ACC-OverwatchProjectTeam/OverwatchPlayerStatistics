package edu.bsu.cs;

public class Hero {
    public static final class Builder{
        private String heroData;
        private String[] heroStatsArray;
        private String heroName;
        private String weaponAccuracy;
        private String winPercentage;
        private String eliminationsPerLife;
        private String gamesWon;

        public Hero withHeroData(String heroData) {
            this.heroData = heroData;
            this.heroName = readHeroName();
            this.gamesWon = heroStatsArray[1];
            this.winPercentage = heroStatsArray[2];
            this.weaponAccuracy = heroStatsArray[3];
            this.eliminationsPerLife = heroStatsArray[4];
            return new Hero(this);
        }

        private String readHeroName() {
            this.heroData = heroData.replace("={", "==");
            String[] splitHeroData = heroData.split("==");
            this.heroStatsArray = splitHeroData[1].split(",");
            return splitHeroData[0];
        }
    }
    private final String heroName;
    private final String weaponAccuracy;
    private final String winPercentage;
    private final String eliminationsPerLife;
    private final String gamesWon;

    public Hero(Builder builder) {
        this.heroName = builder.heroName;
        this.gamesWon = builder.gamesWon;
        this.winPercentage = builder.winPercentage;
        this.weaponAccuracy = builder.weaponAccuracy;
        this.eliminationsPerLife = builder.eliminationsPerLife;
    }

    public String accessHeroName() {
        return heroName;
    }

    public String accessWeaponAccuracy() {
        return weaponAccuracy;
    }

    public String accessWinPercentage() {
        return winPercentage;
    }

    public String accessEliminationsPerLife() {
        return eliminationsPerLife;
    }

    public String accessGamesWon() {
        return gamesWon;
    }
}
