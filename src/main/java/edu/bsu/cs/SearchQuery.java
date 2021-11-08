package edu.bsu.cs;

import java.io.IOException;
import java.net.URISyntaxException;

public class SearchQuery {
    public String createURLFromSearchQuery(String searchQuery) throws URISyntaxException, IOException, InterruptedException {
        String queryURL = String.format(
                "https://ow-api.com/v1/stats/pc/us/%s/complete",
                searchQuery.replace('#', '-'));

        QueryEngine engine = new QueryEngine();
        return engine.sendHTTPRequest(queryURL);
    }
}