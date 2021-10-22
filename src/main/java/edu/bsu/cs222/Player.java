package edu.bsu.cs222;

public class Player {
    public static final class Builder {
        private String playerName;
        private String playerIcon;
        private String skillRating;
        private String ratingIcon;
        private String level;
        private String prestige;
        private String totalQuickPlayGames;
        private String totalQuickPlayWins;
        private Parser parser;

        public Builder parserSetup(String dataStream){
            this.parser = new Parser(dataStream);
            return this;
        }

        public Builder withPlayerData(){
            this.playerName = parser.accessUsername();
            this.playerIcon = parser.accessPlayerIcon();
            return this;
        }

        public Builder withPlayerRatingInfo(){
            this.skillRating = parser.accessSkillRating();
            this.ratingIcon = parser.accessRatingIcon();
            return this;
        }

        public Builder withPlayerLevel(){
            this.level = parser.accessLevel();
            this.prestige = parser.accessPrestige();
            return this;
        }

        public Player withQuickPlayGameData(){
            this.totalQuickPlayGames = parser.accessTotalQuickPlayGames();
            this.totalQuickPlayWins = parser.accessTotalQuickPlayWins();
            return new Player(this);
        }

    }

    private final String playerName;
    private final String playerIcon;
    private final String skillRating;
    private final String ratingIcon;
    private final String level;
    private final String prestige;
    private final String totalQuickPlayGames;
    private final String totalQuickPlayWins;

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
