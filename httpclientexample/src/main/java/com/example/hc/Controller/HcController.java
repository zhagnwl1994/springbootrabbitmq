package com.example.hc.Controller;


import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HcController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String testHcController(){
        return "get 无参数请求成功";
    }

    @RequestMapping(value = "/get2",method = RequestMethod.GET)
    public void getHttpTest(){

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://bing.ioliu.cn/photo/EiffelBelow_ZH-CN5149009072?force=home_1");





    }

}
