package com.example.demo.controller;

import com.example.demo.annotation.BaseController;
import com.example.demo.model.Response;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@BaseController(name="DemoController")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value="/demo")
    @ResponseBody
    public Response demo() throws Exception{
        Response response = new Response();
        response.setAppName("Demo");
        demoService.doService();
        return response;

    }
}
