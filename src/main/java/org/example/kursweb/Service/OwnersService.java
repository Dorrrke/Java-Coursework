package org.example.kursweb.Service;

import org.example.kursweb.Mappers.OwnersMapper;
import org.example.kursweb.Models.Owner;
import org.example.kursweb.dao.OwnersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnersService {

    @Autowired
    OwnersDao ownersDao;

    public List<Owner> findAll()
    {
        return ownersDao.findAll();
    }

    public void save(Owner owner)
    {
        ownersDao.save(owner);
    }

    public Owner getByLogin(String login)
    {
        return ownersDao.getByLogin(login);
    }

    public Owner getById(int id)
    {
        return ownersDao.getById(id);
    }

    public Owner getByName(String name)
    {
        return ownersDao.getByName(name);
    }
}
