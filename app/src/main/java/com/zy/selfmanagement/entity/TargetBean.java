package com.zy.selfmanagement.entity;

import com.zy.selfmanagement.db.DateConverter;

import java.util.Date;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2019/7/25 11:40
 * desc   :
 * version: 1.0
 */
@Entity
public class TargetBean {

    @Id(assignable = true)
    public long id;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    public Date createTime;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    public Date updateTime;

    /**
     * 目标的内容
     */
    public String content;

    /**
     * 鼓励自己的话
     */
    public String encourage;

    /**
     * 坚持的天数
     */
    public int frequency;

    @Backlink(to = "TargetBean")
    public ToMany<PunchBean> punchBeans;

}
