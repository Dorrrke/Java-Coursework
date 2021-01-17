package org.example.kursweb.dao;

import org.example.kursweb.Mappers.MainUserMapper;
import org.example.kursweb.Mappers.OwnersMapper;
import org.example.kursweb.Models.MainUser;
import org.example.kursweb.Models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainUserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public MainUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MainUser getByLogin(String login)
    {
        String sql = "SELECT * FROM main_user WHERE main_user.login = ?";

        return jdbcTemplate.queryForObject(sql, new MainUserMapper(), login);
    }
}
