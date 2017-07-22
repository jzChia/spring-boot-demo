package com.example.demo.Controller;

import com.example.demo.Domain.User;
import com.example.demo.Domain.UserRepository;
import io.swagger.annotations.ApiOperation;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiazhijie on 2017/6/8 0008.
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe
    ) {
        logger.info("==========" + userName + password + rememberMe);
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//        token.setRememberMe(rememberMe);
//
//        try {
//            subject.login(token);
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
////            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
//            return "{\"Msg\":\"您的账号或密码输入错误\",\"state\":\"failed\"}";
//        }
        return "{\"Msg\":\"登陆成功\",\"state\":\"success\"}";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "no permission";
    }

    @RequestMapping("/login")
    public String login(ModelMap map) {
        //User user = userRepository.findByUsername("didi");
        //logger.info("age: "+user.getAge());
        map.put("name","jz");
        return "login";
    }
}