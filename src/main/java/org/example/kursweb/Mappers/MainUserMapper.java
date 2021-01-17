package org.example.kursweb.Mappers;

import org.example.kursweb.Models.MainUser;
import org.example.kursweb.Models.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainUserMapper implements RowMapper<MainUser> {


    @Override
    public MainUser mapRow(ResultSet resultSet, int i) throws SQLException {
        MainUser mainUser = new MainUser();
        mainUser.setLogin(resultSet.getString("login"));
        mainUser.setPass(resultSet.getString("pass"));
        return mainUser;
    }
}
