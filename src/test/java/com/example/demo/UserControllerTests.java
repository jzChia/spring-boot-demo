package com.example.demo;

import com.example.demo.Controller.HelloController;
import com.example.demo.Controller.UserController;
import com.example.demo.Domain.User;
import com.example.demo.Domain.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jiazhijie on 2017/6/6 0006.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private SessionFactory sessionFactory;
//
//
//    public Session getSession(){
//        return sessionFactory.openSession();
//    }
//    @Before
//    public void setUp() {
//
//        //userRepository.deleteAll();
//    }
//    @PersistenceContext
//    private EntityManager entityManager;

    @Test
    public void test() throws Exception {

        userRepository.findByUsername("ddd");

    }

}
