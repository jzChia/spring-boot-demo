package com.example.demo.Domain;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jiazhijie on 2017/6/6 0006.
 */
public interface UserRepository  {

    User findByUsername(String user);

    List<User> findAll();

    void save(User user);

}
