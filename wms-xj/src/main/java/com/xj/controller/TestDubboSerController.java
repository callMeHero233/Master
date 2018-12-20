package com.xj.controller;

import com.xj.services.TestDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/testDubbo")
public class TestDubboSerController {

    @Autowired
    private TestDubboService testDubboService;

    @RequestMapping(value = "/hiDubbo")
    @ResponseBody
    public String hiDubbo(HttpServletRequest request, HttpServletResponse response){
        String info = testDubboService.hiDubbo();
        return info;
    }
}
