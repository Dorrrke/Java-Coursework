package org.example.kursweb.Mappers;

import org.example.kursweb.Models.Owner;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.Service.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkersMapper implements RowMapper<Worker> {
    @Autowired
    OwnersService ownersService;

    @Override
    public Worker mapRow(ResultSet resultSet, int i) throws SQLException {
        Worker worker = new Worker();
        worker.setId(resultSet.getInt("id"));
        worker.setName(resultSet.getString("name"));
        worker.setLogin(resultSet.getString("login"));
        worker.setPass(resultSet.getString("pass"));
        worker.setPhone_number((resultSet.getString("number")));
        worker.setEmployer(resultSet.getString("employer_id"));
        return worker;
    }
}
