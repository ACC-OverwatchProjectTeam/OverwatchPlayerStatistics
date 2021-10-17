package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ParserTest {
    @Test
    public void testAccessUsername() throws IOException {
        InputStream testData = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.json");
        Parser parser = new Parser();
        Assertions.assertEquals("Loupine#1170", parser.accessUsername(testData));
    }
}
