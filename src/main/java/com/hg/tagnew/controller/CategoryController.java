package com.hg.tagnew.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hg.tagnew.common.Result;
import com.hg.tagnew.common.ResultCodeEnum;
import com.hg.tagnew.pojo.entity.Category;
import com.hg.tagnew.pojo.entity.Link;
import com.hg.tagnew.pojo.entity.User;
import com.hg.tagnew.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Date 2024/10/27 14:08
 * Author Yu
 * Description
 */

@RestController
@RequestMapping("category")
public class CategoryController {


    @Resource
    private CategoryService categoryService;

    //查 分页查询
    @GetMapping("/{pageNum}/{pageSize}")
    public Result<PageInfo<Category>> findAllByPage(@PathVariable("pageNum") Integer pageNum,
                                              @PathVariable("pageSize") Integer pageSize){

        PageInfo<Category> allByPage = categoryService.findAllByPage(pageNum, pageSize);
        return Result.build(allByPage, ResultCodeEnum.RC200);

    }



    //查询所有
    @GetMapping("/findAll")
    public Result findAll(){

        List<Category> categoryAll = categoryService.findAll();

        if (!ObjectUtils.isEmpty(categoryAll)){
            return Result.build(categoryAll, ResultCodeEnum.RC200);
        }
        return Result.build(null,ResultCodeEnum.RC999);
    }


    //增
    @PostMapping("/add")
    public Result addCategory(@RequestBody Category category){
        List<Category> categoryList = categoryService.findAll();
        for (Category element : categoryList) {
            if (category.getName().equals(element.getName())) {
                return Result.build(null,ResultCodeEnum.RC801);
            }
        }

        //添加
        categoryService.addCategory(category.getName());
        return Result.build(null,ResultCodeEnum.RC200);
    }

    //改

    @PutMapping("/update")
    public Result updateCategory(@RequestBody Category category){

        if (ObjectUtils.isEmpty(category)){
            return Result.build(null,ResultCodeEnum.RC999);
        }

        categoryService.update(category);
        return Result.build(null,ResultCodeEnum.RC200);
    }

    //删
    @DeleteMapping("/del/{id}")
    public Result delCategory(@PathVariable("id") Integer id){

        if (ObjectUtils.isEmpty(id)){
            return Result.build(null,ResultCodeEnum.RC999);
        }

        categoryService.delCategory(id);
        return Result.build(null,ResultCodeEnum.RC200);
    }

    //根据分类名称查询链接

    @GetMapping("/{categoryName}")
    public Result findLinkByCategoryName(@PathVariable("categoryName") String categoryName){
        Map map = categoryService.findLinkByCategoryName(categoryName);

        if (ObjectUtils.isEmpty(map)){
            return Result.build(null,ResultCodeEnum.RC999);
        }

        return Result.build(map,ResultCodeEnum.RC200);

    }
    

}
