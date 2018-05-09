package com.zy.selfmanagement.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.zy.selfmanagement.entity.TaskEntity;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 *    @author : Zeyo
 *     e-mail : zengyongsun@163.com
 *     time   : 2018/05/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */

@Dao
public interface TaskDao {

    /**
     * 查所有
     */
    @Query("select * from tb_task")
    List<TaskEntity> getAll();

    /**
     * 根据指定字段查询
     */
    @Query("select * from tb_task where update_time =:time")
    TaskEntity getTaskByTime(Date time);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inert(TaskEntity taskEntity);

    @Update()
    void update(TaskEntity taskEntity);

    @Delete()
    void delete(TaskEntity taskEntity);

}
