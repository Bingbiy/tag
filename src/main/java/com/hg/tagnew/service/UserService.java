package com.hg.tagnew.service;

import com.hg.tagnew.pojo.entity.Menu;
import com.hg.tagnew.pojo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date 2024/10/20 0:08
 * Author Yu
 * Description
 */

public interface UserService {

    User login( String username);


    List<Menu> getMenuName();
}
