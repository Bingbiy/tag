package com.hg.tagnew.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hg.tagnew.common.Result;
import com.hg.tagnew.common.ResultCodeEnum;
import com.hg.tagnew.dao.CategoryDao;
import com.hg.tagnew.pojo.entity.Category;
import com.hg.tagnew.pojo.entity.Link;
import com.hg.tagnew.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

/**
 * Date 2024/10/27 14:11
 * Author Yu
 * Description
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    //添加
    @Override
    public void addCategory(String name) {
        categoryDao.addCategory(name);
    }

    //删除
    @Override
    public void delCategory(Integer id) {
        categoryDao.delCategory(id);
    }

    //更新
    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    //根据分类名称查询分类下的链接
    @Override
    public Map findLinkByCategoryName(String categoryName) {

        Map<String,Object> map  = new HashMap<>();
        List<Link> list = categoryDao.findLinkByCategoryName(categoryName);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }

        for (Link element : list) {
            map.put(element.getTitle(),element.getLink());
        }


        return map;
    }

    //搜索分类
    @Override
    public List<Category> searchCategory(String categoryName) {


        return categoryDao.searchCategory(categoryName);
    }

    //根据分类名称查询分类
    @Override
    public Category findCategoryByName(String name) {
       return categoryDao.findCategoryByName(name);
    }

    @Override
    public PageInfo<Category> findAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Category> all = categoryDao.findAll();

        return new PageInfo<>(all);

    }


}
