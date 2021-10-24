package edu.bsu.cs222;

public class Player {
    public static final class Builder {
        private String playerName;
        private String playerIcon;
        private Integer skillRating;
        private String ratingIcon;
        private Integer level;
        private Integer prestige;
        private Integer totalQuickPlayGames;
        private Integer totalQuickPlayWins;
        private Integer totalCompetitiveGames;
        private Integer totalCompetitiveWins;
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

        public Builder withCompetitiveGameData(){
            this.totalCompetitiveGames = parser.accessTotalCompetitiveGames();
            this.totalCompetitiveWins = parser.accessTotalCompetitiveWins();
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
    private final Integer skillRating;
    private final String ratingIcon;
    private final Integer level;
    private final Integer prestige;
    private final Integer totalQuickPlayGames;
    private final Integer totalQuickPlayWins;
    private final Integer totalCompetitiveGames;
    private final Integer totalCompetitiveWins;

    public Player(Builder builder) {
        this.playerName = builder.playerName;
        this.playerIcon = builder.playerIcon;
        this.skillRating = builder.skillRating;
        this.ratingIcon = builder.ratingIcon;
        this.level = builder.level;
        this.prestige = builder.prestige;
        this.totalCompetitiveGames = builder.totalCompetitiveGames;
        this.totalCompetitiveWins = builder.totalCompetitiveWins;
        this.totalQuickPlayGames = builder.totalQuickPlayGames;
        this.totalQuickPlayWins = builder.totalQuickPlayWins;
    }

    public String accessPlayerName() {
        return playerName;
    }

    public String accessPlayerIcon() {
        return playerIcon;
    }

    public Integer accessSkillRating() {
        return skillRating;
    }

    public String accessRatingIcon() {
        return ratingIcon;
    }

    public Integer accessLevel() {
        return level;
    }

    public Integer accessPrestige() {
        return prestige;
    }

    public Integer accessTotalQuickPlayGames() {
        return totalQuickPlayGames;
    }

    public Integer accessTotalQuickPlayWins() {
        return totalQuickPlayWins;
    }

    public Integer accessTotalCompetitiveGames() {
        return totalCompetitiveGames;
    }

    public Integer accessTotalCompetitiveWins() {
        return totalCompetitiveWins;
    }
}
