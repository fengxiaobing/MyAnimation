package com.example.myanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 *
 * ValueAnimator.ofInt（int values）
 */
public class ValueAnimatorIntActivity extends AppCompatActivity implements View.OnClickListener {
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
                //步骤一：设置动画的初始值和结束值
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 3);
                //ofInt的作用有两个
                //1.创建动画实例
                //1.将传入多个int参数进行平滑过渡：此处传入0和1，表示将值从0平滑过渡到1，
                //如果传入了3个int参数a、b、c，则是先从a平滑过渡到b，再从b平滑过渡到c。以此类推

                //步骤2：设置动画播放的各个属性
                valueAnimator.setDuration(500);
                //设置动画运行时长

                valueAnimator.setStartDelay(500);
                //设置动画延迟播放时间

                valueAnimator.setRepeatCount(0);
                //设置动画重复播放此时　＝　重放此时+1
                //动画播放次数 = infinite是，动画无线重复

                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
                //设置重复播放动火模式
                //ValueAnimator.RESTART(默认)：正序播放
                //ValueAnimator.REVERSE:倒叙播放

                //步骤3：将改变的手动赋值给对象的属性值，通过动画的更新监听器设置值的更新监听器
                //即：值每次改变、变化一次，该方法会被调用一次
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int currentValue = (int) animation.getAnimatedValue();
                        //改变后的值

                        Log.e("TAG", "======" + currentValue);
                        //输出改变后的值

                        //步骤4：将改变后的值赋值给对象的属性值，
//                View.setproperty（currentValue）;
                        //步骤5：刷新视图，即重新绘制。从而实现动画效果
//                View.requestLayout();
                    }
                });
                valueAnimator.start();

                break;
            case R.id.btn_startXmlAnimal:
                Animator animator = AnimatorInflater.loadAnimator(ValueAnimatorIntActivity.this,R.animator.set_animation);
                animator.setTarget(button);
                animator.start();
                break;
                case R.id.btn_animalShow:
             //实现动画效果：按钮的宽度从150px放大到500px.
                    //步骤一：设置属性动画的起始值和结束值
                    ValueAnimator valueAnimator1 = ValueAnimator.ofInt(150,500);
             //初始值 = 当前按钮的宽度，此处下xml文件中设置的为150px
                    //结束值 = 500
                    //ValueAnimator.ofInt(）内置了整型的估值器，直接采用默认的，不需要设置
                    //即默认的设置了如何从初始值150过渡到500

                    //步骤2：设置动画的各种播放属性
                    valueAnimator1.setDuration(2000);
                    valueAnimator1.setEvaluator(new FloatEvaluator());
                    //设置动画运行时长  2s

                    //步骤3：将属性数值手动赋值给对象的属性：此处是将值赋值给按钮的宽度
                            // 设置监听更新器：即数值每次变化都更新都会调用该方法
                    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int currentValue = (int) animation.getAnimatedValue();
                            //获取每次变化后的属性值

                            Log.e("TAG","==="+currentValue);
                            //输出每次变化后的值查看

                            btn_animalShow.getLayoutParams().width = currentValue;
                            //每次值变化时，将值手动赋值给对象的属性
                            //即将每次变化后的值手动赋值给按钮的宽度，这样就实现了按钮宽度属性的动态变化

                            //步骤4：刷新视图，即重新绘制，从而实现动画效果
                            btn_animalShow.requestLayout();

                        }
                    });
            valueAnimator1.start();
            //启动动画


                break;

        }

    }
}
