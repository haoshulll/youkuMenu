# youkuMenu
自定义菜单，仿优酷菜单，旋转菜单
## 优酷菜单
   1. 优酷菜单界面设计
   2. 三级菜单显示与隐藏
   3. 二级菜单显示与隐藏
   4. 手机菜单按钮实现菜单的显示与隐藏
   5. bug解决，完善
      1. 不同级别菜单的显示或隐藏有一定的顺序
      2. 菜单控件，已经隐藏，但是还能点击控件
      3. 动画没有执行完，防止再次点击控件
         - 要检测动画执行完没有？
           1.假如执行完，则能够再次点击
           2. 假如动画没有执行完，则再次点击无效，防止动画没有执行完，而多次点击
           3. 通过监听动画执行情况
