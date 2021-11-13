package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HeroListMakerTest {
    private final InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LoupineData.txt");
    private Parser parser;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        assert dataStream != null;
        dataStream.transferTo(byteArrayOutputStream);

        String testData = byteArrayOutputStream.toString();
        this.parser = new Parser(testData);
    }

    @Test
    public void testCreateCompetitiveHeroesList() {
        HeroListMaker heroListMaker = new HeroListMaker(parser);
        List<Hero> heroList = new ArrayList<>(heroListMaker.heroList);
        StringBuilder heroNames = new StringBuilder();
        for(Hero hero: heroList){
            heroNames.append(hero.accessHeroName());
        }
        Assertions.assertEquals("ashe cassidy hanzo reaper soldier76 symmetra tracer",
                heroNames.toString());
    }
}
