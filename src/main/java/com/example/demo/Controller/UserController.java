package com.example.demo.Controller;

import com.example.demo.config.MyTestPro;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.HbaseUtils;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.*;

/**
 * Created by jiazhijie on 2017/6/6 0006.
 */
@RestController
@RequestMapping(value = "/user")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    @Autowired
    private MyTestPro mt;
    @Autowired
    private RestTemplate restTemplate;

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

    @RequestMapping(value = "/getdd",method = RequestMethod.GET)
    public String getDownload() throws IOException {

        HttpClient httpClient = new HttpClient(new SimpleHttpConnectionManager(true));
        //发送get请求
        GetMethod getMethod = new GetMethod("http://localhost:1234/testDownload?fileName=agent.csv");
        httpClient.executeMethod(getMethod);
        byte[] bytes = getMethod.getResponseBody();
        // 关闭低层流。


        ByteToFile("e://test.csv",bytes);

        return "sssss";
    }


    public   File ByteToFile( String filePath,byte[] bytes)
    {
        File file = new File(filePath);
        BufferedOutputStream stream = null;
        FileOutputStream fstream = null;
        //byte[] data=new byte[(int)file.length()];
        try {
            fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
                if (null != fstream) {
                    fstream.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return file;
    }

    @Autowired
    private HbaseTemplate hbaseTemplate;


    @GetMapping("/hb")
    @ResponseBody
    public String hbaseTest(){


        hbaseTemplate.find("test", "test1", new RowMapper<Object>() {
            @Override
            public Object mapRow(Result result, int rowNum) throws Exception {


                List<Cell> cells = result.listCells();
                for(Cell cell:cells) {
                    System.out.println(Bytes.toString(cell.getFamilyArray()).substring(cell.getFamilyOffset(),cell.getFamilyOffset()+cell.getFamilyLength()));
                    System.out.println(Bytes.toString(cell.getQualifierArray()).substring(cell.getQualifierOffset(),cell.getQualifierLength()+cell.getQualifierOffset()));
                    System.out.println(Bytes.toString(cell.getRowArray()).substring(cell.getRowOffset(),cell.getRowOffset()+cell.getRowLength()));
                    System.out.println(Bytes.toString(cell.getValueArray()).substring(cell.getValueOffset(),cell.getValueOffset()+cell.getValueLength()));
                }

                System.out.println(Bytes.toString(result.getValue(Bytes.toBytes("test"),null)));
                return null;
            }
        });


        return "sssssss";
    }
}