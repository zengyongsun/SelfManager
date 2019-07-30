package com.zy.selfmanagement.target;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zy.selfmanagement.R;
import com.zy.selfmanagement.entity.TargetBean;

/**
 * @author : Zeyo
 * e-mail : zengyongsun@163.com
 * date   : 2019/7/26 14:53
 * desc   :
 * version: 1.0
 */
public class TargetAdapter extends BaseQuickAdapter<TargetBean, BaseViewHolder> {

    public TargetAdapter() {
        super(R.layout.adapter_target_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, TargetBean item) {
        helper.setText(R.id.tvTarget, item.content);
        helper.setText(R.id.tvEncourage, item.saySelf);
        helper.setText(R.id.tvTimes, item.punchBeans.size() + "");
        helper.setText(R.id.tvTargetTime, "/"+item.frequency);
    }
}
