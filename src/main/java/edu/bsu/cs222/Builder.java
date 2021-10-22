package edu.bsu.cs222;

public class Builder {
    private final Parser parser = new Parser();
    private String dataStream;
    public String playerName, playerIcon, skillRating, ratingIcon,
            level, prestige, totalQuickPlayGames, totalQuickPlayWins;

    public Player build(String dataStream){
        this.dataStream = dataStream;
        return (withPlayerData()
                .withPlayerRatingInfo()
                .withPlayerLevel().
                withQuickPlayGameData());
    }

    private Builder withPlayerData(){
        this.playerName = parser.accessUsername(dataStream);
        this.playerIcon = parser.accessPlayerIcon(dataStream);
        return this;
    }

    private Builder withPlayerRatingInfo(){
        this.skillRating = parser.accessSkillRating(dataStream);
        this.ratingIcon = parser.accessRatingIcon(dataStream);
        return this;
    }

    private Builder withPlayerLevel(){
        this.level = parser.accessLevel(dataStream);
        this.prestige = parser.accessPrestige(dataStream);
        return this;
    }

    private Player withQuickPlayGameData(){
        this.totalQuickPlayGames = parser.accessTotalQuickPlayGames(dataStream);
        this.totalQuickPlayWins = parser.accessTotalQuickPlayWins(dataStream);
        return new Player(this);
    }
}