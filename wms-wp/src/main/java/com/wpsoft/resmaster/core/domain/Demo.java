package com.wpsoft.resmaster.core.domain;

import java.util.Date;

/**
 * MASTER
 *          [框架样例测试DOMAIN模块]
 *
 * @Author WP
 * @Date 2018/12/20
 * @See [相关类/方法]（可选）
 * @Since [产品/模块版本] （可选）
 */
public class Demo {
    //主键编号
    private Integer id;

    //名称
    private String name;

    //创建时间
    private Date createTime;

    //修改时间
    private Date modTime;

    //状态 0 无效,1 有效
    private Integer delStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }
}
