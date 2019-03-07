package com.wiley.javainterviewsexposed.chapter15;

import com.wiley.javainterviewsexposed.chapter15.generated2.ObjectFactory;
import com.wiley.javainterviewsexposed.chapter15.generated2.Player;
import com.wiley.javainterviewsexposed.chapter15.generated2.Players;
import com.wiley.javainterviewsexposed.chapter15.generated2.Team;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;

public class Marshalling {

    @Test
    public void readXml() throws JAXBException {
        final JAXBContext context =
                JAXBContext.newInstance(
                        "com.wiley.javainterviewsexposed.chapter15.generated2");

        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final Team team = (Team) unmarshaller
                .unmarshal(getClass()
                        .getResourceAsStream("/src/main/xsd/teamSample.xml"));

        assertEquals(2, team.getPlayers().getPlayer().size());
    }


    @Test
    public void writeXml() throws JAXBException, FileNotFoundException {
        final ObjectFactory factory = new ObjectFactory();
        final Team team = factory.createTeam();
        final Players players = factory.createPlayers();
        final Player player = factory.createPlayer();
        player.setName("Simon Smith");
        player.setPosition("Substitute");
        players.getPlayer().add(player);

        team.setName("Megastars");
        team.setPlayers(players);

        final JAXBContext context =
                JAXBContext.newInstance(
                        "com.wiley.javainterviewsexposed.chapter15.generated2");

        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(team, new FileOutputStream("/tmp/team.xml"));
    }

}
