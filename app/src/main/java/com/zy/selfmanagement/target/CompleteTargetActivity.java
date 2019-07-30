package com.zy.selfmanagement.target;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.zy.selfmanagement.R;
import com.zy.selfmanagement.base.BaseActivity;
import com.zy.selfmanagement.entity.PunchBean;
import com.zy.selfmanagement.entity.TargetBean;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompleteTargetActivity extends BaseActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvTarget)
    TextView tvTarget;
    @BindView(R.id.etContent)
    TextInputEditText etContent;

    private TargetModel targetModel;
    private TargetBean targetBean;
    private PunchModel punchModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_target);
        ButterKnife.bind(this);
        setTitle();
        targetModel = new TargetModel();
        punchModel = new PunchModel();
        initData();
    }

    private void initData() {
        long id = getIntent().getLongExtra("target_id", -1);
        targetBean = targetModel.getById(id);
        tvTarget.setText(targetBean.content);
    }

    private void setTitle() {
        tvTitle.setText("今日达成");
    }


    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        finish();
    }

    @OnClick(R.id.mbButton)
    public void onMbButtonClicked() {
        PunchBean punchBean = new PunchBean();
        punchBean.createTime = new Date();
        punchBean.description = etContent.getText().toString();
        punchBean.targetBean.setTarget(targetBean);
        punchModel.addPunchBean(punchBean);
        setResult(RESULT_OK);
        finish();
    }

}
