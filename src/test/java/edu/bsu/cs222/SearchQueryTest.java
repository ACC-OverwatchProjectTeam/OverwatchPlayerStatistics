package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchQueryTest {
    @Test
    public void testCreateURLFromSearchQuery() {
        SearchQuery searchQuery = new SearchQuery();
        Assertions.assertEquals("https://ow-api.com/v1/stats/pc/us/Loupine-1170/complete",
                searchQuery.createURLFromSearchQuery("Loupine#1170"));
    }
}
