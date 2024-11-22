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

    //增
    void addCategory(String name);

    //删
    void delCategory(Integer id);

    //改
    void update(Category category);

    List<Link> findLinkByCategoryName(String categoryName);

    //模糊搜索分类
    List<Category> searchCategory(String categoryName);

    //根据名字查询分类
    Category findCategoryByName(String name);
}
