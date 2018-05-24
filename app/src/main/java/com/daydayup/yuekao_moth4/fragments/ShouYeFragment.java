package com.daydayup.yuekao_moth4.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daydayup.yuekao_moth4.R;
import com.daydayup.yuekao_moth4.adapters.MyFragmentAdapter;
import com.daydayup.yuekao_moth4.adapters.MyFragmentAdapter2;
import com.daydayup.yuekao_moth4.fragments.syfragmnet.AndroidFragment;
import com.daydayup.yuekao_moth4.fragments.syfragmnet.FuLiFragment;
import com.daydayup.yuekao_moth4.fragments.syfragmnet.IOSFragment;

import java.util.ArrayList;
import java.util.List;

public class ShouYeFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fs1 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sy, null);
        //初始化页面
        initViews();
        return view;
    }


    private void initViews() {
        tabLayout = view.findViewById(R.id.sy_tablayout);
        viewPager = view.findViewById(R.id.sy_viewpager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //viewPager里面添加Fragment

        fs1.clear();

        Fragment f1 = AndroidFragment.create("Android");
        Fragment f2 = IOSFragment.create("IOS");
        Fragment f3 = FuLiFragment.create("福利");
        fs1.add(f1);
        fs1.add(f2);
        fs1.add(f3);
        //设置适配器
        MyFragmentAdapter2 adapter = new MyFragmentAdapter2(getChildFragmentManager(), fs1);
        viewPager.setAdapter(adapter);
        //设置下划线颜色
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
        //添加选项卡
        TabLayout.Tab tab1 = tabLayout.newTab();
        tab1.setText("Android");
        tabLayout.addTab(tab1);

        TabLayout.Tab tab2 = tabLayout.newTab();
        tab2.setText("IOS");

        tabLayout.addTab(tab2);

        TabLayout.Tab tab3 = tabLayout.newTab();
        tab3.setText("福利");

        tabLayout.addTab(tab3);

        //将ViewPger关联到TabLayout

        tabLayout.setupWithViewPager(viewPager);
    }

    //当可见时。。。。
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);


    }
}
