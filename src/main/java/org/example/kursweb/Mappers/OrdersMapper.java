package org.example.kursweb.Mappers;

import org.example.kursweb.Models.Order;
import org.example.kursweb.Service.WorkersService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setName(resultSet.getString("name"));
        order.setDescription(resultSet.getString("description"));
        order.setPrice(resultSet.getDouble("price"));
        order.setReady(resultSet.getInt("ready"));
        order.setWorker_name(String.valueOf(resultSet.getInt("worker_id")));
        return order;
    }
}
