package com.example.myanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 验证补间动画移动View后，View的实际位置会不会变化
 * 测试属性动画会不会变化，然后发现属性动画与补间动画的区别：
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button btn_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btn_move = findViewById(R.id.btn_move);
        textView.setOnClickListener(this);
        btn_move.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView:
                Toast.makeText(this, "文本" + textView.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_move:
                //补间动画
                // 会发现：没有改变View的属性，只是改变视觉效果
                // 补间动画只是改变了View的视觉效果，而不会真正去改变View的属性。
                //  如，将屏幕左上角的按钮 通过补间动画 移动到屏幕的右下角
                // 点击当前按钮位置（屏幕右下角）是没有效果的，因为实际上按钮还是停留在屏幕左上角，补间动画只是将这个按钮绘制到屏幕右下角，改变了视觉效果而已。
               /* Animation translateAnimation = new TranslateAnimation(0, 400, 0, 0);
                translateAnimation.setDuration(500);
                translateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
                textView.startAnimation(translateAnimation);*/

                //属性动画
                // 解决了补间动画引起的错觉
                //补间动画只能实现平移、旋转、缩放 & 透明度这些简单的动画需求
                //一旦遇到相对复杂的动画效果，即超出了上述4种动画效果，那么补间动画则无法实现。
                //(即补间动画在功能 & 可扩展性有较大局限性，所以工作中一般使用属性动画)

                textView.animate().translationX(500);
                break;
        }
    }
}
