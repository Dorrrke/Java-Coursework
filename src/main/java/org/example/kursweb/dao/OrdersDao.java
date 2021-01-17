package org.example.kursweb.dao;

import org.example.kursweb.Mappers.OrdersMapper;
import org.example.kursweb.Mappers.WorkersMapper;
import org.example.kursweb.Models.Order;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.Service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrdersDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> findAll()
    {
        String sql = "SELECT o.id, o.name, o.description, o.price, o.ready w.name FROM orders o LEFT JOIN workers w ON o.worker_id = w.id";
        return jdbcTemplate.query(sql, new OrdersMapper());
    }

    public List<Order> getByWorker(int id)
    {
        String sql = "SELECT * FROM orders WHERE worker_id = ?";
        return jdbcTemplate.query(sql, new OrdersMapper(), id);
    }

    public void save (Order order)
    {
        String sql = "INSERT INTO orders(id, name, description, price, ready, worker_id) VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), order.getName(), order.getDescription(), order.getPrice(), order.getReady(), order.getWorker_name());
    }

    public Order getById (int id)
    {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new OrdersMapper(), id);
    }

    public void update(Order order)
    {
        String sql = "UPDATE orders SET name ='" + order.getName() + "', description = '" + order.getDescription() + "', price = " + order.getPrice() +
                ", ready = "+ order.getReady() + ", worker_id = " + order.getWorker_name() + " WHERE id = " + order.getId();

        jdbcTemplate.update(sql);
    }

    public void delete(int id)
    {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
