package com.zy.selfmanagement.target;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.zy.selfmanagement.R;
import com.zy.selfmanagement.db.ObjectBox;
import com.zy.selfmanagement.entity.TargetBean;


import java.lang.annotation.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.objectbox.Box;

public class TargetFragment extends Fragment {


    @BindView(R.id.targetList)
    RecyclerView targetList;

    Unbinder unbinder;
    private TargetModel targetModel;
    private TargetAdapter targetAdapter;

    public TargetFragment() {
    }

    public static TargetFragment newInstance() {
        TargetFragment fragment = new TargetFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_target, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        targetModel = new TargetModel();
        targetList.setLayoutManager(new LinearLayoutManager(getContext()));
        targetAdapter = new TargetAdapter();
        targetList.setAdapter(targetAdapter);
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initData() {
        targetAdapter.setNewData(targetModel.getTargetBeans());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private final int REQUEST_CODE = 101;

    @OnClick(R.id.ibAddTarget)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), AddTargetActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Logger.d("调用了");
            initData();
        }
    }
}


