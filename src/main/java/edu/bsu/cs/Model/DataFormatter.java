package edu.bsu.cs.Model;

public class DataFormatter {

    public String formatSkillRatingAsRankName (int skillRating) {
       Rank rank;

        if (skillRating > 3999) {
            rank = Rank.Grandmaster;
            return new RankTest(rank).RankSet();
        } else if (skillRating > 3499) {
            rank = Rank.Master;
            return new RankTest(rank).RankSet();
        } else if (skillRating > 2999) {
            rank = Rank.Diamond;
            return new RankTest(rank).RankSet();
        } else if (skillRating > 2499) {
            rank = Rank.Platinum;
            return new RankTest(rank).RankSet();
        } else if (skillRating > 1999) {
            rank = Rank.Gold;
            return new RankTest(rank).RankSet();
        } else if (skillRating > 1499) {
            rank = Rank.Silver;
            return new RankTest(rank).RankSet();
        } else {
            rank = Rank.Bronze;
            return new RankTest(rank).RankSet();
        }
    }

    public enum Rank {Grandmaster, Master, Diamond, Platinum, Gold, Silver, Bronze}

    public static class RankTest {
        Rank rank;

        public RankTest(Rank rank) {
            this.rank = rank;
        }

        public String RankSet() {
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