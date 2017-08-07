package com.gzf.zfprogresshuddemo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gzf.zfprogresshud.utils.ZFProgressHUDUtils;
import com.gzf.zfprogresshud.utils.ZFUtils;

public class MainActivity extends AppCompatActivity {

    public static ZFUtils sZFUtils;
    public static ZFProgressHUDUtils sZFProgressHUDUtils;

    private Button mTestBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestBtn = (Button) findViewById(R.id.button_test);
//        mTestBtn.setOnClickListener(this);
        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTest();
            }
        });


    }

    private void showTest() {
        // 简单使用
//        sZFUtils.show(this,"正在加载...");

        // 点击背景 取消加载
//        sZFProgressHUDUtils.show(this,"正在加载...",true);

        // 可设置字体大小和颜色
//        sZFProgressHUDUtils.show(this,"正在加载...",15, Color.RED,true);

        // 同上
//        int color = Color.argb (127, 255, 0, 255 );
//        sZFProgressHUDUtils.show(this,"正在加载...",15, color,true); progress_indeterminate_horizontal

        // 可自定义加载动画图片
//        Drawable drawable = getResources().getDrawable(android.R.drawable.custom_progress_animation);
        Drawable drawable = getResources().getDrawable(R.drawable.custom_progress_animation);
    sZFProgressHUDUtils.show(this,"正在加载...",15, Color.WHITE,true,drawable);


    }

}
