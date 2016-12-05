package cn.sm.ljye.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.sm.ljye.R;

/**
 * Created by Administrator on 2016/12/4.
 */

public class ActivityFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View activityView = inflater.inflate(R.layout.fragment_activity,container,false);

        return activityView;
    }
}
