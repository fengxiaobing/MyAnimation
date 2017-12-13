package com.example.myanimation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyObjectAnimatorButtonActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    ViewWrapper wrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_object_animator_button);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
        wrapper = new ViewWrapper(button);
        // 创建包装类,并传入动画作用的对象
    }

    @Override
    public void onClick(View v) {
        //此方法button没有效果，因为setWidth（）并不是设置View的宽度，而是设置Button的最大宽度和最小宽度的
        // 所以通过setWidth（）无法改变控件的宽度（改变方法：用一个类来包装原始对象）
//       ObjectAnimator.ofInt(button,"width",500).setDuration(2000).start();
        // 设置动画的对象


        ObjectAnimator.ofInt(wrapper,"width",500).setDuration(2000).start();

    }

    // 提供ViewWrapper类,用于包装View对象
    // 本例:包装Button对象
    private static class ViewWrapper {
        private View mTarget;
        private int width;
        // 构造方法:传入需要包装的对象

        public ViewWrapper(View mTarget) {
            this.mTarget = mTarget;
        }
        // 为宽度设置get（） & set（）

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }

}
