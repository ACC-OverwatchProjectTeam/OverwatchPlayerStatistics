package edu.bsu.cs.Model;

public class DataFormatter {

    public String formatSkillRatingAsRankName (int skillRating) {
       Rank rank;

        if (skillRating > 3999) {
            rank = Rank.Grandmaster;
            return new RankModifier(rank).accessRankName();
        } else if (skillRating > 3499) {
            rank = Rank.Master;
            return new RankModifier(rank).accessRankName();
        } else if (skillRating > 2999) {
            rank = Rank.Diamond;
            return new RankModifier(rank).accessRankName();
        } else if (skillRating > 2499) {
            rank = Rank.Platinum;
            return new RankModifier(rank).accessRankName();
        } else if (skillRating > 1999) {
            rank = Rank.Gold;
            return new RankModifier(rank).accessRankName();
        } else if (skillRating > 1499) {
            rank = Rank.Silver;
            return new RankModifier(rank).accessRankName();
        } else {
            rank = Rank.Bronze;
            return new RankModifier(rank).accessRankName();
        }
    }

    public enum Rank {Grandmaster, Master, Diamond, Platinum, Gold, Silver, Bronze}

    public static class RankModifier {
        Rank rank;

        public RankModifier(Rank rank) {
            this.rank = rank;
        }

        public String accessRankName() {
            String rankName = null;
            switch (rank) {
                case Grandmaster -> rankName = "Grandmaster";
                case Master -> rankName = "Master";
                case Diamond -> rankName = "Diamond";
                case Platinum -> rankName = "Platinum";
                case Gold -> rankName = "Gold";
                case Silver -> rankName = "Silver";
                case Bronze -> rankName = "Bronze";
            }
            return rankName;
        }
    }
}