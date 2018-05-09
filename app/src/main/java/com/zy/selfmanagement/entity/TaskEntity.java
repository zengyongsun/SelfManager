package com.zy.selfmanagement.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * <pre>
 *    @author : Zeyo
 *     e-mail : zengyongsun@163.com
 *     time   : 2018/05/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */

@Entity(tableName = "tb_task")
public class TaskEntity {

    //主键
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "one_things")
    public String oneThings;

    @ColumnInfo(name = "two_things")
    public String twoThings;

    @ColumnInfo(name = "three_things")
    public String threeThings;

    @ColumnInfo(name = "xiao_que_xing")
    public String xiaoQueXing;

    @ColumnInfo(name = "is_one_finish")
    public boolean isOnefinish;

    @ColumnInfo(name = "is_two_finish")
    public boolean isTwofinish;

    @ColumnInfo(name = "is_three_finish")
    public boolean isThreefinish;

    @ColumnInfo(name = "is_que_xing_finish")
    public boolean isQueXingFinish;

    @ColumnInfo(name = "create_time")
    public Date createTime;

    @ColumnInfo(name = "update_time")
    public Date updateTime;

}
