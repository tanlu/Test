package com.daydayup.yuekao_moth4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.daydayup.yuekao_moth4.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 启动页面
 */
public class SplashActivity extends AppCompatActivity {

    private TextView time;
    private ImageView imageView;
    private int i = 3;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        //初始化界面
        initViews();
        //计时
        initTimes();
    }

    private void initTimes() {
        timer = new Timer();
        timer.schedule(new MyTask(), 1000, 1000);
    }

    class MyTask extends TimerTask {

        @Override
        public void run() {
            i--;

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time.setText(i + "S");
                    if (i == 0) {
                        //跳转
                        timer.cancel();
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));

                        finish();
                    }
                }
            });

        }
    }

    private void initViews() {
        time = findViewById(R.id.splash_time);
        imageView = findViewById(R.id.spalsh_pic);
    }


}
