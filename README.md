# TabsMenu
导航菜单的封装
![image](http://ww4.sinaimg.cn/mw690/7a18e5c2jw1f83j1f1tgcj20go06kwfb.jpg)  
> 我的灵感正在涌现    
[博客地址](http://zeffect.cn/index.php/archives/11/)  
<html>
<body>
<object type="application/x-shockwave-flash" data="http://www.ffsup.com/app/mp/play.swf?mp3=http://mp3.ffsup.com/d.php?mp3l1474614896WODY3ZN.mp3" width="240" height="20" id="dewplayer-vol" name="dewplayer-vol">
<param name="wmode" value="transparent" />
<param name="movie" value="http://www.ffsup.com/app/mp/play.swf?mp3=http://mp3.ffsup.com/d.php?mp3l1474614896WODY3ZN.mp3" />>
</object>
</body>
</html>

# 导航菜单的封装  
- 项目中经常使用一些，底部菜单，基于这个一样场景，就想封装一个常用菜单。  
1. RadioGroup+ViewPager  
    我自己的常用实现方法是这样的，因为RadioGroup，里面放RadioButton的话，会有选中事件，方便实现选中效果。  
2. TabLayout+ViewPager  
    现在很多都用这个方式实现，这种方法的话，就只有TabLayout的一些属性  
    ```
    app:tabSelectedTextColor//字体选中颜色
    app:tabTextColor//未选中颜色
    app:tabIndicatorColor//指示器的颜色
    app:tabBackground//背景色
    ```  
3. 基于上面的想法，本来还想加一个普通的布局，也能有菜单事件的，但是后来想了想，又没有点击效果，也不会知道选中了哪一项，感觉没意思。
***  
# 实现原理，我的想法。  
1. ViewPager里永远是Fragment  
2. 布局支持上下左右四个方向  
3. Navigation的布局由用户自己传入。  
4. 一些属性可以自定义。  
***  
- 入口
    ```
    public class TabMenu {
        public TabConfig creadTabMenu() {
            return new TabConfig();
        }

        public RadioConfig creadRadioMenu() {
            return new RadioConfig();
        }
    }
    ```  
- TabConfig配置字段
    ```
    setTitleLayout(@LayoutRes,@IdRes);配置Navigation布局,@IdRes只能是TabLayout;//必传  
    setContentFragment(List<Fragment>);设置内容视图 //必传  
    setTitleTexts(List<String>);设置Navigation的字 //必传  
    setDefaultGravity(int)//设置显示位置Gravity.BOTTOM,TOP,LEFT,RIGHT //可选  
    ```  
- RadioConfig配置字段  
    ```
    setTitleLayout(@LayoutRes,@IdRes);配置Navigation布局,@IdRes只能是TabLayout;//必传  
    setContentFragment(List<Fragment>);设置内容视图 //必传  
    setDefaultGravity(int)//设置显示位置Gravity.BOTTOM,TOP,LEFT,RIGHT //可选  
    ```  
- 配置完所有参数后，调用Build();就可以生成一个Fragment;然后添加到了一个布局上就可以了。  
***    
### 简单的使用教程  
- project Build.gradle添加  
```
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```  
- app Build.gradle添加  
```
dependencies {
	        compile 'com.github.xuanu:TabsMenu:0.0.1'
	}
```  
- RadioGroup
- TabLayou  
```  
 Fragment radioFragment = new TabMenu().creadRadioMenu().setTitleLayout(R.layout.layout_title_radio, R.id.ltr_gb).setContentFragment(content).setDefaultGravity(Gravity.LEFT).Build();  
        getSupportFragmentManager().beginTransaction().add(R.id.top_right, radioFragment).show(radioFragment).commit();   
 Fragment tabFragment = new TabMenu().creadTabMenu().setTitleLayout(R.layout.layout_title, R.id.lt_tab).setTitleTexts(title).setContentFragment(content).Build();  
        getSupportFragmentManager().beginTransaction().add(R.id.top_left, tabFragment).show(tabFragment).commit();  
```  
### 已知问题  
- 多个菜单不能添加到同一个Activity内，可能与我使用相同的ID有关。如何能解决方法，欢迎提问。
- **项目已提交到Github**
 [开源地址](https://github.com/xuanu/TabsMenu)  
- 截图  
位置在上  
![image](http://ww3.sinaimg.cn/mw690/7a18e5c2jw1f83kke7ynrj205i08ct8k.jpg)
位置在下  
![image](http://ww3.sinaimg.cn/mw690/7a18e5c2jw1f83kkd7rujj205508ct8k.jpg)  
位置在左  
![image](http://ww1.sinaimg.cn/mw690/7a18e5c2jw1f83kkdptq3j205e08cmx6.jpg)  
位置在右  
![image](http://ww1.sinaimg.cn/mw690/7a18e5c2jw1f83kkcepusj205d08cdft.jpg)  
- 在一个布局中全部显示的Bug  
![image](http://ww1.sinaimg.cn/mw690/7a18e5c2jw1f83kkg2drhj22643uwe3f.jpg)

   
