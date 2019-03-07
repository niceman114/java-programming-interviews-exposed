package com.wiley.javainterviewsexposed.chapter15;

import com.wiley.javainterviewsexposed.chapter15.generated.Team;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class XmlSchema1 {

    @Test
    public void useJaxbObject() {
        final Team team = new Team();
        team.setName("Superstars");

        final Team.Players players = new Team.Players();

        final Team.Players.Player p1 = new Team.Players.Player();
        p1.setName("Lucy Jones");
        p1.setPosition("Striker");

        final Team.Players.Player p2 = new Team.Players.Player();
        p2.setName("Becky Simpson");
        p2.setPosition("Midfield");
        players.getPlayer().add(p1);
        players.getPlayer().add(p2);

        team.setPlayers(players);

        final String position = team
                .getPlayers()
                .getPlayer()
                .get(0)
                .getPosition();

        assertEquals("Striker", position);
    }
}
