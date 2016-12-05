package cn.sm.ljye.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.sm.ljye.R;
import cn.sm.ljye.fragment.ActivityFragment;
import cn.sm.ljye.fragment.HomeFragment;
import cn.sm.ljye.fragment.SimpleTextFragment;
import cn.sm.ljye.utils.UiUtil;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.main_bottom_switcher_container)
    LinearLayout mSwitchercontainer;
    @InjectView(R.id.main_fragment_container)
    FrameLayout mFragmentcontainer;
     List<Fragment> mFragments = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        mFragments.add(new HomeFragment());
        mFragments.add(new ActivityFragment());
        mFragments.add(SimpleTextFragment.create("优儿园"));
        mFragments.add(SimpleTextFragment.create("我的"));

        int childCount = mSwitchercontainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            mSwitchercontainer.getChildAt(i).setOnClickListener(mOnClickListener);
        }
        mOnClickListener.onClick(mSwitchercontainer.getChildAt(0));

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int index = mSwitchercontainer.indexOfChild(v);
//            Toast.makeText(MainActivity.this, "" + index, Toast.LENGTH_SHORT).show();
            //切换Fragment
            switcherFragment(index);

            //更新被点击的图标
            updateBottomUi(index);

        }
    };

    private void switcherFragment(int index) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment_container,mFragments.get(index))
                    .commit();

    }

    private void updateBottomUi(int index) {
        int childCount = mSwitchercontainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            UiUtil.setEnable(mSwitchercontainer.getChildAt(i), i != index);
        }


    }
}
