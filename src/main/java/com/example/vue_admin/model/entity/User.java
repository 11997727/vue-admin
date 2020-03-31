package com.example.vue_admin.model.entity;

import java.util.List;

/**
 * @Project: vue_admin
 * @Package com.example.vue_admin.model.entity
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/3/30 星期一 22:17
 * @version V1.0 
 *
 */
public class User {
    /**
    * 主键
    */
    private Integer uid;

    /**
    * 介绍
    */
    private String introduction;

    /**
    * 头像
    */
    private String avatar;

    /**
    * 姓名
    */
    private String name;

    /**
    * 账号
    */
    private String username;
    /**
     * 角色
     */
    private List<String> roles;
    /**
    * 密码
    */
    private String password;

    public User() {
    }

    public User(Integer uid, String introduction, String avatar, String name, String username, List<String> roles, String password) {
        this.uid = uid;
        this.introduction = introduction;
        this.avatar = avatar;
        this.name = name;
        this.username = username;
        this.roles = roles;
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}