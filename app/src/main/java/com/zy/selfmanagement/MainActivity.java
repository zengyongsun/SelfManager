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

import com.zy.selfmanagement.fragment.EventFragment;
import com.zy.selfmanagement.fragment.HistoryFragment;
import com.zy.selfmanagement.fragment.MineFragment;
import com.zy.selfmanagement.utils.BottomNavigationViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    private EventFragment eventFragment;
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
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    private void initFragment() {
        eventFragment = EventFragment.newInstance();
        historyFragment = HistoryFragment.newInstance();
        mineFragment = MineFragment.newInstance();
        setFragment(eventFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigationEvent:
                setFragment(eventFragment);
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
