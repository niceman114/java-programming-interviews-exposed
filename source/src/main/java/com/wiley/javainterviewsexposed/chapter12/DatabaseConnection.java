package com.wiley.javainterviewsexposed.chapter12;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DatabaseConnection {

    private Connection conn;

    @Test
    public void connectToDb() throws SQLException {
        final Connection connection = DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3306/company_db",
                        "nm",
                        "password");
        assertFalse(connection.isClosed());
        connection.close();
        assertTrue(connection.isClosed());
    }

    @Test
    public void retrieveRows() throws SQLException {
        final Statement stmt = conn.createStatement();
        final ResultSet rs = stmt.executeQuery(
                "select employee_number, name from employees");

        final Map<Integer, String> employeeMap = new HashMap<>();

        while (rs.next()) {
            final int employeeNumber = rs.getInt("employee_number");
            final String name = rs.getString("name");
            employeeMap.put(employeeNumber, name);
        }

        final Map<Integer, String> expectedMap = new HashMap<Integer, String>() {{
            put(1, "Bob Smith");
            put(2, "Alice Smith");
        }};

        assertEquals(expectedMap, employeeMap);

        rs.close();
        stmt.close();
    }

    @Test
    public void queryParameters() throws SQLException {
        final PreparedStatement pStmt = conn.prepareStatement(
                "insert into office_locations values (?, ?, ?, NULL)");

        final Map<String, String> locations = new HashMap<String, String>() {{
            put("London", "Picadilly Square");
            put("New York", "Union Plaza");
            put("Paris", "Revolution Place");
        }};

        int i = 1;
        for (String location : locations.keySet()) {
            pStmt.setInt(1, i);
            pStmt.setString(2, location);
            pStmt.setString(3, locations.get(location));
            pStmt.execute();
            i++;
        }

        pStmt.close();

        final Statement stmt = conn.createStatement();
        final ResultSet rs = stmt.executeQuery(
                "select count(*) from office_locations " +
                "where location_name in ('London', 'New York', 'Paris')");
        assertTrue(rs.next());
        assertEquals(3, rs.getInt(1));

        rs.close();
        stmt.close();
    }

    @Test
    public void callStoredProc() throws SQLException {
        final CallableStatement stmt = conn.prepareCall("{call ANNUAL_SALARY_RAISE(?, ?)}");
        stmt.setInt(1, 4);
        stmt.registerOutParameter(2, Types.INTEGER);

        stmt.execute();

        int updatedEmployees = stmt.getInt(2);
        assertEquals(1, updatedEmployees);
    }

    @Test
    public void connectionPools() throws SQLException {
        final ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/company_db");
        cpds.setUser("nm");
        cpds.setPassword("password");

        final Connection conn = cpds.getConnection();
        final Statement stmt = conn.createStatement();
        final ResultSet rs = stmt.executeQuery(
                "select count(*) from office_locations " +
                "where location_name in ('London', 'New York', 'Paris')");
        assertTrue(rs.next());
        assertEquals(3, rs.getInt(1));

        DataSources.destroy(cpds);
    }

    @Test
    public void connectToH2() throws SQLException {
        final Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:test;MODE=MySQL", "nm", "password");
        final Statement stmt = conn.createStatement();
        stmt.executeUpdate("create table teams (id INTEGER, name VARCHAR(100))");
        stmt.executeUpdate("insert into teams values (1, 'Red Team')");
        stmt.executeUpdate("insert into teams values (2, 'Blue Team')");
        stmt.executeUpdate("insert into teams values (3, 'Green Team')");

        final ResultSet rs = stmt.executeQuery("select count(*) from teams");
        assertTrue(rs.next());
        assertEquals(3, rs.getInt(1));
    }
}
