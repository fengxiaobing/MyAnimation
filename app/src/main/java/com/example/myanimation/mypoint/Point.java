package com.example.myanimation.mypoint;

/**
 * Created by Administrator on 2017/12/12.
 */

public class Point {
    // 设置两个变量用于记录坐标的位置
    private float x;
    private float y;

    /**
     * 构造函数用于设置坐标
     * @param x
     * @param y
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // get方法用于获取坐标
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
