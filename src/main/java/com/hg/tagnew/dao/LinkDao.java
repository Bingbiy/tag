package com.hg.tagnew.dao;

import com.hg.tagnew.pojo.entity.Link;

import java.util.List;

/**
 * Date 2024/10/30 23:28
 * Author Yu
 * Description
 */

public interface LinkDao {

    List<Link> getAllLink();

    Integer add(Link link);

    Integer delLink(Integer id);

    Integer updateLink(Link link);
}
