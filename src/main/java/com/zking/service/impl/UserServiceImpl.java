package com.zking.service.impl;

import com.zking.dao.UserDao;
import com.zking.model.User;
import com.zking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserById(List<Integer> uids) {
        return userDao.getUserById(uids);
    }

    @Override
    public int delUserMoney(Integer uid, Double money) {
        return userDao.delUserMoney(uid,money);
    }

    @Override
    public User getByUid(Integer uid) {
        return userDao.getByUid(uid);
    }

    @Override
    public int cz(Integer uid, Double money) {
        return userDao.cz(uid,money);
    }

    @Override
    public int tx(Integer uid, Double money) {
        return userDao.tx(uid,money);
    }


}
