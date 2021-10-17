package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataFormatterTest {
    @Test
    public void testFormatRank(){
        DataFormatter dataFormatter = new DataFormatter();
        Assertions.assertEquals("Platinum", dataFormatter.formatRank("2785"));
    }
}
