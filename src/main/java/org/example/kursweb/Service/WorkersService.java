package org.example.kursweb.Service;

import org.example.kursweb.Mappers.WorkersMapper;
import org.example.kursweb.Models.Worker;
import org.example.kursweb.dao.WorkersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkersService {

    @Autowired
    WorkersDao workersDao;

    public List<Worker> findAll()
    {
        return workersDao.findAll();
    }

    public void save(Worker worker)
    {
        workersDao.save(worker);
    }

    public Worker getById(int id)
    {
        return workersDao.getById(id);
    }

    public Worker getByLogin(String login)
    {
        return workersDao.getByLogin(login);
    }

    public List<Worker> getByOwner(int id) { return workersDao.getByOwner(id); }

    public Worker getByName(String name) { return workersDao.getByName(name); }

    public void update (Worker worker)
    {
        workersDao.update(worker);
    }

    public void delete (int id)
    {
        workersDao.delete(id);
    }

}
