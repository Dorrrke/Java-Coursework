package org.example.kursweb.Mappers;

import org.example.kursweb.Models.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnersMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
        Owner owner = new Owner();
        owner.setId(resultSet.getInt("id"));
        owner.setLogin(resultSet.getString("login"));
        owner.setPass(resultSet.getString("pass"));
        owner.setName(resultSet.getString("name"));
        owner.setCompany_name(resultSet.getString("company_name"));

        return owner;
    }
}
