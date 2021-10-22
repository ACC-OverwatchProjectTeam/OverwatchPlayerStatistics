package edu.bsu.cs222;

public class Builder {
    private Parser parser;
    public String playerName, playerIcon, skillRating, ratingIcon,
            level, prestige, totalQuickPlayGames, totalQuickPlayWins;

    public Player build(String dataStream){
        this.parser = new Parser(dataStream);

        return (withPlayerData()
                .withPlayerRatingInfo()
                .withPlayerLevel().
                withQuickPlayGameData());
    }

    private Builder withPlayerData(){
        this.playerName = parser.accessUsername();
        this.playerIcon = parser.accessPlayerIcon();
        return this;
    }

    private Builder withPlayerRatingInfo(){
        this.skillRating = parser.accessSkillRating();
        this.ratingIcon = parser.accessRatingIcon();
        return this;
    }

    private Builder withPlayerLevel(){
        this.level = parser.accessLevel();
        this.prestige = parser.accessPrestige();
        return this;
    }

    private Player withQuickPlayGameData(){
        this.totalQuickPlayGames = parser.accessTotalQuickPlayGames();
        this.totalQuickPlayWins = parser.accessTotalQuickPlayWins();
        return new Player(this);
    }
}