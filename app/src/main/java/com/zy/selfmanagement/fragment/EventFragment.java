package com.zy.selfmanagement.fragment;

import android.content.Context;
import android.content.Entity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.zy.selfmanagement.R;
import com.zy.selfmanagement.db.SelfManagerDatabase;
import com.zy.selfmanagement.db.TaskDao;
import com.zy.selfmanagement.entity.TaskEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class EventFragment extends Fragment {

    @BindView(R.id.etOne) EditText etOne;
    @BindView(R.id.cbOne) CheckBox cbOne;
    @BindView(R.id.etTwo) EditText etTwo;
    @BindView(R.id.cbTwo) CheckBox cbTwo;
    @BindView(R.id.etThree) EditText etThree;
    @BindView(R.id.cbThree) CheckBox cbThree;
    @BindView(R.id.etQueXing) EditText etQueXing;
    @BindView(R.id.cbQueXing) CheckBox cbQueXing;
    Unbinder unbinder;
    private TaskEntity taskEntity;
    private TaskDao taskDao;

    public EventFragment() {
    }

    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        unbinder = ButterKnife.bind(this, view);
        taskDao = SelfManagerDatabase.getDefault(getActivity().getApplicationContext()).getTaskDao();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        Date date = null;
        String string = "2016-10-24";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        taskEntity = taskDao.getTaskByTime(date);
        if (taskEntity != null) {
            setData(taskEntity);
        }
    }

    private void setData(TaskEntity taskEntity) {
        etOne.setText(taskEntity.oneThings);
        cbOne.setChecked(taskEntity.isOnefinish);
        etTwo.setText(taskEntity.twoThings);
        cbTwo.setChecked(taskEntity.isTwofinish);
        etThree.setText(taskEntity.threeThings);
        cbThree.setChecked(taskEntity.isThreefinish);

        etQueXing.setText(taskEntity.xiaoQueXing);
        cbQueXing.setChecked(taskEntity.isQueXingFinish);

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

    @OnClick({R.id.tvSave, R.id.tvSummary})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSave:
                saveDate(getInputData());
                break;
            case R.id.tvSummary:
                break;
        }
    }

    private TaskEntity getInputData() {
        String oneThings = etOne.getText().toString();
        String twoThings = etTwo.getText().toString();
        String threeThings = etThree.getText().toString();
        String xiaoQueXing = etQueXing.getText().toString();
        Boolean oneCb = cbOne.isChecked();
        Boolean twoCb = cbTwo.isChecked();
        Boolean threeCb = cbThree.isChecked();
        Boolean queXingCb = cbQueXing.isChecked();
        if (taskEntity != null) {
            taskEntity.oneThings = oneThings;
            taskEntity.twoThings = twoThings;
            taskEntity.threeThings = threeThings;
            taskEntity.isOnefinish = oneCb;
            taskEntity.isTwofinish = twoCb;
            taskEntity.isThreefinish = threeCb;
            taskEntity.xiaoQueXing = xiaoQueXing;
            taskEntity.isQueXingFinish = queXingCb;
            Date date = null;
            String string = "2016-10-24";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdf.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            taskEntity.updateTime = date;
            return taskEntity;
        } else {
            TaskEntity entity = new TaskEntity();
            Date date = null;
            String string = "2016-10-24";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdf.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            entity.oneThings = oneThings;
            entity.twoThings = twoThings;
            entity.threeThings = threeThings;
            entity.isOnefinish = oneCb;
            entity.isTwofinish = twoCb;
            entity.isThreefinish = threeCb;
            entity.xiaoQueXing = xiaoQueXing;
            entity.isQueXingFinish = queXingCb;
            entity.createTime = date;
            entity.updateTime = date;
            return entity;
        }

    }

    private void saveDate(TaskEntity entity) {
        if (taskEntity != null) {
            //更新
            taskDao.update(entity);
        } else {
            //插入
            taskDao.inert(entity);
        }
    }
}
