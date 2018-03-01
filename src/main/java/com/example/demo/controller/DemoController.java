package com.example.demo.controller;

import com.example.demo.annotation.BaseController;
import com.example.demo.model.Response;
import com.example.demo.service.DemoService;
import com.example.demo.util.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;

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


    @RequestMapping(value="/download")
    public void download(HttpServletResponse response) throws Exception{


        String filePath = "/Users/simon/demo/demo.csv";
        CsvUtil.writeFile(filePath);
        response.setContentType("application/csv;charset=UTF-8");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + URLEncoder.encode("demo.csv", "UTF-8"));

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null) {
            response.getOutputStream().write(line.getBytes(Charset.forName("UTF-8")));
            response.getOutputStream().write("\r\n".getBytes(Charset.forName("UTF-8")));
        }
        response.getOutputStream().flush();
    }

}
