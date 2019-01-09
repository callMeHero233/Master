package com.xj.services.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wpsoft.resmaster.dubbo.api.TestRegisterService;
import com.xj.services.TestDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("testDubboServiceImpl")
public class TestDubboServiceImpl implements TestDubboService {

    @Reference
    private TestRegisterService testRegisterService;

    @Override
    public String hiDubbo() {
        return testRegisterService.printHello();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{});
    }
}
