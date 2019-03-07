CREATE TABLE employees (
  employee_number INTEGER PRIMARY KEY,
  name VARCHAR(100),
  title VARCHAR(100),
  home_address VARCHAR(200),
  hire_date DATE,
  office_location_id INTEGER
);

create index office_loc_idx on employees (office_location_id);

INSERT INTO employees VALUES (1, "Bob Smith", "CEO", "1, Pine Drive", DATE('2010-01-25'), 1);
INSERT INTO employees VALUES
 (2, "Alice Smith", "CTO", "1, Pine Drive", DATE('2010-01-25'), 1),
 (3, "Cassandra Williams", "Developer", "336, Cedar Court", DATE('2010-02-15'), 2),
 (4, "Dominic Taylor", "Receptionist", "74A, High Road", DATE('2011-01-12'), 2),
 (5, "Eric Twinge", "Developer", "29, Acacia Avenue", DATE('2012-07-29'), 1);

INSERT INTO employees (employee_number, name, title, office_location_id) VALUES (6, "Frank Roberts", "Developer", "2");

UPDATE employees set home_address = "37, King Street" where employee_number = 6;

DELETE FROM employees WHERE name = "Frank Roberts";


CREATE TABLE office_locations (
  office_location_id INTEGER PRIMARY KEY,
  location_name VARCHAR(200),
  address VARCHAR(200),
  lease_expiry_date DATE
);

insert into office_locations values
(1, "New York", "Union Plaza", NULL),
(2, "Paris", "Revolution Place", NULL),
(3, "London", "Piccadilly Square", DATE('2014-05-30'));



CREATE TABLE salaries (
  employee_number INTEGER,
  annual_salary INTEGER,
  last_update_date DATE
);

INSERT INTO salaries VALUES (1, 20000, CURDATE());
INSERT INTO salaries VALUES (2, 12000, CURDATE());
INSERT INTO salaries VALUES (3, 6000,  DATE_SUB(CURDATE(), INTERVAL 55 WEEK));
INSERT INTO salaries VALUES (4, 6000,  DATE_SUB(CURDATE(), INTERVAL 2 WEEK));
INSERT INTO salaries VALUES (5, 12000, DATE_SUB(CURDATE(), INTERVAL 5 WEEK));

CREATE VIEW employees_and_locations AS
SELECT employee_number, name, location_name, address
  FROM employees
  JOIN office_locations
    ON employees.office_location_id = office_locations.office_location_id;

CREATE TABLE meeting_rooms (
  meeting_room_id     INT,
  office_location_id  INT,
  meeting_room_name   VARCHAR(100)
);

ALTER TABLE meeting_rooms
ADD FOREIGN KEY (office_location_id)
REFERENCES office_locations(office_location_id);
