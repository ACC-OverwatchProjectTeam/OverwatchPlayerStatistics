package edu.bsu.cs222;

public class SearchQuery {
    public String createURLFromSearchQuery(String searchQuery) {
        return String.format("https://ow-api.com/v1/stats/pc/us/%s/complete", searchQuery.replace('#', '-'));
    }
}