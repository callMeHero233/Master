package com.wpsoft.resmaster.core.services.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wpsoft.resmaster.core.dao.DemoDao;
import com.wpsoft.resmaster.core.domain.Demo;
import com.wpsoft.resmaster.core.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * MASTER
 *          [框架样例测试SERVICE模块]
 *
 * @Author WP
 * @Date 2018/12/20
 * @See [相关类/方法]（可选）
 * @Since [产品/模块版本] （可选）
 */
@Component("demoService")
@Service(version="1.0")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    //日志
    private Logger logger;

    @Override
    public List<Demo> queryDemoList() {
        List<Demo>  list = null;
        try{
            list = demoDao.queryDemoList();
        }catch (Exception e){
            logger.info(e.toString());
            e.printStackTrace();
        }
        return list;
    }
}
