package com.myapp.youkumenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.myapp.youkumenu.util.AnimationUtil;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mLevel1Rly;// 一级菜单容器
    private RelativeLayout mLevel2Rly;// 二级菜单容器
    private RelativeLayout mLevel3Rly;// 三级菜单容器

    private boolean isDisplayMenu = true;// 菜单是否处于显示状态
    private boolean isDisplayLevel2 = true;// 二级菜单是否处于显示状态
    private boolean isDisplayLevel3 = true;// 三级菜单是否处于显示状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    // 初始化视图
    private void initView() {
        mLevel1Rly = (RelativeLayout) findViewById(R.id.level1_rly);
        mLevel2Rly = (RelativeLayout) findViewById(R.id.level2_rly);
        mLevel3Rly = (RelativeLayout) findViewById(R.id.level3_rly);


    }

    // 1.显示或者隐藏三级菜单
    // 1.显示或者隐藏三级菜单
    public void clickMenu(View v) {
        if (AnimationUtil.runningAnimationCount != 0) {// 表示有动画执行
            return;
        }
        if (isDisplayLevel3) {// 假如三级菜单显示，则隐藏
            // 隐藏三级菜单的动画
            // AnimationUtils.loadAnimation(context, id);//导入动画xml资源
            AnimationUtil.startOutAnimation(mLevel3Rly, 0);

        } else {// 假如隐藏，则显示
            // 显示三级菜单
            AnimationUtil.startInAnimation(mLevel3Rly, 0);

        }
        isDisplayLevel3 = !isDisplayLevel3;

    }

    // 2.显示或者隐藏二级菜单
    public void clickHome(View v) {
        if (AnimationUtil.runningAnimationCount != 0) {// 表示有动画执行
            return;
        }
        long staftOffset = 0;// 设置动画执行的延迟时间
        if (isDisplayLevel2) {// 假如二级菜单显示，则隐藏

            // 假如三级菜单处于显示状态，则隐藏
            if (isDisplayLevel3) {
                AnimationUtil.startOutAnimation(mLevel3Rly, staftOffset);
                isDisplayLevel3 = false;// 不显示
                staftOffset += 200;
            }

            AnimationUtil.startOutAnimation(mLevel2Rly, staftOffset);

        } else {// 假如隐藏，则显示
            // 显示二级菜单
            AnimationUtil.startInAnimation(mLevel2Rly, staftOffset);
        }
        isDisplayLevel2 = !isDisplayLevel2;// 取反
    }

    // 3.显示或者隐藏菜单 ,监听按键事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_MENU == keyCode) {// 当点击菜单按键
            if (AnimationUtil.runningAnimationCount != 0) {//表示有动画执行
                return true;
            }
            long staftOffset = 0;// 设置动画执行的延迟时间
            if (isDisplayMenu) {// 假如有菜单显示，则隐藏
                // 假如有三级菜单，则隐藏
                if (isDisplayLevel3) {
                    AnimationUtil.startOutAnimation(mLevel3Rly, staftOffset);
                    isDisplayLevel3 = false;
                    staftOffset += 200;
                }
                // 假如有二级菜单，则隐藏
                if (isDisplayLevel2) {
                    AnimationUtil.startOutAnimation(mLevel2Rly, staftOffset);
                    isDisplayLevel2 = false;
                    staftOffset += 200;
                }

                // 隐藏一级菜单
                AnimationUtil.startOutAnimation(mLevel1Rly, staftOffset);
                isDisplayMenu = false;

            } else {// 显示菜单
                // 1. 显示一级菜单
                AnimationUtil.startInAnimation(mLevel1Rly, staftOffset);
                staftOffset += 200;
                isDisplayMenu = true;
                // 2. 显示二级菜单
                AnimationUtil.startInAnimation(mLevel2Rly, staftOffset);
                staftOffset += 200;
                isDisplayLevel2 = true;
                // 3. 显示三级菜单
                AnimationUtil.startInAnimation(mLevel3Rly, staftOffset);
                isDisplayLevel3 = true;
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
