package edu.bsu.cs.Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static final class Builder {
        private String playerName;
        private String playerIcon;
        private boolean privacySetting;
        private int averageSkillRating;
        private int tankRating;
        private int damageRating;
        private int supportRating;
        private String ratingIcon;
        private int level;
        private int prestige;
        private List<Hero> quickPlayHeroes;
        private int totalQuickPlayGames;
        private int totalQuickPlayWins;
        private int totalCompetitiveGames;
        private int totalCompetitiveWins;
        private List<Hero> competitiveHeroes;
        private Parser parser;
        HeroListFactory heroListMaker;
        private List<String> ratingList;

        public Builder parserSetup(String dataStream) {
            this.parser = new Parser(dataStream);
            return this;
        }

        public Builder withPlayerData() {
            this.playerName = parser.accessUsername();
            this.playerIcon = parser.accessPlayerIcon();
            return this;
        }

        public Boolean accessPrivacyStatus() {
            return parser.accessPrivateStatus();
        }

        public Builder withPrivacyStatus() {
            this.privacySetting = parser.accessPrivateStatus();
            return this;
        }

        public Builder withPlayerRatingInfo() {
            this.averageSkillRating = parser.accessSkillRating();
            this.ratingIcon = parser.accessRatingIcon();
            List<String> rankData = parser.accessRoleRating();
            this.tankRating = Integer.parseInt(rankData.get(0));
            this.damageRating = Integer.parseInt(rankData.get(1));
            this.supportRating = Integer.parseInt(rankData.get(2));
            return this;
        }



        public Builder withPlayerLevel() {
            this.level = parser.accessLevel();
            this.prestige = parser.accessPrestige();
            return this;
        }

        public Builder withCompetitiveGameData() {
            this.totalCompetitiveGames = parser.accessTotalCompetitiveGames();
            this.totalCompetitiveWins = parser.accessTotalCompetitiveWins();
            return this;
        }

        public Builder withCompetitiveHeroes() {
            this.heroListMaker = new HeroListFactory(parser);
            this.competitiveHeroes = heroListMaker.accessCompetitiveHeroList();
            return this;
        }

        public Builder withQuickPlayGameData() {
            this.totalQuickPlayGames = parser.accessTotalQuickPlayGames();
            this.totalQuickPlayWins = parser.accessTotalQuickPlayWins();
            return this;
        }

        public Builder withQuickPlayHeroes() {
            this.quickPlayHeroes = heroListMaker.accessQuickPlayHeroList();
            return this;
        }

        public Player returnPlayer() {
            return new Player(this);
        }
    }

    private final String playerName;
    private final String playerIcon;
    private final boolean privacySetting;
    private final int skillRating;
    private final String ratingIcon;
    private final List<String> ratingList;
    private final int level;
    private final int prestige;
    private final List<Hero> quickPlayHeroes;
    private final int totalQuickPlayGames;
    private final int totalQuickPlayWins;
    private final List<Hero> competitiveHeroes;
    private final int totalCompetitiveGames;
    private final int totalCompetitiveWins;

    public Player(Builder builder) {
        this.playerName = builder.playerName;
        this.playerIcon = builder.playerIcon;
        this.privacySetting = builder.privacySetting;
        this.skillRating = builder.averageSkillRating;
        this.ratingList = builder.ratingList;
        this.ratingIcon = builder.ratingIcon;
        this.level = builder.level;
        this.prestige = builder.prestige;
        this.competitiveHeroes = builder.competitiveHeroes;
        this.totalCompetitiveGames = builder.totalCompetitiveGames;
        this.totalCompetitiveWins = builder.totalCompetitiveWins;
        this.quickPlayHeroes = builder.quickPlayHeroes;
        this.totalQuickPlayGames = builder.totalQuickPlayGames;
        this.totalQuickPlayWins = builder.totalQuickPlayWins;
    }

    public String accessPlayerName() {
        return playerName;
    }

    public String accessPlayerIcon() {
        return playerIcon;
    }

    public Boolean accessPrivacySetting() {
        return privacySetting;
    }

    public int accessSkillRating() {
        return skillRating;
    }

    public String accessRatingIcon() {
        return ratingIcon;
    }

    public List<String> accessRatingList() {return ratingList;}

    public int accessLevel() {
        return level;
    }

    public int accessPrestige() {
        return prestige;
    }

    public List<Hero> accessQuickPlayHeroes() {
        return List.copyOf(quickPlayHeroes);
    }

    public int accessTotalQuickPlayGames() {
        return totalQuickPlayGames;
    }

    public int accessTotalQuickPlayWins() {
        return totalQuickPlayWins;
    }

    public List<Hero> accessCompetitiveHeroes() {
        return List.copyOf(competitiveHeroes);
    }

    public int accessTotalCompetitiveGames() {
        return totalCompetitiveGames;
    }

    public int accessTotalCompetitiveWins() {
        return totalCompetitiveWins;
    }
}