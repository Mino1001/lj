package cn.sm.ljye.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/12/4.
 */

public class UiUtil {
    //递归设置可被点击
    public  static void setEnable(View view, boolean enable){
        view.setEnabled(enable);
        if (view instanceof ViewGroup){
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = ((ViewGroup) view).getChildAt(i);
                setEnable(child,enable);
            }
        }
    }
}
