package com.wpsoft.resmaster.core.dao;

import com.wpsoft.resmaster.core.domain.Demo;

import java.util.List;

/**
 * MASTER
 *          [框架样例测试DAO模块]
 *
 * @Author WP
 * @Date 2018/12/20
 * @See [相关类/方法]（可选）
 * @Since [产品/模块版本] （可选）
 */
public interface DemoDao {
    public List<Demo> queryDemoList();
}
