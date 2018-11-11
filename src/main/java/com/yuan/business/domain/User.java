package com.yuan.business.domain;

/**
 * FileName: User
 * Author:   yhl
 * Date:     2018/11/11 21:20
 * Description: ${DESCRIPTION}
 */
public class User {
    private Integer id; //主键
    private String username; //登录用户
    private String password; //登录密码
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
