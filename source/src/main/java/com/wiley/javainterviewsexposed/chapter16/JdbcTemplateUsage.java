package com.wiley.javainterviewsexposed.chapter16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        "classpath:com/wiley/javainterviewsexposed/chapter16/jdbcTemplateContext.xml")
public class JdbcTemplateUsage {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void retrieveData() {
        final int rowCount =
                jdbcTemplate.queryForInt("select count(*) from user");

        final List<User> userList = jdbcTemplate.query(
                "select id, username from user",
                new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getString("id"), rs.getString("username"));
            }
        });

        assertEquals(rowCount, userList.size());
    }

}
