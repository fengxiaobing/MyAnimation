package com.example.myanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 *
 * ValueAnimator.ofInt（int values）
 */
public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    Button btn_animalShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        button = findViewById(R.id.btn_startAnimal);
        button.setOnClickListener(this);
        Button button1 = findViewById(R.id.btn_startXmlAnimal);
        button1.setOnClickListener(this);
        btn_animalShow = findViewById(R.id.btn_animalShow);
        btn_animalShow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_startAnimal:
                //ObjectAnimator.ofFloat(Object object, String property, float ....values);
                ObjectAnimator anim = ObjectAnimator.ofFloat(button,"TranslationX",500);
                //ofFloat（）的作用有两个
                //1.创建动画实例
                //2.参数设置，参数说明如下：
                //Object object:需要操作的对象
                //String property：需要操作对象的属性
                // float ....values：动画初始值，结束值（不固定长度）
                // 若是两个参数a,b，则动画效果则是从属性的a值到b值
                // 若是三个参数a,b,c，则则动画效果则是从属性的a值到b值再到c值
                // 以此类推
                // 至于如何从初始值 过渡到 结束值，同样是由估值器决定，此处ObjectAnimator.ofFloat（）是有系统内置的浮点型估值器FloatEvaluator，同ValueAnimator讲解
                anim.setDuration(500);
                // 设置动画运行的时长

                anim.setStartDelay(500);
                // 设置动画延迟播放时间

                anim.setRepeatCount(0);
                // 设置动画重复播放次数 = 重放次数+1
                // 动画播放次数 = infinite时,动画无限重复

                anim.setRepeatMode(ValueAnimator.RESTART);
                // 设置重复播放动画模式
                // ValueAnimator.RESTART(默认):正序重放
                // ValueAnimator.REVERSE:倒序回放

                anim.start();
                // 启动动画

                break;

        }

    }
}
