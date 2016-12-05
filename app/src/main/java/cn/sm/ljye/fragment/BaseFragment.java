package cn.sm.ljye.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.sm.ljye.R;

/**
 * Created by Administrator on 2016/12/4.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        ViewGroup childContainer = (ViewGroup) rootView.findViewById(R.id.fragment_base_child_container);
        ViewGroup titleContainer = (ViewGroup) rootView.findViewById(R.id.fragment_base_title_container);
        //是否需要标题
        if (!needTitle()){
            titleContainer.setVisibility(View.VISIBLE);
        }

        int layoutRes = getContentLayoutRes();
        View childView = inflater.inflate(layoutRes, childContainer);
        TextView titleTv = (TextView) rootView.findViewById(R.id.fragment_base_title_tv);
        initView(titleTv,childView);
        return rootView;
    }
    protected  boolean needTitle(){
        return false;
    }

    protected abstract int getContentLayoutRes();

    protected abstract void initView(TextView titleTv, View childView);

}
