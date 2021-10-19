package edu.bsu.cs222;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryEngine {
    public String sendHTTPRequest(String queryURL) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(
                buildRequest(queryURL), HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private HttpRequest buildRequest(String queryURL) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(queryURL))
                .GET()
                .build();
    }
}

