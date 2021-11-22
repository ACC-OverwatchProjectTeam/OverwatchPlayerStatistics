package edu.bsu.cs;

import edu.bsu.cs.Model.DataFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataFormatterTest {
    DataFormatter dataFormatter = new DataFormatter();

    @Test
    public void testReturnBronzeRankName() {
        Assertions.assertEquals("Bronze", dataFormatter.formatSkillRatingAsRankName("1000"));
    }

    @Test
    public void testReturnSilverRankName() {
        Assertions.assertEquals("Silver", dataFormatter.formatSkillRatingAsRankName("1500"));
    }

    @Test
    public void testReturnGoldRankName() {
        Assertions.assertEquals("Gold", dataFormatter.formatSkillRatingAsRankName("2000"));
    }

    @Test
    public void testReturnPlatinumRankName() {
        Assertions.assertEquals("Platinum", dataFormatter.formatSkillRatingAsRankName("2785"));
    }

    @Test
    public void testAccessDiamondRankName() {
        Assertions.assertEquals("Diamond", dataFormatter.formatSkillRatingAsRankName("3000"));
    }

    @Test
    public void testAccessMasterRankName() {
        Assertions.assertEquals("Master", dataFormatter.formatSkillRatingAsRankName("3500"));
    }

    @Test
    public void testAccessGrandmasterRank() {
        Assertions.assertEquals("Grandmaster", dataFormatter.formatSkillRatingAsRankName("4000"));
    }
}
