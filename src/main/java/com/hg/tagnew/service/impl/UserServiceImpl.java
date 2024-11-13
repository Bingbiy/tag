package com.hg.tagnew.service.impl;

import com.hg.tagnew.dao.UserDao;
import com.hg.tagnew.pojo.entity.Menu;
import com.hg.tagnew.pojo.entity.User;
import com.hg.tagnew.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date 2024/10/20 0:16
 * Author Yu
 * Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public User login(String username) {
        return userDao.login(username);
    }

    @Override
    public List<Menu> getMenuName() {
        return userDao.getMemuName();
    }
}
