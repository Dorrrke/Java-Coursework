package org.example.kursweb.dao;

import org.example.kursweb.Mappers.OwnersMapper;
import org.example.kursweb.Mappers.WorkersMapper;
import org.example.kursweb.Models.Owner;
import org.example.kursweb.Models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WorkersDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Worker> findAll()
    {
        String sql = "SELECT * FROM workers";
        return jdbcTemplate.query(sql, new WorkersMapper());
    }

    public void save(Worker worker)
    {
        String sql = "INSERT INTO workers( name, login, pass, number, employer_id) VALUES ( ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, worker.getName(), worker.getLogin(), worker.getPass(), worker.getPhone_number(), worker.getEmployer());
    }

    public Worker getById(int id)
    {
        String sql = "SELECT * FROM workers WHERE workers.id = ?";

        return jdbcTemplate.queryForObject(sql, new WorkersMapper(), id);
    }

    public List<Worker> getByOwner(int id)
    {
        String sql = "SELECT * FROM workers WHERE employer_id = ?";
        return jdbcTemplate.query(sql, new WorkersMapper(), id);
    }

    public Worker getByName(String name)
    {
        String sql = "SELECT * FROM workers WHERE workers.name = ?";

        return jdbcTemplate.queryForObject(sql, new WorkersMapper(), name);
    }

    public Worker getByLogin(String login)
    {
        String sql = "SELECT * FROM workers WHERE login = ?";
        return jdbcTemplate.queryForObject(sql, new WorkersMapper(), login);
    }

    public void update (Worker worker)
    {
        String sql = "UPDATE workers SET name = ?, login = ?, pass = ?, number = ?, employer_id = ? WHERE id = ?";

        jdbcTemplate.update(sql, worker.getName(), worker.getLogin(), worker.getPass(), worker.getPhone_number(), worker.getEmployer(), worker.getId());
    }

    public void delete (int id)
    {
        String sql = "DELETE FROM workers WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
