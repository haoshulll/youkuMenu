package com.myapp.youkumenu.util;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * @包名: com.myapp.youkumenu.util
 * @作者: haoshul
 * @时间: 2016/11/5 9:30
 * @描述: TODO
 */
public class AnimationUtil {
    public static int runningAnimationCount=0;//正在运行的动画的数量
    /**
     * 隐藏的动画、出去的动画
     *
     * @param
     *            ：要执行动画的视图
     */
    public static void startOutAnimation(RelativeLayout view, long startOffset) {
        // 设置出去的控件为不可用
        int childCount = view.getChildCount();
        // for(int i=0;i<view.getChildCount();i++){
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(false);
        }
        RotateAnimation ra = new RotateAnimation(0, -180,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                1f);
        ra.setDuration(1000);// 动画的执行持续时间
        ra.setFillAfter(true);// 动画停留在动画停止的状态
        ra.setStartOffset(startOffset);// 延迟0.2秒执行动画
        ra.setAnimationListener(animationListener);//动画监听
        view.startAnimation(ra);
    }

    /**
     * 显示的动画、进入的动画
     *
     * @param
     *            ：要执行动画的视图
     */
    public static void startInAnimation(RelativeLayout view, long startOffset) {
        int childCount = view.getChildCount();
        // for(int i=0;i<view.getChildCount();i++){
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(true);
        }
        RotateAnimation ra = new RotateAnimation(-180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                1f);
        ra.setDuration(1000);// 动画的执行持续时间
        ra.setFillAfter(true);// 动画停留在动画停止的状态
        ra.setStartOffset(startOffset);// 延迟0.2秒执行动画
        ra.setAnimationListener(animationListener);//动画监听
        view.startAnimation(ra);
    }
    private static  Animation.AnimationListener animationListener=new Animation.AnimationListener() {
        //动画开始
        @Override
        public void onAnimationStart(Animation animation) {
            //标记
            runningAnimationCount++;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
        //动画结束
        @Override
        public void onAnimationEnd(Animation animation) {
            //标记
            runningAnimationCount--;

        }
    };

}
