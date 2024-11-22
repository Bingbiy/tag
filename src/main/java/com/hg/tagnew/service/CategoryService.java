package com.hg.tagnew.service;

import com.github.pagehelper.PageInfo;
import com.hg.tagnew.common.Result;
import com.hg.tagnew.pojo.entity.Category;
import com.hg.tagnew.pojo.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * Date 2024/10/27 14:11
 * Author Yu
 * Description
 */
public interface CategoryService {
    List<Category> findAll();

    void addCategory(String name);

    void delCategory(Integer id);

    void update(Category category);

    //根据分类名称查询分类下的链接
    Map findLinkByCategoryName(String categoryName);

    PageInfo<Category> findAllByPage(Integer pageNum, Integer pageSize);

    //搜索分类
    List<Category> searchCategory(String categoryName);

    //根据分类名称查询分类
    Category findCategoryByName(String name);
}
