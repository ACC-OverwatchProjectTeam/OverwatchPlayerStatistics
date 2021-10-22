package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataFormatterTest {
    DataFormatter dataFormatter = new DataFormatter();

    @Test
    public void testFormatRank(){
        Assertions.assertEquals("Platinum", dataFormatter.formatRank("2785"));
    }

    @Test
    public void testConvertStringToInteger(){
        String stringNumber = "123455677";
        Assertions.assertEquals(123455677, dataFormatter.convertStringToInteger(stringNumber));
    }
}
