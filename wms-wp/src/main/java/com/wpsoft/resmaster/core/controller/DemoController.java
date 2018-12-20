package com.wpsoft.resmaster.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.wpsoft.resmaster.core.domain.Demo;
import com.wpsoft.resmaster.core.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Master
 *          [框架样例测试CONTROLLER模块]
 *
 * @Author WP
 * @Date 2018/12/20
 * @See [相关类/方法]（可选）
 * @Since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/main")
public class DemoController {

    @Autowired
    private DemoService demoService;

   /**
    * @Author: WP
    * @param:  request
    * @param:  response
    * @Description: 测试DB
    * @Date: 16:19 2018/12/20
    */
    @RequestMapping(value = "/queryDemoList")
    @ResponseBody
    public String queryDemoList(HttpServletRequest request, HttpServletResponse response){
        List<Demo> list = new ArrayList<Demo>();
        list = demoService.queryDemoList();
        return JSONObject.toJSONString(list);
    }
}
