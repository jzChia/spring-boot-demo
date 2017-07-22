package com.example.demo.Controller;

import com.example.demo.exception.MyException;
import com.example.demo.rabbit.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jiazhijie on 2017/6/6 0006.
 */
@Controller
public class HelloController {

    @Autowired
    private Sender sender;

    @RequestMapping("/hello")
    public String hello(){
        throw new NullPointerException("空指针异常");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2","数据内容");
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView map = new ModelAndView();
        map.setViewName("index");
        map.addObject("host", "http://blog.didispace.com");
        return map;
    }

    @RequestMapping("/send")
    @ResponseBody
    public String send(){
        sender.send();
        sender.sendhi();
        return "ok";
    }
}
