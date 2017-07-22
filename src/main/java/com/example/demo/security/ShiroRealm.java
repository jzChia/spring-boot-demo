//package com.example.demo.security;
//
//import com.example.demo.Domain.User;
//import com.example.demo.Domain.UserRepository;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.codehaus.groovy.runtime.powerassert.SourceText;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * Created by jiazhijie on 2017/6/19.
// */
//public class ShiroRealm extends AuthorizingRealm {
//    private Logger logger =  LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        logger.info("doGetAuthorizationInfo+"+principalCollection.toString());
//        System.out.println(principalCollection.getPrimaryPrincipal());
//        User u = (User)principalCollection.getPrimaryPrincipal();
//        User user = userRepository.findByUsername(u.getUsername());
//
//        //把principals放session中 key=userId value=principals
//        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //赋予角色
//        info.addRole("ROLE_USER");
//
//        //赋予权限
////        for(Permission permission:permissionService.getByUserId(user.getId())){
//////            if(StringUtils.isNotBlank(permission.getPermCode()))
////            info.addStringPermission(permission.getName());
////        }
//
//        //设置登录次数、时间
////        userService.updateUserLogin(user);
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());
//
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String userName=token.getUsername();
//        for(char c:token.getPassword()){
//            System.out.print(c);
//        }
//        logger.info(userName+":"+token.getPassword().toString());
//
//        User user = userRepository.findByUsername(token.getUsername());
//        if(user==null) throw new UnknownAccountException();
//
//        System.out.println("zhegemima:"+String.valueOf(((UsernamePasswordToken)token).getPassword()));
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                user, //用户
//                user.getPassword(), //密码
//                ByteSource.Util.bytes(userName),
//                getName()  //realm name
//        );
//        // 当验证都通过后，把用户信息放在session里
//        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("userSession", user);
//        session.setAttribute("userSessionId", user.getId());
//        return authenticationInfo;
//    }
//
//}
