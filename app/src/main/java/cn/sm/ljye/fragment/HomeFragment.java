package cn.sm.ljye.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.sm.ljye.R;

/**
 * Created by Administrator on 2016/12/4.
 */

public class HomeFragment extends Fragment {
    @InjectView(R.id.homeFragemnt_banner)
    Banner mBanner;


    Integer[] imageer = {R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3};
    private View mHomeView;
    private List<String> mList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mHomeView == null) {
            mHomeView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        ButterKnife.inject(this, mHomeView);

        initAutoBanner();//初始化轮播图

        return mHomeView;
    }


    private void initAutoBanner() {
        //设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        mBanner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT   指示器居左
        //Banner.CENTER 指示器居中
        //Banner.RIGHT  指示器居右
        mBanner.setIndicatorGravity(Banner.CENTER);
        mBanner.isAutoPlay(true);//设置是否自动轮播（不设置则默认自动）
        mBanner.setDelayTime(2000);//设置轮播图片间隔时间（不设置默认为2000）
        mBanner.setImages(imageer);
        //自定义图片加载框架
//        banner.setImages(images, new Banner.OnLoadImageListener() {
//            @Override
//            public void OnLoadImage(ImageView view, Object url) {
//
//                for (int i = 0; i < images.length; i++) {
//                    Picasso.with(getActivity()).load(images[i]).into(view);
//                }
//            }
//        });
        //设置点击事件，下标是从1开始
        mBanner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getActivity(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mBanner.isAutoPlay(true);
        Log.i("Fragment", "出现");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Fragment", "消失111");
        mBanner.isAutoPlay(false);
    }

}
