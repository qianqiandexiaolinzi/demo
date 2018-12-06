package com.example.demo.service;

import com.example.demo.model.User;

/**
 * Created by vickl on 2018/12/3.
 */
public interface UserService {
    User save(User user);

    User findByUserName(String userName);
}
