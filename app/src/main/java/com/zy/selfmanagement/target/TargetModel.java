package com.zy.selfmanagement.target;

import com.zy.selfmanagement.db.ObjectBox;
import com.zy.selfmanagement.entity.TargetBean;

import java.util.List;

import io.objectbox.Box;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2019/7/26 15:36
 * desc   :
 * version: 1.0
 */
public class TargetModel {

    private final Box<TargetBean> targetBeanBox;

    public TargetModel() {
        targetBeanBox = ObjectBox.get().boxFor(TargetBean.class);
    }

    public List<TargetBean> getTargetBeans() {
        return targetBeanBox.query().build().find();
    }

    public void addTargetBean(TargetBean targetBean) {
        targetBeanBox.put(targetBean);
    }

    public TargetBean getById(long id) {
        return targetBeanBox.get(id);
    }

}
