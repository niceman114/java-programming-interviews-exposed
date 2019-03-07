package com.wiley.javainterviewsexposed.chapter15;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class JsonMarshalling {

    @Test
    public void readJson() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final String json =
                "/com/wiley/javainterviewsexposed/chapter15/team.json";
        final Team team = mapper.readValue(
                getClass().getResourceAsStream(json),
                Team.class);

        assertEquals(2, team.getPlayers().size());
    }

    @Test
    public void writeJson() throws IOException {
        final Player p1 = new Player();
        p1.setName("Louise Mills");
        p1.setPosition("Coach");

        final Player p2 = new Player();
        p2.setName("Liam Turner");
        p2.setPosition("Attack");

        final Team team = new Team();
        team.setPlayers(Arrays.asList(p1, p2));

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("/tmp/newteam"), team);

    }
}
