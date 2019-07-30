package com.zy.selfmanagement.target;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.zy.selfmanagement.R;
import com.zy.selfmanagement.base.BaseActivity;
import com.zy.selfmanagement.entity.TargetBean;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTargetActivity extends BaseActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.etTarget)
    TextInputEditText etTarget;
    @BindView(R.id.etTimes)
    TextInputEditText etTimes;
    @BindView(R.id.etEncourage)
    TextInputEditText etEncourage;
    @BindView(R.id.etSay)
    TextInputEditText etSay;
    private TargetModel targetModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_target);
        ButterKnife.bind(this);
        setTitle();
        targetModel = new TargetModel();
    }

    private void setTitle() {
        tvTitle.setText("新增好习惯");
    }


    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        finish();
    }

    @OnClick(R.id.mbButton)
    public void onMbButtonClicked() {
        if (checkInput()) {
            TargetBean targetBean = new TargetBean();
            targetBean.content = etTarget.getText().toString();
            targetBean.encourage = etEncourage.getText().toString();
            targetBean.saySelf = etSay.getText().toString();
            targetBean.createTime = new Date();
            targetBean.updateTime = new Date();
            targetBean.frequency = Integer.parseInt(etTimes.getText().toString());
            targetModel.addTargetBean(targetBean);
            setResult(RESULT_OK);
            finish();
        }
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(etTarget.getText())) {
            toToast("目标不能为空！");
            return false;
        }
        if (TextUtils.isEmpty(etEncourage.getText())) {
            toToast("给自己一个激励吧！");
            return false;
        }

        if (TextUtils.isEmpty(etSay.getText())) {
            toToast("来一句鼓励的话！");
            return false;
        }

        if (TextUtils.isEmpty(etTimes.getText())) {
            toToast("持续的天数不能为空！");
            return false;
        }
        return true;
    }

    private void toToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
