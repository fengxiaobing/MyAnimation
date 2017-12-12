package com.example.myanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 *
 * ValueAnimator.ofObject（int values）
 */
public class ValueAnimatorObjectActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    Button btn_animalShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_object_animator);
//        button = findViewById(R.id.btn_startAnimal);
//        button.setOnClickListener(this);
//        Button button1 = findViewById(R.id.btn_startXmlAnimal);
//        button1.setOnClickListener(this);
//        btn_animalShow = findViewById(R.id.btn_animalShow);
//        btn_animalShow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_startAnimal:
            //创建初始动画时的对象和结束动画是的对象
//                myObject object1 = new myObject();
//                myObject object2 = new myObject();

//                ValueAnimator animator = ValueAnimator.ofObject(new myObjectEvaluator(), object1, object2);
                //创建动画和设置参数
                //参数说明：
                // 参数1：自定义的估值器对象（TypeEvaluator 类型参数）
                //参数2：初始动画时的对象
                //参数3：结束动画时的对象

//                animator.setDuration(5000);
//                animator.start();






                break;

        }

    }
}
