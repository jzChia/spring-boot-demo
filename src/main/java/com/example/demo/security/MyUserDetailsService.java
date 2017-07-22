package com.example.demo.security;

//import com.example.demo.Domain.User;
//import com.example.demo.Domain.UserRepository;
//import com.example.demo.Domain.SecurityUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Collection;

/**
 * Created by jiazhijie on 2017/6/9 0009.
 */
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        System.out.println("username:"+userName);
//        if(userRepository==null)
//            System.out.println("userRepository is null");
//        User user = userRepository.findByUsername(userName);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("UserName " + userName + " not found");
//        }
//        System.out.println(user.getUsername());
//
//        // SecurityUser实现UserDetails并将SUser的Email映射为username
//        SecurityUser securityUser = new SecurityUser(user);
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return securityUser;
//    }
//
//}