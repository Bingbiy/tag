package com.hg.tagnew.dao;

import com.hg.tagnew.pojo.entity.Menu;
import com.hg.tagnew.pojo.entity.User;

import java.util.List;

/**
 * Date 2024/10/20 0:09
 * Author Yu
 * Description
 */


public interface UserDao {


    User login(String username);

    List<Menu> getMemuName();
}
