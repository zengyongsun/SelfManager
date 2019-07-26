package com.zy.selfmanagement.target;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zy.selfmanagement.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTargetActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_target);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        finish();
    }

    @OnClick(R.id.mbButton)
    public void onMbButtonClicked() {
        setResult(RESULT_OK);
        finish();
    }
}
