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
        String[] cmdArr = new String[] {"/home/lab713/anaconda3/bin/python", "/home/lab713/data1/git_code/NLPweb/python_lib/untitled.py", question};
        Process pr = Runtime.getRuntime().exec(cmdArr);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                pr.getInputStream()));
        String line="";
        String c;
        while ((c = in.readLine()) != null) {
            line+=c;
        }
        in.close();
        pr.waitFor();
        System.out.println("end");
        return line;
    }
}

