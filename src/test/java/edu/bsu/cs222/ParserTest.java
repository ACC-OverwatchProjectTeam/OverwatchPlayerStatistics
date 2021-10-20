package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ParserTest {
    private final Parser parser = new Parser();
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.txt");
    private String testData;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);
        this.testData = byteArrayOutputStream.toString();
    }

    @Test
    public void testAccessUsername() {
        Assertions.assertEquals("Loupine#1170", parser.accessUsername(testData));
    }

    @Test
    public void testAccessSkillRating() {
        Assertions.assertEquals("2785", parser.accessSkillRating(testData));
    }
    
    @Test
    public void testAccessLevel() {
        Assertions.assertEquals("21", parser.accessLevel(testData));
    }
}
