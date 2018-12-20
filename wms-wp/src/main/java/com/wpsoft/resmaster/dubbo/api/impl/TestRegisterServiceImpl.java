package com.wpsoft.resmaster.dubbo.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.wpsoft.resmaster.core.dao.DemoDao;
import com.wpsoft.resmaster.core.domain.Demo;
import com.wpsoft.resmaster.dubbo.api.TestRegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * MASTER
 *          [DUBBO服务测试模块]
 *
 * @Author WP
 * @Date 2018/12/20
 * @See [相关类/方法]（可选）
 * @Since [产品/模块版本] （可选）
 */
@Service
public class TestRegisterServiceImpl implements TestRegisterService {

    @Autowired
    private DemoDao demoDao;

    /**
     * @Author: WP
     * @Description: 返回数据库信息给dubbo服务
     * @Date: 16:33 2018/12/20
     */
    @Override
    public String printHello() {
        List<Demo> list = demoDao.queryDemoList();
        return JSONObject.toJSONString(list);
    }
}
