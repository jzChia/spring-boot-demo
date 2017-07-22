package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by jiazhijie on 2017/6/6 0006.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String username;

    @Column(name = "AGE")
    private int age;


    @JsonIgnore
    @Column(name = "PWD")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;

//    public User(){}
//    public User( String username, Integer age,String) {
//        this.username = username;
//        this.age = age;
//    }
//
//    public User(Long id, String username, Integer age) {
//        this.id = id;
//        this.username = username;
//        this.age = age;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override

    public String toString() {
        return "id:"+id+System.lineSeparator()+
                "username:"+username+System.lineSeparator()+
                "age"+ age;
    }
}
