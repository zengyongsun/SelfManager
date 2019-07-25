package com.zy.selfmanagement;

import android.app.Application;

import com.zy.selfmanagement.db.ObjectBox;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2019/7/25 8:59
 * desc   :
 * version: 1.0
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ObjectBox.init(this);
    }
}
