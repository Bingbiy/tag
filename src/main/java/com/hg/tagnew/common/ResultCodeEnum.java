package com.hg.tagnew.common;

import lombok.Getter;

/**
 * Date 2024/9/28 14:41
 * Author Yu
 * Description
 */

@Getter
public enum ResultCodeEnum {

    //1、举值
    RC101(101,"用户不存在"),
    RC102(102,"密码不正确"),
    RC200(200, "操作成功"),
    RC404(404, "未找到"),

    RC601(601, "获取链接失败"),
    RC602(602, "标题已存在"),
    RC603(603, "链接添加失败"),
    RC604(604, "删除链接失败"),
    RC605(605, "更新链接失败"),

    RC801(801,"分类名称已存在"),


    RC999(999,"操作失败");


//    2.构造
    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

//    遍历
    public static ResultCodeEnum getResultCodeEnum(Integer code) {
        for (ResultCodeEnum value : ResultCodeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


}
