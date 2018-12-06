package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vickl on 2018/12/3.
 */
public interface UserDao extends CrudRepository<User,Integer> {
    User save(User user);

    /**
     * 根据userName查询user
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
