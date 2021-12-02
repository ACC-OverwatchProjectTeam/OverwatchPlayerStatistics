package edu.bsu.cs.Model;

public class DataFormatter {

    public String formatSkillRatingAsRankName (String skillRating) {
        int rank = Integer.parseInt(skillRating);
        Rank rank1;

        if (rank > 3999) {
            rank1 = Rank.Grandmaster;
            return new RankTest(rank1).RankSet();
        } else if (rank > 3499) {
            rank1 = Rank.Master;
            return new RankTest(rank1).RankSet();
        } else if (rank > 2999) {
            rank1 = Rank.Diamond;
            return new RankTest(rank1).RankSet();
        } else if (rank > 2499) {
            rank1 = Rank.Platinum;
            return new RankTest(rank1).RankSet();
        } else if (rank > 1999) {
            rank1 = Rank.Gold;
            return new RankTest(rank1).RankSet();
        } else if (rank > 1499) {
            rank1 = Rank.Silver;
            return new RankTest(rank1).RankSet();
        } else {
            rank1 = Rank.Bronze;
            return new RankTest(rank1).RankSet();
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