DROP TABLE person_ticket;
DROP TABLE people;
DROP TABLE tickets;
DROP TABLE events;
DROP TABLE venues;

CREATE TABLE venues (
  id INTEGER PRIMARY KEY,
  venue_name VARCHAR(100),
  address VARCHAR(100)
);

CREATE TABLE events (
  id INTEGER PRIMARY KEY,
  venue_id INTEGER,
  event_name VARCHAR(100),
  event_date DATE
);

ALTER TABLE events
ADD FOREIGN KEY (venue_id)
REFERENCES venues(id);

CREATE TABLE tickets (
  id INTEGER PRIMARY KEY,
  event_id INTEGER
);

ALTER TABLE tickets
ADD FOREIGN KEY (event_id)
REFERENCES events(id);

CREATE TABLE people (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  address VARCHAR(100)
);

CREATE TABLE person_ticket (
  person_id INTEGER,
  ticket_id INTEGER,
  PRIMARY KEY (person_id, ticket_id)
);

ALTER TABLE person_ticket
ADD FOREIGN KEY (person_id)
REFERENCES people(id);

ALTER TABLE person_ticket
ADD FOREIGN KEY (ticket_id)
REFERENCES tickets(id);

--

INSERT INTO venues VALUES
  (1, "The Academy", "London"),
  (2, "Space Bowl", "Manchester"),
  (3, "The Ballroom", "Edinburgh"),
  (4, "The Castle", "York");

INSERT INTO events VALUES
  (1, 1, "The Super Six", DATE('2013-08-01')),
  (2, 1, "The Super Six", DATE('2013-08-02')),
  (3, 1, "The Super Six", DATE('2013-08-04')),
  (4, 3, "David Smith", DATE('2013-08-13')),
  (5, 4, "David Smith", DATE('2013-08-14')),
  (6, 2, "Funny Guys", DATE('2013-08-01'));

INSERT INTO people (name, address) VALUES
  ("Eric Twinge", "29, Acacia Avenue"),
  ("Dominic Taylor", "74A, High Road"),
  ("Alice Smith", "1, Pine Drive");

INSERT INTO tickets VALUES
  (1, 1),
  (2, 1),
  (3, 2),
  (4, 2),
  (5, 3),
  (6, 3),
  (7, 4),
  (8, 5),
  (9, 5),
  (10, 6);

INSERT INTO person_ticket VALUES
  (1, 1),
  (1, 7),
  (2, 4),
  (3, 10);

select * from events e, people p, tickets t, person_ticket pt, venues v
where e.id = t.event_id
and t.id = pt.ticket_id
and p.id = pt.person_id
and e.venue_id = v.id;

