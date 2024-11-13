package com.hg.tagnew.service;

import com.github.pagehelper.PageInfo;
import com.hg.tagnew.pojo.entity.Link;

import java.util.List;

/**
 * Date 2024/10/30 23:27
 * Author Yu
 * Description
 */
public interface LinkService {
    // 获取所有链接
    List<Link> getAllLink();

    Integer add(Link link);

    Integer delLink(Integer id);

    Integer updateLink(Link link);

    PageInfo<Link> getByPage(Integer pageNum, Integer pageSize);
}
