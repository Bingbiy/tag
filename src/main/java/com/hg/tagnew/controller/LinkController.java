package com.hg.tagnew.controller;

import com.github.pagehelper.PageInfo;
import com.hg.tagnew.common.Result;
import com.hg.tagnew.common.ResultCodeEnum;
import com.hg.tagnew.pojo.entity.Link;
import com.hg.tagnew.service.LinkService;
import jakarta.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Date 2024/10/30 23:26
 * Author Yu
 * Description
 */

@RestController
@RequestMapping("/link")
public class LinkController {

    @Resource
    private LinkService linkService;

    //获取全部
    @GetMapping("/getAll")
    public Result getAllLink(){
        List<Link> allLink = linkService.getAllLink();
        if (CollectionUtils.isEmpty(allLink)){
            return Result.build(null,ResultCodeEnum.RC601);
        }

        return Result.build(allLink, ResultCodeEnum.RC200);
    }

    //分页查询获取
    @GetMapping("/{pageNum}/{pageSize}")
    public Result getLinkByPage(@PathVariable("pageNum") Integer pageNum,
                                @PathVariable("pageSize") Integer pageSize){
        PageInfo<Link> linkInfo = linkService.getByPage(pageNum,pageSize);
        return Result.build( linkInfo,ResultCodeEnum.RC200);

    }

    //增
    @PostMapping("/add")
    public Result addLink(@RequestBody Link link){

        List<Link> list = linkService.getAllLink();
        for (Link element : list) {
            if (element.getTitle().equals(link.getTitle())) {
                return Result.build(null,ResultCodeEnum.RC602);
            }
        }

        Integer result = linkService.add(link);
        if (result < 1 ){
            return Result.build(null,ResultCodeEnum.RC603);
        }

        return Result.build(result,ResultCodeEnum.RC200);
    }

    //删
    @DeleteMapping("/del/{id}")
    public Result delLink(@PathVariable("id") Integer id){
        Integer result = linkService.delLink(id);
        if (result < 1 ){
            return Result.build(null,ResultCodeEnum.RC604);
        }

        return Result.build(result,ResultCodeEnum.RC200);
    }

    //更新
    @PutMapping("/update")
    public Result updateLink(@RequestBody Link link){
        Integer result = linkService.updateLink(link);
        if (result < 1 ){
            return Result.build(null,ResultCodeEnum.RC605);
        }

        return Result.build(result,ResultCodeEnum.RC200);
    }
}
