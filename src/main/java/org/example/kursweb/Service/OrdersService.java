package org.example.kursweb.Service;

import org.example.kursweb.Mappers.OrdersMapper;
import org.example.kursweb.Models.Order;
import org.example.kursweb.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersDao ordersDao;

    public List<Order> findAll()
    {
        return ordersDao.findAll();
    }

    public List<Order> getByWorker(int id) {
        return ordersDao.getByWorker(id);
    }

    public void save (Order order)
    {
        ordersDao.save(order);
    }

    public Order getById (int id) { return ordersDao.getById(id); }

    public void update(Order order)
    {
        ordersDao.update(order);
    }

    public void delete(int id)
    {
        ordersDao.delete(id);
    }
}
