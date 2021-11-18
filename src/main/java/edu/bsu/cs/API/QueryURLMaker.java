package edu.bsu.cs.API;

import edu.bsu.cs.API.QueryEngine;

import java.io.IOException;
import java.net.URISyntaxException;

public class QueryURLMaker {
    public String createURLFromSearchQuery(String searchQuery) throws URISyntaxException, IOException, InterruptedException {
        String queryURL = String.format(
                "https://ow-api.com/v1/stats/pc/us/%s/complete",
                searchQuery.replace('#', '-'));

        QueryEngine engine = new QueryEngine();
        return engine.sendHTTPRequest(queryURL);
    }
}