package com.example.demo.Domain;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
///**
// * Created by jiazhijie on 2017/6/9 0009.
// */
//public class SecurityUser implements UserDetails {
//
//    private String userName;
//    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//    /**
//     *
//     */
//    private static final long serialVersionUID = 1L;
//
//
//    public SecurityUser(User user){
//        this.userName = user.getUsername();
//        this.password = "123";
//    }
//
//    public SecurityUser(String userName){
//        this.userName = userName;
//    }
//
//    public SecurityUser(String userName,String password){
//        this.userName = userName;
//        this.password = password;
//    }
//
//    public SecurityUser(String userName,String password,Collection<? extends GrantedAuthority> authorities){
//        this.userName = userName;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        // TODO Auto-generated method stub
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        // TODO Auto-generated method stub
//        return this.userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        // TODO Auto-generated method stub
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        // TODO Auto-generated method stub
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        // TODO Auto-generated method stub
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        // TODO Auto-generated method stub
//        return true;
//    }
//
//}
