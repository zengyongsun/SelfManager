package com.zy.selfmanagement.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.zy.selfmanagement.entity.TaskEntity;

/**
 * <pre>
 *    @author : Zeyo
 *     e-mail : zengyongsun@163.com
 *     time   : 2018/05/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */

@Database(entities = {TaskEntity.class}, version = 1, exportSchema = false)
@TypeConverters({ConversionFactory.class})
public abstract class SelfManagerDatabase extends RoomDatabase {

    public static SelfManagerDatabase getDefault(Context context) {
        return buildDatabase(context);
    }

    private static SelfManagerDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
            SelfManagerDatabase.class, "SELF.DB")
            .allowMainThreadQueries()
            .build();
    }

    public abstract TaskDao getTaskDao();

}
