package com.liying.back.graducation.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liying
 * @since 2024-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，用户表主键
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别
     */
    private String gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 注册时间
     */
    private LocalDateTime registrationTime;

    /**
     * 角色ID，外键关联角色表
     */
    private Integer roleId;


}
