package com.yuan.cache.domain;

/**
 * FileName: Account
 * Author:   yhl
 * Date:     2018/11/4 23:03
 * Description: ${DESCRIPTION}
 */
public class Account {
    private int id;
    private String name;
    private int age;

    public Account(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
