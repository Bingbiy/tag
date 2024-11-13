package com.hg.tagnew.controller;

import com.alibaba.fastjson2.JSON;
import com.hg.tagnew.common.Result;
import com.hg.tagnew.common.ResultCodeEnum;
import com.hg.tagnew.pojo.entity.Menu;
import com.hg.tagnew.pojo.entity.User;
import com.hg.tagnew.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Date 2024/9/28 14:16
 * Author Yu
 * Description
 */

@RestController
@RequestMapping("admin")
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u  = userService.login(user.getUsername());

        if(ObjectUtils.isEmpty(u)){
            return Result.build("用户不存在",ResultCodeEnum.RC101);
        }

        if(!u.getPassword().equals(user.getPassword())){

            return Result.build(null,ResultCodeEnum.RC102);

        }
        String token = UUID.randomUUID().toString().replaceAll("-", "");

        redisTemplate.opsForValue().set("userToken:"+ token,JSON.toJSONString(u));

        return Result.build(token,ResultCodeEnum.RC200);

    }

    //获取菜单名称
    @GetMapping("/menu")
    public Result getMenuName(){
        List<Menu> menu =  userService.getMenuName();
        return Result.build(menu,ResultCodeEnum.RC200);
    }


    @GetMapping("/logout")
    public Result logout(){

        redisTemplate.delete("token");
        return Result.build(null,ResultCodeEnum.RC200);

    }

}
