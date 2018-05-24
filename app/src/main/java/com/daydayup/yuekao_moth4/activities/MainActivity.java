package com.daydayup.yuekao_moth4.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.daydayup.yuekao_moth4.R;
import com.daydayup.yuekao_moth4.adapters.MyFragmentAdapter;
import com.daydayup.yuekao_moth4.fragments.FenLeiFragment;
import com.daydayup.yuekao_moth4.fragments.ShouYeFragment;
import com.daydayup.yuekao_moth4.fragments.WoDeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private DrawerLayout drawerLayout;
    private LinearLayout tuijian;
    private LinearLayout shangpin;
    private List<Fragment> fs = new ArrayList<>();
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化界面
        initViews();
        //初始化数据
        /**
         * 将Fragment添加到主页面
         *
         * 侧滑的处理
         *
         */
        initFragments();
    }

    private void initFragments() {
        Fragment f_sy = new ShouYeFragment();
        Fragment f_fl = new FenLeiFragment();
        Fragment f_wd = new WoDeFragment();
        fs.add(f_sy);
        fs.add(f_fl);
        fs.add(f_wd);

        //设置适配器
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fs);
        viewPager.setAdapter(myFragmentAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.one);
                        break;
                    case 1:
                        radioGroup.check(R.id.two);
                        break;
                    case 2:
                        radioGroup.check(R.id.three);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {
        viewPager = findViewById(R.id.main_vp);
        radioGroup = findViewById(R.id.main_rg);
        drawerLayout = findViewById(R.id.drawerlayout);
        tuijian = findViewById(R.id.tuijian);
        shangpin = findViewById(R.id.shangpin);

        tuijian.setOnClickListener(this);
        shangpin.setOnClickListener(this);

        //默认选中第一个
        radioGroup.check(R.id.one);
        //点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.one:
                    viewPager.setCurrentItem(0);
                        break;

                    case R.id.two:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.three:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tuijian:
                Toast.makeText(MainActivity.this, "推荐", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                break;

            case R.id.shangpin:
                startActivity(new Intent(MainActivity.this, GoodsActivity.class));

                drawerLayout.closeDrawers();
                break;
        }
    }
}
