package com.example.myanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyAnimatorSetActivity extends AppCompatActivity implements View.OnClickListener {
    Button button,btn_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_animator_set);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        btn_xml = findViewById(R.id.btn_xml);
        btn_xml.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:

                //主要动画是平移，平移过程中伴随旋转动画，平移完后进行透明度变化
                Float curTranslationX = button.getTranslationX();

                // 步骤1：设置需要组合的动画效果
                ObjectAnimator translation = ObjectAnimator.ofFloat(button,"translationX",curTranslationX,300,curTranslationX);
                // 平移动画

                ObjectAnimator rotation = ObjectAnimator.ofFloat(button,"rotation",0f,360f);
                //旋转动画

                ObjectAnimator alpha = ObjectAnimator.ofFloat(button,"alpha",1f,0f,1f);
                // 透明度动画

                // 步骤2：创建组合动画的对象
                AnimatorSet animatorSet = new AnimatorSet();
                // 步骤3：根据需求组合动画
                animatorSet.play(translation).with(rotation).before(alpha);
                animatorSet.setDuration(3000);

                // 步骤4：启动动画
                animatorSet.start();
                break;
            case R.id.btn_xml:

                AnimatorSet animatorSet1 = (AnimatorSet) AnimatorInflater.loadAnimator(MyAnimatorSetActivity.this,R.animator.animalset_animation);
                animatorSet1.setTarget(btn_xml);
                animatorSet1.start();
                break;
        }



    }
}
