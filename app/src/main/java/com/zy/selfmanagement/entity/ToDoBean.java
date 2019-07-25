package com.zy.selfmanagement.entity;


import com.zy.selfmanagement.db.DateConverter;

import java.util.Date;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2019/4/16 13:19
 * desc   :
 * version: 1.0
 */
@Entity
public class ToDoBean {

    @Id(assignable = true)
    public long id;


    @Convert(converter = DateConverter.class, dbType = Long.class)
    public Date createDate;


}
