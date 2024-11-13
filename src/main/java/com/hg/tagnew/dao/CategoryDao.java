package com.hg.tagnew.dao;

import com.hg.tagnew.pojo.entity.Category;
import com.hg.tagnew.pojo.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * Date 2024/10/27 14:14
 * Author Yu
 * Description
 */


public interface CategoryDao {

    //查 分页查询
    List<Category> findAll();

    void addCategory(String name);

    void delCategory(Integer id);

    void update(Category category);

    List<Link> findLinkByCategoryName(String categoryName);


    //增

    //删

    //改



}
