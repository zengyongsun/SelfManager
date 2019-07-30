package com.zy.selfmanagement.target;

import com.zy.selfmanagement.db.ObjectBox;
import com.zy.selfmanagement.entity.PunchBean;
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
public class PunchModel {

    private final Box<PunchBean> punchBeanBox;

    public PunchModel() {
        punchBeanBox = ObjectBox.get().boxFor(PunchBean.class);
    }

    public void addPunchBean(PunchBean punchBean) {
        punchBeanBox.put(punchBean);
    }

}
