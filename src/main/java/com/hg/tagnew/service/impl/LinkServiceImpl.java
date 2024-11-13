package com.hg.tagnew.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hg.tagnew.dao.LinkDao;
import com.hg.tagnew.pojo.entity.Link;
import com.hg.tagnew.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date 2024/10/30 23:27
 * Author Yu
 * Description
 */

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;


    //获取所有链接
    @Override
    public List<Link> getAllLink() {

         List<Link> all =  linkDao.getAllLink();


        return all;
    }

    @Override
    public Integer add(Link link) {
        return linkDao.add(link);
    }

    @Override
    public Integer delLink(Integer id) {

        return linkDao.delLink(id);
    }

    @Override
    public Integer updateLink(Link link) {
        return linkDao.updateLink(link);
    }

    @Override
    public PageInfo<Link> getByPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Link> allLink = linkDao.getAllLink();


        return new PageInfo<>(allLink);
    }
}
