package com.wiley.javainterviewsexposed.chapter17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unchecked") // Hibernate queries aren't parameterized
public class HibernateConnection {

    private SessionFactory sessionFactory;

    final Set<Ticket> ericTickets = new HashSet<Ticket>(2) {{
        add(new Ticket(1, new Event(1, 1, "The Super Six", new DateTime(2013, 8, 1, 0, 0).toDate())));
        add(new Ticket(7, new Event(4, 3, "David Smith", new DateTime(2013, 8, 13, 0, 0).toDate())));
    }};

    final Set<Ticket> dominicTickets = new HashSet<Ticket>(1) {{
        add(new Ticket(4,
                new Event(
                        2,
                        1,
                        "The Super Six",
                        new DateTime(2013, 8, 1, 0, 0).toDate())));
    }};

    final Set<Ticket> aliceTickets = new HashSet<Ticket>(1) {{
        add(new Ticket(10, new Event(6, 1, "Funny Guys", new DateTime(2013, 8, 1, 0, 0).toDate())));
    }};

    @Before
    public void buildSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void retrievePeople() {
        final SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();

        final Session session = sessionFactory.openSession();
        final List<Person> actual = session
                .createQuery("from Person")
                .list();

        final List<Person> expected = Arrays.asList(
          new Person(1, "Eric Twinge", "29, Acacia Avenue", ericTickets),
          new Person(2, "Dominic Taylor", "74A, High Road", dominicTickets),
          new Person(3, "Alice Smith", "1, Pine Drive", aliceTickets));

        assertEquals(expected, actual);
    }

    @Test
    public void storePerson() throws SQLException {
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        final Person newPerson =
                new Person(4, "Bruce Wayne", "Gotham City", new HashSet<Ticket>());
        session.save(newPerson);
        transaction.commit();

        final Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ticketoffice",
                "nm",
                "password");

        final Statement stmt = conn.createStatement();

        final ResultSet rs = stmt.executeQuery(
                "select name from people where id = 4");
        assertTrue(rs.next());
        assertEquals("Bruce Wayne", rs.getString(1));

        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void hqlSinglePerson() {
        final Session session = sessionFactory.openSession();
        final List<Person> singleUser = session
                .createQuery("from Person where name like 'Dominic%'")
                .list();
        assertEquals(1, singleUser.size());
    }

    @Test
    public void hqlSpecificTickets() {
        final Session session = sessionFactory.openSession();
        final List<Ticket> actual = session.createQuery("" +
                "select person.tickets " +
                "from Person person " +
                "where person.name = 'Eric Twinge'").list();

        assertEquals(2, actual.size());
    }

    @Test
    public void hqlVenuesForPerson() {
        final Session session = sessionFactory.openSession();
        final List actual = session.createQuery("" +
                "select event.eventName " +
                "from Person person " +
                "inner join person.tickets as tickets " +
                "inner join tickets.event as event " +
                "where person.name = 'Eric Twinge'").list();

        assertEquals(Arrays.asList("The Super Six", "David Smith"), actual);
    }

    @Test
    public void lazyLoading() {
        final SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();

        final Session session = sessionFactory.openSession();
        Event.constructedInstances.set(0);
        final Person person = (Person) session.createQuery("" +
                "select person " +
                "from Person person " +
                "where person.name = 'Eric Twinge'").uniqueResult();

        System.out.println("Person name: " + person.getName());

        assertEquals(0, Event.constructedInstances.get());

        final Set<Ticket> tickets = person.getTickets();

        for (Ticket ticket : tickets) {
            System.out.println("Ticket ID: " + ticket.getId());
            System.out.println("Event: " + ticket.getEvent());
        }

        assertEquals(2, Event.constructedInstances.get());

    }

}
