package com.wpsoft.resmaster.dubbo.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wpsoft.resmaster.dubbo.api.PublicRegisterService;

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
public class PublicRegisterServiceImpl implements PublicRegisterService {

    /**
     * @Author: WP
     * @Description: 直接返回字符窜信息
     * @Date: 16:33 2018/12/20
     */
    @Override
    public String hiDubbo() {
        return "this is \tdubbo register!";
    }
}
