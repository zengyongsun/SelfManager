package com.zy.selfmanagement.entity;

import com.zy.selfmanagement.db.DateConverter;

import java.util.Date;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2019/7/25 15:34
 * desc   :
 * version: 1.0
 */
@Entity
public class PunchBean {

    @Id(assignable = true)
    public long id;

    @Convert(converter = DateConverter.class, dbType = Long.class)
    public Date createTime;

    public String description;

    public ToOne<TargetBean> targetBean;

}
