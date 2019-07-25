package com.zy.selfmanagement.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zy.selfmanagement.R;

public class TargetFragment extends Fragment {


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
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {

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

    }

}


