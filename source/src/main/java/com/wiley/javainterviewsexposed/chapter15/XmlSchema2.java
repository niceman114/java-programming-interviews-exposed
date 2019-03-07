package com.wiley.javainterviewsexposed.chapter15;

import com.wiley.javainterviewsexposed.chapter15.generated2.Player;
import com.wiley.javainterviewsexposed.chapter15.generated2.Players;
import com.wiley.javainterviewsexposed.chapter15.generated2.Team;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XmlSchema2 {

    @Test
    public void useTopLevelJaxbObjects() {
        final Team team = new Team();
        team.setName("Superstars");

        final Players players = new Players();

        final Player p1 = new Player();
        p1.setName("Lucy Jones");
        p1.setPosition("Striker");

        final Player p2 = new Player();
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
