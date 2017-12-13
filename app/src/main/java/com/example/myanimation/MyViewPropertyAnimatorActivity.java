package com.example.myanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.Button;

public class MyViewPropertyAnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_property_animator);
        Button button  = findViewById(R.id.button);

//        button.animate().translationX(200).setDuration(2000);
//        Keyframe keyframe1 = Keyframe.ofFloat(0, 50); // 开始：progress 为 0
//        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 500); // 进行到一半是，progres 为 100
//        Keyframe keyframe3 = Keyframe.ofFloat(1, 200); // 结束时倒回到 80
//        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("translationX", keyframe1, keyframe2, keyframe3);
//
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(button, holder);
//        animator.setInterpolator(new FastOutSlowInInterpolator());
//        animator.setDuration(2000);
//        animator.start();

        ObjectAnimator animator = ObjectAnimator.ofFloat(button,"translationX",1000);
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();
        //AnimatorListener 四个接口必实现
//        button.animate().translationX(500).setDuration(2000).setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                //动画开始时执行
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                //动画结束时执行
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                //动画取消时执行
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//                //动画重复时执行
//            }
//        });

        //AnimatorListenerAdapter 可以灵活实现其中的某一个接口
//        button.animate().translationX(200).setDuration(2000).setListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                super.onAnimationStart(animation);
//            }
//        });

        //使用解析
        //   View.animate().xxx().xxx();
        //ViewPropertyAnimator的功能建立在animate()上
        //调用animate()方法返回值是一个ViewPropertyAnimator对象，之后的调用的所有的方法都是通过该实例完成。
        //调用该实例的各种方法来实现动画效果
        //ViewPropertyAnimator的所有接口方法都是使用连缀语法来设计，每个方法的返回都是自身的实例
        //因此调用完一个方法后可直接连缀调用另一个方法，即可通过一行代码就完成所有动画效果
        // 以下是例子
      /*  mButton = (Button) findViewById(R.id.Button);
        // 创建动画作用对象：此处以Button为例

        mButton.animate().alpha(0f);
        // 单个动画设置:将按钮变成透明状态
        mButton.animate().alpha(0f).setDuration(5000).setInterpolator(new BounceInterpolator());
        // 单个动画效果设置 & 参数设置
        mButton.animate().alpha(0f).x(500).y(500);
        // 组合动画:将按钮变成透明状态再移动到(500,500)处*/

      /**
       * 特别注意：
       *动画自动启动之后，无需调用start()方法，因为新的接口中使用了隐式启动动画的功能，只要我们将动画定义完成之后，
       * 该机制对于组合动画也同样有效，只要不断地连缀新的方法，那么动画就不会立刻执行，等到所有在ViewPropertyAnimator上设置的方法都执行完毕后，动画就会自动启动
       * 如果不想使用这一默认机制，也可以显式地调用start()方法来启动动画
       * */


    }
}
