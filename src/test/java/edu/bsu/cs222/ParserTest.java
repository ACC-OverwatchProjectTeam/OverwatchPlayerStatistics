package edu.bsu.cs222;

import com.google.common.io.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ParserTest {
    private final String testData = Resources.toString(Resources.getResource("LoupineData.txt"), StandardCharsets.UTF_8);
    private final Parser parser = new Parser();

    public ParserTest() throws IOException {
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
