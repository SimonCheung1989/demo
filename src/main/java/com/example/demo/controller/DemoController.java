package com.example.demo.controller;

import com.csvreader.CsvWriter;
import com.example.demo.annotation.BaseController;
import com.example.demo.model.Response;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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


        String filePath = write();
        response.setContentType("application/csv;charset=UTF-8");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + URLEncoder.encode("demo.csv", "UTF-8"));

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null) {
            response.getOutputStream().write(line.getBytes(Charset.forName("UTF-8")));
        }
        response.getOutputStream().flush();

    }

    public static String write(){
        String filePath = "/Users/simon/demo/demo.csv";
        try {
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));
            String[] headers = {"编号","姓名","年龄"};
            String[] content = {"12365","张山","34"};
            csvWriter.writeRecord(headers);
            csvWriter.writeRecord(content);
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

}
