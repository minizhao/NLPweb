package com.lab713.nlpservices.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@RestController
@RequestMapping("/")
public class ModelController {
    @PostMapping("reading")
    public String reading(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        String question = request.getParameter("weiboContent");
        String[] cmdArr = new String[] {"D:\\ProgramData\\Anaconda3\\python", "F:\\untitled.py", question};
        Process pr = Runtime.getRuntime().exec(cmdArr);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                pr.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
        pr.waitFor();
        System.out.println("end");
        return question;
    }
}

