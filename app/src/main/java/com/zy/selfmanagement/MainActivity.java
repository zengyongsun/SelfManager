package com.zy.selfmanagement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.zy.selfmanagement.base.BaseActivity;
import com.zy.selfmanagement.target.TargetFragment;
import com.zy.selfmanagement.fragment.HistoryFragment;
import com.zy.selfmanagement.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    private TargetFragment targetFragment;
    private HistoryFragment historyFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
        initFragment();
    }

    private void initUI() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initFragment() {
        targetFragment = TargetFragment.newInstance();
        historyFragment = HistoryFragment.newInstance();
        mineFragment = MineFragment.newInstance();
        setFragment(targetFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigationTarget:
                setFragment(targetFragment);
                return true;
            case R.id.navigationHistory:
                setFragment(historyFragment);
                return true;
            case R.id.navigationMine:
                setFragment(mineFragment);
                return true;
            default:
                break;
        }
        return false;
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.frameLayout, fragment);
        fTransaction.commit();
    }

}
