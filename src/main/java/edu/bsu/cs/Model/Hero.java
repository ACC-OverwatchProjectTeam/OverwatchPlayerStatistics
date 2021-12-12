package edu.bsu.cs.Model;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    public static final class Builder {
        private String heroData;
        private String heroName;
        private String weaponAccuracy;
        private String scopedAccuracy;
        private String criticalHitsAccuracy;
        private String eliminationsPerLife;
        private String gamesWon;
        private String winPercentage;
        private String timePlayed;

        public Hero withHeroData(String heroData) {
            this.heroData = heroData;
            this.heroName = readHeroName();
            assignHeroStats();
            return new Hero(this);
        }

        private String readHeroName() {
            heroData = heroData.replaceFirst("=", "===");
            List<String> splitHeroData = new ArrayList<>(List.of(heroData.split("===")));
            String heroName = splitHeroData.get(0);

            if (heroName.contains("},")) {
                heroName = heroName.replace("},", "");
            }
            return heroName;
        }

        private void assignHeroStats() {
            if (heroData.contains("weaponAccuracy=")) {
                this.weaponAccuracy = heroData.substring(heroData.indexOf("weaponAccuracy="),
                        heroData.indexOf("%", heroData.indexOf("weaponAccuracy=")));
            }else {
                this.weaponAccuracy = "weaponAccuracy = N/A";
            }

            if (heroData.contains("scopedAccuracy")) {
                this.scopedAccuracy = heroData.substring(heroData.indexOf("scopedAccuracy"),
                        heroData.indexOf(",", heroData.indexOf("scopedAccuracy")));
            }else {
                this.scopedAccuracy = "scopedAccuracy = N/A";
            }

            if (heroData.contains("criticalHitsAccuracy")) {
                this.criticalHitsAccuracy = heroData.substring(heroData.indexOf("criticalHitsAccuracy"),
                        heroData.indexOf(",", heroData.indexOf("criticalHitsAccuracy")));
            }else {
                this.criticalHitsAccuracy = "criticalHitsAccuracy = N/A";
            }

            if (heroData.contains("eliminationsPerLife")) {
                this.eliminationsPerLife = heroData.substring(heroData.indexOf("eliminationsPerLife"),
                        heroData.indexOf(",", heroData.indexOf("eliminationsPerLife")));
            }else {
                this.eliminationsPerLife = "eliminationsPerLife = N/A";
            }

            if (heroData.contains("gamesWon")) {
                this.gamesWon = heroData.substring(heroData.indexOf("gamesWon"),
                        heroData.indexOf(",", heroData.indexOf("gamesWon")));
            }else {
                this.gamesWon = "gamesWon = N/A";
            }

            if (heroData.contains("winPercentage")) {
                this.winPercentage = heroData.substring(heroData.indexOf("winPercentage"),
                        heroData.indexOf("}", heroData.indexOf("winPercentage")) - 1);
            }else {
                this.winPercentage = "winPercentage = N/A";
            }

            this.timePlayed = heroData.substring(heroData.indexOf("timePlayed"),
                    heroData.indexOf(", ", heroData.indexOf("timePlayed"))).replace("}", "");
        }

    }
    private final String heroName;
    private final String weaponAccuracy;
    private final String scopedAccuracy;
    private final String criticalHitAccuracy;
    private final String eliminationsPerLife;
    private final String gamesWon;
    private final String winPercentage;
    private final String timePlayed;

    public Hero(Builder builder) {
        this.heroName = builder.heroName;
        this.weaponAccuracy = builder.weaponAccuracy;
        this.scopedAccuracy = builder.scopedAccuracy;
        this.criticalHitAccuracy = builder.criticalHitsAccuracy;
        this.eliminationsPerLife = builder.eliminationsPerLife;
        this.gamesWon = builder.gamesWon;
        this.winPercentage = builder.winPercentage;
        this.timePlayed = builder.timePlayed;
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

    public String accessScopedAccuracy() {
        return scopedAccuracy;
    }

    public String accessCriticalHitAccuracy() {
        return criticalHitAccuracy;
    }

    public String accessTimePlayed() {
        return timePlayed;
    }
}