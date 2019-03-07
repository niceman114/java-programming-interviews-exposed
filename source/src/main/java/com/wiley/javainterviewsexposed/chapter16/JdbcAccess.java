package com.wiley.javainterviewsexposed.chapter16;

import org.junit.Test;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class JdbcAccess {

    @Test
    public void plainJdbcExample() {
        Connection conn = null;
        PreparedStatement insert = null;
        PreparedStatement query = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/springtrans?" +
                    "user=nm&" +
                    "password=password");

            insert = conn.prepareStatement("insert into user values (?, ?)");

            final List<String> users = Arrays.asList("Dave", "Erica", "Frankie");

            for (String user : users) {
                insert.setString(1, UUID.randomUUID().toString());
                insert.setString(2, user);

                insert.executeUpdate();
            }

            query = conn.prepareStatement("select count(*) from user");
            resultSet = query.executeQuery();

            if (!resultSet.next()) {
                fail("Unable to retrieve row count of user table");
            }

            final int rowCount = resultSet.getInt(1);

            assertTrue(rowCount >= users.size());
        } catch (ClassNotFoundException | SQLException e) {
            fail("Exception occurred in database access: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (query != null) {
                    query.close();
                }
                if (insert != null) {
                    insert.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                fail("Unable to close Database connection: " + e.getMessage());
            }
        }
    }

    @Test
    public void springJdbcExample() {
        Connection conn = null;
        PreparedStatement insert = null;
        PreparedStatement query = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springtrans?user=nm&password=password");

            insert = conn.prepareStatement("insert into user values (?, ?)");

            final List<String> users = Arrays.asList("Dave", "Erica", "Frankie");

            for (String user : users) {
                insert.setString(1, UUID.randomUUID().toString());
                insert.setString(2, user);

                insert.executeUpdate();
            }

            query = conn.prepareStatement("select count(*) from user");
            resultSet = query.executeQuery();

            if (!resultSet.next()) {
                fail("Unable to retrieve row count of user table");
            }

            final int rowCount = resultSet.getInt(1);

            assertTrue(rowCount >= users.size());

        } catch (ClassNotFoundException | SQLException e) {
            fail("Exception occurred in database access: " + e.getMessage());
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(query);
            JdbcUtils.closeStatement(insert);
            JdbcUtils.closeConnection(conn);
        }

    }

    @Test
    public void twr() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection("blah")) {

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
