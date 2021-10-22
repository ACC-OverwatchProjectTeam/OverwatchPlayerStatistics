package edu.bsu.cs222;

public class Player {
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
