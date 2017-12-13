package com.example.myanimation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myanimation.TypeEvaluator.ColorEvaluator;

/**
 * 实现的动画效果：一个圆的颜色渐变：
 */
public class MyObjectAnimatorCircleColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_object_animator_circle_color);
        MyObjectAnimatorCircleColor myObjectAnimatorCircleColor = findViewById(R.id.MyView2);
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(myObjectAnimatorCircleColor,"color",new ColorEvaluator(), "#0000FF", "#FF0000");
        //设置自定义view对象、背景颜色、和颜色估值器
        //本质逻辑
        //步骤1：根据颜色估值器不断改变值
        //步骤2：调用set()设置背景颜色属性值（实际上是通过画笔进行颜色设置）
        //步骤3；调用invalidate()刷新视图，即调用onDraw()方法重新绘制，从而实现动画效果；
        objectAnimator.setRepeatCount(8);
        objectAnimator.setDuration(2000);
        objectAnimator.start();


    }
}
