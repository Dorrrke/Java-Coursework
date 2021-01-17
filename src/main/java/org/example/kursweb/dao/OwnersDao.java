package org.example.kursweb.dao;

import org.example.kursweb.Mappers.OwnersMapper;
import org.example.kursweb.Models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OwnersDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OwnersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Owner> findAll()
    {
        String sql = "SELECT * FROM owners";
        return jdbcTemplate.query(sql, new OwnersMapper());
    }

    public void save(Owner owner)
    {
        String sql = "INSERT INTO owners(login, pass, name, company_name) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, owner.getLogin(), owner.getPass(), owner.getName(), owner.getCompany_name());
    }

    public Owner getById(int id)
    {
        String sql = "SELECT * FROM owners WHERE owners.id = ?";

        return jdbcTemplate.queryForObject(sql, new OwnersMapper(), id);
    }

    public Owner getByLogin(String login)
    {
        String sql = "SELECT * FROM owners WHERE owners.login = ?";

        return jdbcTemplate.queryForObject(sql, new OwnersMapper(), login);
    }

    public Owner getByName(String name)
    {
        String sql = "SELECT * FROM owners WHERE owners.name = ?";

        return jdbcTemplate.queryForObject(sql, new OwnersMapper(), name);
    }


}
