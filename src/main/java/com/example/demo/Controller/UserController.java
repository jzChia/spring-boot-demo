package com.example.demo.Controller;

import com.example.demo.config.MyTestPro;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Created by jiazhijie on 2017/6/6 0006.
 */
@RestController
@RequestMapping(value = "/user")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    @Autowired
    private MyTestPro mt;

    @ApiOperation(value = "用户列表", notes = "")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(HttpServletRequest req) {
        req.getSession().setAttribute("testKey", "testValue");

        System.out.println("sze:" + mt.getFoo().size());
        for (Map.Entry<String, List<String>> map : mt.getFoo().entrySet()) {
            System.out.println(map.getKey());
            for (int i = 0; i < 2; i++)
                System.out.println("--" + map.getValue().get(i));
        }


        return "hello world!";
    }

    @ApiOperation(value = "用户列表", notes = "")
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(HttpServletRequest req) {
        System.out.println(req.getSession().getAttribute("testKey"));

        System.out.println("sze:" + mt.getFoo().size());
        for (Map.Entry<String, List<String>> map : mt.getFoo().entrySet()) {
            System.out.println(map.getKey());
            for (int i = 0; i < 2; i++)
                System.out.println("--" + map.getValue().get(i));
        }


        return "hello world!";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody
    String handleFileUpload(@RequestParam("name") String name,
                            @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                System.out.println(name + "-uploaded");
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
}