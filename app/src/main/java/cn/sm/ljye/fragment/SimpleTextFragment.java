package cn.sm.ljye.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/4.
 */

public class SimpleTextFragment extends Fragment {

    String title;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(inflater.getContext());
        textView.setTextSize(80);
        textView.setGravity(Gravity.CENTER);
        textView.setText(title);



        return textView;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        title=args.getString("Title");
    }

    public  static  SimpleTextFragment create(String title){

        SimpleTextFragment simpleTextFragment= new SimpleTextFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title",title);
        simpleTextFragment.setArguments(bundle);
        return  simpleTextFragment;

    }
}
