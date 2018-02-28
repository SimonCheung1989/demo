package com.example.demo.service;

import com.example.demo.exception.DemoException;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void doService() throws Exception{
        double d = 1/0;
        throw new DemoException("Code", "Message");
    }
}
