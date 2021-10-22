package edu.bsu.cs222;

public class Player {


    public static final class Builder {
        private String playerName, playerIcon, skillRating, ratingIcon,
                level, prestige, totalQuickPlayGames, totalQuickPlayWins;

        private final Parser parser = new Parser();

        public Builder withPlayerData(String dataStream){
            this.playerName = parser.accessUsername(dataStream);
            this.playerIcon = parser.accessPlayerIcon(dataStream);
            return this;
        }

        public Builder withPlayerRatingInfo(String dataStream){
            this.skillRating = parser.accessSkillRating(dataStream);
            this.ratingIcon = parser.accessRatingIcon(dataStream);
            return this;
        }

        public Builder withPlayerLevel(String dataStream){
            this.level = parser.accessLevel(dataStream);
            this.prestige = parser.accessPrestige(dataStream);
            return this;
        }

        public Player withQuickPlayGameData(String dataStream){
            this.totalQuickPlayGames = parser.accessTotalQuickPlayGames(dataStream);
            this.totalQuickPlayWins = parser.accessTotalQuickPlayWins(dataStream);
            return new Player(this);
        }

    }

    private final String playerName, playerIcon, skillRating, ratingIcon,
            level, prestige, totalQuickPlayGames, totalQuickPlayWins;

    public Player(Builder builder) {
        this.playerName = builder.playerName;
        this.playerIcon = builder.playerIcon;
        this.skillRating = builder.skillRating;
        this.ratingIcon = builder.ratingIcon;
        this.level = builder.level;
        this.prestige = builder.prestige;
        this.totalQuickPlayGames = builder.totalQuickPlayGames;
        this.totalQuickPlayWins = builder.totalQuickPlayWins;
    }

    public String accessPlayerName() {
        return playerName;
    }

    public String accessPlayerIcon() {
        return playerIcon;
    }

    public String accessSkillRating() {
        return skillRating;
    }

    public String accessRatingIcon() {
        return ratingIcon;
    }

    public String accessLevel() {
        return level;
    }

    public String accessPrestige() {
        return prestige;
    }

    public String accessTotalQuickPlayGames() {
        return totalQuickPlayGames;
    }

    public String accessTotalQuickPlayWins() {
        return totalQuickPlayWins;
    }
}
