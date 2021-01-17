package org.example.kursweb.Service;

import org.example.kursweb.Models.MainUser;
import org.example.kursweb.dao.MainUserDao;
import org.example.kursweb.dao.OwnersDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MainUserService {

    @Autowired
    MainUserDao mainUserDao;

    public MainUser getByLogin(String login)
    {
        return mainUserDao.getByLogin(login);
    }
}
