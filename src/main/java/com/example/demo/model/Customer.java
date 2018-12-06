package com.example.demo.model;

import javax.persistence.*;

/**
 * Created by vickl on 2018/12/4.
 */
@Entity
@Table(name="t_customer")
public class Customer {
    private int id;
    private String name;
    private String password;
    private int sex;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
