package com.example.demo.util;

import com.csvreader.CsvWriter;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

public class CsvUtil {

    public static void decoderBase64File(String base64Code,String savePath) throws Exception {
        byte[] buffer = Base64.getDecoder().decode(base64Code.getBytes(Charset.forName("UTF-8")));
        FileOutputStream out = new FileOutputStream(savePath);
        out.write(buffer);
        out.close();
    }


    public static String writeFile(String filePath){
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

    public static void main(String[] args) throws Exception{
        String filePath = "/Users/simon/demo/demo.csv";
        CsvUtil.writeFile(filePath);
        StringBuilder sb = new StringBuilder();

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null) {
            sb.append(line).append("\r\n");
        }

        String outputPath = "/Users/simon/demo/copy.csv";

        String base64Code = Base64.getEncoder().encodeToString(sb.toString().getBytes(Charset.forName("UTF-8")));

        CsvUtil.decoderBase64File(base64Code, outputPath);
    }
}
