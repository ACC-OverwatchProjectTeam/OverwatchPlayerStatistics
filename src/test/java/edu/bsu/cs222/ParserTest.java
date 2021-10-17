package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ParserTest {
    private final Parser parser = new Parser();
    @Test
    public void testAccessUsername() throws IOException {
        InputStream testData = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.json");
        Assertions.assertEquals("Loupine#1170", parser.accessUsername(testData));
    }

    @Test
    public void testAccessSkillRating() throws IOException {
        InputStream testData = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.json");
        Assertions.assertEquals("2785", parser.accessSkillRating(testData));
    }
}
